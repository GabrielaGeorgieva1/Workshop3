package com.telerikacademy.oop.agency.tests.models;

import com.telerikacademy.oop.agency.exceptions.InvalidUserInputException;
import com.telerikacademy.oop.agency.models.TicketImpl;
import com.telerikacademy.oop.agency.tests.utils.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketImpl_Tests {

    @Test
    public void constructor_should_throwException_when_costsNegative() {
        //Arrange, Act, Assert
        Assertions.assertThrows(InvalidUserInputException.class,
                () -> new TicketImpl(1, TestUtilities.initializeJourney(), -1.2));
    }

    @Test
    public void constructor_shouldNot_throwException_when_costsPositive() {
        //Arrange, Act, Assert
        Assertions.assertDoesNotThrow(() -> new TicketImpl(1, TestUtilities.initializeJourney(), 1));
    }

}
