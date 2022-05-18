package com.test.university.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class CommandReader {
    private Map<String, Command> commands;

    public static List<String> groupList(String text, Pattern pattern) {
        List<String> list = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                list.add(matcher.group(i));
            }
        }
        return list;
    }

    @Autowired
    public void setCommands(Set<Command> converters) {
        this.commands = converters.stream()
                .collect(Collectors.toMap(Command::getPattern, Function.identity()));
    }

    private void executor(String command) {
        Pattern pattern;
        Matcher matcher;
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            pattern = Pattern.compile("^"+entry.getKey()+"$");
            matcher = pattern.matcher(command);
            if (matcher.find()) {
                List<String> groups = groupList(command, pattern);
                System.out.println(entry.getValue().execute(groups));
                return;
            }
        }

    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("\nChoose  command (\"help\" for information) :");
            command = scanner.nextLine();
            executor(command);
        } while (!command.isBlank());
    }
}
