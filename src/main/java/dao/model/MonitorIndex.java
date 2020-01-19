package dao.model;

import java.util.Date;

public class MonitorIndex {
    private Integer id;

    private String pid;

    private Date startTime;

    private Double totalGcTime;

    private Integer fullGcCount;

    private Double fullGcTime;

    private Integer youngGcCount;

    private Double youngGcTime;

    private Double youngMinCapacity;

    private Double youngMaxCapacity;

    private Double youngCurrentCapacity;

    private Double edenCapacity;

    private Double s0Capacity;

    private Double s1Capacity;

    private Double oldMinCapacity;

    private Double oldMaxCapacity;

    private Double oldCurrentCapacity;

    private Double oldCurrentGenerationCapacity;

    private Double metaMinCapacity;

    private Double metaMaxCapacity;

    private Double metaCurrentCapacity;

    private Double compressedClassMinCapacity;

    private Double compressedClassMaxCapacity;

    private Double compressedClassCurrentCapacity;

    private String lastFullGcCause;

    private String currentFullGcCause;

    private Double s0UsePercent;

    private Double s1UsePercent;

    private Double edenUsePercent;

    private Double oldUsePercent;

    private Double metaUsePercent;

    private Double compressedClassUsePercent;

    private Integer totalThreadNum;

    private Integer runningThreadNum;

    private Integer blockedThreadNum;

    private Integer waitingThreadNum;

    private Integer timedWaitingThreadNum;

    private String topCpuThreadPid;

    private String topTimeThreadPid;

    private String topCpuThreadName;

    private String topTimeThreadName;

    private String topCpuThreadStatus;

    private String topTimeThreadStatus;

    private Double topCpuThreadUsage;

    private Double topTimeThreadUsage;

    private Integer totalConnectionNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Double getTotalGcTime() {
        return totalGcTime;
    }

    public void setTotalGcTime(Double totalGcTime) {
        this.totalGcTime = totalGcTime;
    }

    public Integer getFullGcCount() {
        return fullGcCount;
    }

    public void setFullGcCount(Integer fullGcCount) {
        this.fullGcCount = fullGcCount;
    }

    public Double getFullGcTime() {
        return fullGcTime;
    }

    public void setFullGcTime(Double fullGcTime) {
        this.fullGcTime = fullGcTime;
    }

    public Integer getYoungGcCount() {
        return youngGcCount;
    }

    public void setYoungGcCount(Integer youngGcCount) {
        this.youngGcCount = youngGcCount;
    }

    public Double getYoungGcTime() {
        return youngGcTime;
    }

    public void setYoungGcTime(Double youngGcTime) {
        this.youngGcTime = youngGcTime;
    }

    public Double getYoungMinCapacity() {
        return youngMinCapacity;
    }

    public void setYoungMinCapacity(Double youngMinCapacity) {
        this.youngMinCapacity = youngMinCapacity;
    }

    public Double getYoungMaxCapacity() {
        return youngMaxCapacity;
    }

    public void setYoungMaxCapacity(Double youngMaxCapacity) {
        this.youngMaxCapacity = youngMaxCapacity;
    }

    public Double getYoungCurrentCapacity() {
        return youngCurrentCapacity;
    }

    public void setYoungCurrentCapacity(Double youngCurrentCapacity) {
        this.youngCurrentCapacity = youngCurrentCapacity;
    }

    public Double getEdenCapacity() {
        return edenCapacity;
    }

    public void setEdenCapacity(Double edenCapacity) {
        this.edenCapacity = edenCapacity;
    }

    public Double getS0Capacity() {
        return s0Capacity;
    }

    public void setS0Capacity(Double s0Capacity) {
        this.s0Capacity = s0Capacity;
    }

    public Double getS1Capacity() {
        return s1Capacity;
    }

    public void setS1Capacity(Double s1Capacity) {
        this.s1Capacity = s1Capacity;
    }

    public Double getOldMinCapacity() {
        return oldMinCapacity;
    }

    public void setOldMinCapacity(Double oldMinCapacity) {
        this.oldMinCapacity = oldMinCapacity;
    }

    public Double getOldMaxCapacity() {
        return oldMaxCapacity;
    }

    public void setOldMaxCapacity(Double oldMaxCapacity) {
        this.oldMaxCapacity = oldMaxCapacity;
    }

    public Double getOldCurrentCapacity() {
        return oldCurrentCapacity;
    }

    public void setOldCurrentCapacity(Double oldCurrentCapacity) {
        this.oldCurrentCapacity = oldCurrentCapacity;
    }

    public Double getOldCurrentGenerationCapacity() {
        return oldCurrentGenerationCapacity;
    }

    public void setOldCurrentGenerationCapacity(Double oldCurrentGenerationCapacity) {
        this.oldCurrentGenerationCapacity = oldCurrentGenerationCapacity;
    }

    public Double getMetaMinCapacity() {
        return metaMinCapacity;
    }

    public void setMetaMinCapacity(Double metaMinCapacity) {
        this.metaMinCapacity = metaMinCapacity;
    }

    public Double getMetaMaxCapacity() {
        return metaMaxCapacity;
    }

    public void setMetaMaxCapacity(Double metaMaxCapacity) {
        this.metaMaxCapacity = metaMaxCapacity;
    }

    public Double getMetaCurrentCapacity() {
        return metaCurrentCapacity;
    }

    public void setMetaCurrentCapacity(Double metaCurrentCapacity) {
        this.metaCurrentCapacity = metaCurrentCapacity;
    }

    public Double getCompressedClassMinCapacity() {
        return compressedClassMinCapacity;
    }

    public void setCompressedClassMinCapacity(Double compressedClassMinCapacity) {
        this.compressedClassMinCapacity = compressedClassMinCapacity;
    }

    public Double getCompressedClassMaxCapacity() {
        return compressedClassMaxCapacity;
    }

    public void setCompressedClassMaxCapacity(Double compressedClassMaxCapacity) {
        this.compressedClassMaxCapacity = compressedClassMaxCapacity;
    }

    public Double getCompressedClassCurrentCapacity() {
        return compressedClassCurrentCapacity;
    }

    public void setCompressedClassCurrentCapacity(Double compressedClassCurrentCapacity) {
        this.compressedClassCurrentCapacity = compressedClassCurrentCapacity;
    }

    public String getLastFullGcCause() {
        return lastFullGcCause;
    }

    public void setLastFullGcCause(String lastFullGcCause) {
        this.lastFullGcCause = lastFullGcCause == null ? null : lastFullGcCause.trim();
    }

    public String getCurrentFullGcCause() {
        return currentFullGcCause;
    }

    public void setCurrentFullGcCause(String currentFullGcCause) {
        this.currentFullGcCause = currentFullGcCause == null ? null : currentFullGcCause.trim();
    }

    public Double getS0UsePercent() {
        return s0UsePercent;
    }

    public void setS0UsePercent(Double s0UsePercent) {
        this.s0UsePercent = s0UsePercent;
    }

    public Double getS1UsePercent() {
        return s1UsePercent;
    }

    public void setS1UsePercent(Double s1UsePercent) {
        this.s1UsePercent = s1UsePercent;
    }

    public Double getEdenUsePercent() {
        return edenUsePercent;
    }

    public void setEdenUsePercent(Double edenUsePercent) {
        this.edenUsePercent = edenUsePercent;
    }

    public Double getOldUsePercent() {
        return oldUsePercent;
    }

    public void setOldUsePercent(Double oldUsePercent) {
        this.oldUsePercent = oldUsePercent;
    }

    public Double getMetaUsePercent() {
        return metaUsePercent;
    }

    public void setMetaUsePercent(Double metaUsePercent) {
        this.metaUsePercent = metaUsePercent;
    }

    public Double getCompressedClassUsePercent() {
        return compressedClassUsePercent;
    }

    public void setCompressedClassUsePercent(Double compressedClassUsePercent) {
        this.compressedClassUsePercent = compressedClassUsePercent;
    }

    public Integer getTotalThreadNum() {
        return totalThreadNum;
    }

    public void setTotalThreadNum(Integer totalThreadNum) {
        this.totalThreadNum = totalThreadNum;
    }

    public Integer getRunningThreadNum() {
        return runningThreadNum;
    }

    public void setRunningThreadNum(Integer runningThreadNum) {
        this.runningThreadNum = runningThreadNum;
    }

    public Integer getBlockedThreadNum() {
        return blockedThreadNum;
    }

    public void setBlockedThreadNum(Integer blockedThreadNum) {
        this.blockedThreadNum = blockedThreadNum;
    }

    public Integer getWaitingThreadNum() {
        return waitingThreadNum;
    }

    public void setWaitingThreadNum(Integer waitingThreadNum) {
        this.waitingThreadNum = waitingThreadNum;
    }

    public Integer getTimedWaitingThreadNum() {
        return timedWaitingThreadNum;
    }

    public void setTimedWaitingThreadNum(Integer timedWaitingThreadNum) {
        this.timedWaitingThreadNum = timedWaitingThreadNum;
    }

    public String getTopCpuThreadPid() {
        return topCpuThreadPid;
    }

    public void setTopCpuThreadPid(String topCpuThreadPid) {
        this.topCpuThreadPid = topCpuThreadPid == null ? null : topCpuThreadPid.trim();
    }

    public String getTopTimeThreadPid() {
        return topTimeThreadPid;
    }

    public void setTopTimeThreadPid(String topTimeThreadPid) {
        this.topTimeThreadPid = topTimeThreadPid == null ? null : topTimeThreadPid.trim();
    }

    public String getTopCpuThreadName() {
        return topCpuThreadName;
    }

    public void setTopCpuThreadName(String topCpuThreadName) {
        this.topCpuThreadName = topCpuThreadName == null ? null : topCpuThreadName.trim();
    }

    public String getTopTimeThreadName() {
        return topTimeThreadName;
    }

    public void setTopTimeThreadName(String topTimeThreadName) {
        this.topTimeThreadName = topTimeThreadName == null ? null : topTimeThreadName.trim();
    }

    public String getTopCpuThreadStatus() {
        return topCpuThreadStatus;
    }

    public void setTopCpuThreadStatus(String topCpuThreadStatus) {
        this.topCpuThreadStatus = topCpuThreadStatus == null ? null : topCpuThreadStatus.trim();
    }

    public String getTopTimeThreadStatus() {
        return topTimeThreadStatus;
    }

    public void setTopTimeThreadStatus(String topTimeThreadStatus) {
        this.topTimeThreadStatus = topTimeThreadStatus == null ? null : topTimeThreadStatus.trim();
    }

    public Double getTopCpuThreadUsage() {
        return topCpuThreadUsage;
    }

    public void setTopCpuThreadUsage(Double topCpuThreadUsage) {
        this.topCpuThreadUsage = topCpuThreadUsage;
    }

    public Double getTopTimeThreadUsage() {
        return topTimeThreadUsage;
    }

    public void setTopTimeThreadUsage(Double topTimeThreadUsage) {
        this.topTimeThreadUsage = topTimeThreadUsage;
    }

    public Integer getTotalConnectionNum() {
        return totalConnectionNum;
    }

    public void setTotalConnectionNum(Integer totalConnectionNum) {
        this.totalConnectionNum = totalConnectionNum;
    }
}