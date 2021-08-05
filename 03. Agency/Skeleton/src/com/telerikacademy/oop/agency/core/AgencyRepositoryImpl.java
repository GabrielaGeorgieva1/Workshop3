package com.telerikacademy.oop.agency.core;

import com.telerikacademy.oop.agency.core.contracts.AgencyRepository;
import com.telerikacademy.oop.agency.exceptions.ElementNotFoundException;
import com.telerikacademy.oop.agency.models.contracts.Journey;
import com.telerikacademy.oop.agency.models.contracts.Ticket;
import com.telerikacademy.oop.agency.models.vehicles.BusImpl;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Airplane;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Bus;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Train;
import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class AgencyRepositoryImpl implements AgencyRepository {

    private int nextId;

    private final List<Vehicle> vehicles = new ArrayList<>();
    private final List<Journey> journeys = new ArrayList<>();
    private final List<Ticket> tickets = new ArrayList<>();

    public AgencyRepositoryImpl() {
        nextId = 0;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    @Override
    public List<Journey> getJourneys() {
        return new ArrayList<>(journeys);
    }

    @Override
    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    @Override
    public Vehicle findVehicleById(int id) {
        for (Vehicle vehicle : getVehicles()) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }

        throw new ElementNotFoundException(String.format("No record with ID %d", id));
    }

    @Override
    public Journey findJourneyById(int id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Ticket findTicketById(int id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Airplane createAirplane(int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Bus createBus(int passengerCapacity, double pricePerKilometer) {
        Bus bus = new BusImpl(++nextId, passengerCapacity, pricePerKilometer);
        this.vehicles.add(bus);
        return bus;
    }

    @Override
    public Train createTrain(int passengerCapacity, double pricePerKilometer, int carts) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Journey createJourney(String startLocation, String destination, int distance, Vehicle vehicle) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Ticket createTicket(Journey journey, double costs) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Advanced task: Implement the following generic method that looks for an item by id.
    // private <T extends {{?}}> T findElementById(List<T> elements, int id) { }
}