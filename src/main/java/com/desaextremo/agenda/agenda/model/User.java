package com.desaextremo.agenda.agenda.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "identification", nullable = false, length = 15)
    private String identification;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "address", nullable = false, length = 80)
    private String address;
    @Column(name = "cellPhone", nullable = false, length = 10)
    private String cellPhone;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "gender", nullable = false, length = 1)
    private String gender;
}
