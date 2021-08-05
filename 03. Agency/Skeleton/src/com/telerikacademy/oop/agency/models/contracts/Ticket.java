package com.telerikacademy.oop.agency.models.contracts;

public interface Ticket {

    Journey getJourney();

    double calculatePrice();

    double getAdministrativeCosts();

}