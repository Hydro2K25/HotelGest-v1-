package com.uniremington.HotelGest.model.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {

    private Long idReserva;
    private Long idHuesped;
    private Long idHabitacion;
    private Long idUsuario;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private Integer cantidadHuespedes;
    private BigDecimal tarifaReservada;
    private String estado;
    private LocalDateTime creadaEn;
    private LocalDateTime actualizadaEn;

    public Reserva() {
    }

    public Reserva(Long idReserva, Long idHuesped, Long idHabitacion, Long idUsuario,
                   LocalDate fechaEntrada, LocalDate fechaSalida, Integer cantidadHuespedes,
                   BigDecimal tarifaReservada, String estado, LocalDateTime creadaEn,
                   LocalDateTime actualizadaEn) {
        this.idReserva = idReserva;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.idUsuario = idUsuario;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cantidadHuespedes = cantidadHuespedes;
        this.tarifaReservada = tarifaReservada;
        this.estado = estado;
        this.creadaEn = creadaEn;
        this.actualizadaEn = actualizadaEn;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(Long idHuesped) {
        this.idHuesped = idHuesped;
    }

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public void setCantidadHuespedes(Integer cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public BigDecimal getTarifaReservada() {
        return tarifaReservada;
    }

    public void setTarifaReservada(BigDecimal tarifaReservada) {
        this.tarifaReservada = tarifaReservada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreadaEn() {
        return creadaEn;
    }

    public void setCreadaEn(LocalDateTime creadaEn) {
        this.creadaEn = creadaEn;
    }

    public LocalDateTime getActualizadaEn() {
        return actualizadaEn;
    }

    public void setActualizadaEn(LocalDateTime actualizadaEn) {
        this.actualizadaEn = actualizadaEn;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", idHuesped=" + idHuesped +
                ", idHabitacion=" + idHabitacion +
                ", idUsuario=" + idUsuario +
                ", fechaEntrada=" + fechaEntrada +
                ", fechaSalida=" + fechaSalida +
                ", cantidadHuespedes=" + cantidadHuespedes +
                ", tarifaReservada=" + tarifaReservada +
                ", estado='" + estado + '\'' +
                ", creadaEn=" + creadaEn +
                ", actualizadaEn=" + actualizadaEn +
                '}';
    }
}
