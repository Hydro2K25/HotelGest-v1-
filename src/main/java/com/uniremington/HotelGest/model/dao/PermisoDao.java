package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Permiso;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PermisoDao {

    private static final String SELECT_COLUMNS = "id_permiso, codigo, descripcion";
    private final JdbcTemplate jdbcTemplate;

    public PermisoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Permiso> findAll() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM permiso ORDER BY codigo",
                DaoSupport.rowMapper(Permiso.class));
    }

    public Optional<Permiso> findById(Long idPermiso) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM permiso WHERE id_permiso = ?",
                DaoSupport.rowMapper(Permiso.class), idPermiso).stream().findFirst();
    }

    public Optional<Permiso> findByCodigo(String codigo) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM permiso WHERE codigo = ?",
                DaoSupport.rowMapper(Permiso.class), codigo).stream().findFirst();
    }

    public long insertar(Permiso permiso) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO permiso (codigo, descripcion) VALUES (?, ?)",
                permiso.getCodigo(), permiso.getDescripcion());
    }

    public int actualizar(Permiso permiso) {
        return jdbcTemplate.update(
                "UPDATE permiso SET codigo = ?, descripcion = ? WHERE id_permiso = ?",
                permiso.getCodigo(), permiso.getDescripcion(), permiso.getIdPermiso());
    }

    public int eliminar(Long idPermiso) {
        return jdbcTemplate.update("DELETE FROM permiso WHERE id_permiso = ?", idPermiso);
    }
}
