package com.example.examendesarrollointerfaces.Coche;

import com.example.examendesarrollointerfaces.Cliente.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
public class Coche {
    private String matricula;

    private String modelo;

    private Cliente cliente;

    private String tarifa;

    private LocalDate entrada;

    private LocalDate salida;

    private double costeTotal;


    public Coche(String matricula , String modelo , Cliente cliente , String tipoTarifa , LocalDate fechaEntrada , LocalDate fechaSalida ) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.cliente = cliente;
        this.tarifa = tipoTarifa;
        this.entrada = fechaEntrada;
        this.salida = fechaSalida;
        costeTotal = 0.0;
    }
}
