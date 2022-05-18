package com.test.university.commands.impl;

import com.test.university.commands.Command;
import com.test.university.model.Degree;
import com.test.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CountEmployeeCommand implements Command {

    private final DepartmentRepository departmentRepository;

    @Override
    public String execute(List<String> args) {
        if (!departmentRepository.existsByName(args.get(0))){
            return args.get(0)+ " department don`t exist";
        }
        return String.valueOf(departmentRepository.getCountLectorByDepartment(args.get(0)));
    }

    @Override
    public String getPattern() {
        return "Show count of employee for (\\w+)";
    }
}
