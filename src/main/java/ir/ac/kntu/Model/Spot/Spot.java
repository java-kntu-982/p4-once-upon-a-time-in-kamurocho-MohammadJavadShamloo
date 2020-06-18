package ir.ac.kntu.Model.Spot;

import java.util.Objects;

public class Spot implements Comparable<Spot>{
    private double x;
    private double y;
    private double hValue;
    private double gValue;
    private double aStarFunctionValue;

    public Spot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double gethValue() {
        return hValue;
    }

    public void sethValue(double hValue) {
        this.hValue = hValue;
    }

    public double getgValue() {
        return gValue;
    }

    public void setgValue(double gValue) {
        this.gValue = gValue;
    }

    public double getaStarFunctionValue() {
        return aStarFunctionValue;
    }

    public void setaStarFunctionValue(double aStarFunctionValue) {
        this.aStarFunctionValue = aStarFunctionValue;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Spot)) {
            return false;
        }
        Spot spot = (Spot) o;
        return Double.compare(spot.getX(), getX()) == 0 &&
                Double.compare(spot.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "Spot{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Spot o) {
        return (int) (aStarFunctionValue - o.aStarFunctionValue);
    }
}
