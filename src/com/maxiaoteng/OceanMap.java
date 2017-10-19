/*
* Step 1 – Create the ocean map
* Step 2 – Deploy player’s ships
* Step 3 – Deploy computer’s ships
* Step 4 – Battle
* Step 5 - Game Over
*
* */


package com.maxiaoteng;

import java.lang.reflect.Array;
import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.ArrayList;

public class OceanMap {


    /*Show this OceanMap*/
    public static void showAll(int[][] oceanMap){
        System.out.print("  0123456789  \n");
        for(int i= 0;i<oceanMap.length;i++){
            System.out.print(i+"|");
            /*
            * Player's ship   1(@)
            * computer's ship 2
            * Computer's ship be battled  3(!)
            * Player's ship be battled 4(x)
            * Player miss     5(-)
            * Computer miss   6
             */
            for(int j=0;j<oceanMap[i].length;j++){
                System.out.print(oceanMap[i][j]);
            }
            System.out.print("|"+i+"\n");
        }
        System.out.print("  0123456789  \n");

    }
    public static void showOceanMap(int[][] oceanMap){
        System.out.print("  0123456789  \n");
        for(int i= 0;i<oceanMap.length;i++){
            System.out.print(i+"|");
            /*
            * Player's ship   1(@)
            * computer's ship 2
            * Computer's ship be battled  3(!)
            * Player's ship be battled 4(x)
            * Player miss     5(-)
            * Computer miss   6
             */
            for(int j=0;j<oceanMap[i].length;j++){
                switch(oceanMap[i][j]){
                    case 1:{
                        System.out.print('@');
                        break;
                    }case 3:{
                        System.out.print('!');
                        break;
                    }case 4:{
                        System.out.print('x');
                        break;
                    }case 5:{
                        System.out.print('-');
                        break;
                    }default:
                        System.out.print(' ');
                        break;
                }
            }
            System.out.print("|"+i+"\n");
        }
        System.out.print("  0123456789  \n");
    }

    /*Initialized the OceanMap by space and show it*/
    //print some welcome greets!
    public static int[][] initOceanMap(int[][] oceanMap){
        System.out.println("****Welcome to Battle Ships game!****");
        System.out.println("Right now, the sea is empty!");
        System.out.print("  0123456789  \n");
        for(int i= 0;i<oceanMap.length;i++){
            System.out.print(i+"|");
            for(int j=0;j<oceanMap[i].length;j++){
                oceanMap[i][j] = 0;
                System.out.print(' ');
            }
            System.out.print("|"+i+"\n");
        }
        System.out.print("  0123456789  \n");
        return oceanMap;
    }

    /*Update the current ships layout and return oceanMap*/
    public static int[][] updateOceanMap(ArrayList<Location> ships, int[][] oceanMap, String who){
        Location lo;
        int tag = 0;
        if(who.equals("computer"))
            tag = 2;
        else if(who.equals("user"))
            tag = 1;
        for(int i= 0;i<ships.size();i++){
            lo = ships.get(i);
            oceanMap[lo.getX()][lo.getY()] = tag;
        }
        return oceanMap;
    }
    //input: int[2] location
    //       int[][] currentmap  ,
    //       char
    //return the oceanMap after update.
//    public static int[][] updateBattleMap(Location lo,int[][] oceanMap,char result){
//        int x = lo.getX();
//        int y = lo.getY();
//        switch (result) {
//            case '-':{
//                oceanMap[x][y] = 5;
//                break;
//            }case 'x':{
//                oceanMap[x][y] = 4;
//                break;
//            }case '!':{
//                oceanMap[x][y] = 3;
//                break;
//            }default:
//                System.out.println("Error:");
//        }
//        return oceanMap;
//    }
}
