package ir.ac.kntu.Models;

import java.util.Objects;

public class Soldiers {
    protected String name;
    protected double health;
    protected double attack;
    protected double fieldOfView;

    public Soldiers(String name, double health, double attack, double fieldOfView) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.fieldOfView = fieldOfView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getFieldOfView() {
        return fieldOfView;
    }

    public void setFieldOfView(double fieldOfView) {
        this.fieldOfView = fieldOfView;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soldiers)) return false;
        Soldiers soldiers = (Soldiers) o;
        return Double.compare(soldiers.getHealth(), getHealth()) == 0 &&
                Double.compare(soldiers.getAttack(), getAttack()) == 0 &&
                Double.compare(soldiers.getFieldOfView(), getFieldOfView()) == 0 &&
                Objects.equals(getName(), soldiers.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHealth(), getAttack(), getFieldOfView());
    }

    @Override
    public String toString() {
        return "Soldiers{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", fieldOfView=" + fieldOfView +
                '}';
    }
}
