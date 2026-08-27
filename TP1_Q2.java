
import java.util.Random;

class TP1_Q2 {
    
    // Gera a letra aleatoria
    public static Random gerador = new Random();

    // Verifica se a string é o indicador de parada "FIM"
    public static boolean isFim(String s) {
        return (s.length() == 3 && 
                s.charAt(0) == 'F' && 
                s.charAt(1) == 'I' && 
                s.charAt(2) == 'M');
    }

    //Sorteia duas letras e substitui a primeira pela segunda na string.
    public static String realizarAlteracao(String s) {
        // Sorteia a primeira letra (a que será substituída)
        char letraAntiga = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        // Sorteia a segunda letra (a que entrará no lugar)
        char letraNova = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

        int tamanho = s.length();
        char[] resultadoArray = new char[tamanho];

        for (int i = 0; i < tamanho; i++) {
            char caractereAtual = s.charAt(i);
            
            // Se encontrar a letra antiga, coloca a nova no array
            if (caractereAtual == letraAntiga) {
                resultadoArray[i] = letraNova;
            } else {
                resultadoArray[i] = caractereAtual;
            }
        }

        return new String(resultadoArray);
    }

    public static void main(String[] args) {
        // Configura a semente fixa como solicitado pelo enunciado
        gerador.setSeed(4);

        String linha = MyIO.readLine();

        while (!isFim(linha)) {
            // Executa a troca e imprime o resultado
            MyIO.println(realizarAlteracao(linha));

            linha = MyIO.readLine();
        }
    }
}