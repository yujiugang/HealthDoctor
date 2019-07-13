package com.example.mine.model.eventbean;

public class EventRegisterBean {

    private String email;
    private String inputCode;
    private String pwd1;
    private String pwd2;

    public EventRegisterBean(String email, String inputCode, String pwd1, String pwd2) {
        this.email = email;
        this.inputCode = inputCode;
        this.pwd1 = pwd1;
        this.pwd2 = pwd2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode;
    }

    public String getPwd1() {
        return pwd1;
    }

    public void setPwd1(String pwd1) {
        this.pwd1 = pwd1;
    }

    public String getPwd2() {
        return pwd2;
    }

    public void setPwd2(String pwd2) {
        this.pwd2 = pwd2;
    }
}
