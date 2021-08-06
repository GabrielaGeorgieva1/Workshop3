package com.telerikacademy.oop.agency.models;


import com.telerikacademy.oop.agency.models.vehicles.VehicleType;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;

public abstract class VehicleBase implements Vehicle {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double Price_MIN_VALUE = 0.10;
    public static final double Price_MAX_VALUE = 2.50;

    private int passengerCapacity;
    private double pricePerKilometer;
    protected static VehicleType type;
    private int id;

    public VehicleBase(int id, int passengerCapacity, double pricePerKilometer, VehicleType type) {
        this.id = id;
        this.type = type;
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }


    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    protected abstract void validatePassengerCapacity(int passengerCapacity);

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }


    protected abstract void validatePricePerKilometer(double pricePerKilometer);

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Passenger capacity: %s%nPrice per kilometer: %s%nVehicle type: %s", getPassengerCapacity(),
                getPricePerKilometer(), getType());
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }
}
