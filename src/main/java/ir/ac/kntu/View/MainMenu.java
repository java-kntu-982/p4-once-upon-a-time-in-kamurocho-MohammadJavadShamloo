package ir.ac.kntu.View;

import ir.ac.kntu.Controller.Controller;
import ir.ac.kntu.Model.Soldier.Soldier;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu extends Application {
    public static void trainSoldier(Scanner scanner,Controller controller){
        System.out.println("Please Enter Number Of Soldier Wanna Upgrade It : ");
        controller.soldierShower();
        int index = Integer.parseInt(scanner.nextLine());
        if(controller.upgradeSoldier(index)){
            System.out.println("Done....");
        } else {
            System.out.println("There isnt Enough Money.");
        }
    }

    public static void trainMaterial(Scanner scanner,Controller controller){
        System.out.println("Please Enter Number Of Material Wanna Upgrade It : ");
        controller.materialShower();
        int index = Integer.parseInt(scanner.nextLine());
        if(controller.upgradeMaterial(index)){
            System.out.println("Done....");
        } else {
            System.out.println("There isnt Enough Money.");
        }
    }

    public static void orgazination(Scanner scanner,Controller controller){
        System.out.println("How Many Place You Take ? ");
        int lengthOfSoldiers = Integer.parseInt(scanner.nextLine());
        ArrayList<Soldier> selectedSoldiers = new ArrayList<>();
        for (int i=0;i<lengthOfSoldiers;i++){
            controller.soldierShower();
            int index = Integer.parseInt(scanner.nextLine());
            selectedSoldiers.add(controller.getTeamMates().get(index));
        }
        controller.organization(selectedSoldiers);
        System.out.println("Its Done....");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StartGame startGame = new StartGame();
        Controller controller = new Controller();
        controller.initializeSoldiers();
        controller.initializeMaterial();
        int index;
        while (true) {
            System.out.println("Please Select Number of Option : ");
            System.out.println("1.Start Game");
            System.out.println("2.Train Soldiers");
            System.out.println("3.Train Material");
            System.out.println("4.Organization");
            System.out.println("5.For Checking Money");
            index = Integer.parseInt(scanner.nextLine());
            if(index == 1){
                launch(args);
            } else if(index == 2){
                trainSoldier(scanner,controller);
            } else if(index == 3){
                trainMaterial(scanner,controller);
            } else if(index == 4){
                orgazination(scanner,controller);
            } else if(index == 5){
                System.out.println(controller.getMoney());
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        StartGame startGame = new StartGame();
        startGame.start(stage);
    }
}
