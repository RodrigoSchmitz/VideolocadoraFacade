/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.videolocadorafacade.exception;

/**
 * Classe <b>FilmeIndisponivelException</b>
 * 
 * Essa Classe representa a exceção de Filme indisponível.
 * 
 * @author Felipe Di Bernardi S Thiago
 */
public class FilmeIndisponivelException extends RuntimeException {

    public FilmeIndisponivelException(String message) {
        super(message);
    }

}
