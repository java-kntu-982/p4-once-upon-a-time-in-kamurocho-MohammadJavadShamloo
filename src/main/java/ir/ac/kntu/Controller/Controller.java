package ir.ac.kntu.Controller;

import ir.ac.kntu.Model.Game.Game;
import ir.ac.kntu.Model.Material.BuildingMaterials.*;
import ir.ac.kntu.Model.Soldier.Enemy.*;
import ir.ac.kntu.Model.Material.Material;
import ir.ac.kntu.Model.Soldier.Soldier;
import ir.ac.kntu.Model.Spot.Spot;
import ir.ac.kntu.Model.Soldier.TeamMate.*;

import java.util.*;

public class Controller {
    protected ArrayList<Soldier> teamMates = new ArrayList<>();
    protected ArrayList<Soldier> inWarTeamMates = new ArrayList<>();
    protected ArrayList<Soldier> enemies = new ArrayList<>();
    protected ArrayList<Soldier> inWarEnemies = new ArrayList<>();
    protected ArrayList<Material> materials = new ArrayList<>();
    protected ArrayList<Material> inWarMaterials = new ArrayList<>();
    protected int money = 100;
    protected boolean[][] booleans = new boolean[600][600];
    protected int width = 600;
    protected int height = 600;

    public boolean[][] getBooleans() {
        return booleans;
    }

    public void setBooleans(boolean[][] booleans) {
        this.booleans = booleans;
    }

    public ArrayList<Soldier> getTeamMates() {
        return teamMates;
    }

    public void setTeamMates(ArrayList<Soldier> teamMates) {
        this.teamMates = teamMates;
    }

    public ArrayList<Soldier> getInWarTeamMates() {
        return inWarTeamMates;
    }

    public void setInWarTeamMates(ArrayList<Soldier> inWarTeamMates) {
        this.inWarTeamMates = inWarTeamMates;
    }

    public ArrayList<Soldier> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Soldier> enemies) {
        this.enemies = enemies;
    }

    public ArrayList<Soldier> getInWarEnemies() {
        return inWarEnemies;
    }

    public void setInWarEnemies(ArrayList<Soldier> inWarEnemies) {
        this.inWarEnemies = inWarEnemies;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    public ArrayList<Material> getInWarMaterials() {
        return inWarMaterials;
    }

    public void setInWarMaterials(ArrayList<Material> inWarMaterials) {
        this.inWarMaterials = inWarMaterials;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean upgradeSoldier(int index){
        if(money >= (teamMates.get(index).getLevel() + 1)*10){
            teamMates.get(index).levelUp();
            money -= (teamMates.get(index).getLevel())*10;
            return true;
        } else {
            return false;
        }
    }

    public boolean upgradeMaterial(int index){
        if(money >= (materials.get(index).getLevel() + 1)*40){
            materials.get(index).levelUp();
            money -= (materials.get(index).getLevel())*10;
            return true;
        } else {
            return false;
        }
    }

    public void soldierShower(){
        for (int i=0;i<teamMates.size();i++){
            System.out.printf("%d -> %s",i,teamMates.get(i).toString());
        }
    }

    public void materialShower(){
        for (int i=0;i<materials.size();i++){
            System.out.printf("%d -> %s",i,materials.get(i).toString());
        }
    }

    public void initBools(){
        for (int i=0;i<600;i++){
            for (int j=0;j<600;j++){
                if(i>=300 && i<=320){
                    if(j <= 60){
                        booleans[i][j] = false;
                    } else if(j>=120 && j<=180){
                        booleans[i][j] = false;
                    }  else if(j>=240 && j<=300){
                        booleans[i][j] = false;
                    }  else if(j>=360 && j<=420){
                        booleans[i][j] = false;
                    }  else if(j>=480 && j<=540){
                        booleans[i][j] = false;
                    } else {
                        booleans[i][j] = true;
                    }
                }
            }
        }
    }

    public void organization(ArrayList<Soldier> GivedinWarTeamMates){
        setInWarTeamMates(GivedinWarTeamMates);
    }

    public void initializeSoldiers(){
        teamMates.add(new GoroMajima());
        teamMates.add(new DaigoDojima());
        teamMates.add(new FutoshiShimano());
        teamMates.add(new JiroKawara());
        teamMates.add(new KaoruSayama());
        teamMates.add(new KojiShindo());
        teamMates.add(new MakotoDate());
        teamMates.add(new OsamuKashiwagi());
        teamMates.add(new RyoTakashima());
        teamMates.add(new RyujiGoda());
        teamMates.add(new ShintaroKazama());
        teamMates.add(new SoheiDojima());
        teamMates.add(new SotaroKomaki());
        teamMates.add(new TaigaSaejima());
        teamMates.add(new TetsuTachibana());
        teamMates.add(new YukioTerada());
    }

    public void initializeEnemy(){
        enemies.add(new BossLevel1());
        enemies.add(new BossLevel2());
        enemies.add(new GoldSoldier());
        enemies.add(new GreenSoldier());
        enemies.add(new GraySoldier());
        enemies.add(new RedSoldier());
        enemies.add(new YellowSoldier());
    }

    public void initializeMaterial(){
        materials.add(new Container());
        materials.add(new PowerShovel());
        materials.add(new SteelFramework());
        materials.add(new Truck());
        materials.add(new Van());
    }

    private double aStarValue(Spot dep,Spot des,Spot current){
        double gValue =  Math.sqrt(Math.pow(current.getX() - dep.getX(),2) + Math.pow(current.getY() - dep.getY(),2));
        double hValue =  Math.sqrt(Math.pow(des.getX() - current.getX(),2) + Math.pow(des.getY() - current.getY(),2));
        return (gValue + hValue);
    }

    public LinkedList<Spot> pathFinder(Spot dep,Spot des){
        LinkedList<Spot> spots = new LinkedList<>();
        Spot current = new Spot(dep.getX(), dep.getY());
        while(current.getX() != des.getX() && current.getY() != des.getY()){
            Spot n = new Spot(current.getX(), current.getY() - 1);
            n.setaStarFunctionValue(aStarValue(dep,des,current));
            Spot ne = new Spot(current.getX() + 1, current.getY() - 1);
            ne.setaStarFunctionValue(aStarValue(dep,des,current));
            Spot e = new Spot(current.getX() + 1, current.getY());
            e.setaStarFunctionValue(aStarValue(dep,des,current));
            Spot se = new Spot(current.getX() + 1, current.getY() + 1);
            se.setaStarFunctionValue(aStarValue(dep,des,current));
            Spot s = new Spot(current.getX(), current.getY() + 1);
            s.setaStarFunctionValue(aStarValue(dep,des,current));
            Spot sw = new Spot(current.getX() - 1, current.getY() + 1);
            sw.setaStarFunctionValue(aStarValue(dep,des,current));
            Spot w = new Spot(current.getX() - 1, current.getY());
            w.setaStarFunctionValue(aStarValue(dep,des,current));
            Spot nw = new Spot(current.getX() - 1, current.getY() - 1);
            nw.setaStarFunctionValue(aStarValue(dep,des,current));

            ArrayList<Spot> spots1 = new ArrayList<>();

            if(booleans[(int) n.getX()][(int) n.getY()]){
                spots1.add(n);
            }
            if(booleans[(int) ne.getX()][(int) ne.getY()]){
                spots1.add(ne);
            }
            if(booleans[(int) e.getX()][(int) e.getY()]){
                spots1.add(e);
            }
            if(booleans[(int) se.getX()][(int) se.getY()]){
                spots1.add(se);
            }
            if(booleans[(int) s.getX()][(int) s.getY()]) {
                spots1.add(s);
            }
            if(booleans[(int) sw.getX()][(int) sw.getY()]){
                spots1.add(sw);
            }
            if(booleans[(int) w.getX()][(int) w.getY()]){
                spots1.add(w);
            }
            if(booleans[(int) nw.getX()][(int) nw.getY()]){
                spots1.add(nw);
            }

            Collections.sort(spots1);

            spots.add(new Spot(spots1.get(0).getX() , spots1.get(0).getY()));
            current = new Spot(spots1.get(0).getX() , spots1.get(0).getY());

            spots1.clear();
        }
        return spots;
    }

    public void placeSoldiers(Game game){
        ArrayList<Soldier> frsWave = new ArrayList<>();
        ArrayList<Soldier> secWave = new ArrayList<>();
        ArrayList<Soldier> thrWave = new ArrayList<>();
        ArrayList<Soldier> fouWave = new ArrayList<>();
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(new Container());
        materials.add(new Truck());
        fouWave.add(new BossLevel1());

        Random random = new Random();

        for (int i=0;i<20;i++){
            if(i<10){
                RedSoldier redSoldier =  new RedSoldier();
                redSoldier.setSpot(new Spot(random.nextInt(15) + 100,random.nextInt(15) + 570));
                frsWave.add(redSoldier);
            } else {
                GreenSoldier greenSoldier =  new GreenSoldier();
                greenSoldier.setSpot(new Spot(random.nextInt(15) + 100,random.nextInt(15) + 570));
                frsWave.add(greenSoldier);
            }
        }

        for (int i=0;i<20;i++){
            if(i<10){
                GraySoldier graySoldier =  new GraySoldier();
                graySoldier.setSpot(new Spot(random.nextInt(15) + 100,random.nextInt(15) + 570));
                secWave.add(graySoldier);
            } else {
                GreenSoldier greenSoldier =  new GreenSoldier();
                greenSoldier.setSpot(new Spot(random.nextInt(15) + 100,random.nextInt(15) + 570));
                secWave.add(greenSoldier);
            }
        }

        for (int i=0;i<20;i++){
            if(i<10){
                GraySoldier graySoldier =  new GraySoldier();
                graySoldier.setSpot(new Spot(random.nextInt(15) + 100,random.nextInt(15) + 570));
                thrWave.add(graySoldier);
            } else {
                RedSoldier redSoldier =  new RedSoldier();
                redSoldier.setSpot(new Spot(random.nextInt(15) + 100,random.nextInt(15) + 570));
                thrWave.add(redSoldier);
            }
        }

        Stack<ArrayList<Soldier>> enemies = new Stack<>();
        enemies.push(fouWave);
        enemies.push(thrWave);
        enemies.push(secWave);
        enemies.push(frsWave);

        game.setEnemyStack(enemies);
        game.setTeamMate(inWarTeamMates);
        game.setMaterials(materials);
    }
}
