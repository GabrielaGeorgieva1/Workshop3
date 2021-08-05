package com.telerikacademy.oop.agency.models.vehicles.contracts;

import com.telerikacademy.oop.agency.models.contracts.Identifiable;
import com.telerikacademy.oop.agency.models.vehicles.VehicleType;

public interface Vehicle {

    VehicleType getType();

    int getPassengerCapacity();

    double getPricePerKilometer();

}