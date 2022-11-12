package com.jclopezr.prueba.Vista;

import com.jclopezr.prueba.Entity.Categoria;
import com.jclopezr.prueba.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria/")
public class CategoriaControlador {

    private CategoriaService service;


    @Autowired
    public CategoriaControlador(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("todo")
    public ResponseEntity<List<Categoria>> obtenerTodo() {
        return new ResponseEntity<>(service.obtenerTodo(), HttpStatus.OK);
    }

    @PostMapping("guardar")
    public Categoria guardar(@RequestBody Categoria categoria) {
        service.guardar(categoria);
        return categoria;
    }


    @PostMapping("eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorID(id).
                map(categoria -> new ResponseEntity<>(categoria, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("update")
    public void actualizar(@RequestBody Categoria categoria) {
        service.actualizar(categoria);
    }

}
