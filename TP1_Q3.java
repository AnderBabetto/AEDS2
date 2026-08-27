

class TP1_Q3 {

    // Verifica se a string é o indicador de parada "FIM"
    public static boolean isFim(String s) {
        return (s.length() == 3 && 
                s.charAt(0) == 'F' && 
                s.charAt(1) == 'I' && 
                s.charAt(2) == 'M');
    }

    // X1: Verifica se a string contém apenas vogais
    public static boolean isSomenteVogais(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Se não for uma vogal (maiuscula ou minuscula), retorna falso
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                  c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
                return false;
            }
        }
        return true;
    }

    // X2: Verifica se a string contém apenas consoantes
    public static boolean isSomenteConsoantes(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Primeiro, checa se é uma letra
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                // Se for uma vogal, então não é "somente consoantes"
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    return false;
                }
            } else {
                // Se houver número ou símbolo, também retorna falso
                return false;
            }
        }
        return true;
    }

    // X3: Verifica se a string é um número inteiro
    public static boolean isInteiro(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Se encontrar qualquer coisa que não seja dígito de 0-9, é falso
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // X4: Verifica se a string é um número real
    public static boolean isReal(String s) {
        int contadoresPontuacao = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
            } else if (c == '.' || c == ',') {
                contadoresPontuacao++;
            } else {
                return false;
            }
        }
        // É real se tiver apenas dígitos OU apenas um ponto/vírgula separador
        return (contadoresPontuacao <= 1);
    }

    public static void main(String[] args) {
        String linha = MyIO.readLine();

        while (!isFim(linha)) {
            // Testa cada condição e monta a saída SIM/NAO
            String x1 = isSomenteVogais(linha) ? "SIM" : "NAO";
            String x2 = isSomenteConsoantes(linha) ? "SIM" : "NAO";
            String x3 = isInteiro(linha) ? "SIM" : "NAO";
            String x4 = isReal(linha) ? "SIM" : "NAO";

            // Imprime no formato solicitado: X1 X2 X3 X4
            MyIO.println(x1 + " " + x2 + " " + x3 + " " + x4);
            
            linha = MyIO.readLine();
        }
    }
}