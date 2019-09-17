package com.company;

import java.util.Scanner;

public class Main {
    private static int[] towerone = {0,1,2,3};
    private static int[] towertwo = {0,0,0,0};
    private static int[] towerthree = {0,0,0,0};

    private static boolean state = true;

    final private static String introduction = "\n'Die Türme von Hanoi' ist ein Denkspiel, bei dem der Spieler versucht," +
            " die Scheiben\nvon dem ersten Stab zum dritten zu befördern, wobei der zweite Stab zur Hilfe genutzt wird." +
            "\nDie größeren Scheiben dürfen hierbei jedoch nicht über den kleinen Scheiben liegen und die " +
            "\nScheiben dürfen nur einzeln bewegt werden." +
            "\nIn dem Programm bewegt man die Steine ...\n";

    public static void main(String[] args) {
        while (state){
            switch (funcSelect()){
                case 1:
                    towerone[1] = 1;
                    towerone[2] = 2;
                    towerone[3] = 3;
                    towertwo[1] = 0;
                    towertwo[2] = 0;
                    towertwo[3] = 0;
                    towerthree[1] = 0;
                    towerthree[2] = 0;
                    towerthree[3] = 0;
                    gameFunc();
                    break;

                case 2:
                    System.out.println(introduction);
                    break;

                case 3:
                    System.out.println("\nBye");
                    state = false;
                    break;
                default:
                    System.out.println("\nFehler\n");
                    break;


            }
        }
    }

    private static int funcSelect(){
        System.out.println("Möchten Sie ...\n 1. ein neues Spiel spielen?\n 2. die Spielanleitung lesen?\n 3. das Programm schließen?\n");
        Scanner func = new Scanner(System.in);
        int choice;
        try{
            choice = Integer.parseInt(func.nextLine());
        }

        catch (NumberFormatException a){
            choice = 0;
        }
        return choice;
    }

    private static void gameFunc() {
        boolean game = true;
        String eingabe;
        String eingabestart;
        String eingabeziel;
        int start;
        int ziel;

        while (game) {
            if ((towerthree[1] == 1) && (towerthree[2] == 2) && (towerthree[3] == 3)) {
                game = false;
            } else {
                System.out.println(output());
                System.out.println("Geben Sie den Zug ein:\n");
                Scanner turmeingabe = new Scanner(System.in);
                eingabe = turmeingabe.nextLine();
                eingabestart = eingabe.substring(0,1);
                eingabeziel = eingabe.substring(1,2);
                start = Integer.parseInt(eingabestart);
                ziel = Integer.parseInt(eingabeziel);
                int [] zielarray = {0,0,0};
                int [] startarray = {0,0,0};
                if(ziel == 1){
                    zielarray = towerone;
                } else if (ziel == 2){
                   zielarray = towertwo;
                } else if (ziel == 3){
                    zielarray = towerthree;
                } else{
                    System.out.println("Error");
                }
                if(start == 1){
                    startarray = towerone;
                } else if (start == 2){
                    startarray = towertwo;
                } else if (start == 3){
                    startarray = towerthree;
                } else {
                    System.out.println("Error");
                }
                if (zielarray[arrayPos(zielarray)]<startarray[arrayPos(startarray)]) {
                    zielarray[arrayPos(zielarray) + 1] = startarray[arrayPos(startarray)];
                    startarray[arrayPos(startarray)] = 0;
                } else {
                    System.out.println("Error");
                }
            }
            }
        System.out.println("Gewonnen");
    }

    private static int arrayPos(int [] tower) {
        int count = 0;
        for (int i = 1; i < tower.length; i++) {
            if (tower[i] != 0) {
                count = count + 1;
            } else {
                break;
            }
        }
        return count;
    }

    private static String output() {

        return  towerone[3]+"|"+towerone[3]+"__"+towertwo[3]+"|"+towertwo[3]+"__"+towerthree[3]+"|"+towerthree[3]+"\n" +
                towerone[2]+"|"+towerone[2]+"__"+towertwo[2]+"|"+towertwo[2]+"__"+towerthree[2]+"|"+towerthree[2]+"\n" +
                towerone[1]+"|"+towerone[1]+"__"+towertwo[1]+"|"+towertwo[1]+"__"+towerthree[1]+"|"+towerthree[1]+"\n" +
                " a    b   c\n";
    }
}