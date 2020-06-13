package ir.ac.kntu.Models.Materials;

import java.util.Objects;

public class Materials {
    protected String name;
    protected double durability;

    public Materials(String name, double durability) {
        this.name = name;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materials)) return false;
        Materials materials = (Materials) o;
        return Double.compare(materials.getDurability(), getDurability()) == 0 &&
                Objects.equals(getName(), materials.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDurability());
    }

    @Override
    public String toString() {
        return "Materials{" +
                "name='" + name + '\'' +
                ", durability=" + durability +
                '}';
    }
}
