/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.engsoft.videolocadorafacade.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe <b>Aluguel</b>
 * 
 * Essa Classe associa um Cliente a um Filme, quebrando o relacionamento Muitos para Muitos entre as duas classes.
 * 
 * @author Felipe Di Bernardi S Thiago
 */
public class Aluguel {

    private Filme filme;
    
    private Cliente cliente;
    
    private Date dataAluguel;
    
    private Date dataDevolucaoLimite;
    
    private Date dataDevolucaoReal;

    /**
     * Construtor com parâmetros necessário para inicialização de uma instância.
     * @param filme Filme a ser locado.
     * @param cliente Cliente que irá locar o Filme.
     * @param dataAluguel Data que o Filme é locado.
     */
    public Aluguel(Filme filme, Cliente cliente, Date dataAluguel) {
        this.filme = filme;
        this.cliente = cliente;
        this.dataAluguel = dataAluguel;
        this.dataDevolucaoLimite = this.calcularDataDevolucao();
        this.dataDevolucaoReal = null;
    }
    
    /**
     * Calcula o dia de devolução do Filme a ser locado..
     * @return Data de devolução limite
     */
    public final Date calcularDataDevolucao() {
        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.setTime(dataAluguel);
        dataDevolucao.add(Calendar.DATE, filme.getCategoria().getQuantidadeDias());
        return dataDevolucao.getTime();
    }
    
    /**
     * Verifica se a locação foi devolvida dentro da data limite.
     * @return Booleano que indica se houve ou não atraso na devolução da locação.
     */
    public boolean verificarDataDevolucaoNoPrazo() {
        return this.dataDevolucaoReal.before(dataDevolucaoLimite) || dataDevolucaoReal.equals(dataDevolucaoLimite);
    }
    
    /**
     * Calcula os juros de devolução.
     * @return Valor dos juros.
     */
    public BigDecimal calcularJuros() {
        Calendar dataLimite = Calendar.getInstance();
        Calendar dataReal = Calendar.getInstance();
        
        dataLimite.setTime(dataDevolucaoLimite);
        dataReal.setTime(dataDevolucaoReal);
        
        if (dataReal.get(Calendar.YEAR) == dataLimite.get(Calendar.YEAR)) {
            return BigDecimal.valueOf(filme.getCategoria().getJuros() * (dataReal.get(Calendar.DAY_OF_YEAR) 
                - dataLimite.get(Calendar.DAY_OF_YEAR)));
        } else {
            return BigDecimal.valueOf(filme.getCategoria().getJuros() * (dataReal.get(Calendar.DAY_OF_YEAR) 
                    + dataReal.getActualMaximum(Calendar.DAY_OF_YEAR) - dataLimite.get(Calendar.DAY_OF_YEAR)));
        }
        
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Date getDataDevolucaoLimite() {
        return dataDevolucaoLimite;
    }

    public void setDataDevolucaoLimite(Date dataDevolucaoLimite) {
        this.dataDevolucaoLimite = dataDevolucaoLimite;
    }

    public Date getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(Date dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }
    
}
