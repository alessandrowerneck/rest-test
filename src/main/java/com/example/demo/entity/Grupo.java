package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Grupo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String  nome;

    @Column(nullable = false)
    private String  descricao;

    @Column(nullable = false)
    private Boolean pautado;

    @Column(nullable = false)
    private Boolean ativo;

    @Column(nullable = false)
    private String  categoriaPadrao;



    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Boolean getPautado() {
        return pautado;
    }

    public void setDescricao(Boolean pautado) {
        this.pautado = pautado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }



}
