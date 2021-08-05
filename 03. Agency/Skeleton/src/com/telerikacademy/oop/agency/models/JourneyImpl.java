package com.telerikacademy.oop.agency.models;

import com.telerikacademy.oop.agency.models.contracts.Journey;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;

public class JourneyImpl {

    public static final int START_LOCATION_MIN_LENGTH = 5;
    public static final int START_LOCATION_MAX_LENGTH = 25;
    public static final int DESTINATION_MIN_LENGTH = 5;
    public static final int DESTINATION_MAX_LENGTH = 25;
    public static final int DISTANCE_MIN_VALUE = 5;
    public static final int DISTANCE_MAX_VALUE = 5000;

    public JourneyImpl(int id, String startLocation, String destination, int distance, Vehicle vehicle) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

}