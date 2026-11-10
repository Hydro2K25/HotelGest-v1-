package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Huesped;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HuespedDao {

    private static final String SELECT_COLUMNS =
            "id_huesped, documento, nombre, telefono, correo, activo";
    private final JdbcTemplate jdbcTemplate;

    public HuespedDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Huesped> findAll() {
        return jdbcTemplate.query("SELECT " + SELECT_COLUMNS + " FROM huesped ORDER BY nombre",
                DaoSupport.rowMapper(Huesped.class));
    }

    public List<Huesped> findActivos() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM huesped WHERE activo = 1 ORDER BY nombre",
                DaoSupport.rowMapper(Huesped.class));
    }

    public List<Huesped> findByNombre(String nombre) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM huesped WHERE nombre LIKE ? ORDER BY nombre",
                DaoSupport.rowMapper(Huesped.class), "%" + nombre + "%");
    }

    public Optional<Huesped> findById(Long idHuesped) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM huesped WHERE id_huesped = ?",
                DaoSupport.rowMapper(Huesped.class), idHuesped).stream().findFirst();
    }

    public Optional<Huesped> findByDocumento(String documento) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM huesped WHERE documento = ?",
                DaoSupport.rowMapper(Huesped.class), documento).stream().findFirst();
    }

    public long insertar(Huesped huesped) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO huesped (documento, nombre, telefono, correo, activo) "
                        + "VALUES (?, ?, ?, ?, COALESCE(?, 1))",
                huesped.getDocumento(), huesped.getNombre(), huesped.getTelefono(),
                huesped.getCorreo(), huesped.getActivo());
    }

    public int actualizar(Huesped huesped) {
        return jdbcTemplate.update(
                "UPDATE huesped SET documento = ?, nombre = ?, telefono = ?, correo = ?, activo = ? "
                        + "WHERE id_huesped = ?",
                huesped.getDocumento(), huesped.getNombre(), huesped.getTelefono(),
                huesped.getCorreo(), huesped.getActivo(), huesped.getIdHuesped());
    }

    public int desactivar(Long idHuesped) {
        return jdbcTemplate.update("UPDATE huesped SET activo = 0 WHERE id_huesped = ?", idHuesped);
    }
}
