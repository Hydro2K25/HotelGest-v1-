package com.uniremington.HotelGest.model.vo;

public class RolPermiso {

    private Long idRol;
    private Long idPermiso;

    public RolPermiso() {
    }

    public RolPermiso(Long idRol, Long idPermiso) {
        this.idRol = idRol;
        this.idPermiso = idPermiso;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    @Override
    public String toString() {
        return "RolPermiso{" +
                "idRol=" + idRol +
                ", idPermiso=" + idPermiso +
                '}';
    }
}
