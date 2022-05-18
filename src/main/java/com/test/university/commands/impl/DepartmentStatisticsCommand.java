package com.test.university.commands.impl;

import com.test.university.commands.Command;
import com.test.university.model.Degree;
import com.test.university.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentStatisticsCommand implements Command {

    private final DepartmentRepository departmentRepository;

    @Override
    public String execute(List<String> args) {
        if (!departmentRepository.existsByName(args.get(0))){
            return args.get(0)+ " department don`t exist";
        }
        return "assistants - " +
                departmentRepository.getCountLectorByDegreeAndDepartment(args.get(0), Degree.ASSISTANT.getName()) +
                "\nassociate professors - " +
                departmentRepository.getCountLectorByDegreeAndDepartment(args.get(0), Degree.ASSOCIATE_PROFESSOR.getName()) +
                "\nprofessors  - " +
                departmentRepository.getCountLectorByDegreeAndDepartment(args.get(0), Degree.PROFESSOR.getName());
    }

    @Override
    public String getPattern() {
        return "Show (\\w+) statistics";
    }
}
