package com.uniremington.HotelGest.model.vo;

public class Habitacion {

    private Long idHabitacion;
    private Long idTipo;
    private String numero;
    private String estado;
    private Boolean activo;

    public Habitacion() {
    }

    public Habitacion(Long idHabitacion, Long idTipo, String numero, String estado, Boolean activo) {
        this.idHabitacion = idHabitacion;
        this.idTipo = idTipo;
        this.numero = numero;
        this.estado = estado;
        this.activo = activo;
    }

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "idHabitacion=" + idHabitacion +
                ", idTipo=" + idTipo +
                ", numero='" + numero + '\'' +
                ", estado='" + estado + '\'' +
                ", activo=" + activo +
                '}';
    }
}
