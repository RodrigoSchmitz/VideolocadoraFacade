/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.engsoft.videolocadorafacade.model;

import br.ufsc.engsoft.videolocadorafacade.type.Genero;

/**
 * Classe <b>Filme</b>
 * 
 * Essa Classe representa um Filme no sistema.
 * 
 * @author Felipe Di Bernardi S Thiago
 */
public class Filme {

    private String nome;
    
    private Integer quantidadeTotal;
    
    private Integer quantidadeDisponivel;
    
    private Categoria categoria;
    
    private Genero genero;

    /**
     * Construtor com parâmetros obrigatórios para inicialização de uma instância.
     * @param nome Título do Filme.
     * @param quantidadeTotal Quantidade total.
     * @param categoria Categoria do Filme.
     * @param genero Gênero do Filme.
     */
    public Filme(String nome, Integer quantidadeTotal, Categoria categoria, Genero genero) {
        this.nome = nome;
        this.quantidadeTotal = quantidadeTotal;
        this.quantidadeDisponivel = quantidadeTotal;
        this.categoria = categoria;
        this.genero = genero;
    }

    /**
     * Verifica se o Filme está disponível para ser locado.
     * @return Booleano que representa a disponibilidade do Filme.
     */
    public boolean verificarDisponibilidade() {
        return this.quantidadeDisponivel > 0;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
}
