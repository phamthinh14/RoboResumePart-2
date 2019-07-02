package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recruiter {
    private final String ASKING_PROMPT = "Do you want to ";
    private final String ASKING_TO_QUIT_PROMPT = " If yes press any key, press q to quit";
    private final String EMPTY_LIST_NOTICE = "The list is empty";
    private Controller controller = new Controller();
    private List<Identity> foundPeopleList = new ArrayList<>();


    public Recruiter() {

        System.out.println("\t\t\t\tWELCOME\n");
//        DisplayMenu();
        MenuSelect();
//        this.controller.SampleResume();
    }

    private void DisplayMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("1/ Press 1 to add resume\n")
                .append("2/ Press 2 to display all the resumes\n")
                .append("3/ Press 3 to find people with a specific skill\n")
                .append("4/ Press 4 to change Name/Email/Phone Number\n")
                .append("Rules: If you type in characters. We will assume that you want to add a resume.");
        System.out.println(menu);
    }

    public void MenuSelect() {
        String answer;
        int option = 1;

        do {
            DisplayMenu();
            try {
                option = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("You typed in character(s). Below is a form for you to input your information for your resume");
            }
            switch (option) {
                case 1:
                    this.controller.AddPeopleResume();
                    break;
                case 2:
                    DisplayAllResume();
                    break;
                case 3:
                    DisplayAllNameWithSpecificSkill();
                    break;
                case 4:
                    this.controller.ChangeIdentity();
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
            System.out.println(ASKING_PROMPT + "choose another option?" + ASKING_TO_QUIT_PROMPT);
            answer = new Scanner(System.in).nextLine();
        } while (!answer.equalsIgnoreCase("q"));

    }

    private void DisplayAllResume() {
        if (this.controller.getIdentityList().isEmpty()) {
            System.out.println(EMPTY_LIST_NOTICE);
        }
        if (!this.controller.getIdentityList().isEmpty()) {
            this.controller.getIdentityList().forEach(System.out::println);
        }
    }

    private void DisplayAllNameWithSpecificSkill() {
        String skillWanted;
        boolean isFound = false;
        if (this.controller.getIdentityList().isEmpty()) {
            System.out.println(EMPTY_LIST_NOTICE);
        }
        if (!this.controller.getIdentityList().isEmpty()) {
            System.out.println("What skill do you want to find?");
            skillWanted = new Scanner(System.in).nextLine();
            for (int i = 0; i < this.controller.getIdentityList().size(); i++) {
                for (int j = 0; j < this.controller.getIdentityList().get(i).getSkillList().size(); j++) {
                    if (this.controller.getIdentityList().get(i).getSkillList().get(j).getSkillName().equalsIgnoreCase(skillWanted)) {
                        System.out.println(this.controller.getIdentityList().get(i));
                        isFound = true;
                    }
                }

            }
            if (!isFound) {
                System.out.println("We cannot find the people with the skill " + skillWanted + " like you specified");
            }
//            if (!this.foundPeopleList.isEmpty()) {
//                PeopleFoundBySkillName();
//            }
        }
    }

//    private void PeopleFoundBySkillName() {
//        this.foundPeopleList.forEach(System.out::println);
//    }
}
