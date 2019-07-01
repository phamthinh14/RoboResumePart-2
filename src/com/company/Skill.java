package com.company;

public class Skill {
    private String skillName;
    private String competencyProficiency;
    private int level;

    public Skill(String skillName, String competencyProficiency) {
        this.skillName = skillName;
        this.competencyProficiency = competencyProficiency;
    }

    public Skill(String skillName, int level) {
        this.skillName = skillName;
//        (Fundamental, Novice, Intermediate, Advanced, Expert
        this.level = level;
        switch (this.level) {
            case 1:
                this.competencyProficiency = "Fundamental";
                break;
            case 2:
                this.competencyProficiency = "Novice";
                break;
            case 3:
                this.competencyProficiency = "Intermediate";
                break;
            case 4:
                this.competencyProficiency = "Advanced";
                break;
            case 5:
                this.competencyProficiency = "Expert";
                break;
            default:
                System.out.println("Your level will be automatically set to Fundamental");
                this.competencyProficiency = "Fundamental";
        }


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
