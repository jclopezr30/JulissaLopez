package com.jclopezr.prueba.repo.daoImp;

import com.jclopezr.prueba.Entity.Categoria;
import com.jclopezr.prueba.Entity.mapper.CategoriaMapper;
import com.jclopezr.prueba.repo.dao.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CategoriaDaoImp implements CategoriaDAO {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert insert;

    @Autowired
    public CategoriaDaoImp(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Categoria> obtenerTodo() {
        return jdbc.query("select * from categoria",
                new CategoriaMapper());
    }


    @Override
    public Categoria guardar(Categoria categoria) {
        Map parameters = new HashMap();
        insert = new SimpleJdbcInsert(jdbc).withTableName("categoria").usingGeneratedKeyColumns("idcategoria");
        parameters.put("nombre", categoria.getNombre());
        parameters.put("descripcion", categoria.getDescripcion());
        parameters.put("estado", categoria.getEstado());
        Number newId = insert.executeAndReturnKey(parameters);
        categoria.setIdcategoria(newId.intValue());
        return categoria;
    }

    @Override
    public void eliminar(Integer id) {
        jdbc.update("delete from categoria where id = ?", id);
    }

    @Override
    public Optional<Categoria> obtenerporId(Integer catId) {
        return jdbc.query("select * from categoria where idcategoria = ? ",
                BeanPropertyRowMapper.newInstance(Categoria.class), catId).stream().findFirst();
    }

    @Override
    public void actualizar(Categoria categoria) {
        jdbc.update("update categoria " +
                        "set nombre = ?, descripcion = ?, estado = ?" +
                        "where idcategoria  = ?",
                categoria.getNombre(),
                categoria.getDescripcion(),
                categoria.getEstado(),
                categoria.getIdcategoria());
    }

}
