package com.telerikacademy.oop.agency.models;

import com.telerikacademy.oop.agency.exceptions.InvalidUserInputException;
import com.telerikacademy.oop.agency.models.contracts.Journey;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;
import com.telerikacademy.oop.agency.utils.ValidationHelper;

public class JourneyImpl implements Journey  {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;

    private final int id;
    private String startLocation;
    private String destination;
    private int distance;
    private final Vehicle vehicle;


    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        this.id = id;
        setStartLocation(startLocation);
        setDestination(destination);
        setDistance(distance);
        this.vehicle = vehicle;

    }

    public void setStartLocation(String startLocation) {
        try {
            ValidationHelper.validateStringLength(startLocation,START_LOCATION_MIN_LENGTH,START_LOCATION_MAX_LENGTH
                    ,"");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format("The StartingLocation's length cannot be less than %s or more than %s symbols long."
                    ,START_LOCATION_MIN_LENGTH,START_LOCATION_MAX_LENGTH));
        }
        this.startLocation = startLocation;
    }

    public void setDestination(String destination) {
        try {
            ValidationHelper.validateStringLength(destination,DESTINATION_MIN_LENGTH,DESTINATION_MAX_LENGTH
                    ,"");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format("The Destination's length cannot be less than %s or more than %s symbols long."
                    ,DESTINATION_MIN_LENGTH,DESTINATION_MAX_LENGTH));
        }

        this.destination = destination;
    }

    public void setDistance(int distance) {
        try {
            ValidationHelper.validateValueInRange(distance,DISTANCE_MIN_VALUE,DISTANCE_MAX_VALUE
                    ,"");
        }catch (InvalidUserInputException e){
            throw new IllegalArgumentException(String.format("The Destination's length cannot be less than %s or more than %s symbols long."
                    ,DESTINATION_MIN_LENGTH,DISTANCE_MAX_VALUE));
        }
        this.distance = distance;
    }

    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String getDestination() {
        return destination;
    }

    @Override
    public double calculateTravelCosts() {
        return getDistance() * getVehicle().getPricePerKilometer();
    }

    @Override
    public String getAsString() {
        return String.format("Journey ----\n" +
                "Start location: %s\n" +
                "Destination: %s\n" +
                "Distance: %s\n" +
                "Vehicle type: %s\n" +
                "Travel costs: %s\n",getStartLocation(),getDestination(),getDistance()
                ,getVehicle(),calculateTravelCosts());
    }

    @Override
    public int getId() {
        return id;
    }
}