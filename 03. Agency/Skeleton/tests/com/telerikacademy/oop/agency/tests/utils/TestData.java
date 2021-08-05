package com.telerikacademy.oop.agency.tests.utils;

import com.telerikacademy.oop.agency.models.JourneyImpl;
import com.telerikacademy.oop.agency.models.vehicles.AirplaneImpl;
import com.telerikacademy.oop.agency.models.vehicles.BusImpl;
import com.telerikacademy.oop.agency.models.vehicles.TrainImpl;

public class TestData {

    public static class Journey {

        public static final int VALID_DISTANCE = JourneyImpl.DISTANCE_MIN_VALUE + 1;
        public static final String VALID_DESTINATION_NAME = "x".repeat(JourneyImpl.DESTINATION_MIN_LENGTH + 1);
        public static final String VALID_START_LOCATION_NAME = "x".repeat(JourneyImpl.START_LOCATION_MIN_LENGTH + 1);

    }

    public static class Airplane {

        public static final double VALID_PRICE = AirplaneImpl.PRICE_MIN_VALUE + 1;
        public static final int VALID_PASSENGER_CAPACITY = AirplaneImpl.PASSENGER_MIN_VALUE + 1;

    }

    public static class Bus {

        public static final double VALID_PRICE = BusImpl.PRICE_MIN_VALUE + 1;
        public static final int VALID_PASSENGER_CAPACITY = BusImpl.PASSENGER_MIN_VALUE + 1;

    }

    public static class Train {

        public static final int VALID_CARTS = TrainImpl.CARTS_MIN_VALUE + 1;

        public static final double VALID_PRICE = TrainImpl.PRICE_MIN_VALUE + 1;
        public static final int VALID_PASSENGER_CAPACITY = TrainImpl.PASSENGER_MIN_VALUE + 1;

    }

    public static class Ticket {

        public static final double VALID_COSTS = 2.50;

    }

}
