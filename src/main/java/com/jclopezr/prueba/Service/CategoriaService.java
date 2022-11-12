package com.jclopezr.prueba.Service;

import com.jclopezr.prueba.Entity.Categoria;
import com.jclopezr.prueba.repo.dao.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaDAO dao;

    @Autowired
    public CategoriaService(CategoriaDAO dao) {
        this.dao = dao;
    }

    public List<Categoria> obtenerTodo() {
        return dao.obtenerTodo();
    }

    public Categoria guardar(Categoria categoria) {
        return dao.guardar(categoria);
    }

    public void eliminar(Integer id) {
        dao.eliminar(id);
    }

    public Optional<Categoria> obtenerPorID(Integer catID) {
        return dao.obtenerporId(catID);
    }

    public void actualizar(Categoria categoria) {
        dao.actualizar(categoria);
    }



}
