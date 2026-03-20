package com.Carreira.PA_GerenciadorDeCategorias.services;



import com.Carreira.PA_GerenciadorDeCategorias.models.CategoriaModel;
import com.Carreira.PA_GerenciadorDeCategorias.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaModel> findAll(){
        return categoriaRepository.findAll();
    }

    public CategoriaModel criarCategoria(CategoriaModel categoria){
        return categoriaRepository.save(categoria);
    }

    public Optional<CategoriaModel> buscarPorId(Long id){
        return categoriaRepository.findById(id);
    }

    public CategoriaModel atualizar(Long id,CategoriaModel categoria){
        CategoriaModel model =  categoriaRepository.findById(id).get();
        model.setNome(categoria.getNome());
        model.setDescricao(categoria.getDescricao());
        return categoriaRepository.save(model);
    }
    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }
}

