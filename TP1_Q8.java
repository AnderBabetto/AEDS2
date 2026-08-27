

class TP1_Q8 {

    // Método para verificar o fim da leitura
    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    // Método de validação otimizado para evitar Time Out
    public static boolean validarSenha(String s) {
        int n = s.length();
        if (n < 8) return false;

        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;
        boolean temEspecial = false;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // Classificação rápida por intervalos ASCII
            if (c >= 'A' && c <= 'Z') temMaiuscula = true;
            else if (c >= 'a' && c <= 'z') temMinuscula = true;
            else if (c >= '0' && c <= '9') temNumero = true;
            else if (c > 32 && c < 127) temEspecial = true;

            // Otimização: se já achou tudo, não precisa olhar o resto da String
            if (temMaiuscula && temMinuscula && temNumero && temEspecial) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Leitura inicial
        String linha = MyIO.readLine();

        // Loop de processamento
        while (linha != null && !isFim(linha)) {
            if (validarSenha(linha)) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
            // Lê a próxima linha
            linha = MyIO.readLine();
        }
    }
}