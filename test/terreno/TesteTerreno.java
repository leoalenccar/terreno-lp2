package terreno;

import terreno.PosicaoInvalidaException;
import terreno.Terreno;

public class TesteTerreno {
    public static void main(String[] args) {
        // testa set e get
        Terreno t1 = new Terreno(5);
        t1.setAltitude(1, 3, 70);
        assert t1.getAltitude(1, 3) == 70 : "get deve devolver o valor do set";

        // testa se acessa os indices das extremidadess corretamente
        Terreno t2 = new Terreno(5);
        t2.setAltitude(0, 0, 1);
        t2.setAltitude(4, 4, 2);
        assert t2.getAltitude(0, 0) == 1 : "Canto (0, 0) falhou";
        assert t2.getAltitude(4, 4) == 2 : "Canto (4, 4) falhou";

        // testa acessar posição invalida
        Terreno t3 = new Terreno(5);
        boolean lancou = false;
        try {
            t3.getAltitude(0, 5);
        } catch(PosicaoInvalidaException e) {
            lancou = true;
        }
        assert lancou : "posição (5, 0) deveria lançar exceção";

        // testa criar terreno com tamanho invalido
        boolean lancouTamanho = false;
        try {
            new Terreno(0);
        } catch(IllegalArgumentException e) {
            lancouTamanho = true;
        }
        assert lancouTamanho : "tamanho 0 deveria lançar exceção";
    }
}