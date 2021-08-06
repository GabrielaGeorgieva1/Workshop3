package com.telerikacademy.oop.agency.commands.listing;

import com.telerikacademy.oop.agency.commands.contracts.Command;
import com.telerikacademy.oop.agency.core.contracts.AgencyRepository;
import com.telerikacademy.oop.agency.models.contracts.Ticket;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;
import com.telerikacademy.oop.agency.utils.ListingHelpers;

import java.util.List;


public class ListVehiclesCommand implements Command {

    private final List<Vehicle> vehicles;
    public ListVehiclesCommand(AgencyRepository agencyRepository) {
        vehicles = agencyRepository.getVehicles();
    }


    @Override
    public String execute(List<String> parameters) {
            if (vehicles.isEmpty()) {
                return "There are no registered tickets.";
            }

            return ListingHelpers.vehiclesToString(vehicles);
        }
    }
