package com.teamtreehouse.courses.model;

import java.util.Date;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private int diaCumpleaños;
    private int mesCumpleaños;
    private int saldo;

    public Cliente(String nombre, String apellido, int diaCumpleaños, int mesCumpleaños) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.diaCumpleaños = diaCumpleaños;
        this.mesCumpleaños = mesCumpleaños;
        this.saldo = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getDiaCumpleaños() {
        return diaCumpleaños;
    }

    public void setDiaCumpleaños(int diaCumpleaños) {
        this.diaCumpleaños = diaCumpleaños;
    }

    public int getMesCumpleaños() {
        return mesCumpleaños;
    }

    public void setMesCumpleaños(int mesCumpleaños) {
        this.mesCumpleaños = mesCumpleaños;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (id != cliente.id) return false;
        if (diaCumpleaños != cliente.diaCumpleaños) return false;
        if (mesCumpleaños != cliente.mesCumpleaños) return false;
        if (saldo != cliente.saldo) return false;
        if (!nombre.equals(cliente.nombre)) return false;
        return apellido.equals(cliente.apellido);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nombre.hashCode();
        result = 31 * result + apellido.hashCode();
        result = 31 * result + diaCumpleaños;
        result = 31 * result + mesCumpleaños;
        result = 31 * result + saldo;
        return result;
    }
}

