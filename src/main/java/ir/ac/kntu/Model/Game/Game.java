package ir.ac.kntu.Model.Game;

import ir.ac.kntu.Model.Material.Material;
import ir.ac.kntu.Model.Soldier.Soldier;

import java.util.*;

public class Game implements GameSupplies {
    protected ArrayList<Soldier> teamMate = new ArrayList<>();
    protected Stack<ArrayList<Soldier>> enemyStack = new Stack<>();
    protected ArrayList<Material> materials = new ArrayList<>();
    protected ArrayList<Soldier> currentEnemiesInWar = new ArrayList<>();

    public Game(ArrayList<Soldier> teamMate, Stack<ArrayList<Soldier>> enemyStack) {
        this.teamMate = teamMate;
        this.enemyStack = enemyStack;
    }

    public Game(){}

    public ArrayList<Soldier> getTeamMate() {
        return teamMate;
    }

    public void setTeamMate(ArrayList<Soldier> teamMate) {
        this.teamMate = teamMate;
    }

    public Stack<ArrayList<Soldier>> getEnemyStack() {
        return enemyStack;
    }

    public void setEnemyStack(Stack<ArrayList<Soldier>> enemyStack) {
        this.enemyStack = enemyStack;
    }

    public ArrayList<Soldier> getCurrentEnemiesInWar() {
        return currentEnemiesInWar;
    }

    public void setCurrentEnemiesInWar(ArrayList<Soldier> currentEnemiesInWar) {
        this.currentEnemiesInWar = currentEnemiesInWar;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(getTeamMate(), game.getTeamMate()) &&
                Objects.equals(getEnemyStack(), game.getEnemyStack());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeamMate(), getEnemyStack());
    }

    @Override
    public boolean nextWave() {
        if(currentEnemiesInWar.size() == 0 && teamMate.size() != 0){
            setCurrentEnemiesInWar(enemyStack.pop());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isWin() {
        return currentEnemiesInWar.size() == 0 && enemyStack.size() == 0
                && materials.size() == 0 && teamMate.size() != 0;
    }
}
