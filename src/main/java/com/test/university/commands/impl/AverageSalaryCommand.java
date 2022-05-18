package com.test.university.commands.impl;

import com.test.university.commands.Command;
import com.test.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AverageSalaryCommand implements Command {

    private final DepartmentRepository departmentRepository;

    @Override
    public String execute(List<String> args) {
        if (!departmentRepository.existsByName(args.get(0))){
            return args.get(0)+ " department don`t exist";
        }
        return "The average salary of "+args.get(0)+" is "
                +departmentRepository.getAverageSalaryDepartment(args.get(0));
    }

    @Override
    public String getPattern() {
        return "Show the average salary for the department (\\w+)";
    }
}
