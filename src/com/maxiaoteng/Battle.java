package com.maxiaoteng;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static Location userBattle(ArrayList<Location> hasBattled,
                                   int[][] currentMap,
                                   ArrayList<Location> computerships,
                                   ArrayList<Location> userships){
        Location temp = new Location();
        Scanner input = new Scanner(System.in);
        System.out.println("YOUR TURN");
        while (true) {
            System.out.println("Enter X coordinate: ");
            int x = input.nextInt();
            System.out.println("Enter Y coordinate: ");
            int y = input.nextInt();
            if(x >= 0 && x <= 9 && y >= 0 && y <= 9) {
                temp.setY(y);
                temp.setX(x);
                if (hasBattled.contains(temp)) {
                    System.out.println("This colation has battled! Please try again!");
                }else{
                    switch(currentMap[x][y]){
                        case 1:{
                            System.out.println( "Oh no, you sunk your own ship :(");
                            currentMap[x][y] = 4;
                            userships.remove(temp);
                            break;
                        }case 2:{
                            System.out.println("Boom! You sunk the ship!");
                            currentMap[x][y] = 3;
                            computerships.remove(temp);
                            break;
                        }default:
                            System.out.println("Sorry, you missed");
                            currentMap[x][y] = 5;
                            break;
                    }
                    return temp;
                }
            }else
                System.out.println("Please input the property coordinates in 10 by 10 grid!");
        }
    }

    public static Location computerBattle(ArrayList<Location> hasBattled,
                                       int[][] currentMap,
                                       ArrayList<Location> computerships,
                                       ArrayList<Location> userships){
        Location temp = new Location();
        Random random = new Random();
        System.out.println("COMPUTER'S TURN");
        while (true) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            System.out.println(x+y);
            temp.setY(y);
            temp.setX(x);
            if(x >= 0 && x <= 9 && y >= 0 && y <= 9 && !hasBattled.contains(temp)) {
                switch(currentMap[x][y]){
                    case 1:{
                        System.out.println( "Oh,computer sunks your ship :(");
                        currentMap[x][y] = 4;
                        userships.remove(temp);
                        break;
                    }case 2:{
                        System.out.println("Boom! computer sunks its ship!");
                        currentMap[x][y] = 3;
                        computerships.remove(temp);
                        break;
                    }default:
                        System.out.println("Computer missed");
                        break;
                }
                return temp;
            }
        }
    }
}
