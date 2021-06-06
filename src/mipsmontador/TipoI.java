package mipsmontador;

import java.util.ArrayList;

public class TipoI extends TipoInstrucao {

    protected String opcode, shamt, imm, rs, rd, rt, funct, offset, addr;
    ArrayList<Estrutura> opcodeI = new ArrayList<>();
    protected int labelOff;

    public String identificadorI(String line, ArrayList label, ArrayList posicao, int contLinha) {  // Tratando tipo I
        String linha[], funcao;
        Object labelOffset;
        funcao = line.substring(0, line.indexOf(" "));
        opcodeI.add(new Estrutura("addi", "001000"));
        opcodeI.add(new Estrutura("lui", "001111"));
        opcodeI.add(new Estrutura("andi", "001100"));
        opcodeI.add(new Estrutura("ori", "001101"));
        opcodeI.add(new Estrutura("xori", "001110"));
        opcodeI.add(new Estrutura("slti", "001010"));
        opcodeI.add(new Estrutura("beq", "000100"));
        opcodeI.add(new Estrutura("bne", "000101"));
        opcodeI.add(new Estrutura("lw", "100011"));
        opcodeI.add(new Estrutura("sw", "101011"));
        for (Estrutura cont : opcodeI) {
            if (funcao.equals(cont.tipoFuncao)) {
                opcode = cont.binFuncao;
            }
        }
        line = line.replaceAll(" ", "");
        if ((!funcao.equals("lui")) && (!funcao.equals("beq")) && (!funcao.equals("bne")) && (!funcao.equals("sw") && (!funcao.equals("lw")))) {
            line = line.substring(line.indexOf("$"));
            line = line.replaceAll("\\$", "");
            linha = line.split(",");
            rt = linha[0];
            rs = linha[1];
            imm = linha[2];
            imm = this.decimalParaBinario(imm, "imm");
            opcode = opcode.concat(rs);
            opcode = opcode.concat(rt);
            opcode = opcode.concat(imm);
        } else if (funcao.equals("sw") || funcao.equals("lw")) {
            line = line.replaceAll(",", "\\$");
            line = line.replaceAll("\\(", "");
            line = line.replaceAll("\\)", "");
            linha = line.split("\\$");
            rs = linha[1];
            offset = linha[2];
            rt = linha[3];
            offset = this.decimalParaBinario(offset, "imm");
            opcode = opcode.concat(rs);
            opcode = opcode.concat(rt);
            opcode = opcode.concat(offset);
        } else if (funcao.equals("lui")) {
            line = line.replaceAll("\\$", ",");
            linha = line.split(",");
            rs = "00000";
            rt = linha[1];
            imm = linha[2];
            imm = this.decimalParaBinario(imm, "imm");
            opcode = opcode.concat(rs);
            opcode = opcode.concat(rt);
            opcode = opcode.concat(imm);
        } else {
            line = line.substring(line.indexOf("$"));
            line = line.replaceAll("\\$", "");
            linha = line.split(",");
            rs = linha[0];
            rt = linha[1];
            offset = linha[2];
            for (int cont = 0; cont < label.size(); cont++) {
                if (offset.equals(label.get(cont))) {
                    labelOffset = posicao.get(cont);
                    labelOff = (Integer) labelOffset;
                }
            }
            offset = Integer.toString(labelOff - contLinha);
            offset = this.decimalParaBinario(offset, "imm");
            opcode = opcode.concat(rs);
            opcode = opcode.concat(rt);
            opcode = opcode.concat(offset);
        }
        opcode = this.registrador(opcode);
        opcode = this.BinarioParaHexadecimal(opcode);
        return opcode;
    }
}
