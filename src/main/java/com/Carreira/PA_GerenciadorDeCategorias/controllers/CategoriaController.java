package com.Carreira.PA_GerenciadorDeCategorias.controllers;


import com.Carreira.PA_GerenciadorDeCategorias.models.CategoriaModel;
import com.Carreira.PA_GerenciadorDeCategorias.repositories.CategoriaRepository;
import com.Carreira.PA_GerenciadorDeCategorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAllCategoria(){
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel nova = categoriaService.criarCategoria(categoriaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> findById(@PathVariable Long id){
        Optional<CategoriaModel> categoria = categoriaService.buscarPorId(id);

        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModel> atualizarCategoria(@PathVariable Long id,
                                                             @RequestBody CategoriaModel categoriaModel){
        Optional<CategoriaModel> existente = categoriaService.buscarPorId(id);

        if (existente.isPresent()) {
            CategoriaModel atualizado = categoriaService.atualizar(id, categoriaModel);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id){
        Optional<CategoriaModel> existente = categoriaService.buscarPorId(id);

        if (existente.isPresent()) {
            categoriaService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
