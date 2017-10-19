//Include the main method

package com.maxiaoteng;

import java.util.ArrayList;
import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {

        ArrayList<Location> userShips= new ArrayList<Location>();
        ArrayList<Location> computerShips= new ArrayList<Location>();
        ArrayList<Location> userBattled= new ArrayList<Location>();
        ArrayList<Location> computerBattled= new ArrayList<Location>();
        int[][] ArrayListShip = new int[10][10];
        int[][] currentLayout = new int[10][10];

        //Step 1 – Create the ocean map
        currentLayout = OceanMap.initOceanMap(ArrayListShip);

        //Step 2 – Deploy player’s ships
        userShips = DeployShips.userdeployships();
        currentLayout = OceanMap.updateOceanMap(userShips,currentLayout,"user");
        OceanMap.showOceanMap(currentLayout);

        //Step 3 – Deploy computer’s ships
        computerShips = DeployShips.computerDeployShips();
        currentLayout = OceanMap.updateOceanMap(computerShips,currentLayout,"computer");
        OceanMap.showAll(currentLayout);

        //Step 4 – Battle

        while(userShips.size()!=0 && computerShips.size()!=0){
            Location temp ;
            temp = Battle.userBattle(userBattled,currentLayout,computerShips,userShips);
            userBattled.add(temp);
            temp = Battle.computerBattle(computerBattled,currentLayout,computerShips,userShips);
            computerBattled.add(temp);

            OceanMap.showOceanMap(currentLayout);
            System.out.printf("Your ships: %d | Computer ships: %d \n",
                    userShips.size(),computerShips.size());
        }

        //Show the battle's result
        System.out.printf("Your ships: %d | Computer ships: %d \n",
                userShips.size(),computerShips.size());
        if(userShips.size()==0){
            System.out.println("Sorry, you miss the battle. :(");
        }
        else
            System.out.println("Hooray! You win the battle! :)");


    }
}
