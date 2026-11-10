package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Rol;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RolDao {

    private static final String SELECT_COLUMNS = "id_rol, nombre, descripcion, activo";
    private final JdbcTemplate jdbcTemplate;

    public RolDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Rol> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM rol ORDER BY nombre",
                DaoSupport.rowMapper(Rol.class));
    }

    public List<Rol> findActivos() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM rol WHERE activo = 1 ORDER BY nombre",
                DaoSupport.rowMapper(Rol.class));
    }

    public Optional<Rol> findById(Long idRol) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM rol WHERE id_rol = ?",
                DaoSupport.rowMapper(Rol.class), idRol).stream().findFirst();
    }

    public Optional<Rol> findByNombre(String nombre) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM rol WHERE nombre = ?",
                DaoSupport.rowMapper(Rol.class), nombre).stream().findFirst();
    }

    public long insertar(Rol rol) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO rol (nombre, descripcion, activo) VALUES (?, ?, COALESCE(?, 1))",
                rol.getNombre(), rol.getDescripcion(), rol.getActivo());
    }

    public int actualizar(Rol rol) {
        return jdbcTemplate.update(
                "UPDATE rol SET nombre = ?, descripcion = ?, activo = ? WHERE id_rol = ?",
                rol.getNombre(), rol.getDescripcion(), rol.getActivo(), rol.getIdRol());
    }

    public int desactivar(Long idRol) {
        return jdbcTemplate.update("UPDATE rol SET activo = 0 WHERE id_rol = ?", idRol);
    }
}
