package com.Carreira.PA_GerenciadorDeCategorias.controllers;


import com.Carreira.PA_GerenciadorDeCategorias.models.CategoriaModel;
import com.Carreira.PA_GerenciadorDeCategorias.repositories.CategoriaRepository;
import com.Carreira.PA_GerenciadorDeCategorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaModel> findAll(){
        return categoriaService.findAll();
    }

    @PostMapping
    public CategoriaModel criarCategoria(@RequestBody CategoriaModel categoriaModel){
        return categoriaService.criarCategoria(categoriaModel);
    }

    @GetMapping("/{id}")
    public Optional<CategoriaModel> findById(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaModel atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaModel categoriaModel){
        return categoriaService.atualizar(id,categoriaModel);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id){
        categoriaService.deletar(id);
    }
}
