package com.telerikacademy.oop.agency.models.vehicles.contracts;

import com.telerikacademy.oop.agency.models.contracts.Identifiable;
import com.telerikacademy.oop.agency.models.contracts.Printable;
import com.telerikacademy.oop.agency.models.vehicles.VehicleType;

public interface Vehicle extends Identifiable, Printable {

    VehicleType getType();

    int getPassengerCapacity();

    double getPricePerKilometer();

}