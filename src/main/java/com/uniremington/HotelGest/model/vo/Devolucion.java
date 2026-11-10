package com.uniremington.HotelGest.model.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Devolucion {

    private Long idDevolucion;
    private Long idPago;
    private Long idUsuario;
    private BigDecimal monto;
    private String motivo;
    private String estado;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaConfirmacion;
    private Long idPagoDevolucionConfirmada;

    public Devolucion() {
    }

    public Devolucion(Long idDevolucion, Long idPago, Long idUsuario, BigDecimal monto,
                      String motivo, String estado, LocalDateTime fechaSolicitud,
                      LocalDateTime fechaConfirmacion, Long idPagoDevolucionConfirmada) {
        this.idDevolucion = idDevolucion;
        this.idPago = idPago;
        this.idUsuario = idUsuario;
        this.monto = monto;
        this.motivo = motivo;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaConfirmacion = fechaConfirmacion;
        this.idPagoDevolucionConfirmada = idPagoDevolucionConfirmada;
    }

    public Long getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Long idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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

    public LocalDateTime getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(LocalDateTime fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Long getIdPagoDevolucionConfirmada() {
        return idPagoDevolucionConfirmada;
    }

    public void setIdPagoDevolucionConfirmada(Long idPagoDevolucionConfirmada) {
        this.idPagoDevolucionConfirmada = idPagoDevolucionConfirmada;
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "idDevolucion=" + idDevolucion +
                ", idPago=" + idPago +
                ", idUsuario=" + idUsuario +
                ", monto=" + monto +
                ", motivo='" + motivo + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaSolicitud=" + fechaSolicitud +
                ", fechaConfirmacion=" + fechaConfirmacion +
                ", idPagoDevolucionConfirmada=" + idPagoDevolucionConfirmada +
                '}';
    }
}
