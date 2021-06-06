package mipsmontador;

import java.util.ArrayList;

public class TratarLabel extends TratarComentarios {

    final ArrayList<String> label = new ArrayList<>();
    final ArrayList<String> arrayInstrucoesTratado = new ArrayList<>();
    final ArrayList<Integer> posicao = new ArrayList<>();

    public String[] identificarLabel(String[] vetorInstrucoesTratado) {
        
        
        
        for (int contadorDeLinhas = 0; contadorDeLinhas < vetorInstrucoesTratado.length; contadorDeLinhas++) {
            if (!vetorInstrucoesTratado[contadorDeLinhas].substring(vetorInstrucoesTratado[contadorDeLinhas].indexOf(":") + 1).trim().isEmpty()) {
                
             
                arrayInstrucoesTratado.add(vetorInstrucoesTratado[contadorDeLinhas].substring(vetorInstrucoesTratado[contadorDeLinhas].indexOf(":") + 1).replaceAll("^\\s+", ""));

            }

        }
        vetorInstrucoesTratado = null;
        vetorInstrucoesTratado = arrayInstrucoesTratado.toArray(new String[arrayInstrucoesTratado.size()]);
        
        return vetorInstrucoesTratado;
    }

}
