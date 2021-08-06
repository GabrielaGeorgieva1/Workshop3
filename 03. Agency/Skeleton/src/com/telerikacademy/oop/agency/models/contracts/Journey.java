package com.telerikacademy.oop.agency.models.contracts;

import com.telerikacademy.oop.agency.models.vehicles.contracts.Vehicle;

public interface Journey extends Identifiable,Printable{

    int getDistance();

    Vehicle getVehicle();

    String getDestination();

    double calculateTravelCosts();

}