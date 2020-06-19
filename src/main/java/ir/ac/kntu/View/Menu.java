package ir.ac.kntu.View;

import ir.ac.kntu.Controll.Controll;
import ir.ac.kntu.Model.Soldier;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu extends Application {

    public static void trainSoldier(Scanner scanner, Controll controll){
        System.out.println("Please Enter Number Of Soldier Wanna Upgrade It : ");
        controll.SoldierShower();
        int index = Integer.parseInt(scanner.nextLine());
        if(controll.SoldierUpgrading(index)){
            System.out.println("Done....");
        } else {
            System.out.println("There isnt Enough Money.");
        }
    }

    public static void trainMaterial(Scanner scanner, Controll controll){
        System.out.println("Please Enter Number Of Material Wanna Upgrade It : ");
        controll.MaterialShower();
        int index = Integer.parseInt(scanner.nextLine());
        if(controll.MaterialUpgrading(index)){
            System.out.println("Done....");
        } else {
            System.out.println("There isnt Enough Money.");
        }
    }

    public static void orgazination(Scanner scanner,Controll controll){
        System.out.println("How Many Place You Take ? ");
        int lengthOfSoldiers = Integer.parseInt(scanner.nextLine());
        ArrayList<Soldier> selectedSoldiers = new ArrayList<>();
        for (int i=0;i<lengthOfSoldiers;i++){
            controll.SoldierShower();
            int index = Integer.parseInt(scanner.nextLine());
            selectedSoldiers.add(controll.getTeamMates().get(index));
        }
        controll.setSelectedTeamMates(selectedSoldiers);
        System.out.println("Its Done....");
    }

    public static void RecuitTeamMate(Controll controll){
        if(controll.getMoney() >= 100 && controll.getRecuitingSoldiers().size() > 0){
            System.out.println("A Team Mate Recuiting For You...");
            System.out.println("New Recuited Soldier.....");
            Soldier soldier = controll.RecuitingSoldiers();
            System.out.println(soldier.toString());
        } else {
            System.out.println("Money is Not Enough Or There isnt Another Soldier");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controll controll = new Controll();
        controll.MainInit();
        int index;
        while (true) {
            System.out.println("Please Select Number of Option : ");
            System.out.println("1.Start Game");
            System.out.println("2.Train Soldiers");
            System.out.println("3.Train Material");
            System.out.println("4.Organization");
            System.out.println("5.Recuit Team Mate");
            System.out.println("6.For Checking Money");
            index = Integer.parseInt(scanner.nextLine());
            if(index == 1){
                launch(args);
            } else if(index == 2){
                trainSoldier(scanner,controll);
            } else if(index == 3){
                trainMaterial(scanner,controll);
            } else if(index == 4){
                orgazination(scanner,controll);
            } else if(index == 5){
                RecuitTeamMate(controll);
            } else if(index == 6){
                System.out.println(controll.getMoney());
            }
        }
    }

    @Override
    public void start(Stage primaryStage){
        Game game = new Game();
        game.start(primaryStage);
    }
}