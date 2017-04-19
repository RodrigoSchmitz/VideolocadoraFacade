/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.engsoft.videolocadorafacade.model;

import java.math.BigDecimal;

/**
 * Classe <b>Categoria</b>
 *
 * Essa Classe representa uma Categoria de Filme a ser colocado a disposição.
 *
 * @author Felipe Di Bernardi S Thiago
 */
public class Categoria {

    private String nome;

    private Integer quantidadeDias;

    private BigDecimal valor;

    private Double juros;
    
    /**
     * Construtor com parâmetros obrigatórios para inicialização da instância.
     * @param nome Nome da Categoria.
     * @param quantidadeDias Quantidade de dias que o filme pode ficar locado.
     * @param valor Valor da locação.
     * @param juros Juros da Categoria.
     */
    public Categoria(String nome, Integer quantidadeDias, BigDecimal valor, Double juros) {
        this.nome = nome;
        this.quantidadeDias = quantidadeDias;
        this.valor = valor;
        this.juros = juros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(Integer quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

}
