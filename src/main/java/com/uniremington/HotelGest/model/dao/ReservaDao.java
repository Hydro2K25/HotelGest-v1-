package com.uniremington.HotelGest.model.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Reserva;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReservaDao {

    private static final String SELECT_COLUMNS =
            "id_reserva, id_huesped, id_habitacion, id_usuario, fecha_entrada, fecha_salida, "
                    + "cantidad_huespedes, tarifa_reservada, estado, creada_en, actualizada_en";
    private final JdbcTemplate jdbcTemplate;

    public ReservaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Reserva> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM reserva ORDER BY fecha_entrada, id_reserva",
                DaoSupport.rowMapper(Reserva.class));
    }

    public List<Reserva> findByEstado(String estado) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM reserva WHERE estado = ? "
                        + "ORDER BY fecha_entrada, id_reserva",
                DaoSupport.rowMapper(Reserva.class), estado);
    }

    public List<Reserva> findByHuesped(Long idHuesped) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM reserva WHERE id_huesped = ? "
                        + "ORDER BY fecha_entrada DESC, id_reserva DESC",
                DaoSupport.rowMapper(Reserva.class), idHuesped);
    }

    public List<Reserva> findByHabitacion(Long idHabitacion) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM reserva WHERE id_habitacion = ? "
                        + "ORDER BY fecha_entrada DESC, id_reserva DESC",
                DaoSupport.rowMapper(Reserva.class), idHabitacion);
    }

    public List<Reserva> findEntradasBetween(LocalDate desde, LocalDate hasta) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM reserva "
                        + "WHERE fecha_entrada >= ? AND fecha_entrada <= ? "
                        + "ORDER BY fecha_entrada, id_reserva",
                DaoSupport.rowMapper(Reserva.class), desde, hasta);
    }

    public Optional<Reserva> findById(Long idReserva) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM reserva WHERE id_reserva = ?",
                DaoSupport.rowMapper(Reserva.class), idReserva).stream().findFirst();
    }

    public long insertar(Reserva reserva) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO reserva (id_huesped, id_habitacion, id_usuario, fecha_entrada, "
                        + "fecha_salida, cantidad_huespedes, tarifa_reservada, estado) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, COALESCE(?, 'PENDIENTE'))",
                reserva.getIdHuesped(), reserva.getIdHabitacion(), reserva.getIdUsuario(),
                reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getCantidadHuespedes(),
                reserva.getTarifaReservada(), reserva.getEstado());
    }

    public int actualizar(Reserva reserva) {
        return jdbcTemplate.update(
                "UPDATE reserva SET id_huesped = ?, id_habitacion = ?, id_usuario = ?, "
                        + "fecha_entrada = ?, fecha_salida = ?, cantidad_huespedes = ?, "
                        + "tarifa_reservada = ?, estado = ? WHERE id_reserva = ?",
                reserva.getIdHuesped(), reserva.getIdHabitacion(), reserva.getIdUsuario(),
                reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getCantidadHuespedes(),
                reserva.getTarifaReservada(), reserva.getEstado(), reserva.getIdReserva());
    }
}
