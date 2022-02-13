package com.bolingcavalry.mavendockerplugindemo.VO;

import com.bolingcavalry.mavendockerplugindemo.PO.User;

public class UserVO {
    private long id;
    private String username;
    private String password;
    private int role;

    public UserVO(User user){
        this.id=user.getId();
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
