package com.Carreira.PA_GerenciadorDeCategorias.models;

import jakarta.persistence.*;

@Entity
@Table(name="TBL_Categoria")
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nome Categoria")
    private String nome;
    @Column(name = "Descricao Categoria")
    private String descricao;

    public CategoriaModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}