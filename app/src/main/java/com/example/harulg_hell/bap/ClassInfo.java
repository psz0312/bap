package com.example.harulg_hell.bap;

public class ClassInfo {
    public static final int NULLPTR = 100;
    public static final String NULLCLASS = "#";
    public boolean isValid = false;
    public String title = "", location = "", rawtime = "";
    public int wday = NULLPTR, shour = NULLPTR, smin = NULLPTR, ehour = NULLPTR, emin = NULLPTR;

    public ClassInfo(String title, String location, String rawtime, int wday){
        this.title = title;
        this.location = location;
        this.rawtime = rawtime;
        this.wday = wday;
        rawToMean();
    }

    public ClassInfo(String title, String location, String rawtime){
        this.title = title;
        this.location = location;
        this.rawtime = rawtime;
    }

    public ClassInfo(String title, String location, String rawtime, int wday, boolean isValid){
        this.title = title;
        this.location = location;
        this.rawtime = rawtime;
        this.wday = wday;
        this.isValid = isValid;
        rawToMean();
    }

    public void rawToMean(){
        if(rawtime.length() < 10) return;
        shour = Integer.parseInt(rawtime.substring(0, 2).trim());
        smin = Integer.parseInt(rawtime.substring(3, 5).trim());
        ehour = Integer.parseInt(rawtime.substring(8, 10).trim());
        emin = Integer.parseInt(rawtime.substring(11, 13).trim());
    }
}
