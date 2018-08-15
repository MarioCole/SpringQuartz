package com.supermap.entity;

import javax.persistence.*;

@Entity
@Table(name = "ScheduleJob")
public class ScheduleJob {

    /**
     * id
     */
    private Long id;

    /**
     * job名称
     */
    private String jobName;

    /**
     * job组名
     */
    private String jobGroupName;

    /**
     * cron表达式
     */
    private String cronExpression;

    /**
     * job状态 1为执行 0为暂停
     */
    private String jobState;

    /**
     * job所在包 一个job对应一个包
     */
    private String jobLocation;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "jobName")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Column(name = "jobGroupName")
    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    @Column(name = "cronExpression")
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Column(name = "jobState")
    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    @Column(name = "jobLocation")
    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    @Override
    public String toString() {
        return "ScheduleJob{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobGroupName='" + jobGroupName + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", jobState='" + jobState + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                '}';
    }
}
