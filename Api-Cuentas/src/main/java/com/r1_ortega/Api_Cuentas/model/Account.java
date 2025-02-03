package com.r1_ortega.Api_Cuentas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_Cliente", nullable = false)
    private String nombreCliente;

    @Column(name = "numero_Cuenta", nullable = false, unique = true)
    private String numeroCuenta;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @Column(name = "estado", nullable = false)
    private boolean Estado = true;

}
