package com.uniremington.HotelGest.model.dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.uniremington.HotelGest.model.vo.Auditoria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AuditoriaDao {

    private static final String SELECT_COLUMNS =
            "id_auditoria, id_usuario, accion, entidad, id_registro, fecha_hora, detalles";
    private static final RowMapper<Auditoria> ROW_MAPPER = (resultSet, rowNumber) -> {
        String idAuditoria = resultSet.getString("id_auditoria");
        long idUsuarioValue = resultSet.getLong("id_usuario");
        Long idUsuario = resultSet.wasNull() ? null : idUsuarioValue;
        Timestamp fechaHoraValue = resultSet.getTimestamp("fecha_hora");
        LocalDateTime fechaHora = fechaHoraValue == null ? null : fechaHoraValue.toLocalDateTime();

        return new Auditoria(
                idAuditoria == null ? null : new BigInteger(idAuditoria),
                idUsuario,
                resultSet.getString("accion"),
                resultSet.getString("entidad"),
                resultSet.getString("id_registro"),
                fechaHora,
                resultSet.getString("detalles"));
    };

    private final JdbcTemplate jdbcTemplate;

    public AuditoriaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Auditoria> findRecientes(int limite) {
        if (limite < 1) {
            throw new IllegalArgumentException("El límite debe ser mayor que cero.");
        }
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM auditoria "
                        + "ORDER BY fecha_hora DESC, id_auditoria DESC LIMIT ?",
                ROW_MAPPER, limite);
    }

    public List<Auditoria> findByUsuario(Long idUsuario) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM auditoria WHERE id_usuario = ? "
                        + "ORDER BY fecha_hora DESC, id_auditoria DESC",
                ROW_MAPPER, idUsuario);
    }

    public List<Auditoria> findByEntidadRegistro(String entidad, String idRegistro) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM auditoria "
                        + "WHERE entidad = ? AND id_registro = ? "
                        + "ORDER BY fecha_hora DESC, id_auditoria DESC",
                ROW_MAPPER, entidad, idRegistro);
    }

    public List<Auditoria> findBetween(LocalDateTime desde, LocalDateTime hasta) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM auditoria "
                        + "WHERE fecha_hora >= ? AND fecha_hora <= ? "
                        + "ORDER BY fecha_hora DESC, id_auditoria DESC",
                ROW_MAPPER, desde, hasta);
    }

    public BigInteger insertar(Auditoria auditoria) {
        return DaoSupport.insertAndReturnBigIntegerKey(jdbcTemplate,
                "INSERT INTO auditoria "
                        + "(id_usuario, accion, entidad, id_registro, fecha_hora, detalles) "
                        + "VALUES (?, ?, ?, ?, COALESCE(?, CURRENT_TIMESTAMP), ?)",
                auditoria.getIdUsuario(), auditoria.getAccion(), auditoria.getEntidad(),
                auditoria.getIdRegistro(), auditoria.getFechaHora(), auditoria.getDetalles());
    }
}
