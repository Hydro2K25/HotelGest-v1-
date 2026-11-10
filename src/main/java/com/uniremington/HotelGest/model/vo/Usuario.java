package com.uniremington.HotelGest.model.vo;

import java.time.LocalDateTime;

public class Usuario {

    private Long idUsuario;
    private Long idRol;
    private String nombreUsuario;
    private String passwordHash;
    private String nombreCompleto;
    private Boolean activo;
    private LocalDateTime creadoEn;

    public Usuario() {
    }

    public Usuario(Long idUsuario, Long idRol, String nombreUsuario, String passwordHash,
                   String nombreCompleto, Boolean activo, LocalDateTime creadoEn) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = passwordHash;
        this.nombreCompleto = nombreCompleto;
        this.activo = activo;
        this.creadoEn = creadoEn;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", idRol=" + idRol +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", activo=" + activo +
                ", creadoEn=" + creadoEn +
                '}';
    }
}
