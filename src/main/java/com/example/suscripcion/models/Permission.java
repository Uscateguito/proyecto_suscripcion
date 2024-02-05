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
@Entity(name = "permissions")
public class Permission {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String permissions_name;

        @ManyToMany
        @JoinTable(
                name = "suscription_permissions",
                joinColumns = @JoinColumn(name = "permission_id"),
                inverseJoinColumns = @JoinColumn(name = "suscription_id"))
        Set<Suscription> permisions_for_suscription;

}
