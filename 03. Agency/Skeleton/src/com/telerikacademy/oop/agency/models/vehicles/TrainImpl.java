package com.telerikacademy.oop.agency.models.vehicles;


import com.telerikacademy.oop.agency.exceptions.InvalidUserInputException;
import com.telerikacademy.oop.agency.models.VehicleBase;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Train;
import com.telerikacademy.oop.agency.utils.ValidationHelper;

public class TrainImpl extends VehicleBase implements Train {

    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer, VehicleType.Land);
        setCarts(carts);
    }

    public void setCarts(int carts) {
        try {
            ValidationHelper.validateValueInRange(carts, CARTS_MIN_VALUE, CARTS_MAX_VALUE, "");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format("A train cannot have less than %s cart or more than %s carts."
                    , CARTS_MIN_VALUE, CARTS_MAX_VALUE));
        }
        this.carts = carts;
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        try{
            ValidationHelper.validateValueInRange(passengerCapacity, PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE,
                   "");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format("A train cannot have less than %s passengers or more than %s passengers."
                    , PRICE_MIN_VALUE, PASSENGER_MAX_VALUE));
        }
    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        try {
            ValidationHelper.validateValueInRange(pricePerKilometer, PRICE_MIN_VALUE, PRICE_MAX_VALUE,
                   "");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format("Price should between %s and %s"
                    , PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }

    }

    @Override
    public int getCarts() {
        return carts;
    }

    @Override
    public String getAsString() {
        return String.format("Train ----%n%s%nCarts amount: %s",super.getAsString(),getCarts());
    }
}