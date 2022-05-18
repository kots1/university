package com.test.university.repository;

import com.test.university.model.Degree;
import com.test.university.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findDepartmentByName(String name);

    @Query(value = "SELECT count(*) FROM university.lector as l \n" +
            "join university.department_lector as dl \n" +
            "on l.id_lector=dl.id_lector \n" +
            "where degree = ?2 \n" +
            "and id_department = (select id_department from university.department as d where d.`name` =?1 )"
            , nativeQuery = true)
    int getCountLectorByDegreeAndDepartment(String name, String degree);

    @Query(value = "SELECT count(*) FROM university.lector as l \n" +
            "join university.department_lector as dl \n" +
            "on l.id_lector=dl.id_lector \n" +
            "where id_department = (select id_department from university.department as d where d.`name` =?1 )"
            , nativeQuery = true)
    int getCountLectorByDepartment(String name);

    @Query(value = "SELECT avg(salary) FROM university.lector as l \n" +
            "join university.department_lector as dl \n" +
            "on l.id_lector=dl.id_lector \n" +
            "where id_department = (select id_department from university.department as d where d.`name` =?1 )"
            , nativeQuery = true)
    int getAverageSalaryDepartment(String name);

    boolean existsByName(String name);
}
