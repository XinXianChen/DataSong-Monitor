package dao.mapper;

import dao.model.MonitorIndex;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface MonitorIndexMapper {
    @Delete({
        "delete from monitor_index",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into monitor_index (id, pid, ",
        "start_time, total_gc_time, ",
        "full_gc_count, full_gc_time, ",
        "young_gc_count, young_gc_time, ",
        "young_min_capacity, young_max_capacity, ",
        "young_current_capacity, eden_capacity, ",
        "s0_capacity, s1_capacity, ",
        "old_min_capacity, old_max_capacity, ",
        "old_current_capacity, old_current_generation_capacity, ",
        "meta_min_capacity, meta_max_capacity, ",
        "meta_current_capacity, compressed_class_min_capacity, ",
        "compressed_class_max_capacity, compressed_class_current_capacity, ",
        "last_full_gc_cause, current_full_gc_cause, ",
        "s0_use_percent, s1_use_percent, ",
        "eden_use_percent, old_use_percent, ",
        "meta_use_percent, compressed_class_use_percent, ",
        "total_thread_num, running_thread_num, ",
        "blocked_thread_num, waiting_thread_num, ",
        "timed_waiting_thread_num, top_cpu_thread_pid, ",
        "top_time_thread_pid, top_cpu_thread_name, ",
        "top_time_thread_name, top_cpu_thread_status, ",
        "top_time_thread_status, top_cpu_thread_usage, ",
        "top_time_thread_usage, total_connection_num)",
        "values (#{id,jdbcType=INTEGER}, #{pid,jdbcType=VARCHAR}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{totalGcTime,jdbcType=DOUBLE}, ",
        "#{fullGcCount,jdbcType=INTEGER}, #{fullGcTime,jdbcType=DOUBLE}, ",
        "#{youngGcCount,jdbcType=INTEGER}, #{youngGcTime,jdbcType=DOUBLE}, ",
        "#{youngMinCapacity,jdbcType=DOUBLE}, #{youngMaxCapacity,jdbcType=DOUBLE}, ",
        "#{youngCurrentCapacity,jdbcType=DOUBLE}, #{edenCapacity,jdbcType=DOUBLE}, ",
        "#{s0Capacity,jdbcType=DOUBLE}, #{s1Capacity,jdbcType=DOUBLE}, ",
        "#{oldMinCapacity,jdbcType=DOUBLE}, #{oldMaxCapacity,jdbcType=DOUBLE}, ",
        "#{oldCurrentCapacity,jdbcType=DOUBLE}, #{oldCurrentGenerationCapacity,jdbcType=DOUBLE}, ",
        "#{metaMinCapacity,jdbcType=DOUBLE}, #{metaMaxCapacity,jdbcType=DOUBLE}, ",
        "#{metaCurrentCapacity,jdbcType=DOUBLE}, #{compressedClassMinCapacity,jdbcType=DOUBLE}, ",
        "#{compressedClassMaxCapacity,jdbcType=DOUBLE}, #{compressedClassCurrentCapacity,jdbcType=DOUBLE}, ",
        "#{lastFullGcCause,jdbcType=VARCHAR}, #{currentFullGcCause,jdbcType=VARCHAR}, ",
        "#{s0UsePercent,jdbcType=DOUBLE}, #{s1UsePercent,jdbcType=DOUBLE}, ",
        "#{edenUsePercent,jdbcType=DOUBLE}, #{oldUsePercent,jdbcType=DOUBLE}, ",
        "#{metaUsePercent,jdbcType=DOUBLE}, #{compressedClassUsePercent,jdbcType=DOUBLE}, ",
        "#{totalThreadNum,jdbcType=INTEGER}, #{runningThreadNum,jdbcType=INTEGER}, ",
        "#{blockedThreadNum,jdbcType=INTEGER}, #{waitingThreadNum,jdbcType=INTEGER}, ",
        "#{timedWaitingThreadNum,jdbcType=INTEGER}, #{topCpuThreadPid,jdbcType=VARCHAR}, ",
        "#{topTimeThreadPid,jdbcType=VARCHAR}, #{topCpuThreadName,jdbcType=VARCHAR}, ",
        "#{topTimeThreadName,jdbcType=VARCHAR}, #{topCpuThreadStatus,jdbcType=VARCHAR}, ",
        "#{topTimeThreadStatus,jdbcType=VARCHAR}, #{topCpuThreadUsage,jdbcType=DOUBLE}, ",
        "#{topTimeThreadUsage,jdbcType=DOUBLE}, #{totalConnectionNum,jdbcType=INTEGER})"
    })
    int insert(MonitorIndex record);

    @Select({
        "select",
        "id, pid, start_time, total_gc_time, full_gc_count, full_gc_time, young_gc_count, ",
        "young_gc_time, young_min_capacity, young_max_capacity, young_current_capacity, ",
        "eden_capacity, s0_capacity, s1_capacity, old_min_capacity, old_max_capacity, ",
        "old_current_capacity, old_current_generation_capacity, meta_min_capacity, meta_max_capacity, ",
        "meta_current_capacity, compressed_class_min_capacity, compressed_class_max_capacity, ",
        "compressed_class_current_capacity, last_full_gc_cause, current_full_gc_cause, ",
        "s0_use_percent, s1_use_percent, eden_use_percent, old_use_percent, meta_use_percent, ",
        "compressed_class_use_percent, total_thread_num, running_thread_num, blocked_thread_num, ",
        "waiting_thread_num, timed_waiting_thread_num, top_cpu_thread_pid, top_time_thread_pid, ",
        "top_cpu_thread_name, top_time_thread_name, top_cpu_thread_status, top_time_thread_status, ",
        "top_cpu_thread_usage, top_time_thread_usage, total_connection_num",
        "from monitor_index",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total_gc_time", property="totalGcTime", jdbcType=JdbcType.DOUBLE),
        @Result(column="full_gc_count", property="fullGcCount", jdbcType=JdbcType.INTEGER),
        @Result(column="full_gc_time", property="fullGcTime", jdbcType=JdbcType.DOUBLE),
        @Result(column="young_gc_count", property="youngGcCount", jdbcType=JdbcType.INTEGER),
        @Result(column="young_gc_time", property="youngGcTime", jdbcType=JdbcType.DOUBLE),
        @Result(column="young_min_capacity", property="youngMinCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="young_max_capacity", property="youngMaxCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="young_current_capacity", property="youngCurrentCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="eden_capacity", property="edenCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="s0_capacity", property="s0Capacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="s1_capacity", property="s1Capacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_min_capacity", property="oldMinCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_max_capacity", property="oldMaxCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_current_capacity", property="oldCurrentCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_current_generation_capacity", property="oldCurrentGenerationCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="meta_min_capacity", property="metaMinCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="meta_max_capacity", property="metaMaxCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="meta_current_capacity", property="metaCurrentCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="compressed_class_min_capacity", property="compressedClassMinCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="compressed_class_max_capacity", property="compressedClassMaxCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="compressed_class_current_capacity", property="compressedClassCurrentCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="last_full_gc_cause", property="lastFullGcCause", jdbcType=JdbcType.VARCHAR),
        @Result(column="current_full_gc_cause", property="currentFullGcCause", jdbcType=JdbcType.VARCHAR),
        @Result(column="s0_use_percent", property="s0UsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="s1_use_percent", property="s1UsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="eden_use_percent", property="edenUsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_use_percent", property="oldUsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="meta_use_percent", property="metaUsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="compressed_class_use_percent", property="compressedClassUsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="total_thread_num", property="totalThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="running_thread_num", property="runningThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="blocked_thread_num", property="blockedThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="waiting_thread_num", property="waitingThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="timed_waiting_thread_num", property="timedWaitingThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="top_cpu_thread_pid", property="topCpuThreadPid", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_time_thread_pid", property="topTimeThreadPid", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_cpu_thread_name", property="topCpuThreadName", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_time_thread_name", property="topTimeThreadName", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_cpu_thread_status", property="topCpuThreadStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_time_thread_status", property="topTimeThreadStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_cpu_thread_usage", property="topCpuThreadUsage", jdbcType=JdbcType.DOUBLE),
        @Result(column="top_time_thread_usage", property="topTimeThreadUsage", jdbcType=JdbcType.DOUBLE),
        @Result(column="total_connection_num", property="totalConnectionNum", jdbcType=JdbcType.INTEGER)
    })
    MonitorIndex selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, pid, start_time, total_gc_time, full_gc_count, full_gc_time, young_gc_count, ",
        "young_gc_time, young_min_capacity, young_max_capacity, young_current_capacity, ",
        "eden_capacity, s0_capacity, s1_capacity, old_min_capacity, old_max_capacity, ",
        "old_current_capacity, old_current_generation_capacity, meta_min_capacity, meta_max_capacity, ",
        "meta_current_capacity, compressed_class_min_capacity, compressed_class_max_capacity, ",
        "compressed_class_current_capacity, last_full_gc_cause, current_full_gc_cause, ",
        "s0_use_percent, s1_use_percent, eden_use_percent, old_use_percent, meta_use_percent, ",
        "compressed_class_use_percent, total_thread_num, running_thread_num, blocked_thread_num, ",
        "waiting_thread_num, timed_waiting_thread_num, top_cpu_thread_pid, top_time_thread_pid, ",
        "top_cpu_thread_name, top_time_thread_name, top_cpu_thread_status, top_time_thread_status, ",
        "top_cpu_thread_usage, top_time_thread_usage, total_connection_num",
        "from monitor_index"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_time", property="startTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total_gc_time", property="totalGcTime", jdbcType=JdbcType.DOUBLE),
        @Result(column="full_gc_count", property="fullGcCount", jdbcType=JdbcType.INTEGER),
        @Result(column="full_gc_time", property="fullGcTime", jdbcType=JdbcType.DOUBLE),
        @Result(column="young_gc_count", property="youngGcCount", jdbcType=JdbcType.INTEGER),
        @Result(column="young_gc_time", property="youngGcTime", jdbcType=JdbcType.DOUBLE),
        @Result(column="young_min_capacity", property="youngMinCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="young_max_capacity", property="youngMaxCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="young_current_capacity", property="youngCurrentCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="eden_capacity", property="edenCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="s0_capacity", property="s0Capacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="s1_capacity", property="s1Capacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_min_capacity", property="oldMinCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_max_capacity", property="oldMaxCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_current_capacity", property="oldCurrentCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_current_generation_capacity", property="oldCurrentGenerationCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="meta_min_capacity", property="metaMinCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="meta_max_capacity", property="metaMaxCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="meta_current_capacity", property="metaCurrentCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="compressed_class_min_capacity", property="compressedClassMinCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="compressed_class_max_capacity", property="compressedClassMaxCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="compressed_class_current_capacity", property="compressedClassCurrentCapacity", jdbcType=JdbcType.DOUBLE),
        @Result(column="last_full_gc_cause", property="lastFullGcCause", jdbcType=JdbcType.VARCHAR),
        @Result(column="current_full_gc_cause", property="currentFullGcCause", jdbcType=JdbcType.VARCHAR),
        @Result(column="s0_use_percent", property="s0UsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="s1_use_percent", property="s1UsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="eden_use_percent", property="edenUsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="old_use_percent", property="oldUsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="meta_use_percent", property="metaUsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="compressed_class_use_percent", property="compressedClassUsePercent", jdbcType=JdbcType.DOUBLE),
        @Result(column="total_thread_num", property="totalThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="running_thread_num", property="runningThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="blocked_thread_num", property="blockedThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="waiting_thread_num", property="waitingThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="timed_waiting_thread_num", property="timedWaitingThreadNum", jdbcType=JdbcType.INTEGER),
        @Result(column="top_cpu_thread_pid", property="topCpuThreadPid", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_time_thread_pid", property="topTimeThreadPid", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_cpu_thread_name", property="topCpuThreadName", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_time_thread_name", property="topTimeThreadName", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_cpu_thread_status", property="topCpuThreadStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_time_thread_status", property="topTimeThreadStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="top_cpu_thread_usage", property="topCpuThreadUsage", jdbcType=JdbcType.DOUBLE),
        @Result(column="top_time_thread_usage", property="topTimeThreadUsage", jdbcType=JdbcType.DOUBLE),
        @Result(column="total_connection_num", property="totalConnectionNum", jdbcType=JdbcType.INTEGER)
    })
    List<MonitorIndex> selectAll();

    @Update({
        "update monitor_index",
        "set pid = #{pid,jdbcType=VARCHAR},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "total_gc_time = #{totalGcTime,jdbcType=DOUBLE},",
          "full_gc_count = #{fullGcCount,jdbcType=INTEGER},",
          "full_gc_time = #{fullGcTime,jdbcType=DOUBLE},",
          "young_gc_count = #{youngGcCount,jdbcType=INTEGER},",
          "young_gc_time = #{youngGcTime,jdbcType=DOUBLE},",
          "young_min_capacity = #{youngMinCapacity,jdbcType=DOUBLE},",
          "young_max_capacity = #{youngMaxCapacity,jdbcType=DOUBLE},",
          "young_current_capacity = #{youngCurrentCapacity,jdbcType=DOUBLE},",
          "eden_capacity = #{edenCapacity,jdbcType=DOUBLE},",
          "s0_capacity = #{s0Capacity,jdbcType=DOUBLE},",
          "s1_capacity = #{s1Capacity,jdbcType=DOUBLE},",
          "old_min_capacity = #{oldMinCapacity,jdbcType=DOUBLE},",
          "old_max_capacity = #{oldMaxCapacity,jdbcType=DOUBLE},",
          "old_current_capacity = #{oldCurrentCapacity,jdbcType=DOUBLE},",
          "old_current_generation_capacity = #{oldCurrentGenerationCapacity,jdbcType=DOUBLE},",
          "meta_min_capacity = #{metaMinCapacity,jdbcType=DOUBLE},",
          "meta_max_capacity = #{metaMaxCapacity,jdbcType=DOUBLE},",
          "meta_current_capacity = #{metaCurrentCapacity,jdbcType=DOUBLE},",
          "compressed_class_min_capacity = #{compressedClassMinCapacity,jdbcType=DOUBLE},",
          "compressed_class_max_capacity = #{compressedClassMaxCapacity,jdbcType=DOUBLE},",
          "compressed_class_current_capacity = #{compressedClassCurrentCapacity,jdbcType=DOUBLE},",
          "last_full_gc_cause = #{lastFullGcCause,jdbcType=VARCHAR},",
          "current_full_gc_cause = #{currentFullGcCause,jdbcType=VARCHAR},",
          "s0_use_percent = #{s0UsePercent,jdbcType=DOUBLE},",
          "s1_use_percent = #{s1UsePercent,jdbcType=DOUBLE},",
          "eden_use_percent = #{edenUsePercent,jdbcType=DOUBLE},",
          "old_use_percent = #{oldUsePercent,jdbcType=DOUBLE},",
          "meta_use_percent = #{metaUsePercent,jdbcType=DOUBLE},",
          "compressed_class_use_percent = #{compressedClassUsePercent,jdbcType=DOUBLE},",
          "total_thread_num = #{totalThreadNum,jdbcType=INTEGER},",
          "running_thread_num = #{runningThreadNum,jdbcType=INTEGER},",
          "blocked_thread_num = #{blockedThreadNum,jdbcType=INTEGER},",
          "waiting_thread_num = #{waitingThreadNum,jdbcType=INTEGER},",
          "timed_waiting_thread_num = #{timedWaitingThreadNum,jdbcType=INTEGER},",
          "top_cpu_thread_pid = #{topCpuThreadPid,jdbcType=VARCHAR},",
          "top_time_thread_pid = #{topTimeThreadPid,jdbcType=VARCHAR},",
          "top_cpu_thread_name = #{topCpuThreadName,jdbcType=VARCHAR},",
          "top_time_thread_name = #{topTimeThreadName,jdbcType=VARCHAR},",
          "top_cpu_thread_status = #{topCpuThreadStatus,jdbcType=VARCHAR},",
          "top_time_thread_status = #{topTimeThreadStatus,jdbcType=VARCHAR},",
          "top_cpu_thread_usage = #{topCpuThreadUsage,jdbcType=DOUBLE},",
          "top_time_thread_usage = #{topTimeThreadUsage,jdbcType=DOUBLE},",
          "total_connection_num = #{totalConnectionNum,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MonitorIndex record);
}