#include <stdio.h>
#include <stdlib.h>

void inverterIterativo(char *str) {
    if (str == NULL) return;

    int fim = 0;
    // Encontra o final da string manualmente (strlen manual)
    while (str[fim] != '\0') {
        fim++;
    }

    // Ajuste para ignorar o caractere de nova linha '\n' do fgets
    if (fim > 0 && str[fim - 1] == '\n') {
        str[fim - 1] = '\0';
        fim--;
    }

    int inicio = 0;
    fim = fim - 1; // Aponta para o último caractere válido
    char temp;

    // Troca os caracteres das extremidades até o centro
    while (inicio < fim) {
        temp = str[inicio];
        str[inicio] = str[fim];
        str[fim] = temp;
        
        inicio++;
        fim--;
    }
}

// Lê um inteiro da entrada padrão. Se for vazio ou não-número, retorna 0.

int lerInteiroSeguro() {
    char buffer[128];
    if (fgets(buffer, sizeof(buffer), stdin) == NULL) {
        return 0;
    }

    // atoi retorna 0 se a conversão falhar ou se a string for vazia
    return atoi(buffer);
}

int main() {
    char linha[1000];

    // Lê linhas da entrada padrão até o fim do arquivo (EOF)
    while (fgets(linha, sizeof(linha), stdin) != NULL) {
        inverterIterativo(linha);
        
        // puts escreve a string e adiciona \n automaticamente
        puts(linha);
    }

    return 0;
}