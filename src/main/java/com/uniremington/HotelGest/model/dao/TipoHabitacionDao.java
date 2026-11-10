package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.TipoHabitacion;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TipoHabitacionDao {

    private static final String SELECT_COLUMNS =
            "id_tipo, nombre, descripcion, capacidad, tarifa_noche, activo";
    private final JdbcTemplate jdbcTemplate;

    public TipoHabitacionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TipoHabitacion> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM tipo_habitacion ORDER BY nombre",
                DaoSupport.rowMapper(TipoHabitacion.class));
    }

    public List<TipoHabitacion> findActivos() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM tipo_habitacion "
                        + "WHERE activo = 1 ORDER BY nombre",
                DaoSupport.rowMapper(TipoHabitacion.class));
    }

    public Optional<TipoHabitacion> findById(Long idTipo) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM tipo_habitacion WHERE id_tipo = ?",
                DaoSupport.rowMapper(TipoHabitacion.class), idTipo).stream().findFirst();
    }

    public long insertar(TipoHabitacion tipoHabitacion) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO tipo_habitacion "
                        + "(nombre, descripcion, capacidad, tarifa_noche, activo) "
                        + "VALUES (?, ?, ?, ?, COALESCE(?, 1))",
                tipoHabitacion.getNombre(), tipoHabitacion.getDescripcion(),
                tipoHabitacion.getCapacidad(), tipoHabitacion.getTarifaNoche(),
                tipoHabitacion.getActivo());
    }

    public int actualizar(TipoHabitacion tipoHabitacion) {
        return jdbcTemplate.update(
                "UPDATE tipo_habitacion SET nombre = ?, descripcion = ?, capacidad = ?, "
                        + "tarifa_noche = ?, activo = ? WHERE id_tipo = ?",
                tipoHabitacion.getNombre(), tipoHabitacion.getDescripcion(),
                tipoHabitacion.getCapacidad(), tipoHabitacion.getTarifaNoche(),
                tipoHabitacion.getActivo(), tipoHabitacion.getIdTipo());
    }

    public int desactivar(Long idTipo) {
        return jdbcTemplate.update(
                "UPDATE tipo_habitacion SET activo = 0 WHERE id_tipo = ?", idTipo);
    }
}
