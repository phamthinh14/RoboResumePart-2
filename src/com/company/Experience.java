package com.company;

import java.util.ArrayList;
import java.util.List;

public class Experience {
    private String companyName;
    private String title;
    private String date;
    private String description;
    private List<String> descriptionList;

    public Experience(String companyName, String title, String date, List<String> descriptionList) {
        this.companyName = companyName;
        this.title = title;
        this.date = date;
        this.descriptionList = descriptionList;
    }

//    public Experience(String companyName, String title, String date, String description) {
//        this.companyName = companyName;
//        this.title = title;
//        this.date = date;
//        this.description = description;
//    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<String> descriptionList) {
        this.descriptionList = descriptionList;
    }

    @Override
    public String toString() {
        String descriptionList = "";
        String result;

        for (int i = 0; i < this.getDescriptionList().size(); i++) {
            descriptionList += "\n Description " + (i + 1) + ":\n" + this.getDescriptionList().get(i) + "\n";
        }

        result = "\n Title: " + this.title +
                "\n Company Name: " + this.companyName +
                "\n Date: " + this.date +
                descriptionList + "\n";
        return result;
    }
}
