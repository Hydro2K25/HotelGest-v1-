package com.uniremington.HotelGest.model.dao;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

final class DaoSupport {

    private DaoSupport() {
    }

    static <T> RowMapper<T> rowMapper(Class<T> type) {
        return BeanPropertyRowMapper.newInstance(type);
    }

    static long insertAndReturnLongKey(JdbcTemplate jdbcTemplate, String sql, Object... parameters) {
        KeyHolder keyHolder = executeInsert(jdbcTemplate, sql, parameters);
        Number key = keyHolder.getKey();
        if (key == null) {
            throw new IllegalStateException("La inserción no devolvió una clave generada.");
        }
        return key.longValue();
    }

    static BigInteger insertAndReturnBigIntegerKey(
            JdbcTemplate jdbcTemplate, String sql, Object... parameters) {
        KeyHolder keyHolder = executeInsert(jdbcTemplate, sql, parameters);
        Number key = keyHolder.getKey();
        if (key == null) {
            throw new IllegalStateException("La inserción no devolvió una clave generada.");
        }
        return new BigInteger(key.toString());
    }

    private static KeyHolder executeInsert(
            JdbcTemplate jdbcTemplate, String sql, Object... parameters) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement =
                    connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int index = 0; index < parameters.length; index++) {
                statement.setObject(index + 1, parameters[index]);
            }
            return statement;
        }, keyHolder);
        return keyHolder;
    }
}
