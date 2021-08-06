package com.telerikacademy.oop.agency.models.vehicles;


import com.telerikacademy.oop.agency.exceptions.InvalidUserInputException;
import com.telerikacademy.oop.agency.models.VehicleBase;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Airplane;
import com.telerikacademy.oop.agency.utils.ValidationHelper;

public class AirplaneImpl extends VehicleBase implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id,passengerCapacity,pricePerKilometer,VehicleType.Air);
        this.hasFreeFood = hasFreeFood;
    }

    public boolean getIsHasFreeFood() {
        return hasFreeFood;
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        try {
            ValidationHelper.validateValueInRange(passengerCapacity,PASSENGER_MIN_VALUE,PASSENGER_MAX_VALUE,"");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format("A air planet cannot have less than %s passengers or more than %s passengers."
                    ,PASSENGER_MIN_VALUE,PASSENGER_MAX_VALUE));
        }

    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        try {
            ValidationHelper.validateValueInRange(pricePerKilometer,PRICE_MIN_VALUE,PRICE_MAX_VALUE,"");
        }catch (InvalidUserInputException e){
             throw  new IllegalArgumentException(String.format("Price should between %s and %s"
                     ,PRICE_MIN_VALUE,PRICE_MAX_VALUE));
        }
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public String getAsString() {
        return String.format("Airplane ----%n%s%nHas free food: %s",super.getAsString(),getIsHasFreeFood());
    }
}