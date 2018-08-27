package com.supermap.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RunnableJob")
public class RunnableJob {
    /**
     * 主键
     */
    private Long id;

    /**
     * 类型
     */
    private String runnable_type;

    /**
     * 状态
     */
    private String runnable_state;

    /**
     * 开始时间
     */
    private Date runnable_starttime;

    /**
     * 结束时间
     */
    private Date runnable_endtime;

    private ScheduleJob scheduleJob;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "runnable_type")
    public String getRunnable_type() {
        return runnable_type;
    }

    public void setRunnable_type(String runnable_type) {
        this.runnable_type = runnable_type;
    }

    @Column(name = "runnable_state")
    public String getRunnable_state() {
        return runnable_state;
    }

    public void setRunnable_state(String runnable_state) {
        this.runnable_state = runnable_state;
    }

    @Column(name = "runnable_endtime")
    public Date getRunnable_endtime() {
        return runnable_endtime;
    }

    public void setRunnable_endtime(Date runnable_endtime) {
        this.runnable_endtime = runnable_endtime;
    }

    @Column(name = "runnable_starttime")
    public Date getRunnable_starttime() {
        return runnable_starttime;
    }

    public void setRunnable_starttime(Date runnable_starttime) {
        this.runnable_starttime = runnable_starttime;
    }


    @ManyToOne(targetEntity = ScheduleJob.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "schedulejob_id")
    public ScheduleJob getScheduleJob() {
        return scheduleJob;
    }

    public void setScheduleJob(ScheduleJob scheduleJob) {
        this.scheduleJob = scheduleJob;
    }

    @Override
    public String toString() {
        return "RunnableJob{" +
                "id=" + id +
                ", runnable_type='" + runnable_type + '\'' +
                ", runnable_state='" + runnable_state + '\'' +
                ", runnable_starttime=" + runnable_starttime +
                ", runnable_endtime=" + runnable_endtime +
                '}';
    }
}
