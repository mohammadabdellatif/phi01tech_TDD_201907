package com.newaeon.training;

public class Talent extends User {

    private String type;
    private String fullName;
    private String mobile;

    public Talent(String username, String password) {
        super(username, password);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
