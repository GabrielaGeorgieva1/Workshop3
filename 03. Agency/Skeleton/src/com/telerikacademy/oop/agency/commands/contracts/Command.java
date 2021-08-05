package com.telerikacademy.oop.agency.commands.contracts;

import java.util.List;

public interface Command {

    String execute(List<String> parameters);

}