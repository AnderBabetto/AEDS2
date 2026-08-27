class TP1_Q1 {

    //Verifica se a linha lida é o indicador de parada "FIM".
    public static boolean isFim(String s) {
        return (s.length() == 3 && 
                s.charAt(0) == 'F' && 
                s.charAt(1) == 'I' && 
                s.charAt(2) == 'M');
    }

    //Método iterativo que aplica o deslocamento de 3 posições na tabela ASCII.
    public static String cifrar(String s) {
        int tamanho = s.length();
        char[] arrayCifrado = new char[tamanho];
        for (int i = 0; i < tamanho; i++) {
            // Soma 3 ao seu valor ASCII e guardamos no array
            arrayCifrado[i] = (char) (s.charAt(i) + 3);
        }

        return new String(arrayCifrado);
    }

    public static void main(String[] args) {
        // Lê a primeira linha usando a classe MyIO
        String linha = MyIO.readLine();

        // O loop continua enquanto a string não for "FIM"
        while (isFim(linha) == false) {
            
            // Aplica a lógica de ciframento
            String resultado = cifrar(linha);
            
            // Imprime o resultado na saída padrão via MyIO
            MyIO.println(resultado);
            
            // Lê a próxima linha para a próxima iteração
            linha = MyIO.readLine();
        }
    }
}