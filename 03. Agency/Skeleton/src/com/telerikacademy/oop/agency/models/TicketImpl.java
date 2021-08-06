package com.telerikacademy.oop.agency.models;

import com.telerikacademy.oop.agency.exceptions.InvalidUserInputException;
import com.telerikacademy.oop.agency.models.contracts.Journey;
import com.telerikacademy.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    private int id;
    private Journey journey;
    private double costs;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        this.journey = journey;
        setCosts(costs);
    }

    public void setCosts(double costs) {
        if(costs < 0){
            throw new InvalidUserInputException("Price cannon negative");
        }
        this.costs = costs;
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return getAdministrativeCosts() * getJourney().calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format(" Ticket ----\n" +
                "Destination: %s\n" +
                "Price: %s\n",journey.getDestination(),calculatePrice());
    }
}
