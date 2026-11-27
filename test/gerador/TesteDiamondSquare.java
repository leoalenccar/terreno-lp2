package gerador;
import gerador.DiamondSquare;
import terreno.Terreno;

public class TesteDiamondSquare {
    private static boolean iguais(Terreno a, Terreno b) {
        if(a.getTamanho() != b.getTamanho()) return false;

        for(int lin = 0; lin < a.getTamanho(); lin++) {
            for(int col = 0; col < a.getTamanho(); col++) {
                if(a.getAltitude(lin, col) != b.getAltitude(lin, col)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //mesma seed gera o mesmo mapa
        Terreno t1 = new DiamondSquare(13, 0, 10).gerar(5);
        Terreno t2 = new DiamondSquare(13, 0, 10).gerar(5);
        assert iguais(t1, t2) : "mesmaa seed deveria gerar o mesmo mapa";

        // testa gerar altitudes dentro do intervalor [min, max]
        int min = 10, max = 30, tamanho = 33;
        Terreno t3 = new DiamondSquare(85, min, max).gerar(tamanho);
        for(int lin = 0; lin < tamanho; lin++) {
            for(int col = 0; col < tamanho; col++) {
                int alt = t3.getAltitude(lin, col);
                assert alt >= min && alt <= max : "altitude fora do intervalo [10, 30]: " + alt;
            }
        }

        // testa tamanhos inválidos lançam exceção
        int[] invalidos = {1, 2, 4, 10, 26, 64};
        for (int n : invalidos) {
            boolean lancou = false;
            try {
                new DiamondSquare(1, 0, 20).gerar(n);
            } catch(IllegalArgumentException e) {
                lancou = true;
            }
            assert lancou : "tamanho " + n + " deveria lançar exceção";
        }
    }
}