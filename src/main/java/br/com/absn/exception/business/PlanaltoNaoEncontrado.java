package br.com.absn.exception.business;

/**
 * Created by antonio on 23/10/17.
 */
public class PlanaltoNaoEncontrado extends RuntimeException{

    public PlanaltoNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
