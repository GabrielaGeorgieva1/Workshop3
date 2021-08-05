package com.telerikacademy.oop.agency.tests.models;

import com.telerikacademy.oop.agency.models.JourneyImpl;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;
import com.telerikacademy.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.agency.tests.utils.TestData.Journey.*;

public class JourneyImpl_Tests {

    private Vehicle testVehicle;

    @BeforeEach
    public void before() {
        testVehicle = TestUtilities.initializeVehicle();
    }

    @ParameterizedTest(name = "with start location length {0}")
    @ValueSource(ints = {JourneyImpl.START_LOCATION_MIN_LENGTH - 1, JourneyImpl.START_LOCATION_MAX_LENGTH + 1})
    public void constructor_should_throw_when_startLocationLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new JourneyImpl(1, "x".repeat(testLength), VALID_DESTINATION_NAME, VALID_DISTANCE, testVehicle));
    }

    @ParameterizedTest(name = "with destination length {0}")
    @ValueSource(ints = {JourneyImpl.DESTINATION_MIN_LENGTH - 1, JourneyImpl.DESTINATION_MAX_LENGTH + 1})
    public void constructor_should_throw_when_destinationLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new JourneyImpl(1, VALID_START_LOCATION_NAME, "x".repeat(testLength), VALID_DISTANCE, testVehicle));
    }

    @ParameterizedTest(name = "with distance {0}")
    @ValueSource(ints = {JourneyImpl.DISTANCE_MIN_VALUE - 1, JourneyImpl.DISTANCE_MAX_VALUE + 1})
    public void constructor_should_throw_when_distanceOutOfBounds(int testDistance) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new JourneyImpl(1, VALID_START_LOCATION_NAME, VALID_DESTINATION_NAME, testDistance, testVehicle));
    }

}
