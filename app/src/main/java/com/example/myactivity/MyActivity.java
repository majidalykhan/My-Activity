package com.example.myactivity;

public class MyActivity {

    String titleActivity, descActivity, dateActivity;

    public MyActivity() {
    }

    public MyActivity(String titleActivity, String descActivity, String dateActivity) {
        this.titleActivity = titleActivity;
        this.descActivity = descActivity;
        this.dateActivity = dateActivity;
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
