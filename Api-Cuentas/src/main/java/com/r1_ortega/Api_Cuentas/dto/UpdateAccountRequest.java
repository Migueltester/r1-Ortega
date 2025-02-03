package com.r1_ortega.Api_Cuentas.dto;

//Clase para convertir el saldo en un objeto JSON y hacer escalable el Api

public class UpdateAccountRequest {

    private String nombreCliente;
    private Double saldo;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
