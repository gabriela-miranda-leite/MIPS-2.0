package mipsmontador;

public class TratarComentarios extends Arquivo {
    
    public String[] lerArquivo(String line){
        if(line.indexOf(":\n")>0){
            line = line.replaceAll(":\n", ":");
        }
        if(line.indexOf("\n\n")>0){
            line = line.replaceAll("\n\n", "\n");
        }
        line = line.replaceAll("  ", ""); // Tira os Tabs
        
        String vetorInstrucoes[];
        vetorInstrucoes  = line.split("\n");
        
        // Tratar comentários
        for(int contadorDeLinhas = 0; contadorDeLinhas < vetorInstrucoes.length; contadorDeLinhas++){
            if(vetorInstrucoes[contadorDeLinhas].startsWith("#")){
                vetorInstrucoes[contadorDeLinhas] = vetorInstrucoes[contadorDeLinhas].replaceAll(vetorInstrucoes[contadorDeLinhas], "" );
            }
            if(vetorInstrucoes[contadorDeLinhas].lastIndexOf("#") > 0){
                vetorInstrucoes[contadorDeLinhas] = vetorInstrucoes[contadorDeLinhas].substring(0, vetorInstrucoes[contadorDeLinhas].lastIndexOf("#"));
            }else if(vetorInstrucoes[contadorDeLinhas].indexOf("#")> 0){
                vetorInstrucoes[contadorDeLinhas] = vetorInstrucoes[contadorDeLinhas].replaceAll(vetorInstrucoes[contadorDeLinhas], "" );
            }
        }
       
       
        int LinhasVazias = 0;
        for (String i : vetorInstrucoes) {
            if (i.length() == 0) {
                LinhasVazias++;
            }
        }
        
        String vetorInstrucoesTratado[] = new String[vetorInstrucoes.length - LinhasVazias];
        int contadorFinal = 0;
        
        
        for (String linhaArquivo : vetorInstrucoes) {
            if (linhaArquivo.length() != 0) {
                vetorInstrucoesTratado[contadorFinal] = linhaArquivo;
                contadorFinal++;
            }
        
        }  
        return vetorInstrucoesTratado;
    }
}
