package com.test.university.repository;

import com.test.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface LectorRepository extends JpaRepository<Lector,Integer> {

 List<Lector> findByNameLike(String name);
}
