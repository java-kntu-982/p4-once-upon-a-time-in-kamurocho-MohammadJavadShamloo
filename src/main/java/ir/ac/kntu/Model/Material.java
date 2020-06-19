package ir.ac.kntu.Model;

import java.util.Objects;

public class Material implements GameSupplies{
    private String Name;
    private int Durability;
    private int x,y;
    private int Level;

    public Material(String name, int durability) {
        Name = name;
        Durability = durability;
        Level = 0;
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

    public int getDurability() {
        return Durability;
    }

    public void setDurability(int durability) {
        Durability = durability;
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
        if (!(o instanceof Material)) return false;
        Material material = (Material) o;
        return getDurability() == material.getDurability() &&
                getX() == material.getX() &&
                getY() == material.getY() &&
                getLevel() == material.getLevel() &&
                Objects.equals(getName(), material.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDurability(), getX(), getY(), getLevel());
    }

    @Override
    public String toString() {
        return "Name : " + getName() + " && Durability : " + getDurability() + " && Level : " + getLevel() + "\n";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void levelUp() {
        setDurability((int) (getDurability() * 1.1));
        setLevel( getLevel() + 1);
    }
}
