/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.engsoft.videolocadorafacade.client;

import br.ufsc.engsoft.videolocadorafacade.facade.VideoLocadoraFacade;
import br.ufsc.engsoft.videolocadorafacade.model.Aluguel;
import br.ufsc.engsoft.videolocadorafacade.model.Categoria;
import br.ufsc.engsoft.videolocadorafacade.model.Cliente;
import br.ufsc.engsoft.videolocadorafacade.model.Filme;
import br.ufsc.engsoft.videolocadorafacade.type.Genero;
import java.math.BigDecimal;

/**
 * Classe <b>VideoLocadoraClient</b>
 * 
 * Essa Classe representa um client do subsistema no padrão de projeto Façade.
 * 
 * @author Felipe Di Bernardi S Thiago
 */
public class VideoLocadoraClient {

    public static void main(String args[]) {
        
        Cliente cliente = new Cliente("Felipe");
        cliente.creditarCliente(BigDecimal.TEN);
        
        Categoria classico = new Categoria("Clássico", 3, BigDecimal.valueOf(4d), 0.5);
        
        Filme filme = new Filme("Lord of the Rings - Fellowship of the Ring", 3, classico, Genero.EPICO);
        
        VideoLocadoraFacade facade = VideoLocadoraFacade.getInstance();
        
        Aluguel aluguel = facade.alugar(filme, cliente);
        
        facade.devolver(aluguel);
    }
    
}
