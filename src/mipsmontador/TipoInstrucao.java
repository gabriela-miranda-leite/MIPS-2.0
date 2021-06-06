package mipsmontador;

public class TipoInstrucao extends Estrutura {

    protected String decimalParaBinario(String decimal, String tipoInstrucao) {
        int num = Integer.parseInt(decimal);
        String bin;
        bin = Integer.toBinaryString(num);
        switch (tipoInstrucao) {
            case "sh":
            {
                String tam = "00000";
                if (bin.length() < 5) {
                    int calc = 5 - bin.length();
                    tam = tam.substring(5 - calc);
                    tam = tam.concat(bin);
                    return tam;
                } else {
                    bin = bin.substring(bin.length() - 5);
                    return bin;
                }
            }
            case "imm":
            {
                String tam = "0000000000000000";
                if (bin.length() < 16) {
                    int calc = 16 - bin.length();
                    tam = tam.substring(16 - calc);
                    tam = tam.concat(bin);
                    return tam;
                } else {
                    bin = bin.substring(bin.length() - 16);
                    return bin;
                }
            }
            case "addr":
            {
                String tam = "00000000000000000000000000";
                if (bin.length() < 26) {
                    int calc = 26 - bin.length();
                    tam = tam.substring(26 - calc);
                    tam = tam.concat(bin);
                    return tam;
                } else {
                    bin = bin.substring(bin.length() - 26);
                    return bin;
                }
            }
            default:
                break;
        }
        return "nada";
    }

    protected String registrador(String line) { // Substitui os registradores por número binário
        line = line.replaceAll("zero", "00000");

        line = line.replaceAll("at", "00001");
        line = line.replaceAll("v0", "00010");
        line = line.replaceAll("v1", "00011");

        line = line.replaceAll("ra", "11111");

        line = line.replaceAll("a0", "00100");
        line = line.replaceAll("a1", "00101");
        line = line.replaceAll("a2", "00110");
        line = line.replaceAll("a3", "00111");

        line = line.replaceAll("t0", "01000");
        line = line.replaceAll("t1", "01001");
        line = line.replaceAll("t2", "01010");
        line = line.replaceAll("t3", "01011");
        line = line.replaceAll("t4", "01100");
        line = line.replaceAll("t5", "01101");
        line = line.replaceAll("t6", "01110");
        line = line.replaceAll("t7", "01111");

        line = line.replaceAll("s0", "10000");
        line = line.replaceAll("s1", "10001");
        line = line.replaceAll("s2", "10010");
        line = line.replaceAll("s3", "10011");
        line = line.replaceAll("s4", "10100");
        line = line.replaceAll("s5", "10101");
        line = line.replaceAll("s6", "10110");
        line = line.replaceAll("s7", "10111");

        line = line.replaceAll("t8", "11000");
        line = line.replaceAll("t9", "11001");

        line = line.replaceAll("k0", "11010");
        line = line.replaceAll("k1", "11011");

        line = line.replaceAll("gp", "11100");

        line = line.replaceAll("sp", "11101");
        return line;

    }

    protected String BinarioParaHexadecimal(String line) {
        String hexa1, hexa2, hexa3, hexa4;
        String acresZero = "0";
        hexa1 = line.substring(0, 8);
        hexa2 = line.substring(8, 16);
        hexa3 = line.substring(16, 24);
        hexa4 = line.substring(24, 32);
        hexa1 = Integer.toString(Integer.parseInt(hexa1, 2), 16);
        hexa2 = Integer.toString(Integer.parseInt(hexa2, 2), 16);
        hexa3 = Integer.toString(Integer.parseInt(hexa3, 2), 16);
        hexa4 = Integer.toString(Integer.parseInt(hexa4, 2), 16);
        if (hexa1.length() == 1) {
            acresZero = "0";
            acresZero = acresZero.concat(hexa1);
            hexa1 = acresZero;
        }
        if (hexa2.length() == 1) {
            acresZero = "0";
            acresZero = acresZero.concat(hexa2);
            hexa2 = acresZero;
        }
        if (hexa3.length() == 1) {
            acresZero = "0";
            acresZero = acresZero.concat(hexa3);
            hexa3 = acresZero;
        }
        if (hexa4.length() == 1) {
            acresZero = "0";
            acresZero = acresZero.concat(hexa4);
            hexa4 = acresZero;
        }
        hexa1 = hexa1.concat(hexa2);
        hexa1 = hexa1.concat(hexa3);
        hexa1 = hexa1.concat(hexa4);

        return hexa1;
    }
}
