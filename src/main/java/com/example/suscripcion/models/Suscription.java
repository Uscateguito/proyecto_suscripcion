package com.example.suscripcion.models;

import com.example.suscripcion.enums.SuscriptionLevel;
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
@Entity(name = "suscriptions")
public class Suscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String start_date;
    private double end_date;
    private boolean active_suscription;

    @Enumerated(EnumType.ORDINAL)
    private SuscriptionLevel suscription_level;

    @ManyToMany(mappedBy = "permisions_for_suscription")
    Set<Permission> suscription_permissions;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
