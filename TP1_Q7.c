#include <stdio.h>
#include <stdlib.h>

//Calcula o comprimento da maior substring sem letras repetidas.
int maiorSubstringSemRepeticao(char *s) {
    // Vetor para guardar a última posição onde vimos cada caractere
    // Iniciou com -1 para indicar que a letra nunca apareceu
    int ultimaPosicao[256];
    for (int i = 0; i < 256; i++) ultimaPosicao[i] = -1;

    int maiorComprimento = 0;
    int inicioJanela = 0;
    int i = 0;

    // Percorre a string até o fim ou quebra de linha
    while (s[i] != '\0' && s[i] != '\n') {
        unsigned char caractereAtual = (unsigned char)s[i];

        // Se já vimos essa letra e ela está dentro da nossa janela atual...
        if (ultimaPosicao[caractereAtual] >= inicioJanela) {
            // Pulamos o início da janela para logo após a posição antiga da letra
            inicioJanela = ultimaPosicao[caractereAtual] + 1;
        }

        // Atualiza onde vimos essa letra pela última vez
        ultimaPosicao[caractereAtual] = i;

        // Calcula o tamanho atual da janela e vê se é o recorde
        int tamanhoAtual = i - inicioJanela + 1;
        if (tamanhoAtual > maiorComprimento) {
            maiorComprimento = tamanhoAtual;
        }

        i++;
    }

    return maiorComprimento;
}

// imprime um número inteiro usando apenas putchar.
void imprimirNumero(int n) {
    if (n == 0) {
        putchar('0');
        return;
    }
    char res[12];
    int i = 0;
    while (n > 0) {
        res[i++] = (n % 10) + '0';
        n /= 10;
    }
    while (--i >= 0) putchar(res[i]);
}

int main() {
    char buffer[1024];

    // Lê cada linha da entrada
    while (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        // Ignora linhas vazias
        if (buffer[0] == '\n') continue;

        int resultado = maiorSubstringSemRepeticao(buffer);
        
        imprimirNumero(resultado);
        putchar('\n');
    }

    return 0;
}