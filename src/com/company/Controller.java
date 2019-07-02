package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final String ENTER_PROMPT = "Please enter your ";
    private final String ASKING_PROMPT = "Do you want to ";
    private final String ASKING_TO_QUIT_PROMPT = " If yes press any key, press q to quit";
    private final String EMPTY_LIST_NOTICE = "The list is empty";
    private List<Identity> identityList = new ArrayList<>();
    private List<String> uniqueIDList = new ArrayList<>();

    public Controller() {
        SampleResume();
    }

    public List<Identity> getIdentityList() {
        return identityList;
    }

    public void setIdentityList(List<Identity> identityList) {
        this.identityList = identityList;
    }

    public void SampleResume() {
//        Education(String degree, String major, String schoolName, String year) {
        List<Education> educationList1 = new ArrayList<>();
        List<Education> educationList2 = new ArrayList<>();
        List<Education> educationList3 = new ArrayList<>();
//        Experience(String companyName, String title, String date, List<String> descriptionList) {
        List<Experience> experienceList1 = new ArrayList<>();
        List<Experience> experienceList2 = new ArrayList<>();
        List<Experience> experienceList3 = new ArrayList<>();
        List<String> descriptionList1 = new ArrayList<>();
        List<String> descriptionList2 = new ArrayList<>();

        List<String> descriptionList2_1 = new ArrayList<>();
        List<String> descriptionList3 = new ArrayList<>();
//        Skill(String skillName, int level) {
        List<Skill> skillList1 = new ArrayList<>();
        List<Skill> skillList2 = new ArrayList<>();
        List<Skill> skillList3 = new ArrayList<>();

        educationList1.add(new Education("Bachelor", "Psychology", "MC", "1965"));
        educationList1.add(new Education("Certificate", "English", "MC", "1975"));
        descriptionList1.add("Treat mental problem");
        descriptionList1.add("Doing research");
        descriptionList1.add("Improve Productivity");
        experienceList1.add(new Experience("Yahoo", "Therapist", "06/01/2000", descriptionList1));
        skillList1.add(new Skill("Java", 1));
        skillList1.add(new Skill("Python", 2));
        skillList1.add(new Skill("SQL", 1));
        skillList1.add(new Skill("Go", 3));

        educationList2.add(new Education("Associate", "Socy", "UCLA", "1995"));
        educationList2.add(new Education("Certificate", "CPA", "MC", "2015"));
        descriptionList2.add("Conduct survey");
        descriptionList2.add("Doing research");
        descriptionList2_1.add("Help people in case of emergency");
        descriptionList2_1.add("Work in hospital");
        experienceList2.add(new Experience("Yahoo", "Therapist", "06/01/2000", descriptionList2));
        experienceList2.add(new Experience("Holy Cross Hospital", "Nurse", "04/22/2010", descriptionList2_1));
        skillList2.add(new Skill("SQL", 1));
        skillList2.add(new Skill("Tableau", 4));
        skillList2.add(new Skill("Go", 3));

        educationList3.add(new Education("", "", "", ""));
        descriptionList3.add("");
        experienceList3.add(new Experience("", "", "", descriptionList3));
        skillList3.add(new Skill("SQL", 1));
        skillList3.add(new Skill("Tableau", 4));
        skillList3.add(new Skill("Go", 3));
        skillList3.add(new Skill("Java", 5));

        this.identityList.add(new Identity("B56", "John Doe", "Doe11@gmail.com", "2407022014", educationList1, experienceList1, skillList1));
        this.identityList.add(new Identity("X13", "Maria Doe", "Mari_22@hotmail.com", "3107011111", educationList2, experienceList2, skillList2));
        this.identityList.add(new Identity("T65", "Lily", "LilyChase7@outlook.com", "7428880171", educationList3, experienceList3, skillList3));

//        this.identityList.stream().forEach(System.out::println);
    }

    public void AddPeopleResume() {
        String answer;
        do {
            this.identityList.add(new Identity(AddID(), AddName(), AddEmail(), AddPhoneNumber(), AddEducation(), AddExperience(), AddSkills()));
            System.out.println(ASKING_PROMPT + "add another person's resume?" + ASKING_TO_QUIT_PROMPT);
            answer = new Scanner(System.in).nextLine();
        } while (!answer.equalsIgnoreCase("q"));
    }

    private String AddID() {
        String idUserInput;
        boolean isDuplicate = false;

        System.out.println(ENTER_PROMPT + "ID(You can enter anything(Recruiters will use this ID to find your resume). For example: C92)");
        idUserInput = new Scanner(System.in).nextLine();
        this.uniqueIDList.add(idUserInput);
        if (this.uniqueIDList.size() == 1) {
            System.out.println("Your ID has been created");
        }
        if (this.uniqueIDList.size() > 1) {
            while (!isDuplicate) {
                for (int i = 0; i < this.uniqueIDList.size() - 1; i++) {
                    if (this.uniqueIDList.get(i).equalsIgnoreCase(idUserInput)) {
                        isDuplicate = true;
                    }
                }
            }
            while (isDuplicate) {
                System.out.println("You ID is duplicated. Please type in again");
                idUserInput = new Scanner(System.in).nextLine();
                this.uniqueIDList.add(idUserInput);
                for (int i = 0; i < this.uniqueIDList.size() - 1; i++) {
                    if (!this.uniqueIDList.get(i).equalsIgnoreCase(idUserInput)) {
                        isDuplicate = false;
                    }
                }
                System.out.println("Your ID has been created");
            }
        }
        return idUserInput;
    }

    private String AddName() {
        String nameUserInput;
        System.out.println(ENTER_PROMPT + "name:");
        nameUserInput = new Scanner(System.in).nextLine();

        return nameUserInput;
    }

    private String AddEmail() {
        String emailUserInput;
        System.out.println(ENTER_PROMPT + "email:");
        emailUserInput = new Scanner(System.in).nextLine();
        return emailUserInput;
    }

    private String AddPhoneNumber() {
        String phoneNumbersUserInput;
        System.out.println(ENTER_PROMPT + "phone number:");
        phoneNumbersUserInput = new Scanner(System.in).nextLine();
        return phoneNumbersUserInput;
    }

    private List<Education> AddEducation() {
        String askMoreEducation;
        String degreeUserInput;
        String majorUserInput;
        String schoolNameUserInput;
        String yearUserInput;
        List<Education> educationList = new ArrayList<>();
        do {
            System.out.println(ENTER_PROMPT + "degree:");
            degreeUserInput = new Scanner(System.in).nextLine();
            System.out.println(ENTER_PROMPT + "major:");
            majorUserInput = new Scanner(System.in).nextLine();
            System.out.println(ENTER_PROMPT + "school name:");
            schoolNameUserInput = new Scanner(System.in).nextLine();
            System.out.println(ENTER_PROMPT + "school year:");
            yearUserInput = new Scanner(System.in).nextLine();

            educationList.add(new Education(degreeUserInput, majorUserInput, schoolNameUserInput, yearUserInput));
            System.out.println(ASKING_PROMPT + "add more education?" + ASKING_TO_QUIT_PROMPT);
            askMoreEducation = new Scanner(System.in).nextLine();
        } while (!askMoreEducation.equalsIgnoreCase("q"));
        return educationList;
    }

    private List<Experience> AddExperience() {
        String askMoreExperience;
        String askMoreDescription;
        String companyNameUserInput;
        String titleUserInput;
        String dateUserInput;
        String descriptionUserInput;
        List<Experience> experienceList = new ArrayList<>();
        List<String> descriptionList = new ArrayList<>();
        do {
            System.out.println(ENTER_PROMPT + "company name:");
            companyNameUserInput = new Scanner(System.in).nextLine();
            System.out.println(ENTER_PROMPT + "title:");
            titleUserInput = new Scanner(System.in).nextLine();
            System.out.println(ENTER_PROMPT + "starting and end date of work");
            dateUserInput = new Scanner(System.in).nextLine();

            do {
                System.out.println(ENTER_PROMPT + "job description:");
                descriptionUserInput = new Scanner(System.in).nextLine();
                descriptionList.add(descriptionUserInput);
                System.out.println(ASKING_PROMPT + "add more description?" + ASKING_TO_QUIT_PROMPT);
                askMoreDescription = new Scanner(System.in).nextLine();
            } while (!askMoreDescription.equalsIgnoreCase("q"));


            experienceList.add(new Experience(companyNameUserInput, titleUserInput, dateUserInput, descriptionList));
            System.out.println(ASKING_PROMPT + "add more experience?" + ASKING_TO_QUIT_PROMPT);
            askMoreExperience = new Scanner(System.in).nextLine();
        } while (!askMoreExperience.equalsIgnoreCase("q"));
        return experienceList;
    }

    private List<Skill> AddSkills() {
        String askMoreSkills;
        String skillNameUserInput;
        Integer competencyProficiencyUserInput = 0;
        List<Skill> skillList = new ArrayList<>();

        do {
            System.out.println(ENTER_PROMPT + "skills:");
            skillNameUserInput = new Scanner(System.in).nextLine();
            System.out.println(ENTER_PROMPT + "competency proficiency:");
            System.out.println("1 = Fundamental, 2 = Novice, 3 = Intermediate, 4 = Advanced, 5 = Expert," +
                    " or any other than that competency proficiency will be set to Fundamental");
            try {
                competencyProficiencyUserInput = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("You cannot type in characters. Your skill will be set to Fundamental");
            }
            skillList.add(new Skill(skillNameUserInput, competencyProficiencyUserInput));
            System.out.println(ASKING_PROMPT + "add more skills?" + ASKING_TO_QUIT_PROMPT);
            askMoreSkills = new Scanner(System.in).nextLine();
        } while (!askMoreSkills.equalsIgnoreCase("q"));
        return skillList;
    }

    public void ChangeIdentity() {
        String answer;
        String userInputToChange;
//        int userInput;
        if (this.identityList.isEmpty()) {
            System.out.println(EMPTY_LIST_NOTICE);
        }
        if (!this.identityList.isEmpty()) {
            do {
                System.out.println(ENTER_PROMPT + "id to change name/email/phone number");
                userInputToChange = new Scanner(System.in).nextLine();
                for (int i = 0; i < this.identityList.size(); i++) {
                    if (this.identityList.get(i).getID().equalsIgnoreCase(userInputToChange)) {
                        ChangeNameEmailPhoneNum(i);
                    }
                }
                System.out.println(ASKING_PROMPT + "change more?" + ASKING_TO_QUIT_PROMPT);
                answer = new Scanner(System.in).nextLine();
            } while (!answer.equalsIgnoreCase("q"));

        }
    }

    private void ChangeNameEmailPhoneNum(int indexToChange) {
        String answer;
        String userInputToChange;

        System.out.println("Here is your information: ");
        System.out.println(this.identityList.get(indexToChange));
        System.out.println("What do you want to change? Name? Email? Or Phone Number?");
        answer = new Scanner(System.in).nextLine();
        switch (answer.toLowerCase()) {
            case "name":
                System.out.println(ENTER_PROMPT + "new name");
                userInputToChange = new Scanner(System.in).nextLine();
                this.identityList.get(indexToChange).setName(userInputToChange);
                break;
            case "email":
                System.out.println(ENTER_PROMPT + "new email");
                userInputToChange = new Scanner(System.in).nextLine();
                this.identityList.get(indexToChange).setEmail(userInputToChange);
                break;
            case "phone number":
            case "phone numbers":
            case "phone":
            case "mobile phone":
            case "telephone":
            case "cell phone":
                System.out.println(ENTER_PROMPT + "new phone number");
                userInputToChange = new Scanner(System.in).nextLine();
                this.identityList.get(indexToChange).setPhoneNumbers(userInputToChange);
                break;
            default:
                System.out.println("Sorry. We do not understand what you want to change?");
        }
        System.out.println("Below is your changed information: ");
        System.out.println("====================================================================\n");
        System.out.println(this.identityList.get(indexToChange));
    }

}
