package com.uniremington.HotelGest.model.vo;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Auditoria {

    private BigInteger idAuditoria;
    private Long idUsuario;
    private String accion;
    private String entidad;
    private String idRegistro;
    private LocalDateTime fechaHora;
    private String detalles;

    public Auditoria() {
    }

    public Auditoria(BigInteger idAuditoria, Long idUsuario, String accion, String entidad,
                     String idRegistro, LocalDateTime fechaHora, String detalles) {
        this.idAuditoria = idAuditoria;
        this.idUsuario = idUsuario;
        this.accion = accion;
        this.entidad = entidad;
        this.idRegistro = idRegistro;
        this.fechaHora = fechaHora;
        this.detalles = detalles;
    }

    public BigInteger getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(BigInteger idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Auditoria{" +
                "idAuditoria=" + idAuditoria +
                ", idUsuario=" + idUsuario +
                ", accion='" + accion + '\'' +
                ", entidad='" + entidad + '\'' +
                ", idRegistro='" + idRegistro + '\'' +
                ", fechaHora=" + fechaHora +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}
