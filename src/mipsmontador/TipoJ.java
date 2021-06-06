package mipsmontador;

import java.util.ArrayList;

public class TipoJ extends TipoInstrucao {

    protected String opcode, addr;
    protected int labelOff;

    public String identificadorJ(String line, ArrayList label, ArrayList posicao, int contLinha) { // Tratando tipo J
        if (line.startsWith("jal")) {
            opcode = "000011";
        } else {
            opcode = "000010";
        }
        addr = line.substring(line.indexOf(" ") + 1);
        for (int cont = 0; cont < label.size(); cont++) {
            if (label.get(cont).equals(addr)) {
                labelOff = (Integer) posicao.get(cont);
            }
        }
        addr = Integer.toString(labelOff - contLinha);
        addr = this.decimalParaBinario(addr, "addr");
        opcode = opcode.concat(addr);
        opcode = this.registrador(opcode);
        opcode = this.BinarioParaHexadecimal(opcode);
        return opcode;
    }
}
