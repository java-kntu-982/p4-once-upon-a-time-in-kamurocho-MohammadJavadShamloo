package ir.ac.kntu.Model;

import java.util.LinkedList;
import java.util.Objects;

public class Soldier implements GameSupplies{
    private String Name;
    private int Health;
    private int Attack;
    private int AttackRange;
    private int FieldOfView;
    private int x,y;
    private int Level;
    private LinkedList<Spot> spots;

    public Soldier(String name, int health, int attack, int attackRange, int fieldOfView) {
        Name = name;
        Health = health;
        Attack = attack;
        AttackRange = attackRange;
        FieldOfView = fieldOfView;
        Level = 0;
    }

    public LinkedList<Spot> getSpots() {
        return spots;
    }

    public void setSpots(LinkedList<Spot> spots) {
        this.spots = spots;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getAttack() {
        return Attack;
    }

    public void setAttack(int attack) {
        Attack = attack;
    }

    public int getAttackRange() {
        return AttackRange;
    }

    public void setAttackRange(int attackRange) {
        AttackRange = attackRange;
    }

    public int getFieldOfView() {
        return FieldOfView;
    }

    public void setFieldOfView(int fieldOfView) {
        FieldOfView = fieldOfView;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soldier)) return false;
        Soldier soldier = (Soldier) o;
        return getHealth() == soldier.getHealth() &&
                getAttack() == soldier.getAttack() &&
                getAttackRange() == soldier.getAttackRange() &&
                getFieldOfView() == soldier.getFieldOfView() &&
                getX() == soldier.getX() &&
                getY() == soldier.getY() &&
                getLevel() == soldier.getLevel() &&
                Objects.equals(getName(), soldier.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHealth(), getAttack(), getAttackRange(), getFieldOfView(), getX(), getY(), getLevel());
    }

    @Override
    public String toString() {
        return "Name : " + getName() + " && Health : " + getHealth() + " && Attack : " + getAttack() + " && Level : "+ getLevel() + "\n";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void levelUp() {
        setHealth((int) (getHealth() * 1.1));
        setAttack((int) (getAttack() * 1.1));
        setAttackRange((int) (getAttack() * 1.1));
        setFieldOfView((int) (getFieldOfView() * 1.1));
        setLevel(getLevel() + 1);
    }
}
