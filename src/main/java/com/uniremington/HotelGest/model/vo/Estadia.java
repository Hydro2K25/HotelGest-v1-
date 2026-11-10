package com.uniremington.HotelGest.model.vo;

import java.time.LocalDateTime;

public class Estadia {

    private Long idEstadia;
    private Long idReserva;
    private Long idUsuarioCheckin;
    private Long idUsuarioCheckout;
    private LocalDateTime checkinReal;
    private LocalDateTime checkoutReal;

    public Estadia() {
    }

    public Estadia(Long idEstadia, Long idReserva, Long idUsuarioCheckin, Long idUsuarioCheckout,
                   LocalDateTime checkinReal, LocalDateTime checkoutReal) {
        this.idEstadia = idEstadia;
        this.idReserva = idReserva;
        this.idUsuarioCheckin = idUsuarioCheckin;
        this.idUsuarioCheckout = idUsuarioCheckout;
        this.checkinReal = checkinReal;
        this.checkoutReal = checkoutReal;
    }

    public Long getIdEstadia() {
        return idEstadia;
    }

    public void setIdEstadia(Long idEstadia) {
        this.idEstadia = idEstadia;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdUsuarioCheckin() {
        return idUsuarioCheckin;
    }

    public void setIdUsuarioCheckin(Long idUsuarioCheckin) {
        this.idUsuarioCheckin = idUsuarioCheckin;
    }

    public Long getIdUsuarioCheckout() {
        return idUsuarioCheckout;
    }

    public void setIdUsuarioCheckout(Long idUsuarioCheckout) {
        this.idUsuarioCheckout = idUsuarioCheckout;
    }

    public LocalDateTime getCheckinReal() {
        return checkinReal;
    }

    public void setCheckinReal(LocalDateTime checkinReal) {
        this.checkinReal = checkinReal;
    }

    public LocalDateTime getCheckoutReal() {
        return checkoutReal;
    }

    public void setCheckoutReal(LocalDateTime checkoutReal) {
        this.checkoutReal = checkoutReal;
    }

    @Override
    public String toString() {
        return "Estadia{" +
                "idEstadia=" + idEstadia +
                ", idReserva=" + idReserva +
                ", idUsuarioCheckin=" + idUsuarioCheckin +
                ", idUsuarioCheckout=" + idUsuarioCheckout +
                ", checkinReal=" + checkinReal +
                ", checkoutReal=" + checkoutReal +
                '}';
    }
}
