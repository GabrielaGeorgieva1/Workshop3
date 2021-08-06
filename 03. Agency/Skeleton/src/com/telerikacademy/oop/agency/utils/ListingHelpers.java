package com.telerikacademy.oop.agency.utils;

import com.telerikacademy.oop.agency.models.contracts.Journey;
import com.telerikacademy.oop.agency.models.contracts.Printable;
import com.telerikacademy.oop.agency.models.contracts.Ticket;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.oop.agency.commands.CommandsConstants.JOIN_DELIMITER;

public class ListingHelpers {

    public static String ticketsToString(List<Ticket> tickets) {
        List<String> result = new ArrayList<>();
        for (Ticket ticket : tickets) {
            result.add(ticket.getAsString());
        }

        return String.join(JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }

    public static String vehiclesToString(List<Vehicle> vehicles) {
        List<String> result = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            result.add(vehicle.getAsString());
        }

        return String.join(JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }

    public static String journeysToString(List<Journey> journeys) {
        List<String> result = new ArrayList<>();
        for (Journey journey : journeys) {
            result.add(journey.getAsString());
        }

        return String.join(JOIN_DELIMITER + System.lineSeparator(), result).trim();
    }

  public static <T extends Printable> String elementsToString(List<T> elements) {
      List<String> result = new ArrayList<>();
      for (T element : elements) {
          result.add(element.getAsString());
      }

      return String.join(JOIN_DELIMITER + System.lineSeparator(), result).trim();
  }
}

