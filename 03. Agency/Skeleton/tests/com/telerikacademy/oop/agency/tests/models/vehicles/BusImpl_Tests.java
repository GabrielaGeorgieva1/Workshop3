package com.telerikacademy.oop.agency.tests.models.vehicles;

import com.telerikacademy.oop.agency.models.vehicles.BusImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.agency.tests.utils.TestData.Bus.VALID_PASSENGER_CAPACITY;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Bus.VALID_PRICE;

public class BusImpl_Tests {

    @ParameterizedTest(name = "with capacity {0}")
    @ValueSource(ints = {BusImpl.PASSENGER_MIN_VALUE - 1, BusImpl.PASSENGER_MAX_VALUE + 1})
    public void constructor_should_throw_when_passengerCapacityOutOfBounds(int testCapacity) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BusImpl(1, testCapacity, VALID_PRICE));
    }

    @ParameterizedTest(name = "with price {0}")
    @ValueSource(doubles = {BusImpl.PRICE_MIN_VALUE - 0.1, BusImpl.PRICE_MAX_VALUE + 0.1})
    public void constructor_should_throw_when_pricePerKmLessThanMinimum(double testPrice) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BusImpl(1, VALID_PASSENGER_CAPACITY, testPrice));
    }

}
