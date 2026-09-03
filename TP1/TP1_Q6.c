#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

// Verifica se a linha contém um anagrama (ignora case e espaços)
void verificarAnagramaNaLinha(char *linha) {
    int freq[256] = {0};
    int i = 0;
    int modoSubtracao = 0; 

    while (linha[i] != '\0' && linha[i] != '\n') {
        // Define a troca: ao encontrar o primeiro espaço ou hífen, 
        // passamos a subtrair as letras da contagem.
        if (linha[i] == '-' || (linha[i] == ' ' && modoSubtracao == 0)) {
            modoSubtracao = 1;
        } 
        // Processa apenas letras
        else if (isalpha((unsigned char)linha[i])) {
            // Converte para minúsculo para ignorar a diferença de case
            char c = (char)tolower((unsigned char)linha[i]);

            if (modoSubtracao == 0) {
                freq[(unsigned char)c]++;
            } else {
                freq[(unsigned char)c]--;
            }
        }
        i++;
    }

    // Se todas as letras da primeira palavra foram "anuladas" pela segunda, é um anagrama
    for (int k = 0; k < 256; k++) {
        if (freq[k] != 0) {
            puts("NAO");
            return;
        }
    }
    puts("SIM");
}

int main() {
    char buffer[256];

    while (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        // Ignora linhas que são apenas números isolados (como o contador de casos)
        // ou linhas em branco
        if (isdigit(buffer[0]) && (buffer[1] == '\n' || buffer[1] == '\0')) {
            continue;
        }

        if (buffer[0] != '\n') {
            verificarAnagramaNaLinha(buffer);
        }
    }

    return 0;
}