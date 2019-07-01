package com.company;

public class Skill {
    private String skillName;
    private String competencyProficiency;

    public Skill(String skillName, String competencyProficiency) {
        this.skillName = skillName;
        this.competencyProficiency = competencyProficiency;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getCompetencyProficiency() {
        return competencyProficiency;
    }

    public void setCompetencyProficiency(String competencyProficiency) {
        this.competencyProficiency = competencyProficiency;
    }

    @Override
    public String toString() {
        String result;
        result = "\n" + " " + this.skillName + "- Competency Proficiency: " + this.competencyProficiency + "\n";
        return result;
    }
}
