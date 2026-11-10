package com.uniremington.HotelGest.model.dao;

import java.util.List;

import com.uniremington.HotelGest.model.vo.RolPermiso;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RolPermisoDao {

    private final JdbcTemplate jdbcTemplate;

    public RolPermisoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RolPermiso> findAll() {
        return jdbcTemplate.query(
                "SELECT id_rol, id_permiso FROM rol_permiso ORDER BY id_rol, id_permiso",
                DaoSupport.rowMapper(RolPermiso.class));
    }

    public List<RolPermiso> findByRol(Long idRol) {
        return jdbcTemplate.query(
                "SELECT id_rol, id_permiso FROM rol_permiso WHERE id_rol = ? ORDER BY id_permiso",
                DaoSupport.rowMapper(RolPermiso.class), idRol);
    }

    public int asignar(Long idRol, Long idPermiso) {
        return jdbcTemplate.update(
                "INSERT INTO rol_permiso (id_rol, id_permiso) VALUES (?, ?)", idRol, idPermiso);
    }

    public int revocar(Long idRol, Long idPermiso) {
        return jdbcTemplate.update(
                "DELETE FROM rol_permiso WHERE id_rol = ? AND id_permiso = ?", idRol, idPermiso);
    }
}
