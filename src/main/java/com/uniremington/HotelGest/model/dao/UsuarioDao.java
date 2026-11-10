package com.uniremington.HotelGest.model.dao;

import java.util.List;
import java.util.Optional;

import com.uniremington.HotelGest.model.vo.Usuario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao {

    private static final String SELECT_COLUMNS =
            "id_usuario, id_rol, nombre_usuario, nombre_completo, activo, creado_en";
    private final JdbcTemplate jdbcTemplate;

    public UsuarioDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Usuario> findAll() {
        return jdbcTemplate.query("SELECT " + SELECT_COLUMNS + " FROM usuario ORDER BY id_usuario",
                DaoSupport.rowMapper(Usuario.class));
    }

    public List<Usuario> findActivos() {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM usuario WHERE activo = 1 ORDER BY nombre_usuario",
                DaoSupport.rowMapper(Usuario.class));
    }

    public List<Usuario> findByRol(Long idRol) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM usuario WHERE id_rol = ? ORDER BY nombre_usuario",
                DaoSupport.rowMapper(Usuario.class), idRol);
    }

    public Optional<Usuario> findById(Long idUsuario) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM usuario WHERE id_usuario = ?",
                DaoSupport.rowMapper(Usuario.class), idUsuario).stream().findFirst();
    }

    public Optional<Usuario> findByNombreUsuario(String nombreUsuario) {
        return jdbcTemplate.query(
                "SELECT " + SELECT_COLUMNS + " FROM usuario WHERE nombre_usuario = ?",
                DaoSupport.rowMapper(Usuario.class), nombreUsuario).stream().findFirst();
    }

    public long insertar(Usuario usuario) {
        return DaoSupport.insertAndReturnLongKey(jdbcTemplate,
                "INSERT INTO usuario (id_rol, nombre_usuario, nombre_completo, activo) "
                        + "VALUES (?, ?, ?, COALESCE(?, 0))",
                usuario.getIdRol(), usuario.getNombreUsuario(), usuario.getNombreCompleto(),
                usuario.getActivo());
    }

    public int actualizar(Usuario usuario) {
        return jdbcTemplate.update(
                "UPDATE usuario SET id_rol = ?, nombre_usuario = ?, nombre_completo = ?, activo = ? "
                        + "WHERE id_usuario = ?",
                usuario.getIdRol(), usuario.getNombreUsuario(), usuario.getNombreCompleto(),
                usuario.getActivo(), usuario.getIdUsuario());
    }

    public int actualizarPasswordHash(Long idUsuario, String passwordHash) {
        return jdbcTemplate.update(
                "UPDATE usuario SET password_hash = ? WHERE id_usuario = ?", passwordHash, idUsuario);
    }

    public int desactivar(Long idUsuario) {
        return jdbcTemplate.update("UPDATE usuario SET activo = 0 WHERE id_usuario = ?", idUsuario);
    }
}
