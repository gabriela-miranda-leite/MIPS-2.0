package mipsmontador;

public class IdentificadorDeFuncao extends TratarLabel {

    private final String r[] = {"add", "sub", "sll", "srl", "and", "or", "xor", "slt", "mul", "div", "jr"};
    private final String i[] = {"addi", "lui", "andi", "ori", "xori", "slti", "beq", "bne", "lw", "sw"};
    private final String j[] = {"j", "jal"};
    TipoR tipoR = new TipoR();
    TipoJ tipoJ = new TipoJ();
    TipoI tipoI = new TipoI();

    public void identificador(String[] vetorInstrucoesTratado) {
        String funcao;
        
        for (int linha = 0; linha < vetorInstrucoesTratado.length; linha++) {
            funcao = vetorInstrucoesTratado[linha].substring(0,  vetorInstrucoesTratado[linha].indexOf(" "));
            for (String cont : r) {
                if (cont.equals(funcao)) {
                    vetorInstrucoesTratado[linha] = tipoR.identificadorR(vetorInstrucoesTratado[linha]);
                }
            }
            for (String cont : i) {
                if (cont.equals(funcao)) {
                     vetorInstrucoesTratado[linha] = tipoI.identificadorI( vetorInstrucoesTratado[linha], label, posicao, linha + 1);
                }
            }
            for (String cont : j) {
                if (cont.equals(funcao)) {
                    vetorInstrucoesTratado[linha] = tipoJ.identificadorJ( vetorInstrucoesTratado[linha], label, posicao, linha + 1);
                }
            }
        }
    }

}
