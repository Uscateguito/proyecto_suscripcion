package com.example.suscripcion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;
        private String las_name;
        private String user_name;
        private String email;
        private String password_hash;
        private String registration_date;

        @OneToMany(cascade =
                CascadeType.ALL,
                fetch = FetchType.LAZY,
                orphanRemoval = true,
                mappedBy = "user")
        private Set<Suscription> suscriptions_for_user;

        @OneToMany(cascade =
                CascadeType.ALL,
                fetch = FetchType.LAZY,
                orphanRemoval = true,
                mappedBy = "user")
        private Set<Payment> payments_for_user;
}
