package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Pago;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PagoDao {

    private static final String SELECT_COLUMNS =
            "id_pago, id_reserva, monto, metodo_pago, estado, fecha_creacion, fecha_confirmacion";
    private final JdbcTemplate jdbcTemplate;

    public PagoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pago> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM pago ORDER BY fecha_creacion DESC",
                DaoSupport.rowMapper(Pago.class));
    }

    public List<Pago> findByReserva(Long idReserva) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM pago WHERE id_reserva = ? "
                        + "ORDER BY fecha_creacion DESC",
                DaoSupport.rowMapper(Pago.class), idReserva);
    }

    public List<Pago> findByEstado(String estado) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM pago WHERE estado = ? "
                        + "ORDER BY fecha_creacion DESC",
                DaoSupport.rowMapper(Pago.class), estado);
    }

    public Optional<Pago> findById(Long idPago) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM pago WHERE id_pago = ?",
                DaoSupport.rowMapper(Pago.class), idPago).stream().findFirst();
    }

    public long insertar(Pago pago) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO pago (id_reserva, monto, metodo_pago, estado, fecha_confirmacion) "
                        + "VALUES (?, ?, ?, COALESCE(?, 'PENDIENTE'), ?)",
                pago.getIdReserva(), pago.getMonto(), pago.getMetodoPago(),
                pago.getEstado(), pago.getFechaConfirmacion());
    }

    public int actualizar(Pago pago) {
        return jdbcTemplate.update(
                "UPDATE pago SET id_reserva = ?, monto = ?, metodo_pago = ?, estado = ?, "
                        + "fecha_confirmacion = ? WHERE id_pago = ?",
                pago.getIdReserva(), pago.getMonto(), pago.getMetodoPago(),
                pago.getEstado(), pago.getFechaConfirmacion(), pago.getIdPago());
    }
}
