package com.test.university.commands.impl;

import com.test.university.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Help implements Command {

    private Set<Command> commands;

    @Override
    public String execute(List<String> args) {
        return "Existing command:\n"+ commands.stream()
                .map(Command::getPattern)
                .map(s -> s.replaceAll("\\(.+\\)", "{input}"))
                .collect(Collectors.joining("\n"));
    }

    @Autowired
    public void setCommands(Set<Command> commands) {
        this.commands = commands;
    }

    @Override
    public String getPattern() {
        return "help";
    }
}
