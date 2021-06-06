package mipsmontador;

import java.util.ArrayList;

public class TipoR extends TipoInstrucao {

    private final ArrayList<Estrutura> funcaoR = new ArrayList<>();
    protected String opcode, shamt, imm, rs, rd, rt, funct, offset, addr;

    public String identificadorR(String instrucao) {
        opcode = "000000";
        String linha[];
        tipoFuncao = instrucao.substring(0, instrucao.indexOf(" "));
        funcaoR.add(new Estrutura("add", "100000"));
        funcaoR.add(new Estrutura("sub", "100010"));
        funcaoR.add(new Estrutura("sll", "000000"));
        funcaoR.add(new Estrutura("srl", "000010"));
        funcaoR.add(new Estrutura("and", "100100"));
        funcaoR.add(new Estrutura("or", "010101"));
        funcaoR.add(new Estrutura("xor", "100110"));
        funcaoR.add(new Estrutura("slt", "101010"));
        funcaoR.add(new Estrutura("mul", "011000"));
        funcaoR.add(new Estrutura("div", "011010"));
        funcaoR.add(new Estrutura("jr", "001000"));

        for (Estrutura cont : funcaoR) {
            if (tipoFuncao.equals(cont.tipoFuncao)) {
                funct = cont.binFuncao;
            }
        }
        instrucao = instrucao.replaceAll(" ", "");
        if (!(tipoFuncao.equals("sll")) && !(tipoFuncao.equals("srl")) && !(tipoFuncao.equals("jr"))) {
            instrucao = instrucao.replaceAll(",", "");
            linha = instrucao.split("\\$");
            rd = linha[1];
            rs = linha[2];
            rt = linha[3];
            shamt = "00000";
        } else if (!(tipoFuncao.equals("jr"))) {
            instrucao = instrucao.substring(instrucao.indexOf("$"));
            instrucao = instrucao.replaceAll("\\$", "");
            linha = instrucao.split(",");
            rd = linha[0];
            rs = linha[1];
            shamt = linha[2];
            shamt = this.decimalParaBinario(shamt, "sh");
        } else {
            rs = instrucao.substring(instrucao.indexOf("$") + 1);
            rt = "00000";
            rd = "00000";
            shamt = "00000";
        }
        
        opcode = opcode.concat(rs);
        opcode = opcode.concat(rt);
        opcode = opcode.concat(rd);
        opcode = opcode.concat(shamt);
        opcode = opcode.concat(funct);
        opcode = this.registrador(opcode);
        opcode = this.BinarioParaHexadecimal(opcode);
        return opcode;
    }

}
