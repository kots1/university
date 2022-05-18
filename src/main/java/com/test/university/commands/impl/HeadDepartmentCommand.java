package com.test.university.commands.impl;

import com.test.university.commands.Command;
import com.test.university.model.Department;
import com.test.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HeadDepartmentCommand implements Command {

    private final DepartmentRepository departmentRepository;

    @Override
    public String execute(List<String> args) {
        if (!departmentRepository.existsByName(args.get(0))){
            return args.get(0)+ " department don`t exist";
        }
        Department department = departmentRepository.findDepartmentByName(args.get(0)).orElseThrow();
        return "Head of " +
                args.get(0) +
                " department is " +
                department.getHead().getName();
    }

    @Override
    public String getPattern() {
        return "Who is head of department (\\w+)";
    }
}
