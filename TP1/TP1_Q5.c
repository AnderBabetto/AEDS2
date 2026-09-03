#include <stdio.h>

int somaDigitos(int n){
    // Garante que lidamos com números negativos convertendo para positivo
    if (n < 0) n = -n;

    // Caso Base: quando não restam mais dígitos
    if (n == 0) {
        return 0;
    }

    // Passo Recursivo:
    // n % 10 pega o último dígito (ex: 123 % 10 = 3)
    // n / 10 remove o último dígito (ex: 123 / 10 = 12)
    return (n % 10) + somaDigitos(n / 10);
}


// Lê a entrada e garante que se for vazio ou não-número, retorne 0.
int lerEntradaComoInteiro() {
    char buffer[128];
    // Se a leitura falhar ou o usuário apenas der Enter, retorna 0
    if (fgets(buffer, sizeof(buffer), stdin) == NULL || buffer[0] == '\n') {
        return 0;
    }
    
    // atoi retorna 0 para strings não numéricas
    return atoi(buffer);
}

int main() {
    char buffer[128];

    while (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        // Converte a linha lida para inteiro
        int numero = atoi(buffer);
        
        // Calcula a soma recursivamente
        int resultado = somaDigitos(numero);
        
        // Exibe a saida
        printf("%d\n", resultado);
    }

    return 0;
}