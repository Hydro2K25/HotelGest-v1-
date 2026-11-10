package com.uniremington.HotelGest.model.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pago {

    private Long idPago;
    private Long idReserva;
    private BigDecimal monto;
    private String metodoPago;
    private String estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaConfirmacion;

    public Pago() {
    }

    public Pago(Long idPago, Long idReserva, BigDecimal monto, String metodoPago, String estado,
                LocalDateTime fechaCreacion, LocalDateTime fechaConfirmacion) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaConfirmacion = fechaConfirmacion;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaConfirmacion() {
        return fechaConfirmacion;
    }

    public void setFechaConfirmacion(LocalDateTime fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idPago=" + idPago +
                ", idReserva=" + idReserva +
                ", monto=" + monto +
                ", metodoPago='" + metodoPago + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaConfirmacion=" + fechaConfirmacion +
                '}';
    }
}
