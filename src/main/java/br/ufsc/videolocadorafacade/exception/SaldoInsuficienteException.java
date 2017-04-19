/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufsc.videolocadorafacade.exception;

/**
 * Classe <b>SaldoInsuficienteException</b>
 * 
 * Essa Classe representa a exceção de saldo insuficiente para locar Filme.
 * 
 * @author Felipe Di Bernardi S Thiago
 */
public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String message) {
        super(message);
    }

}
