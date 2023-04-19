package com.example.lab4.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreserva", nullable = false)
    private Integer id;

    @Column(name = "fecha_reserva", nullable = false)
    private Instant fechaReserva;

    @Column(name = "precio_total", nullable = false, precision = 10)
    private BigDecimal precioTotal;

    @Column(name = "estado_pago", nullable = false, length = 45)
    private String estadoPago;

}