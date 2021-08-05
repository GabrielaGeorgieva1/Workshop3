package com.telerikacademy.oop.agency.core.contracts;

import com.telerikacademy.oop.agency.models.contracts.Journey;
import com.telerikacademy.oop.agency.models.contracts.Ticket;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Airplane;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Bus;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Train;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;

import java.util.List;

public interface AgencyRepository {

    List<Ticket> getTickets();

    List<Vehicle> getVehicles();

    List<Journey> getJourneys();

    Ticket findTicketById(int id);

    Vehicle findVehicleById(int id);

    Journey findJourneyById(int id);

    Bus createBus(int passengerCapacity, double pricePerKilometer);

    Ticket createTicket(Journey journey, double costs);

    Train createTrain(int passengerCapacity, double pricePerKilometer, int carts);

    Airplane createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood);

    Journey createJourney(String startLocation, String destination, int distance, Vehicle vehicle);

}