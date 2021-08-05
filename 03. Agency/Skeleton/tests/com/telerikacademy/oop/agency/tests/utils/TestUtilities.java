package com.telerikacademy.oop.agency.tests.utils;

import com.telerikacademy.oop.agency.models.JourneyImpl;
import com.telerikacademy.oop.agency.models.vehicles.AirplaneImpl;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;

import java.util.Arrays;
import java.util.List;

public class TestUtilities {

    /**
     * Returns a new List with size equal to wantedSize.
     * Useful when you do not care what the contents of the List are,
     * for example when testing if a list of a command throws exception
     * when it's parameters list's size is less/more than expected.
     *
     * @param wantedSize the size of the List to be returned.
     * @return a new List with size equal to wantedSize
     */
    public static List<String> initializeListWithSize(int wantedSize) {
        return Arrays.asList(new String[wantedSize]);
    }

    public static com.telerikacademy.oop.agency.models.contracts.Journey initializeJourney() {
        return new JourneyImpl(1,
                TestData.Journey.VALID_START_LOCATION_NAME,
                TestData.Journey.VALID_DESTINATION_NAME,
                TestData.Journey.VALID_DISTANCE,
                initializeVehicle()
        );
    }

    public static Vehicle initializeVehicle() {
        return new AirplaneImpl(1, TestData.Bus.VALID_PASSENGER_CAPACITY, TestData.Airplane.VALID_PRICE, true);
    }

}
