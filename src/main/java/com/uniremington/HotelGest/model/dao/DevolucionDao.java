package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Devolucion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DevolucionDao {

    private static final String SELECT_COLUMNS =
            "id_devolucion, id_pago, id_usuario, monto, motivo, estado, fecha_solicitud, "
                    + "fecha_confirmacion, id_pago_devolucion_confirmada";
    private final JdbcTemplate jdbcTemplate;

    public DevolucionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Devolucion> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM devolucion ORDER BY fecha_solicitud DESC",
                DaoSupport.rowMapper(Devolucion.class));
    }

    public List<Devolucion> findByPago(Long idPago) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM devolucion WHERE id_pago = ? "
                        + "ORDER BY fecha_solicitud DESC",
                DaoSupport.rowMapper(Devolucion.class), idPago);
    }

    public List<Devolucion> findByEstado(String estado) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM devolucion WHERE estado = ? "
                        + "ORDER BY fecha_solicitud DESC",
                DaoSupport.rowMapper(Devolucion.class), estado);
    }

    public Optional<Devolucion> findById(Long idDevolucion) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM devolucion WHERE id_devolucion = ?",
                DaoSupport.rowMapper(Devolucion.class), idDevolucion).stream().findFirst();
    }

    public long insertar(Devolucion devolucion) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO devolucion "
                        + "(id_pago, id_usuario, monto, motivo, estado, fecha_confirmacion) "
                        + "VALUES (?, ?, ?, ?, COALESCE(?, 'SOLICITADA'), ?)",
                devolucion.getIdPago(), devolucion.getIdUsuario(), devolucion.getMonto(),
                devolucion.getMotivo(), devolucion.getEstado(), devolucion.getFechaConfirmacion());
    }

    public int actualizar(Devolucion devolucion) {
        return jdbcTemplate.update(
                "UPDATE devolucion SET id_pago = ?, id_usuario = ?, monto = ?, motivo = ?, "
                        + "estado = ?, fecha_confirmacion = ? WHERE id_devolucion = ?",
                devolucion.getIdPago(), devolucion.getIdUsuario(), devolucion.getMonto(),
                devolucion.getMotivo(), devolucion.getEstado(), devolucion.getFechaConfirmacion(),
                devolucion.getIdDevolucion());
    }
}
