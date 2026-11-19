package terreno;

public class PosicaoInvalidaException extends RuntimeException {
    public PosicaoInvalidaException(int lin, int col) {
        super("Posição inválida: (" + lin + ", " + col + ")");
    }
}