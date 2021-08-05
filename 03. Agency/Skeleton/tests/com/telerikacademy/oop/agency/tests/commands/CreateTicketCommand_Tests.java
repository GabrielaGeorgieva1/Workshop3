package com.telerikacademy.oop.agency.tests.commands;

import com.telerikacademy.oop.agency.commands.contracts.Command;
import com.telerikacademy.oop.agency.commands.creation.CreateTicketCommand;
import com.telerikacademy.oop.agency.core.AgencyRepositoryImpl;
import com.telerikacademy.oop.agency.core.contracts.AgencyRepository;
import com.telerikacademy.oop.agency.exceptions.ElementNotFoundException;
import com.telerikacademy.oop.agency.exceptions.InvalidUserInputException;
import com.telerikacademy.oop.agency.models.contracts.Journey;
import com.telerikacademy.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.telerikacademy.oop.agency.commands.creation.CreateTicketCommand.EXPECTED_NUMBER_OF_ARGUMENTS;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Bus.VALID_PASSENGER_CAPACITY;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Bus.VALID_PRICE;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Journey.*;
import static com.telerikacademy.oop.agency.tests.utils.TestData.Ticket.VALID_COSTS;

/**
 * CreateTicketCommand arguments: {{Journey ID}} {{Administrative Costs}}
 */
public class CreateTicketCommand_Tests {

    private Command command;
    private AgencyRepository repository;

    @BeforeEach
    public void before() {
        this.repository = new AgencyRepositoryImpl();
        this.command = new CreateTicketCommand(repository);
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
    public void execute_should_throwException_when_passedUnparsableJourneyIndex() {
        // Arrange
        List<String> arguments = List.of("3", String.valueOf(VALID_COSTS));
        repository.createBus(VALID_PASSENGER_CAPACITY, VALID_PRICE);

        // Act, Assert
        Assertions.assertThrows(ElementNotFoundException.class, () -> command.execute(arguments));
    }

    @Test
    public void execute_should_throwException_when_unableToParseAdministrativeCosts() {
        // Arrange
        List<String> arguments = List.of("1", "two dollars");
        repository.createJourney(VALID_START_LOCATION_NAME,
                VALID_DESTINATION_NAME,
                VALID_DISTANCE,
                TestUtilities.initializeVehicle());

        // Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class, () -> command.execute(arguments));
    }

    @Test
    public void execute_should_createTicket_when_passedValidInput() {
        // Arrange
        List<String> arguments = List.of("1", String.valueOf(VALID_COSTS));
        Journey journeyToCreate = TestUtilities.initializeJourney();
        repository.createJourney(VALID_START_LOCATION_NAME,
                VALID_DESTINATION_NAME,
                VALID_DISTANCE,
                TestUtilities.initializeVehicle());

        // Act, Assert
        Assertions.assertAll(
                Assertions.assertDoesNotThrow(() -> command.execute(arguments)),
                () -> Assertions.assertFalse(repository.getTickets().isEmpty()),
                () -> Assertions.assertEquals(repository.getJourneys().get(0).getId(), journeyToCreate.getId())
        );
    }

}
