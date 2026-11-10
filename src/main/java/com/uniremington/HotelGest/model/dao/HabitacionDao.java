package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Habitacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HabitacionDao {

    private static final String SELECT_COLUMNS =
            "id_habitacion, id_tipo, numero, estado, activo";
    private final JdbcTemplate jdbcTemplate;

    public HabitacionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Habitacion> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM habitacion ORDER BY numero",
                DaoSupport.rowMapper(Habitacion.class));
    }

    public List<Habitacion> findActivas() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM habitacion WHERE activo = 1 ORDER BY numero",
                DaoSupport.rowMapper(Habitacion.class));
    }

    public List<Habitacion> findByTipo(Long idTipo) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM habitacion WHERE id_tipo = ? ORDER BY numero",
                DaoSupport.rowMapper(Habitacion.class), idTipo);
    }

    public List<Habitacion> findByEstado(String estado) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM habitacion WHERE estado = ? ORDER BY numero",
                DaoSupport.rowMapper(Habitacion.class), estado);
    }

    public Optional<Habitacion> findById(Long idHabitacion) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM habitacion WHERE id_habitacion = ?",
                DaoSupport.rowMapper(Habitacion.class), idHabitacion).stream().findFirst();
    }

    public Optional<Habitacion> findByNumero(String numero) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM habitacion WHERE numero = ?",
                DaoSupport.rowMapper(Habitacion.class), numero).stream().findFirst();
    }

    public long insertar(Habitacion habitacion) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO habitacion (id_tipo, numero, estado, activo) "
                        + "VALUES (?, ?, COALESCE(?, 'DISPONIBLE'), COALESCE(?, 1))",
                habitacion.getIdTipo(), habitacion.getNumero(),
                habitacion.getEstado(), habitacion.getActivo());
    }

    public int actualizar(Habitacion habitacion) {
        return jdbcTemplate.update(
                "UPDATE habitacion SET id_tipo = ?, numero = ?, estado = ?, activo = ? "
                        + "WHERE id_habitacion = ?",
                habitacion.getIdTipo(), habitacion.getNumero(), habitacion.getEstado(),
                habitacion.getActivo(), habitacion.getIdHabitacion());
    }

    public int desactivar(Long idHabitacion) {
        return jdbcTemplate.update(
                "UPDATE habitacion SET activo = 0 WHERE id_habitacion = ?", idHabitacion);
    }
}
