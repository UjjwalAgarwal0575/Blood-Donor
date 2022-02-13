package com.example.blooddonor;

public class Donor {
    private String UserName;
    private String MobileNum;
    private String Password;
    private String DistrictName;

    public Donor(String mobileNum, String districtName, String userName, String password) {
        UserName = userName;
        MobileNum = mobileNum;
        Password = password;
        DistrictName = districtName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getMobileNum() {
        return MobileNum;
    }

    public void setMobileNum(String mobileNum) {
        MobileNum = mobileNum;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String districtName) {
        DistrictName = districtName;
    }
}
