package util;

public class CommandLineUtil {
    private static boolean isWindows;

    static{
        isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
    }
    public static String[] getCommandLine(String cmd){
        String[] command = new String[3];
        if (isWindows) {
            command[0] = "cmd.exe";
            command[1] = "/c";
        } else {
            command[0] = "sh";
            command[1] = "-c";
        }
        command[2] = cmd;
        return command;
    }

}
