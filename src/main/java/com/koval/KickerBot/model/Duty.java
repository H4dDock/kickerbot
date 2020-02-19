package com.koval.KickerBot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "duties")
@Entity
public class Duty {
    @Id
    private Long id;
    @Column(nullable = false)
    private String dutyName;
    @Column
    private String dutyDescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getDutyDescription() {
        return dutyDescription;
    }

    public void setDutyDescription(String dutyDescription) {
        this.dutyDescription = dutyDescription;
    }
}
