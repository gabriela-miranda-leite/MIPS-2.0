package mipsmontador;

public class MipsMontador {
    public static void main(String[] args) {
        
        Arquivo arquivoEntrada = new Arquivo();
        TratarComentarios tratarComentarios = new TratarComentarios();
        arquivoEntrada.open("assembly.txt", "memoria.txt");
        String[] arquivoTratar = tratarComentarios.lerArquivo(arquivoEntrada.colocarArquivoEmUmaVariavel);
        TratarLabel tratarLabel = new TratarLabel();
        String[] arquivoIdentificador = tratarLabel.identificarLabel(arquivoTratar);
        IdentificadorDeFuncao identificadorDeFuncao = new IdentificadorDeFuncao();
        identificadorDeFuncao.identificador(arquivoIdentificador);
        ArquivoSaida arquivoSaida = new ArquivoSaida();
        arquivoSaida.hexaFormato();
        arquivoSaida.hexaCodigo(arquivoIdentificador);
        arquivoSaida.saidaFinal();
        /*for(String i : arquivoIdentificador){
            System.out.println(i);
        }*/
        for(int cont = 0; cont < arquivoSaida.codFinal.size(); cont++){
            arquivoEntrada.saida.println(arquivoSaida.codFinal.get(cont));
        }
        arquivoEntrada.saida.print("END;");
       
        arquivoEntrada.saida.flush();
        arquivoEntrada.close();
    }
    
}
