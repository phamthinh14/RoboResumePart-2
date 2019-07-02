package com.company;

import java.util.*;
import java.util.regex.Pattern;

public class Controller {
    private final String ENTER_PROMPT = "Please enter your ";
    private final String ASKING_PROMPT = "Do you want to ";
    private final String ASKING_TO_QUIT_PROMPT = " If yes press any key, press q to quit";
    private final String EMPTY_LIST_NOTICE = "The list is empty";
    private List<Identity> identityList = new ArrayList<>();
    private List<String> uniqueIDList = new ArrayList<>();

    public Controller() {
//        SampleResume();
    }

    public List<Identity> getIdentityList() {
        return identityList;
    }

    public void setIdentityList(List<Identity> identityList) {
        this.identityList = identityList;
    }

//    private void SampleResume() {
//        List<Identity> identityList = new ArrayList<>();
//        List<Education> educationList = new ArrayList<>();
//        List<Experience> experienceList = new ArrayList<>();
//        List<Skill> skillList = new ArrayList<>();
//
//        Education education1 = new Education("Bachelor", "Psychology", "Borwn University", "2016-2028");
//        Experience experience1 = new Experience("Domino Pizza", "Calm down Therapist", "06/06/2011", "There are a lot of angry people, this job is to calm them down");
//        Skill skill1 = new Skill("Calm people down", 2);
//        Education education2 = new Education("Associate", "Math", "University BLVD", "2016-2021");
//        Experience experience2 = new Experience("Pizza Hut", "Algorithm Inventor", "09/11/2015", "Create algorithm for software engineers");
//        Skill skill2 = new Skill("Matlab", 3);
//
//        System.out.println("\t\t\t\tBELOW IS A SAMPLE RESUME");
//        educationList.add(education1);
//        educationList.add(education2);
//        experienceList.add(experience1);
//        experienceList.add(experience2);
//        skillList.add(skill1);
//        skillList.add(skill2);
////        String name, String email, String phoneNumbers, List<Education> educationList, List<Experience> experienceList, List<Skill> skillList
//        identityList.add(new Identity("John Doe", "Doe11@gmail.com", "2407022014", educationList, experienceList, skillList));
//        identityList.stream().forEach(System.out::println);
//    }

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
