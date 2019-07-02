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
    }

    private void DisplayMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Press 1 to add resume\n")
                .append("Press 2 to display all the resumes\n")
                .append("Press 3 to find people with a specific skill\n");
        System.out.println(menu);
    }

    public void MenuSelect() {
        String answer;
        int option;

        do {
            DisplayMenu();
            option = new Scanner(System.in).nextInt();
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
                default:
                    System.out.println("Invalid options");

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
        if (this.controller.getIdentityList().isEmpty()) {
            System.out.println(EMPTY_LIST_NOTICE);
        }
        if (!this.controller.getIdentityList().isEmpty()) {
            System.out.println("What skill do you want to find?");
            skillWanted = new Scanner(System.in).nextLine();
            for (int i = 0; i < this.controller.getIdentityList().size(); i++) {
                for (int j = 0; j < this.controller.getIdentityList().get(i).getSkillList().size(); j++) {
                    if (this.controller.getIdentityList().get(i).getSkillList().get(j).getSkillName().equalsIgnoreCase(skillWanted)) {
                        this.foundPeopleList.add(this.controller.getIdentityList().get(i));
                    }
                }

            }
            if (this.foundPeopleList.isEmpty()) {
                System.out.println("We cannot find the people with the skill " + skillWanted + " like you specified");
            }
            if (!this.foundPeopleList.isEmpty()) {
                PeopleFoundBySkillName();
            }
        }
    }

    private void PeopleFoundBySkillName() {
        for (int i = 0; i < this.foundPeopleList.size(); i++) {
            System.out.println(this.foundPeopleList.get(i));
        }
    }
}
