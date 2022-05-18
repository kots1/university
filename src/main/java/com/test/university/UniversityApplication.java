package com.test.university;

import com.test.university.commands.CommandReader;
import com.test.university.model.Degree;
import com.test.university.model.Department;
import com.test.university.model.Lector;
import com.test.university.repository.DepartmentRepository;
import com.test.university.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@RequiredArgsConstructor
public class UniversityApplication implements CommandLineRunner {

	private final CommandReader commandReader;

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		commandReader.read();
	}
}
