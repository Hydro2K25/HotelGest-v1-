package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.AutorizacionExcepcion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AutorizacionExcepcionDao {

    private static final String SELECT_COLUMNS =
            "id_autorizacion, id_reserva, id_solicitante, id_administrador, tipo_excepcion, "
                    + "motivo, estado, fecha_solicitud, fecha_resolucion";
    private final JdbcTemplate jdbcTemplate;

    public AutorizacionExcepcionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AutorizacionExcepcion> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM autorizacion_excepcion "
                        + "ORDER BY fecha_solicitud DESC",
                DaoSupport.rowMapper(AutorizacionExcepcion.class));
    }

    public List<AutorizacionExcepcion> findByReserva(Long idReserva) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM autorizacion_excepcion WHERE id_reserva = ? "
                        + "ORDER BY fecha_solicitud DESC",
                DaoSupport.rowMapper(AutorizacionExcepcion.class), idReserva);
    }

    public List<AutorizacionExcepcion> findByEstado(String estado) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM autorizacion_excepcion WHERE estado = ? "
                        + "ORDER BY fecha_solicitud",
                DaoSupport.rowMapper(AutorizacionExcepcion.class), estado);
    }

    public Optional<AutorizacionExcepcion> findById(Long idAutorizacion) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM autorizacion_excepcion "
                        + "WHERE id_autorizacion = ?",
                DaoSupport.rowMapper(AutorizacionExcepcion.class), idAutorizacion)
                .stream().findFirst();
    }

    public long insertar(AutorizacionExcepcion autorizacion) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO autorizacion_excepcion "
                        + "(id_reserva, id_solicitante, id_administrador, tipo_excepcion, "
                        + "motivo, estado, fecha_resolucion) "
                        + "VALUES (?, ?, ?, ?, ?, COALESCE(?, 'PENDIENTE'), ?)",
                autorizacion.getIdReserva(), autorizacion.getIdSolicitante(),
                autorizacion.getIdAdministrador(), autorizacion.getTipoExcepcion(),
                autorizacion.getMotivo(), autorizacion.getEstado(),
                autorizacion.getFechaResolucion());
    }

    public int actualizar(AutorizacionExcepcion autorizacion) {
        return jdbcTemplate.update(
                "UPDATE autorizacion_excepcion SET id_reserva = ?, id_solicitante = ?, "
                        + "id_administrador = ?, tipo_excepcion = ?, motivo = ?, estado = ?, "
                        + "fecha_resolucion = ? WHERE id_autorizacion = ?",
                autorizacion.getIdReserva(), autorizacion.getIdSolicitante(),
                autorizacion.getIdAdministrador(), autorizacion.getTipoExcepcion(),
                autorizacion.getMotivo(), autorizacion.getEstado(),
                autorizacion.getFechaResolucion(), autorizacion.getIdAutorizacion());
    }
}
