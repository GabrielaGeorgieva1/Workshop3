package com.telerikacademy.oop.agency.commands.creation;


import com.telerikacademy.oop.agency.commands.contracts.Command;
import com.telerikacademy.oop.agency.core.contracts.AgencyRepository;
import com.telerikacademy.oop.agency.models.contracts.Journey;
import com.telerikacademy.oop.agency.models.contracts.Ticket;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;
import com.telerikacademy.oop.agency.utils.ParsingHelpers;
import com.telerikacademy.oop.agency.utils.ValidationHelper;

import java.util.List;

public class CreateTicketCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String TICKET_CREATED_MESSAGE = "Journey with ID %d was created.";

    private final AgencyRepository agencyRepository;
    private Journey journey;
    private double costs;
    private int journeyId;

    public CreateTicketCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        parseParameters(parameters);

        Journey journey = agencyRepository.findJourneyById(journeyId);
        Ticket ticket = agencyRepository.createTicket(journey,costs);

        return String.format(TICKET_CREATED_MESSAGE, ticket.getId());
    }

    private void parseParameters(List<String> parameters) {
        journeyId = ParsingHelpers.tryParseInteger(parameters.get(0),"journey id");
        costs = ParsingHelpers.tryParseDouble(parameters.get(1),"cost");
    }
}