package com.jngkang;

import com.jngkang.anno.DataRange;
import com.jngkang.enumeration.StringTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author JngKang
 * @date 2022-03-19 22:22
 * @description Employee entity class
 */
public class Emp {
    /**
     * Employee ID
     */
    @DataRange(min = 100000, max = 999999)
    private Integer empno;
    /**
     * Employee name
     */
    @DataRange(type = StringTypeEnum.CHINESE_NAME, minLen = 10, maxLen = 20)
    private String ename;
    /**
     * Job
     */
    @DataRange(type = StringTypeEnum.CHINESE, minLen = 2, maxLen = 2)
    private String job;
    /**
     * Senior leader number
     */
    @DataRange(min = 1000, max = 9999)
    private Integer mgr;
    /**
     * Date of employment
     */
    @DataRange(startDate = "2010-1-1", endDate = "2011-1-1")
    private LocalDate hiredate;
    /**
     * Salary
     */
    @DataRange(bigMin = 4, bigMax = 6, precision = 2)
    private BigDecimal sal;
    /**
     * Bonus
     */
    @DataRange(bigMin = 3, bigMax = 6, precision = 2)
    private BigDecimal comm;
    /**
     * Email
     */
    @DataRange(type = StringTypeEnum.EMAIL)
    private String email;

    /**
     * Phone number
     */
    @DataRange(type = StringTypeEnum.PHONE_NUM)
    private String phone;

    /**
     * Information entry time
     */
    @DataRange(startDateTime = "2010-1-1 0:0:0", endDateTime = "2011-1-1 0:0:0")
    private LocalDateTime inputTime;

    /**
     * Department Number
     */
    @DataRange(min = 10, max = 99)
    private Integer deptno;

    public Emp() {
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getInputTime() {
        return inputTime;
    }

    public void setInputTime(LocalDateTime inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", inputTime=" + inputTime +
                ", deptno=" + deptno +
                '}';
    }
}
