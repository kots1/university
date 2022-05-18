package com.test.university.commands;

import java.util.List;

public interface Command {
    String execute(List<String> args);

    String getPattern();

}
