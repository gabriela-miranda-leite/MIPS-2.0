package mipsmontador;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;

public class ArquivoSaida extends Arquivo{

    ArrayList<String> codFinal = new ArrayList<>();
    ArrayList<String> hexaCont = new ArrayList<>(); // array de 1 a 511
    ArrayList<String> hexaCod = new ArrayList<>(); // array de separação de hexa

    public void hexaFormato() {
        String hexa;
        String concatenarZero;
        NumberFormat num;
        for (int cont = 1; cont < 512; cont++) {
            hexa = Integer.toBinaryString(cont);
            hexa = Integer.toString(Integer.parseInt(hexa, 2), 16);
            if (hexa.length() == 2) {
                concatenarZero = "0";
                concatenarZero = concatenarZero.concat(hexa);
                hexa = concatenarZero;
            } else {
                if (hexa.length() == 1) {
                    concatenarZero = "00";
                    concatenarZero = concatenarZero.concat(hexa);
                    hexa = concatenarZero;
                }
            }
            hexa = hexa.toUpperCase();
            hexaCont.add(hexa);
        }

    }

    public void hexaCodigo(String[] vetorInstrucoesTratado) {

        for (String line : vetorInstrucoesTratado) {
            String hexa1, hexa2, hexa3, hexa4;
            hexa1 = line.substring(0, 2);
            hexaCod.add(hexa1);
            hexa2 = line.substring(2, 4);
            hexaCod.add(hexa2);
            hexa3 = line.substring(4, 6);
            hexaCod.add(hexa3);
            hexa4 = line.substring(6);
            hexaCod.add(hexa4);
        }
        
    }

    public ArrayList<String> saidaFinal() {
        String linha;

        for (int cont = 0; cont < hexaCod.size(); cont++) {
            linha = "     ";
            linha = linha.concat(hexaCont.get(cont));
            linha = linha.concat("    :");
            linha = linha.concat(hexaCod.get(cont));
            linha = linha.toUpperCase();
            
            codFinal.add(linha); // ArrayList com o código em formato de saída
            
        }
        return codFinal;
    }
}
