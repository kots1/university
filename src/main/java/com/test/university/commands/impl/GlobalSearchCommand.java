package com.test.university.commands.impl;

import com.test.university.commands.Command;
import com.test.university.model.Lector;
import com.test.university.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GlobalSearchCommand implements Command {

    private final LectorRepository lectorRepository;

    @Override
    public String execute(List<String> args) {
        return lectorRepository.findByNameLike("%"+args.get(0)+"%")
                .stream()
                .map(Lector::getName)
                .collect(Collectors.joining(", "));
    }

    @Override
    public String getPattern() {
        return "Global search by (\\w+)";
    }
}
