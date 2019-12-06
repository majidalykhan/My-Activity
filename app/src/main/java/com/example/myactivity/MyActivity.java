package com.example.myactivity;

public class MyActivity {

    String titleActivity;
    String descActivity;
    String dateActivity;
    String keyActivity;

    public MyActivity() {
    }

    public MyActivity(String titleActivity, String descActivity, String dateActivity, String keyActivity) {
        this.titleActivity = titleActivity;
        this.descActivity = descActivity;
        this.dateActivity = dateActivity;
        this.keyActivity = keyActivity;
    }

    public String getKeyActivity() {
        return keyActivity;
    }

    public void setKeyActivity(String keyActivity) {
        this.keyActivity = keyActivity;
    }

    public String getTitleActivity() {
        return titleActivity;
    }

    public void setTitleActivity(String titleActivity) {
        this.titleActivity = titleActivity;
    }

    public String getDescActivity() {
        return descActivity;
    }

    public void setDescActivity(String descActivity) {
        this.descActivity = descActivity;
    }

    public String getDateActivity() {
        return dateActivity;
    }

    public void setDateActivity(String dateActivity) {
        this.dateActivity = dateActivity;
    }
}
