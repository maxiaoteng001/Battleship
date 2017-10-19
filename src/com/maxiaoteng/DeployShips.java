/*
* Deploy player’s ships
* */
package com.maxiaoteng;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DeployShips {
    //Users delay the ships
    public static ArrayList<Location> userdeployships() {
        ArrayList<Location> results = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Deploy your ships:");
        /*
        Here is some sample code where you ask the user to enter in the coordinates for where to place a ship
        */
        for (int i = 0; i < 5; i++) {
            while(true) {
                System.out.printf("Enter X coordinate for your %d ship: ", i + 1);
                int x = input.nextInt();
                System.out.printf("Enter Y coordinate for your %d ship: ", i + 1);
                int y = input.nextInt();
                Location temp = new Location();
                temp.setX(x);
                temp.setY(y);
                if (x >= 0 && x <= 9 && y >= 0 && y <= 9) {
                    if (results.contains(temp)) {
                        System.out.println("This location has been place one ship!Please input coordinates again!");
                        continue;
                    } else {
                        results.add(temp);
                        break;
                    }
                } else {
                    System.out.println("Please input the property coordinates in 10 by 10 grid!");
                }
            }
        }
        return results;
    }

    public static ArrayList<Location> computerDeployShips() {
        ArrayList<Location> results = new ArrayList<>();
        System.out.println("Computer is deploying ships");
        Random random = new Random();
    /*

    */
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            Location temp = new Location();
            temp.setX(x);
            temp.setY(y);
            if (x >= 0 && x <= 9 && y >= 0 && y <= 9 && !results.contains(temp)) {
                results.add(temp);
                    System.out.printf("%d.ship DEPLOYED\n",i);
                }
            else
                i--;
            }
        return results;
    }

}
