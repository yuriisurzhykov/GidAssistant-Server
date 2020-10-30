package com.yuriysurzhikov.gidassistant.model.client;

import com.sun.istack.Nullable;
import com.yuriysurzhikov.gidassistant.utils.DateUtils;

import java.util.*;

public class UserFromClient {

    /* Field for user data as person */
    private String id;
    private String name;
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

    public UserFromClient() {
        id = UUID.randomUUID().toString();
        name = "";
        passwd = "";
        birthday = Calendar.getInstance().getTime().getTime();
        city = new CityFromClient();
        ip = null;
        loginTime = null;
        phoneData = null;
    }

    public UserFromClient(String id,
                          String name,
                          String passwd,
                          Long birthday,
                          Integer age,
                          CityFromClient city,
                          List<InterestFromClient> interests,
                          String ip,
                          Long loginTime,
                          String phoneData) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
        this.birthday = birthday;
        this.city = city;
        this.interests = interests;
        this.ip = ip;
        this.loginTime = loginTime;
        this.phoneData = phoneData;
    }

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
}
