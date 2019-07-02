package com.company;

import java.util.ArrayList;
import java.util.List;

public class Identity {
    private String ID;
    private String name;
    private String email;
    private String phoneNumbers;
    private List<Education> educationList = new ArrayList<>();
    private List<Experience> experienceList = new ArrayList<>();
    private List<Skill> skillList = new ArrayList<>();

    public Identity() {
    }

    public Identity(String name, String email, String phoneNumbers, List<Education> educationList, List<Experience> experienceList, List<Skill> skillList) {
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.educationList = educationList;
        this.experienceList = experienceList;
        this.skillList = skillList;
    }

    public Identity(String ID, String name, String email, String phoneNumbers, List<Education> educationList, List<Experience> experienceList, List<Skill> skillList) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.educationList = educationList;
        this.experienceList = experienceList;
        this.skillList = skillList;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    @Override
    public String toString() {
        String education = "";
        String experience = "";
        String skills = "";
        String result;
        for (int i = 0; i < this.educationList.size(); i++) {
            education += this.educationList.get(i);
        }
        for (int i = 0; i < this.experienceList.size(); i++) {
            experience += this.experienceList.get(i);
        }
        for (int i = 0; i < this.skillList.size(); i++) {
            skills += this.skillList.get(i);
        }
        result = "====================================================================\n" +
                "IDENTITY: \n" +
                "\n" +
                " " + this.ID + "\n" +
                " " + this.name + "\n" +
                " " + this.email + "\n" +
                " " + this.phoneNumbers + "\n" +
                "\nEDUCATION:\n" +
                education + "\n" +
                "EXPERIENCE:\n" +
                experience + "\n" +
                "SKILL:\n" +
                skills + "\n";
        return result;
    }
}
