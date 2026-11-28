package terreno;

public class Terreno {
    private int altitudes[][];
    private int linhas;
    private int colunas;

    private void validar(int lin, int col) {
        if (lin < 0 || lin >= linhas || col < 0 || col >= colunas) {
            throw new PosicaoInvalidaException(lin, col);
        }
    }

    public Terreno(int linhas, int colunas) {
        if(linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("Linhas e colunas devem ser positivas");
        }

        this.linhas = linhas;
        this.colunas = colunas;
        this.altitudes = new int[linhas][colunas];
    }
    
    public int getAltitude(int lin, int col) {
        validar(lin, col);
        return altitudes[lin][col];
    }

    public void setAltitude(int lin, int col, int alt) {
        validar(lin, col);
        altitudes[lin][col] = alt;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
}
