package com.jeremy;

import java.util.*;

public class LakesManager {

    static Scanner StringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //initializing the variables and calling the methods
        System.out.println("How many parks and times do you want to enter?");
        int amountEntered = numberScanner.nextInt();


        //creating a linked hash map to keep the names and times of the lake
        LinkedHashMap<String, List<Double>> totalTimeAndPark = new LinkedHashMap<>();
        //creating array lists to store info about the names and times
        ArrayList<String> getName = new ArrayList<>();
        ArrayList<Double> timed = new ArrayList<>();
        List<Double> times;

        //for loop to get the user input and add the user input to the lists
        for (int i = 0; i < amountEntered; i++) {
            System.out.println("What is the name of the lake?");
            String userInput = StringScanner.nextLine();
            System.out.println("What is the time you ran at that lake?");
            double timeRan = numberScanner.nextDouble();
            getName.add(userInput);
            timed.add(timeRan);
            times = totalTimeAndPark.get(userInput);
            //if statement to add multiple runtimes to the same key name, and change when a new name is entered
            if (times == null) {
                times = new ArrayList<>();
                totalTimeAndPark.put(userInput, times);
            }
            //sorting the times lowest to highest
            times.add(timeRan);
            Collections.sort(times);

        }
        //for loop to print the user input as entered in
        for(int i = 0 ; i < timed.size() ; i++){
            System.out.println(getName.get(i) + ", " + timed.get(i));
        }
        System.out.println();

        //using a Linked hash set to remove the double names, and keep the order of the user input
        getName = new ArrayList<>(new LinkedHashSet<>(getName));

        //using a for each to get the lowest values and to print the names of the lakes
        System.out.println("Best Times:");
        int i = 0;
        for (List<Double> lakes : totalTimeAndPark.values()) {
            System.out.println(getName.get(i) + ", " + lakes.get(0));
            i++;
        }


        numberScanner.close();

    }

}

