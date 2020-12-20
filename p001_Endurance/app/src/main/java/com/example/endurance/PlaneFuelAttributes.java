package com.example.endurance;

/**
 * Created by fabio on 05/11/17.
 */

public class PlaneFuelAttributes {
    private int capacity;
    private int hourlyConsumption;
    private double tankLeftFilling;
    private double tankRightFilling;

    public PlaneFuelAttributes(int capacity, int hourlyConsumption) {
        this.capacity = capacity;
        this.hourlyConsumption = hourlyConsumption;
        this.tankLeftFilling = this.tankRightFilling = 0.;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getCapacity() {
        return this.capacity;
    }

    public void setHourlyConsumption(int hourlyConsumption) {
        this.hourlyConsumption = hourlyConsumption;
    }
    public int getHourlyConsumption() {
        return this.hourlyConsumption;
    }

    public void setTankLeft(double filling) {
        this.tankLeftFilling = filling;
    }

    public void setTankRight(double filling) {
        this.tankRightFilling = filling;
    }

    public double getFuel() {
        return (this.tankLeftFilling + this.tankRightFilling) * this.capacity / 8.;
    }
}
