package com.jclopezr.prueba.repo.dao;

import com.jclopezr.prueba.Entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaDAO {

    List<Categoria> obtenerTodo();

    Categoria guardar(Categoria categoria);

    void eliminar(Integer id);

    Optional<Categoria> obtenerporId(Integer catId);

    void actualizar(Categoria categoria);
}
