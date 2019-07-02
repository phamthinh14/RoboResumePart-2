package com.company;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        new Recruiter();
        String name;
        String email;
        String noise;
        String content = " j";
        List<String> stringList = new ArrayList<>();


        Path path = Paths.get("Data.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Read text file using Scanner");
//read line by line
        while (scanner.hasNextLine()) {
            //process each line
            String line = scanner.nextLine();
            stringList.add(line);

        }
        scanner.close();

        System.out.println(stringList.size());

        System.out.println(stringList);


    }
}
