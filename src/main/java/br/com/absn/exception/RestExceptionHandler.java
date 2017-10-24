package br.com.absn.exception;

import br.com.absn.exception.business.LimiteExcedidoException;
import br.com.absn.exception.business.PlanaltoNaoEncontrado;
import br.com.absn.exception.business.SondaNaoEncontrada;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by antonio on 23/10/17.
 */

@ControllerAdvice
public class RestExceptionHandler{

    @ExceptionHandler(LimiteExcedidoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetail limiteExcedidoException(LimiteExcedidoException e) {
        return new ErrorDetail(e.getMessage());
    }

    @ExceptionHandler(PlanaltoNaoEncontrado.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetail planaltoNaoEncontrado(PlanaltoNaoEncontrado e) {
        return new ErrorDetail(e.getMessage());
    }

    @ExceptionHandler(SondaNaoEncontrada.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetail sondaNaoEncontrada(SondaNaoEncontrada e) {
        return new ErrorDetail(e.getMessage());
    }
}
