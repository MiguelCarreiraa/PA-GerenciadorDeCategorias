package com.Carreira.PA_GerenciadorDeCategorias.repositories;


import com.Carreira.PA_GerenciadorDeCategorias.models.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel,Long> {
}

