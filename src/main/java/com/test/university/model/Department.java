package com.test.university.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "id_department")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_head")
    private Lector head;
    private String address;
    @Column(name = "web_site")
    private String webSite;
    @Column(name = "foundation_date")
    private LocalDate foundationDate;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "department_lector",
            joinColumns = @JoinColumn(name = "id_department"),
            inverseJoinColumns = @JoinColumn(name = "id_lector"))
    private Set<Lector> lectors;


}
