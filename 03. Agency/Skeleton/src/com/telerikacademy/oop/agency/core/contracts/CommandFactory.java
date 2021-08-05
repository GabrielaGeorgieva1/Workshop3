package com.telerikacademy.oop.agency.core.contracts;

import com.telerikacademy.oop.agency.commands.contracts.Command;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandTypeAsString, AgencyRepository agencyRepository);

}