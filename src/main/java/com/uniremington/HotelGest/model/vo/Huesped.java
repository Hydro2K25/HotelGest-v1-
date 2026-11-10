package com.uniremington.HotelGest.model.vo;

public class Huesped {

    private Long idHuesped;
    private String documento;
    private String nombre;
    private String telefono;
    private String correo;
    private Boolean activo;

    public Huesped() {
    }

    public Huesped(Long idHuesped, String documento, String nombre, String telefono,
                   String correo, Boolean activo) {
        this.idHuesped = idHuesped;
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.activo = activo;
    }

    public Long getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(Long idHuesped) {
        this.idHuesped = idHuesped;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "idHuesped=" + idHuesped +
                ", documento='" + documento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", activo=" + activo +
                '}';
    }
}
