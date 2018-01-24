package com.fzt.endurance;

/**
 * Created by fabio on 05/11/17.
 */

public class PlaneFuelAttributes {

    private int capacity;
    private int hourlyConsumption;
    private double fuel;
    private double tank[] = new double[2];

    public PlaneFuelAttributes(int capacity, int hourlyConsumption) {
        this.capacity = capacity;
        this.hourlyConsumption = hourlyConsumption;
        this.fuel = 0.;
        this.tank[0] = this.tank[1] = 0.;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getHourlyConsumption() {
        return this.hourlyConsumption;
    }

    public double getFuel() {
        return this.fuel;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;

        this.updateFuel();
    }

    public void setHourlyConsumption(int hourlyConsumption) {
        this.hourlyConsumption = hourlyConsumption;
    }

    public void setTank(int tankIndex, double filling) {
        this.tank[tankIndex] = filling;

        this.updateFuel();
    }

    private void updateFuel() {
        this.fuel = (this.tank[0] + this.tank[1]) * this.capacity / 8.;
    }
}
