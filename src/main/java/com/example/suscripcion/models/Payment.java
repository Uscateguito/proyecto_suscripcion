package com.example.suscripcion.models;

import com.example.suscripcion.enums.PaymentStatus;
import com.example.suscripcion.enums.SuscriptionLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "payments")
public class Payment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String payment_method;
        private String payment_date;
        private double amount;

        @Enumerated(EnumType.ORDINAL)
        private PaymentStatus payment_status;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
}
