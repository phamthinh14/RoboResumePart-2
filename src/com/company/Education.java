package com.company;

public class Education {
    private String degree;
    private String major;
    private String schoolName;
    private String year;

    public Education(String degree, String major, String schoolName, String year) {
        this.degree = degree;
        this.major = major;
        this.schoolName = schoolName;
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        String result;
        result =  "\n Name of the degree: " + this.degree + "\n Major in " + this.major + "\n Acquired from school "
                + this.schoolName + " in the year of " + this.year + "\n";
        return result;
    }
}
