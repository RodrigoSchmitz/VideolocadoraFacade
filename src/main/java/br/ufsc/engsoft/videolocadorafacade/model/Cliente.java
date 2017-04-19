/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.engsoft.videolocadorafacade.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe <b>Cliente</b>
 * 
 * Essa Classe representa um Cliente no sistema.
 * 
 * @author Felipe Di Bernardi S Thiago
 */
public class Cliente {

    private String nome;
    
    private BigDecimal credito;
    
    private List<Aluguel> alugueis;

    private boolean liberado;
    
    public Cliente(String nome) {
        this.nome = nome;
        this.credito = BigDecimal.ZERO;
        this.alugueis = new ArrayList<>();
        this.liberado = false;
    }

    /**
     * Adiciona crédito ao Cliente, verificando se, após a adição desse valor, ele está liberado para locar filmes.
     * @param credito Crédito adicionado à conta.
     */
    public void creditarCliente(final BigDecimal credito) {
        this.credito = this.credito.add(credito);
        if (this.credito.compareTo(BigDecimal.ZERO) == 1 && !liberado) {
            liberado = true;
        }
    }
    
    /**
     * Subtrai crédito do Cliente, verificando se, após o débito desse valor, ele ainda está liberado para locar filmes.
     * @param debito 
     */
    public void debitarCliente(final BigDecimal debito) {
        this.credito = this.credito.subtract(debito);
        if (this.credito.compareTo(BigDecimal.ZERO) < 1 && liberado) {
            liberado = false;
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public boolean isLiberado() {
        return liberado;
    }

    public void setLiberado(boolean liberado) {
        this.liberado = liberado;
    }
    
}
