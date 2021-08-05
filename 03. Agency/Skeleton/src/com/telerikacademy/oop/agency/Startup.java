package com.telerikacademy.oop.agency;

import com.telerikacademy.oop.agency.core.AgencyEngineImpl;

public class Startup {

    public static void main(String[] args) {
        AgencyEngineImpl engine = new AgencyEngineImpl();
        engine.start();
    }

}
