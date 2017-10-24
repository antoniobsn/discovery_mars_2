package br.com.absn.exception.business;

/**
 * Created by asampaio on 30/09/17.
 */
public class LimiteExcedidoException extends RuntimeException{

    public LimiteExcedidoException(String mensagem) {
        super(mensagem);
    }
}
