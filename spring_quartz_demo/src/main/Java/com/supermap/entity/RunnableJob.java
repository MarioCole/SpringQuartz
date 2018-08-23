package com.supermap.entity;

import javax.persistence.*;
import java.util.Set;

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
    private String type;

    //private Set<ScheduleJob> scheduleJobs;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
    @ManyToMany(mappedBy = "Runnable",cascade = CascadeType.ALL)
    public Set<ScheduleJob> getScheduleJobs() {
        return scheduleJobs;
    }

    public void setScheduleJobs(Set<ScheduleJob> scheduleJobs) {
        this.scheduleJobs = scheduleJobs;
    }*/

    @Override
    public String toString() {
        return "RunnableJob{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
