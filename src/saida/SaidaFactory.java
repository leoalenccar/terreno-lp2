package saida;

import enums.SaidaEnum;

public class SaidaFactory {
    public ISaida criar(SaidaEnum tipo){
        return switch (tipo){
            case TEXTO -> new SaidaTexto();
            case IMAGEM -> new SaidaImagem();
        };
    }
}
