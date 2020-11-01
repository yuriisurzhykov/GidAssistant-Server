package com.yuriysurzhikov.gidassistant.model.client;

import com.sun.istack.Nullable;

import java.util.*;

public class UserFromClient {

    /* Field for user data as person */
    private String serverId;
    private String name;
    private String login;
    private String email;
    private String passwd;
    private Long birthday;
    private CityFromClient city;
    private List<InterestFromClient> interests = new ArrayList<>();

    /* Technical data user data*/
    @Nullable
    private String ip;
    @Nullable
    private Long loginTime;
    @Nullable
    private String phoneData;
    @Nullable
    private String macAddr;

    public UserFromClient() {
        serverId = null;
        name = "";
        passwd = "";
        login = "";
        email = "";
        birthday = Calendar.getInstance().getTime().getTime();
        city = new CityFromClient();
        ip = null;
        loginTime = null;
        phoneData = null;
    }

    public UserFromClient(String serverId,
                          String name,
                          String login,
                          String email,
                          String passwd,
                          Long birthday,
                          CityFromClient city,
                          List<InterestFromClient> interests,
                          String ip,
                          Long loginTime,
                          String phoneData,
                          String macAddr) {
        this.serverId = serverId;
        this.name = name;
        this.login = login;
        this.email = email;
        this.passwd = passwd;
        this.birthday = birthday;
        this.city = city;
        this.interests = interests;
        this.ip = ip;
        this.loginTime = loginTime;
        this.phoneData = phoneData;
        this.macAddr = macAddr;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public CityFromClient getCity() {
        return city;
    }

    public void setCity(CityFromClient city) {
        this.city = city;
    }

    public List<InterestFromClient> getInterests() {
        return interests;
    }

    public void setInterests(List<InterestFromClient> interests) {
        this.interests = interests;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Long loginTime) {
        this.loginTime = loginTime;
    }

    public String getPhoneData() {
        return phoneData;
    }

    public void setPhoneData(String phoneData) {
        this.phoneData = phoneData;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }
}
