package ir.ac.kntu.Model.Game;

import ir.ac.kntu.Model.Material;
import ir.ac.kntu.Model.Soldier;

import java.util.ArrayList;
import java.util.Stack;

public class Game implements GameSupplies{
    private Stack<ArrayList<Soldier>> enemies;
    private ArrayList<Soldier> TeamMates;
    private ArrayList<Material> materials;
    private ArrayList<Soldier> currentEnemies;

    public Game(Stack<ArrayList<Soldier>> enemies, ArrayList<Soldier> teamMates, ArrayList<Material> materials) {
        this.enemies = enemies;
        TeamMates = teamMates;
        this.materials = materials;
    }

    public ArrayList<Soldier> getCurrentEnemies() {
        return currentEnemies;
    }

    public void setCurrentEnemies(ArrayList<Soldier> currentEnemies) {
        this.currentEnemies = currentEnemies;
    }

    public Stack<ArrayList<Soldier>> getEnemies() {
        return enemies;
    }

    public void setEnemies(Stack<ArrayList<Soldier>> enemies) {
        this.enemies = enemies;
    }

    public ArrayList<Soldier> getTeamMates() {
        return TeamMates;
    }

    public void setTeamMates(ArrayList<Soldier> teamMates) {
        TeamMates = teamMates;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    @Override
    public void Update() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean nextWave() {
        if(currentEnemies.size() == 0){
            setCurrentEnemies(enemies.pop());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String whoWin() {
        return null;
    }
}
