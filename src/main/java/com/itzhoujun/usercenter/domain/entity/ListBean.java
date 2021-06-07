package com.itzhoujun.usercenter.domain.entity;

import net.sf.json.JSONObject;



public class ListBean {
    private int id;
    private JSONObject list;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONObject getlist() {
        return list;
    }

    public void setlist(JSONObject time) {
        this.list = list;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }



}
