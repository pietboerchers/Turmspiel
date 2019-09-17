package com.company;

import java.util.Scanner;

public class Main {
   private static int[] towerone;
    private static int[] towertwo;
    private static int[] towerthree;
    private static int[] towererror;

    private static boolean state = true;

    final private static String introduction = "\n'Die Türme von Hanoi' ist ein Denkspiel, bei dem der Spieler versucht," +
            " die Scheiben\nvon dem ersten Stab zum dritten zu befördern, wobei der zweite Stab zur Hilfe genutzt wird." +
            "\nDie größeren Scheiben dürfen hierbei jedoch nicht über den kleinen Scheiben liegen und die " +
            "\nScheiben dürfen nur einzeln bewegt werden." +
            "\nIn dem Programm bewegt man die Scheiben dadurch, dass man zwei Stäbe anwählt. Die Stäbe  " +
            "\nsind mit den Zahlen 1, 2 und 3 gekennzeichnet und die Scheiben sind der Größe nach " +
            "\nbenannt, wobei die Scheibe 1 die größte ist und die folgenden werden immer kleiner. Der erste " +
            "\ngenannte Stab ist der Stab von dem die oberste Scheibe genommen wird und der zweite ist der " +
            "\nangezielte Stab. z.B.: Nutzereingabe = '12' --> 1 = Anfangsstab , 2 = Zielstab. \n";

    public static void main(String[] args) {
        while (state){
            switch (funcSelect()){
                case 1:
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
        towerone = new int[]{0, 1, 2, 3};
        towertwo = new int[]{0, 0, 0, 0};
        towerthree = new int[]{0, 0, 0, 0};
        towererror = new int[]{9, 9, 9, 9};
        int turns = 0;

        while (game) {
            if ((towerthree[1] == 1) && (towerthree[2] == 2) && (towerthree[3] == 3)) {
                game = false;
            } else {
                System.out.println(output());
                System.out.println("Geben Sie den Zug ein:\n");
                Scanner towerInput = new Scanner(System.in);
                String input = towerInput.nextLine();
                if(input.length() == 2) {

                    int[] target = targetArray(input);
                    int[] start = startArray(input);
                    if (target[arrayPos(target)] < start[arrayPos(start)]) {
                        target[arrayPos(target) + 1] = start[arrayPos(start)];
                        start[arrayPos(start)] = 0;
                        turns = turns + 1;
                    } else {
                        System.out.println("\nFehlerhafter Zug");
                    }
                } else {
                    System.out.println("\nFehlerhafte Eingabe");
                }
    }
}
        System.out.println("\n"+output()+"\n"+"\nGewonnen!  Versuche: "+ turns +"\n");
        towerone = towerthree;
        towerthree = towertwo;
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


    private static int []targetArray(String input){
        String targetInput = input.substring(1,2);
        int target = Integer.parseInt(targetInput);
        int [] targetingArray;
        switch (target) {
            case 1:
                targetingArray = towerone;
                break;
            case 2:
                targetingArray = towertwo;
                break;
            case 3:
                targetingArray = towerthree;
                break;
            default:
                System.out.println("Fehlerhaftes Ziel");
                targetingArray = towererror;
                break;
        }
        return targetingArray;
    }

    private static int []startArray(String input){
        String startInput = input.substring(0,1);
        int start = Integer.parseInt(startInput);
        int [] startingArray;
        switch (start) {
            case 1:
                startingArray = towerone;
                break;
            case 2:
                startingArray = towertwo;
                break;
            case 3:
                startingArray = towerthree;
                break;
            default:
                System.out.println("Fehlerhafter Start");
                startingArray = towererror;
                break;
        }
        return startingArray;
    }

    private static String output() {

        return  "\n"+"|"+towerone[3]+"|___|"+towertwo[3]+"|___|"+towerthree[3]+"|\n" +
                "|"+towerone[2]+"|___|"+towertwo[2]+"|___|"+towerthree[2]+"|\n" +
                "|"+towerone[1]+"|___|"+towertwo[1]+"|___|"+towerthree[1]+"|\n" +
                " a     b     c\n";
    }
}