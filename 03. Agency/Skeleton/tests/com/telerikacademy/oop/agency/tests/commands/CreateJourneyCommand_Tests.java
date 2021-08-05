package com.telerikacademy.oop.agency.tests.commands;

import com.telerikacademy.oop.agency.commands.contracts.Command;
import com.telerikacademy.oop.agency.commands.creation.CreateJourneyCommand;
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

import static com.telerikacademy.oop.agency.commands.creation.CreateJourneyCommand.EXPECTED_NUMBER_OF_ARGUMENTS;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Bus.VALID_PASSENGER_CAPACITY;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Bus.VALID_PRICE;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Journey.*;

/**
 * CreateJourneyCommand arguments: {{Start Location}} {{Destination}} {{Distance}} {{Vehicle ID}}
 */
public class CreateJourneyCommand_Tests {

    private Command command;
    private AgencyRepository repository;

    @BeforeEach
    public void before() {
        this.repository = new AgencyRepositoryImpl();
        this.command = new CreateJourneyCommand(repository);
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
    public void execute_should_throwException_when_passedUnparsableDistance() {
        // Arrange
        List<String> arguments = List.of(VALID_START_LOCATION_NAME, VALID_DESTINATION_NAME, "invalid", "1");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(arguments));
    }

    @Test
    public void execute_should_throwException_when_passedUnparsableVehicleId() {
        // Arrange
        List<String> arguments = List.of(VALID_START_LOCATION_NAME, VALID_DESTINATION_NAME, String.valueOf(VALID_DISTANCE), "invalid");

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(arguments));
    }

    @Test
    public void execute_should_addNewJourney_when_passedValidInput() {
        // Arrange
        repository.createBus(VALID_PASSENGER_CAPACITY, VALID_PRICE);
        int journeyVehicleId = 1;
        List<String> arguments = List.of(VALID_START_LOCATION_NAME,
                VALID_DESTINATION_NAME,
                String.valueOf(VALID_DISTANCE),
                String.valueOf(journeyVehicleId));

        // Act, Assert
        Assertions.assertAll(
                Assertions.assertDoesNotThrow(() -> command.execute(arguments)),
                () -> Assertions.assertFalse(repository.getJourneys().isEmpty()),
                () -> Assertions.assertEquals(repository.getJourneys().get(0).getVehicle().getId(), journeyVehicleId)
        );
    }

}
