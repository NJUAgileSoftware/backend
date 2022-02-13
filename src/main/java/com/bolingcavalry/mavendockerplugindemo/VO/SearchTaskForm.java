package com.bolingcavalry.mavendockerplugindemo.VO;

public class SearchTaskForm {

    private String searchText;

    /**
     *  state 为-1意思为该角色在可见权限内所有状态的任务
     */
    private int state;

    private int userRole;

    private int current;

    public SearchTaskForm(){}
    public SearchTaskForm(String searchText, int state, int userRole, int current){
        this.searchText = searchText;
        this.state = state;
        this.userRole = userRole;
        this.current = current;
    }

    public String getSearchText() {
        return searchText;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
