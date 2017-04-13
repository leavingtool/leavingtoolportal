package com.dynagility.leavingtoolportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "program")
@DynamicUpdate
public class Program {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dc_id", nullable = false)
    private Dc dc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sm_pc_employee_id", nullable = false)
    private Employee smPcEmployee;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dc getDc() {
        return dc;
    }

    public void setDc(Dc dc) {
        this.dc = dc;
    }

    public Employee getSmPcEmployee() {
        return smPcEmployee;
    }

    public void setSmPcEmployee(Employee smPcEmployee) {
        this.smPcEmployee = smPcEmployee;
    }
}
