package br.com.absn.exception.business;

/**
 * Created by antonio on 23/10/17.
 */
public class SondaNaoEncontrada extends RuntimeException{

    public SondaNaoEncontrada(String mensagem) {
        super(mensagem);
    }
}
