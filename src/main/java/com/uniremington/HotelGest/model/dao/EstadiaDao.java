package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Estadia;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EstadiaDao {

    private static final String SELECT_COLUMNS =
            "id_estadia, id_reserva, id_usuario_checkin, id_usuario_checkout, "
                    + "checkin_real, checkout_real";
    private final JdbcTemplate jdbcTemplate;

    public EstadiaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Estadia> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM estadia ORDER BY checkin_real DESC",
                DaoSupport.rowMapper(Estadia.class));
    }

    public Optional<Estadia> findById(Long idEstadia) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM estadia WHERE id_estadia = ?",
                DaoSupport.rowMapper(Estadia.class), idEstadia).stream().findFirst();
    }

    public Optional<Estadia> findByReserva(Long idReserva) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM estadia WHERE id_reserva = ?",
                DaoSupport.rowMapper(Estadia.class), idReserva).stream().findFirst();
    }

    public List<Estadia> findAbiertas() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM estadia WHERE checkout_real IS NULL "
                        + "ORDER BY checkin_real",
                DaoSupport.rowMapper(Estadia.class));
    }

    public long insertar(Estadia estadia) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO estadia (id_reserva, id_usuario_checkin, id_usuario_checkout, "
                        + "checkin_real, checkout_real) VALUES (?, ?, ?, ?, ?)",
                estadia.getIdReserva(), estadia.getIdUsuarioCheckin(),
                estadia.getIdUsuarioCheckout(), estadia.getCheckinReal(),
                estadia.getCheckoutReal());
    }

    public int actualizar(Estadia estadia) {
        return jdbcTemplate.update(
                "UPDATE estadia SET id_reserva = ?, id_usuario_checkin = ?, "
                        + "id_usuario_checkout = ?, checkin_real = ?, checkout_real = ? "
                        + "WHERE id_estadia = ?",
                estadia.getIdReserva(), estadia.getIdUsuarioCheckin(),
                estadia.getIdUsuarioCheckout(), estadia.getCheckinReal(),
                estadia.getCheckoutReal(), estadia.getIdEstadia());
    }
}
