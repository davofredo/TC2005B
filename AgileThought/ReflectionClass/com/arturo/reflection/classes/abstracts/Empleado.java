package com.arturo.reflection.classes.abstracts;

import java.time.LocalDate;

import com.arturo.reflection.classes.constants.PuestosEnum;

public class Empleado extends Persona {

    private PuestosEnum puesto = PuestosEnum.DELEVOLPER;
    protected LocalDate fechaIngreso = LocalDate.now();
    double sueldo;
    
    public Empleado() {
    }
    public Empleado(double sueldo) {
        this.sueldo = sueldo;
    }
    public Empleado(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public Empleado(PuestosEnum puesto) {
        this.puesto = puesto;
    }
    public PuestosEnum getPuesto() {
        return puesto;
    }
    public void setPuesto(PuestosEnum puesto) {
        this.puesto = puesto;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double calcularSueldo(LocalDate fechaIngreso, PuestosEnum puesto) {
        System.out.println("Se ingresó fecha de ingreso: " + fechaIngreso);
        System.out.println("Se ingresó puesto: " + puesto.name());
        return 65485;
    }
}
