package com.dynagility.leavingtoolportal.model;

import java.util.Date;
<<<<<<< Upstream, based on development
=======
import java.util.HashSet;
import java.util.Set;
>>>>>>> d324e49 all model

import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< Upstream, based on development
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.dynagility.leavingtoolportal.util.CustomDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "employee")
@DynamicUpdate
public class Employee {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "balance_day", nullable = true)
    private Integer balanceDay;

    @Column(name = "deducted_day", nullable = true)
    private Integer deductedDay;

    @Column(name = "position_id", nullable = true)
    private String positionId;

    @JsonFormat(pattern = CustomDateDeserializer.DATE_PATTERN)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @Column(name = "join_date", nullable = true)
    private Date joinDate;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBalanceDay() {
        return balanceDay;
    }

    public void setBalanceDay(Integer balanceDay) {
        this.balanceDay = balanceDay;
    }

    public Integer getDeductedDay() {
        return deductedDay;
    }

    public void setDeductedDay(Integer deductedDay) {
        this.deductedDay = deductedDay;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
=======
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", nullable = false, length = 255)
	private String id; // GUID

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@Column(name = "balance_day", nullable = false)
	private Integer balanceDay;

	@Column(name = "deducted_day", nullable = false)
	private Integer deductedDay;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id", nullable = false)
	private String positionId;

	@Temporal(TemporalType.DATE)
	@Column(name = "join_date", length = 0)
	private Date joinDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<LeaveDetail> leaveDetails = new HashSet<LeaveDetail>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Dc> dcs = new HashSet<Dc>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Project> projects = new HashSet<Project>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<EmployeeProject> employeeProjects = new HashSet<EmployeeProject>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Account> accounts = new HashSet<Account>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private Set<Program> programs = new HashSet<Program>(0);

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBalanceDay() {
		return balanceDay;
	}

	public void setBalanceDay(Integer balanceDay) {
		this.balanceDay = balanceDay;
	}

	public Integer getDeductedDay() {
		return deductedDay;
	}

	public void setDeductedDay(Integer deductedDay) {
		this.deductedDay = deductedDay;
	}

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Set<LeaveDetail> getLeaveDetails() {
		return leaveDetails;
	}

	public void setLeaveDetails(Set<LeaveDetail> leaveDetails) {
		this.leaveDetails = leaveDetails;
	}

	public Set<Dc> getDcs() {
		return dcs;
	}

	public void setDcs(Set<Dc> dcs) {
		this.dcs = dcs;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<EmployeeProject> getEmployeeProjects() {
		return employeeProjects;
	}

	public void setEmployeeProjects(Set<EmployeeProject> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(Set<Program> programs) {
		this.programs = programs;
	}
	
	
>>>>>>> d324e49 all model
}