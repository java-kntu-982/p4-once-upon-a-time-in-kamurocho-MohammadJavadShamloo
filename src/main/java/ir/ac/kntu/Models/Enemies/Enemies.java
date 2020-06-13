package ir.ac.kntu.Models.Enemies;

import ir.ac.kntu.Models.Soldiers;

public class Enemies extends Soldiers {
    public Enemies(String name, double health, double attack, double fieldOfView) {
        super(name, health, attack, fieldOfView);
    }

    @Override
    public String toString() {
        return "Enemies{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", fieldOfView=" + fieldOfView +
                '}';
    }
}
