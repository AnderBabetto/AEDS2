#include <stdio.h>
#include <stdlib.h>

void cifrarRecursivo(char *str) {
    // Se chegar no fim da string ('\0'), para a recursão.
    if (*str == '\0') {
        return;
    }

    // Se o caractere for uma quebra de linha (\n), apenas o remove para não cifrar o "Enter"
    if (*str == '\n') {
        *str = '\0';
        return; 
    }

    // Altera o caractere atual somando 3 
    *str = *str + 3;

    // Chama a função novamente, mas passando o PRÓXIMO caractere (str + 1).
    cifrarRecursivo(str + 1);
}

int main() {
    char buffer[1000];

    // Lendo a entrada padrão linha por linha até o fim do arquivo (EOF)
    while (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        
        // Inicia a recursão passando o começo do buffer
        cifrarRecursivo(buffer);
        
        // Imprime a string já cifrada e pula linha automaticamente
        puts(buffer);
    }

    return 0;
}