package com.supermap.entity;

import javax.persistence.*;
import java.util.Date;

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
     * job类型
     */
    private String jobType;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

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

    @Column(name = "jobType")
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @Column(name = "startDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ScheduleJob{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobGroupName='" + jobGroupName + '\'' +
                ", cronExpression='" + cronExpression + '\'' +
                ", jobState='" + jobState + '\'' +
                ", jobType='" + jobType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
