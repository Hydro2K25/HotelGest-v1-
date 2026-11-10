package com.uniremington.HotelGest.model.vo;

import java.math.BigDecimal;

public class TipoHabitacion {

    private Long idTipo;
    private String nombre;
    private String descripcion;
    private Integer capacidad;
    private BigDecimal tarifaNoche;
    private Boolean activo;

    public TipoHabitacion() {
    }

    public TipoHabitacion(Long idTipo, String nombre, String descripcion, Integer capacidad,
                          BigDecimal tarifaNoche, Boolean activo) {
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.tarifaNoche = tarifaNoche;
        this.activo = activo;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public BigDecimal getTarifaNoche() {
        return tarifaNoche;
    }

    public void setTarifaNoche(BigDecimal tarifaNoche) {
        this.tarifaNoche = tarifaNoche;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" +
                "idTipo=" + idTipo +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", capacidad=" + capacidad +
                ", tarifaNoche=" + tarifaNoche +
                ", activo=" + activo +
                '}';
    }
}
