package com.company;

public class Experience {
    private String companyName;
    private String title;
    private String date;
    private String description;

    public Experience(String companyName, String title, String date, String description) {
        this.companyName = companyName;
        this.title = title;
        this.date = date;
        this.description = description;
    }

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

    @Override
    public String toString() {
        String result;
        result = "\n Title: " + this.title +
                "\n Company Name: " + this.companyName +
                "\n Date: " + this.date +
                "\n Description:\n" + this.description + "\n";
        return result;
    }
}
