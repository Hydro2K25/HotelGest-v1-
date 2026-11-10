package com.uniremington.HotelGest.model.vo;

import java.time.LocalDateTime;

public class AutorizacionExcepcion {

    private Long idAutorizacion;
    private Long idReserva;
    private Long idSolicitante;
    private Long idAdministrador;
    private String tipoExcepcion;
    private String motivo;
    private String estado;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaResolucion;

    public AutorizacionExcepcion() {
    }

    public AutorizacionExcepcion(Long idAutorizacion, Long idReserva, Long idSolicitante,
                                 Long idAdministrador, String tipoExcepcion, String motivo,
                                 String estado, LocalDateTime fechaSolicitud,
                                 LocalDateTime fechaResolucion) {
        this.idAutorizacion = idAutorizacion;
        this.idReserva = idReserva;
        this.idSolicitante = idSolicitante;
        this.idAdministrador = idAdministrador;
        this.tipoExcepcion = tipoExcepcion;
        this.motivo = motivo;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaResolucion = fechaResolucion;
    }

    public Long getIdAutorizacion() {
        return idAutorizacion;
    }

    public void setIdAutorizacion(Long idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Long idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public Long getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Long idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getTipoExcepcion() {
        return tipoExcepcion;
    }

    public void setTipoExcepcion(String tipoExcepcion) {
        this.tipoExcepcion = tipoExcepcion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    @Override
    public String toString() {
        return "AutorizacionExcepcion{" +
                "idAutorizacion=" + idAutorizacion +
                ", idReserva=" + idReserva +
                ", idSolicitante=" + idSolicitante +
                ", idAdministrador=" + idAdministrador +
                ", tipoExcepcion='" + tipoExcepcion + '\'' +
                ", motivo='" + motivo + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaSolicitud=" + fechaSolicitud +
                ", fechaResolucion=" + fechaResolucion +
                '}';
    }
}
