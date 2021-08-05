package com.telerikacademy.oop.agency.tests.models.vehicles;

import com.telerikacademy.oop.agency.models.vehicles.TrainImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.agency.tests.utils.TestData.Train.*;

public class TrainImpl_Tests {

    @ParameterizedTest(name = "with capacity {0}")
    @ValueSource(ints = {TrainImpl.PASSENGER_MIN_VALUE - 1, TrainImpl.PASSENGER_MAX_VALUE + 1})
    public void constructor_should_throw_when_passengerCapacityOutOfBounds(int testCapacity) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TrainImpl(1, testCapacity, VALID_PRICE, VALID_CARTS));
    }

    @ParameterizedTest(name = "with carts count {0}")
    @ValueSource(ints = {TrainImpl.CARTS_MIN_VALUE - 1, TrainImpl.CARTS_MAX_VALUE + 1})
    public void constructor_should_throw_when_cartsLessThanMinValue(int testCartsCount) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TrainImpl(1, VALID_PASSENGER_CAPACITY, VALID_PRICE, testCartsCount));
    }

    @ParameterizedTest(name = "with price {0}")
    @ValueSource(doubles = {TrainImpl.PRICE_MIN_VALUE - 0.1, TrainImpl.PRICE_MAX_VALUE + 0.1})
    public void constructor_should_throw_when_pricePerKmLessThanMinimum(double testPrice) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TrainImpl(1, VALID_PASSENGER_CAPACITY, testPrice, VALID_CARTS));
    }

}
