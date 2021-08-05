package com.telerikacademy.oop.agency.tests.models.vehicles;

import com.telerikacademy.oop.agency.models.vehicles.AirplaneImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.agency.tests.utils.TestData.Airplane.VALID_PASSENGER_CAPACITY;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Airplane.VALID_PRICE;

public class AirplaneImpl_Tests {

    @ParameterizedTest(name = "with capacity {0}")
    @ValueSource(ints = {AirplaneImpl.PASSENGER_MIN_VALUE - 1, AirplaneImpl.PASSENGER_MAX_VALUE + 1})
    public void constructor_should_throwException_when_passengerCapacityOutOfBounds(int testCapacity) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new AirplaneImpl(1, testCapacity, VALID_PRICE, true));
    }

    @ParameterizedTest(name = "with price {0}")
    @ValueSource(doubles = {AirplaneImpl.PRICE_MIN_VALUE - 0.1, AirplaneImpl.PRICE_MAX_VALUE + 0.1})
    public void constructor_should_throwException_when_pricePerKmOutOfBounds(double testPrice) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new AirplaneImpl(1, VALID_PASSENGER_CAPACITY, testPrice, true));
    }

}
