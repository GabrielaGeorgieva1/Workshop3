package com.telerikacademy.oop.agency.tests.commands;

import com.telerikacademy.oop.agency.commands.contracts.Command;
import com.telerikacademy.oop.agency.commands.creation.CreateBusCommand;
import com.telerikacademy.oop.agency.core.AgencyRepositoryImpl;
import com.telerikacademy.oop.agency.core.contracts.AgencyRepository;
import com.telerikacademy.oop.agency.exceptions.InvalidUserInputException;
import com.telerikacademy.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.telerikacademy.oop.agency.commands.creation.CreateBusCommand.EXPECTED_NUMBER_OF_ARGUMENTS;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Bus.VALID_PASSENGER_CAPACITY;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Train.VALID_PRICE;

/**
 * CreateBusCommand arguments: {{Passenger Capacity}} {{Price Per Kilometer}}
 */
public class CreateBusCommand_Tests {

    private Command command;
    private AgencyRepository repository;

    @BeforeEach
    public void before() {
        this.repository = new AgencyRepositoryImpl();
        this.command = new CreateBusCommand(repository);
    }

    @ParameterizedTest(name = "with arguments count: {0}")
    @ValueSource(ints = {EXPECTED_NUMBER_OF_ARGUMENTS - 1, EXPECTED_NUMBER_OF_ARGUMENTS + 1})
    public void execute_should_throwException_when_argumentsCountDifferentThanExpected(int argumentsCount) {
        // Arrange
        List<String> arguments = TestUtilities.initializeListWithSize(argumentsCount);

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(arguments));
    }

    @Test
    public void execute_should_throwException_when_passedUnparsablePassengerCapacity() {
        // Arrange
        List<String> arguments = List.of("invalid", String.valueOf(VALID_PRICE));

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(arguments));
    }

    @Test
    public void execute_should_throwException_when_passedUnparsablePricePerKm() {
        // Arrange
        List<String> arguments = List.of(String.valueOf(VALID_PASSENGER_CAPACITY), "invalid");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(arguments));
    }

    @Test
    public void execute_should_addNewBus_when_passedValidInput() {
        // Arrange
        List<String> arguments = List.of(String.valueOf(VALID_PASSENGER_CAPACITY), String.valueOf(VALID_PRICE));

        // Act, Assert
        Assertions.assertAll(
                Assertions.assertDoesNotThrow(() -> command.execute(arguments)),
                () -> Assertions.assertFalse(repository.getVehicles().isEmpty())
        );
    }

}
