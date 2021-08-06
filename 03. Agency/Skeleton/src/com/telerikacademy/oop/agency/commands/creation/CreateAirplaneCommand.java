package com.telerikacademy.oop.agency.commands.creation;

import com.telerikacademy.oop.agency.commands.contracts.Command;
import com.telerikacademy.oop.agency.core.contracts.AgencyRepository;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Airplane;
import com.telerikacademy.oop.agency.utils.ValidationHelper;

import java.util.List;

import static com.telerikacademy.oop.agency.commands.CommandsConstants.VEHICLE_CREATED_MESSAGE;
import static com.telerikacademy.oop.agency.utils.ParsingHelpers.*;

public class CreateAirplaneCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;

    private final AgencyRepository agencyRepository;
    private int passengerCapacity;
    private double pricePerKilometer;
    private boolean hasFreeFood;

    public CreateAirplaneCommand(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelper.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        parseParameters(parameters);

        Airplane createAirplane = agencyRepository.createAirplane(passengerCapacity, pricePerKilometer,hasFreeFood);

        return String.format(VEHICLE_CREATED_MESSAGE, createAirplane.getId());
    }

    private void parseParameters(List<String> parameters) {
        passengerCapacity = tryParseInteger(parameters.get(0), "passenger capacity");
        pricePerKilometer = tryParseDouble(parameters.get(1), "price");
        hasFreeFood = tryParseBoolean(parameters.get(2),"Free food");
    }

}