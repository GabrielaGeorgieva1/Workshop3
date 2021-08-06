package com.telerikacademy.oop.agency.models.vehicles;


import com.telerikacademy.oop.agency.exceptions.InvalidUserInputException;
import com.telerikacademy.oop.agency.models.VehicleBase;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Bus;
import com.telerikacademy.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;


    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id,passengerCapacity,pricePerKilometer,VehicleType.Land);
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        try {
            ValidationHelper.validateValueInRange(passengerCapacity,PASSENGER_MIN_VALUE,PASSENGER_MAX_VALUE,"");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format(" A bus cannot have less than %s passengers or more than %s passengers."
                    ,PASSENGER_MIN_VALUE,PASSENGER_MAX_VALUE));
        }

    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        try {
            ValidationHelper.validateValueInRange(pricePerKilometer,PRICE_MIN_VALUE,PRICE_MAX_VALUE,"");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format("Price should between %s and %s"
                    ,PRICE_MIN_VALUE,PRICE_MAX_VALUE));
        }

    }
    @Override
    public String getAsString() {
        return String.format("Bus ----%s%n",super.getAsString());
    }
}