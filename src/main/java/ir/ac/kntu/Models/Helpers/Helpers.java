package ir.ac.kntu.Models.Helpers;

import ir.ac.kntu.Models.Soldiers;

import java.util.Objects;

public class Helpers extends Soldiers {
    protected double attackRange;

    public Helpers(String name, double health, double attack, double fieldOfView, double attackRange) {
        super(name, health, attack, fieldOfView);
        this.attackRange = attackRange;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(double attackRange) {
        this.attackRange = attackRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Helpers)) return false;
        if (!super.equals(o)) return false;
        Helpers helpers = (Helpers) o;
        return Double.compare(helpers.getAttackRange(), getAttackRange()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAttackRange());
    }

    @Override
    public String toString() {
        return "Helpers{" +
                "attackRange=" + attackRange +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", fieldOfView=" + fieldOfView +
                '}';
    }
}
