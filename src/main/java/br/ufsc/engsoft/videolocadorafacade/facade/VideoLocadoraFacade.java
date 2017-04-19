/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.engsoft.videolocadorafacade.facade;

import br.ufsc.engsoft.videolocadorafacade.model.Aluguel;
import br.ufsc.engsoft.videolocadorafacade.model.Cliente;
import br.ufsc.engsoft.videolocadorafacade.model.Filme;
import br.ufsc.videolocadorafacade.exception.FilmeIndisponivelException;
import br.ufsc.videolocadorafacade.exception.SaldoInsuficienteException;
import java.util.Date;

/**
 * Classe <b>VideoLocadoraFacade</b>
 * 
 * Essa Classe implementa o padrão de projeto Facade, onde a complexidade do sistema é escondida através de chamadas 
 * simples de métodos.
 * 
 * @author Felipe Di Bernardi S Thiago
 */
public class VideoLocadoraFacade {

    /**
     * Método para alugar um Filme.
     * @param filme Filme a ser locado.
     * @param cliente Cliente que deseja locar o Filme.
     * @return Aluguel do Filme.
     * @throws FilmeIndisponivelException Exceção que trata quando o Filme está indisponível.
     * @throws SaldoInsuficienteException Exceção que trata quando o Cliente não possui saldo.
     */
    public Aluguel alugar(final Filme filme, final Cliente cliente) throws FilmeIndisponivelException, 
            SaldoInsuficienteException {
        if (!cliente.isLiberado()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para locação.");
        }
        
        if (!filme.verificarDisponibilidade()) {
            throw new FilmeIndisponivelException("Filme indisponível para locação.");
        }
        
        Aluguel aluguel = new Aluguel(filme, cliente, new Date());
        
        filme.setQuantidadeDisponivel(filme.getQuantidadeDisponivel() - 1);
        
        cliente.getAlugueis().add(aluguel);
        
        return aluguel;
    }
    
    /**
     * Método para devolver um Aluguel.
     * @param aluguel Aluguel a ser devolvido.
     */
    public void devolver(final Aluguel aluguel) {
        aluguel.setDataDevolucaoReal(new Date());
        
        aluguel.getCliente().debitarCliente(aluguel.getFilme().getCategoria().getValor());
        
        if (!aluguel.verificarDataDevolucaoNoPrazo()) {
            aluguel.getCliente().debitarCliente(aluguel.calcularJuros());
        }
        
        aluguel.getFilme().setQuantidadeDisponivel(aluguel.getFilme().getQuantidadeDisponivel() + 1);
    }
}
