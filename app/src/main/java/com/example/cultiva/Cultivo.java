package com.example.cultiva;

import java.io.Serializable;
import java.util.Calendar;

public class Cultivo implements Serializable {
    private String nombre;
    private Calendar fechaPlantacion;
    private Calendar fechaCosecha;

    public Cultivo(String nombre, Calendar fechaPlantacion, Calendar fechaCosecha) {
        this.nombre = nombre;
        this.fechaPlantacion = fechaPlantacion;
        this.fechaCosecha = fechaCosecha;
    }

    public String getNombre() {
        return nombre;
    }

    public Calendar getFechaPlantacion() {
        return fechaPlantacion;
    }

    public Calendar getFechaCosecha() {
        return fechaCosecha;
    }
}
