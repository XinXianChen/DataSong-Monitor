package util;


import dao.model.MonitorIndex;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunScriptUtil {
    private static MonitorIndex monitorIndex;
    private static String pid;
    private static String port;
    static {
        monitorIndex = new MonitorIndex();
    }
    public static MonitorIndex runJvmMonitor(String processName, String processPort){
        port = processPort;
        pid = getPid(processName);
        monitorIndex.setPid(pid);
        monitorIndex.setStartTime(new Date());
        checkFullGcCause();
        checkGcCapacity();
        checkThread();
        checkConnection();

        return monitorIndex;
    }

    public static String getPid(String processName){
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(CommandLineUtil.getCommandLine(String.format("jps | grep %s", processName)));
        builder.directory(new File(System.getProperty("user.home")));
        BufferedReader br = null;
        Process process = null;
        String line = null;
        String pid = null;
        try {
            process = builder.start();
            br = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                pid = line.split(" ")[0];
                System.out.println(pid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pid;
    }

    public static void checkFullGcCause(){
        List<String> causeOut = runCmd(String.format("jstat -gccause %s", pid));
        List<String> utilOut = runCmd(String.format("jstat -gcutil %s", pid));
        if(causeOut.size() != 2 || utilOut.size() != 2){
            return;
        }

        String[] utilValues = utilOut.get(1).trim().split("\\s+");
        monitorIndex.setS0UsePercent(Double.parseDouble(utilValues[0]));
        monitorIndex.setS1UsePercent(Double.parseDouble(utilValues[1]));
        monitorIndex.setEdenUsePercent(Double.parseDouble(utilValues[2]));
        monitorIndex.setOldUsePercent(Double.parseDouble(utilValues[3]));
        monitorIndex.setMetaUsePercent(Double.parseDouble(utilValues[4]));
        monitorIndex.setCompressedClassUsePercent(Double.parseDouble(utilValues[5]));
        monitorIndex.setYoungGcCount(Integer.parseInt(utilValues[6]));
        monitorIndex.setYoungGcTime(Double.parseDouble(utilValues[7]));
        monitorIndex.setFullGcCount(Integer.parseInt(utilValues[8]));
        monitorIndex.setFullGcTime(Double.parseDouble(utilValues[9]));
        monitorIndex.setTotalGcTime(Double.parseDouble(utilValues[10]));

        String[] cause = causeOut.get(1).substring(utilOut.get(1).length()).replaceAll("\\s{2,}", "|").split("\\|");
        if(cause.length != 2){
            String tmp = causeOut.get(1).substring(utilOut.get(1).length());
            if(tmp.contains("No GC")){
                monitorIndex.setLastFullGcCause(tmp.substring(0, tmp.indexOf("No GC")));
                monitorIndex.setCurrentFullGcCause("No GC");
            } else {
                return;
            }
        } else {
            monitorIndex.setLastFullGcCause(cause[0]);
            monitorIndex.setCurrentFullGcCause(cause[1]);
        }


        return;
    }

    public static void checkGcCapacity(){
        List<String> capacityOut = runCmd(String.format("jstat -gccapacity %s", pid));
        if(capacityOut.size() != 2){
            return;
        }
        String[] capacityValues = capacityOut.get(1).trim().split("\\s+");
        if(capacityValues.length != 18){
            return;
        }
        monitorIndex.setYoungMinCapacity(Double.parseDouble(capacityValues[0]) / 1024);
        monitorIndex.setYoungMaxCapacity(Double.parseDouble(capacityValues[1]) / 1024);
        monitorIndex.setYoungCurrentCapacity(Double.parseDouble(capacityValues[2]) / 1024);
        monitorIndex.setS0Capacity(Double.parseDouble(capacityValues[3]) / 1024);
        monitorIndex.setS1Capacity(Double.parseDouble(capacityValues[4]) / 1024);
        monitorIndex.setEdenCapacity(Double.parseDouble(capacityValues[5]) / 1024);
        monitorIndex.setOldMinCapacity(Double.parseDouble(capacityValues[6]) / 1024);
        monitorIndex.setOldMaxCapacity(Double.parseDouble(capacityValues[7]) / 1024);
        monitorIndex.setOldCurrentGenerationCapacity(Double.parseDouble(capacityValues[8]) / 1024);
        monitorIndex.setOldCurrentCapacity(Double.parseDouble(capacityValues[9]) / 1024);
        monitorIndex.setMetaMinCapacity(Double.parseDouble(capacityValues[10]) / 1024);
        monitorIndex.setMetaMaxCapacity(Double.parseDouble(capacityValues[11]) / 1024);
        monitorIndex.setMetaCurrentCapacity(Double.parseDouble(capacityValues[12]) / 1024);
        monitorIndex.setCompressedClassMinCapacity(Double.parseDouble(capacityValues[13]) / 1024);
        monitorIndex.setCompressedClassMaxCapacity(Double.parseDouble(capacityValues[14]) / 1024);
        monitorIndex.setCompressedClassCurrentCapacity(Double.parseDouble(capacityValues[15]) / 1024);
        return;
    }

    public static void checkThread(){
        List<String> out = runCmd(String.format("ps -o nlwp %s", pid));
        if(out.size() != 2){
            return;
        }
        monitorIndex.setTotalThreadNum(Integer.parseInt(out.get(1).trim()));
        int totalThreadNum = Integer.parseInt(out.get(1).trim());
        int runingThreadNum = 0;
        int waitingThreadNum = 0;
        int blockedThreadNum = 0;
        int timedwaitingThreadNum = 0;

        List<String> jstackOut = runCmd(String.format("jstack -l %s", pid));
        for(String line : jstackOut){
            if(line.contains(": RUNNABLE")){
                runingThreadNum++;
            } else if(line.contains(": BLOCKED")){
                blockedThreadNum++;
            } else if(line.contains(": TIMED_WAITING")){
                timedwaitingThreadNum++;
            } else if(line.contains(": WAITING")){
                waitingThreadNum++;
            } else {
                continue;
            }
        }

        monitorIndex.setRunningThreadNum(runingThreadNum);
        monitorIndex.setWaitingThreadNum(waitingThreadNum);
        monitorIndex.setBlockedThreadNum(blockedThreadNum);
        monitorIndex.setTimedWaitingThreadNum(timedwaitingThreadNum);

        List<String> topCpuThread = runCmd(String.format("top -b -o %%CPU -n 1 -Hp %s | tail -n +8 | head -n 1", pid));
        List<String> topTimeThread = runCmd(String.format("top -b -o TIME+ -n 1 -Hp %s | tail -n +8 | head -n 1", pid));

        if(topCpuThread.size() != 1 || topTimeThread.size() != 1){
            return;
        }

        String[] topCpuThreadParam = topCpuThread.get(0).trim().split("\\s+");
        String topCpuThreadPid = topCpuThreadParam[0];
        monitorIndex.setTopCpuThreadPid(topCpuThreadPid);
        monitorIndex.setTopCpuThreadUsage(Double.parseDouble(topCpuThreadParam[8]));

        String[] topTimeThreadParam = topTimeThread.get(0).trim().split("\\s+");
        String topTimeThreadPid = topTimeThreadParam[0];
        monitorIndex.setTopTimeThreadPid(topTimeThreadPid);

        String timeStr = topTimeThreadParam[10];
        Double time = Double.parseDouble(timeStr.substring(0, timeStr.indexOf(":"))) * 60 +
                Double.parseDouble(timeStr.substring(timeStr.indexOf(":") + ":".length(), timeStr.indexOf("."))) +
                Double.parseDouble(timeStr.substring(timeStr.lastIndexOf(".") + ".".length())) / 100;
        monitorIndex.setTopTimeThreadUsage(time);

        String topCpuThreadPidHex = Integer.toHexString(Integer.parseInt(topCpuThreadPid));
        String topTimeThreadPidHex = Integer.toHexString(Integer.parseInt(topTimeThreadPid));
        List<String> outTopCpuThreadStatus = runCmd(String.format("jstack -l %s | grep -A 20 %s ", pid, "0x"+topCpuThreadPidHex));
        if(outTopCpuThreadStatus.size() > 0){
            String firstLine = outTopCpuThreadStatus.get(0);
            String threadName = firstLine.substring(firstLine.indexOf("\"") + "\"".length(), firstLine.lastIndexOf("\""));
            monitorIndex.setTopCpuThreadName(threadName);
            for(String line : outTopCpuThreadStatus){
                if(line.contains("java.lang.Thread.State")){
                    String status = line.substring(line.lastIndexOf(":") + ":".length()).trim();
                    monitorIndex.setTopCpuThreadStatus(status);
                    break;
                }
            }
        }

        List<String> outTopTimeThreadStatus = runCmd(String.format("jstack -l %s | grep -A 20 %s ", pid, topTimeThreadPidHex));
        if(outTopTimeThreadStatus.size() > 0){
            String firstLine = outTopTimeThreadStatus.get(0);
            String threadName = firstLine.substring(firstLine.indexOf("\"") + "\"".length(), firstLine.lastIndexOf("\""));
            monitorIndex.setTopTimeThreadName(threadName);
            for(String line : outTopTimeThreadStatus){
                if(line.contains("java.lang.Thread.State")){
                    String status = line.substring(line.lastIndexOf(":") + ":".length()).trim();
                    monitorIndex.setTopTimeThreadStatus(status);
                }
            }
        }


        return;

    }

    public static void checkConnection(){
        List<String> out = runCmd(String.format("netstat -nat | grep -iw \"%s\" | wc -l", port));
        if(out.size() != 1){
            return;
        }
        monitorIndex.setTotalConnectionNum(Integer.parseInt(out.get(0).trim()));

        return;
    }

    private static List<String> runCmd(String cmd){
        List<String> outLines = new ArrayList<>();
        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(new File(System.getProperty("user.home")));
        BufferedReader br;
        String line = null;

        Process process = null;
        builder.command(CommandLineUtil.getCommandLine(cmd));

        try {
            process = builder.start();
            br = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            while ((line = br.readLine()) != null) {
                outLines.add(line);
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outLines;
    }



    /*
    public static void checkFullGcRatio() {
        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(new File(System.getProperty("user.home")));
        BufferedReader br;
        String line = null;

        Process process = null;
        builder.command(CommandLineUtil.getCommandLine(String.format("jstat -gcutil %s", pid)));

        try {
            process = builder.start();
            br = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
//        Executors.newSingleThreadExecutor().submit(streamGobbler);
        //int exitCode = process.waitFor();
        //assert exitCode == 0;
    }


    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }
    */
}
