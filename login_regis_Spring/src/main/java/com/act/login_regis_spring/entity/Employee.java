package com.act.login_regis_spring.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "employee_react")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_Id", length = 45)

    private int employeeId;
    @Column(name = "employee_name", length = 255)

    private String employeeName;
    @Column(name = "email", length = 255)

    private String email;
    @Column(name = "password", length = 255)

    private String password;

//    @Column(name = "conf_password", length = 255)
//
//    private String confPassword;


//    public Employee(String confPassword) {
//        this.confPassword = confPassword;
//    }

    public Employee(int employeeId, String employeeName, String email, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;

    }

    public Employee() {
    }

//    public String getConfPassword() {
//        return confPassword;
//    }
//
//    public void setConfPassword(String confPassword) {
//        this.confPassword = confPassword;
//    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
//                ", confPassword='" + confPassword + '\'' +
                '}';
    }
}
