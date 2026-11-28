package saida;

import terreno.Terreno;

import java.nio.file.Files;
import java.nio.file.Path;

public class SaidaTexto implements ISaida {
    //TODO: A interface deve permitir que o usuário selecione o caminho do arquivo
    static final Path ARQUIVO = Path.of("terreno.txt");

    @Override
    public void exportar(DadosSaida dados) {
        Terreno terreno = dados.getTerreno();
        String texto = serializar(terreno);

        try{
            if (!Files.exists(ARQUIVO)){
                Files.createFile(ARQUIVO);
            }
            Files.writeString(ARQUIVO, texto);
        }catch (Exception e){
            //TODO: tratar exception de erro de arquivo
            System.out.println(e);
        }
    }

    private String serializar(Terreno terreno) {

        int linhas = terreno.getLinhas();
        int colunas = terreno.getColunas();
        String texto = "Tamanho: "+ linhas +" x " + colunas + "\nMatriz:\n\n";
        for (int ii = 0; ii < linhas; ii++) {
            for (int jj = 0; jj < colunas; jj++) {
                texto = texto.concat(Integer.toString(terreno.getAltitude(ii,jj)));
            }
            texto = texto.concat("\n");
        }
        return texto;
    }
}
