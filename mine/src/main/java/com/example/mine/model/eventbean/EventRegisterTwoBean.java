package com.example.mine.model.eventbean;

public class EventRegisterTwoBean {

    private String name;
    private String hospital;
    private String department;
    private String title;

    public EventRegisterTwoBean(String name, String hospital, String department, String title) {
        this.name = name;
        this.hospital = hospital;
        this.department = department;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
