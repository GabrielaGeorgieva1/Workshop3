package com.telerikacademy.oop.agency.commands.creation;

import com.telerikacademy.oop.agency.commands.contracts.Command;
import com.telerikacademy.oop.agency.core.contracts.AgencyRepository;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Bus;
import com.telerikacademy.oop.agency.utils.ValidationHelper;

import java.util.List;

import static com.telerikacademy.oop.agency.commands.CommandsConstants.VEHICLE_CREATED_MESSAGE;
import static com.telerikacademy.oop.agency.utils.ParsingHelpers.tryParseDouble;
import static com.telerikacademy.oop.agency.utils.ParsingHelpers.tryParseInteger;

public class CreateBusCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;

    private final AgencyRepository agencyRepository;

    private int passengerCapacity;
    private double pricePerKilometer;

    public CreateBusCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);

        parseParameters(parameters);

        Bus createdBus = agencyRepository.createBus(passengerCapacity, pricePerKilometer);

        return String.format(VEHICLE_CREATED_MESSAGE, createdBus.getId());
    }

    private void parseParameters(List<String> parameters) {
        pricePerKilometer = tryParseDouble(parameters.get(1), "price");
        passengerCapacity = tryParseInteger(parameters.get(0), "passenger capacity");
    }

}