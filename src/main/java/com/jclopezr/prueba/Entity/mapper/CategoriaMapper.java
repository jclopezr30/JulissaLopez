package com.jclopezr.prueba.Entity.mapper;

import com.jclopezr.prueba.Entity.Categoria;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements RowMapper<Categoria> {

    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {

        Categoria cat = new Categoria();
        cat.setIdcategoria(rs.getInt("idcategoria"));
        cat.setNombre(rs.getString("nombre"));
        cat.setDescripcion(rs.getString("descipcion"));
        cat.setEstado(rs.getBoolean("estado"));
        return cat;
    }

}
