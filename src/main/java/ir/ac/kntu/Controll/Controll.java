package ir.ac.kntu.Controll;

import ir.ac.kntu.Model.Enemies.*;
import ir.ac.kntu.Model.Material;
import ir.ac.kntu.Model.Materials.*;
import ir.ac.kntu.Model.Soldier;
import ir.ac.kntu.Model.TeamMates.*;

import java.util.ArrayList;
import java.util.Random;

public class Controll {
    private ArrayList<Soldier> TeamMates = new ArrayList<>();
    private ArrayList<Soldier> SelectedTeamMates = new ArrayList<>();
    private ArrayList<Soldier> Enemies = new ArrayList<>();
    private ArrayList<Material> Materials = new ArrayList<>();
    private ArrayList<Soldier> RecuitingSoldiers = new ArrayList<>();
    private int Money = 100;
    private boolean[][] Map;

    public boolean[][] getMap() {
        return Map;
    }

    public void setMap(boolean[][] map) {
        Map = map;
    }

    public ArrayList<Soldier> getSelectedTeamMates() {
        return SelectedTeamMates;
    }

    public void setSelectedTeamMates(ArrayList<Soldier> selectedTeamMates) {
        SelectedTeamMates = selectedTeamMates;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }

    public ArrayList<Soldier> getTeamMates() {
        return TeamMates;
    }

    public ArrayList<Soldier> getEnemies() {
        return Enemies;
    }

    public ArrayList<Material> getMaterials() {
        return Materials;
    }

    public ArrayList<Soldier> getRecuitingSoldiers() {
        return RecuitingSoldiers;
    }

    public void setTeamMates(ArrayList<Soldier> teamMates) {
        TeamMates = teamMates;
    }

    public void setEnemies(ArrayList<Soldier> enemies) {
        Enemies = enemies;
    }

    public void setMaterials(ArrayList<Material> materials) {
        Materials = materials;
    }

    public void setRecuitingSoldiers(ArrayList<Soldier> recuitingSoldiers) {
        RecuitingSoldiers = recuitingSoldiers;
    }

    public void MainInit(){
        initEnemies();
        initMaterials();
        initRecuits();
        initTeamMates();
        initMap();
    }

    public boolean SoldierUpgrading(int index){
        if((getMoney() - (getTeamMates().get(index).getLevel() + 1) * 10) >= 0){
            getTeamMates().get(index).levelUp();
            setMoney(getMoney() - (getTeamMates().get(index).getLevel() * 10));
            return true;
        }
        return false;
    }

    public boolean MaterialUpgrading(int index){
        if((getMoney() - (getMaterials().get(index).getLevel() + 1) * 10) >= 0){
            getMaterials().get(index).levelUp();
            setMoney(getMoney() - (getMaterials().get(index).getLevel() * 10));
            return true;
        }
        return false;
    }

    public Soldier RecuitingSoldiers(){
        Random random = new Random();
        Soldier soldier = getRecuitingSoldiers().get(random.nextInt(getRecuitingSoldiers().size()));
        getTeamMates().add(soldier);
        getRecuitingSoldiers().remove(soldier);
        getTeamMates().add(soldier);
        setMoney(getMoney() - 100);
        return soldier;
    }


    public void SoldierShower(){
        int Counter = 0;
        for (Soldier teamMate : TeamMates) {
            System.out.println((Counter++) + " -> " +  teamMate.toString());
        }
    }

    public void SelectedSoldierShower(){
        int Counter = 0;
        for (Soldier teamMate : SelectedTeamMates) {
            System.out.println((Counter++) + " -> " +  teamMate.toString());
        }
    }

    public void MaterialShower(){
        int Counter = 0;
        for (Material material : Materials) {
            System.out.println((Counter++) + " -> " +material.toString());
        }
    }

    public void initMap(){
        boolean[][] Map = new boolean[800][800];
        for (int i=0;i<800;i++){
            for (int j=0;j<800;j++){
                if(i>=400 && i<=420){
                    if(j>=40 && j<=140){
                        Map[i][j] = false;
                    } else if(j>=240 && j<=340){
                        Map[i][j] = false;
                    } else if(j>=440 && j<=540){
                        Map[i][j] = false;
                    } else if(j>=640 && j<=740){
                        Map[i][j] = false;
                    }
                }
            }
        }
        setMap(Map);
    }

    public void initTeamMates() {
        ArrayList<Soldier> teamMates = new ArrayList<>();
        teamMates.add(new DiagoDojima());
        teamMates.add(new FutoshiShimano());
        teamMates.add(new GoroMajima());
        teamMates.add(new JiroKawara());
        teamMates.add(new KaoruSayama());
        teamMates.add(new KojiShindo());
        teamMates.add(new MakotoDate());
        teamMates.add(new OsamuKashiwagi());
        teamMates.add(new RyoTakashima());
        setTeamMates(teamMates);
    }

    public void initEnemies() {
        ArrayList<Soldier> Enemies = new ArrayList<>();
        Enemies.add(new BossLevel1());
        Enemies.add(new BossLevel2());
        Enemies.add(new GoldSoldier());
        Enemies.add(new GraySoldier());
        Enemies.add(new GreenSoldier());
        Enemies.add(new RedSoldier());
        Enemies.add(new YellowSoldier());
        setEnemies(Enemies);
    }

    public void initMaterials() {
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(new Container());
        materials.add(new PowerShovel());
        materials.add(new SteelFrameWork());
        materials.add(new Truck());
        materials.add(new Van());
        setMaterials(materials);
    }

    public void initRecuits() {
        ArrayList<Soldier> RecuitingSoldiers = new ArrayList<>();
        RecuitingSoldiers.add(new RyujiGoda());
        RecuitingSoldiers.add(new ShintaroKazama());
        RecuitingSoldiers.add(new SoheiDojima());
        RecuitingSoldiers.add(new SotaroKomaki());
        RecuitingSoldiers.add(new TaigaSaejima());
        RecuitingSoldiers.add(new TetsuTachibana());
        RecuitingSoldiers.add(new YukioTerada());
        setRecuitingSoldiers(RecuitingSoldiers);
    }
}
