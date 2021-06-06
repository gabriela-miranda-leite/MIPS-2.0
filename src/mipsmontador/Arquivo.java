package mipsmontador;

import java.io.*;

public class Arquivo {
    BufferedReader entrada;
    PrintWriter saida;
    public String colocarArquivoEmUmaVariavel ="";

    public String getColocarArquivoEmUmaVariavel() {
        return colocarArquivoEmUmaVariavel;
    }

    public void setColocarArquivoEmUmaVariavel(String colocarArquivoEmUmaVariavel) {
        this.colocarArquivoEmUmaVariavel = colocarArquivoEmUmaVariavel;
    }
    
    public void open(String arquivoEntrada, String arquivoSaida)
    {
        try
        {
            //abre arquivo, modo leitura
            this.entrada = new BufferedReader(new FileReader(arquivoEntrada));
            this.readLinha();
            //abre arquivo, modo escrita
            this.saida = new PrintWriter(new FileWriter(arquivoSaida, false));
            this.saida.println("WITH 8;");
            this.saida.println("DEPTH = 512;");
            this.saida.println();
            this.saida.println("ADDRESS_RADIX = HEX;");
            this.saida.println("DATA_RADIX = HEX;");
            this.saida.println();
            this.saida.println("CONTENT BEGIN");
           
        }
        catch (IOException e)
        {
            throw new RuntimeException(e.toString());
        }
    }
    
    //fechar arquivo
    protected void close()
    {
       try
       {
            if(this.entrada != null)
        {
            this.entrada.close();
            this.entrada = null;
        }
        
        if(this.saida != null)
        {
            this.saida.close();
            this.saida = null;
        }
       }
       catch(IOException e)
       {
           throw new RuntimeException(e.toString());
       }
    }
    
    //Colocar o arquivo em uma String
    protected void readLinha() throws IOException
    {
        String line = this.entrada.readLine();
        if(line != null)
        {
            colocarArquivoEmUmaVariavel = colocarArquivoEmUmaVariavel.concat(line);
            colocarArquivoEmUmaVariavel = colocarArquivoEmUmaVariavel.concat("\n");
            readLinha();
        }else{
            this.entrada.close();
        }
    }
}