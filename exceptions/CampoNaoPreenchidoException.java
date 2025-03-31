package exceptions;

public class CampoNaoPreenchidoException extends Exception {
    public CampoNaoPreenchidoException(String mensagem) {
        super(mensagem);
    }
}