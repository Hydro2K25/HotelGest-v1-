package com.uniremington.HotelGest.model.vo;

public class Permiso {

    private Long idPermiso;
    private String codigo;
    private String descripcion;

    public Permiso() {
    }

    public Permiso(Long idPermiso, String codigo, String descripcion) {
        this.idPermiso = idPermiso;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Long getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Permiso{" +
                "idPermiso=" + idPermiso +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
