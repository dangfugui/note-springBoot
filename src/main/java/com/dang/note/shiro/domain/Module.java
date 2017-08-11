package com.dang.note.shiro.domain;

import java.io.Serializable;
import java.util.Set;

public class Module implements Serializable{
    private int mid;
    private String mname;
    private Set<Role> roles;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
