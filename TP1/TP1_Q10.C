#include <stdio.h>
#include <stdlib.h>

// Função para verificar apenas as vogais
int apenasVogais(char *s) {
    // Chega no fim da string ou quebra de linha
    if (*s == '\0' || *s == '\n') return 1;

    char c = *s;
    // Se não for vogal, para tudo e retorna falso (0)
    if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
          c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')) {
        return 0;
    }

    // Se estiver certo, verifica o próximo caractere
    return apenasVogais(s + 1);
}

// Função para verificar as consoantes
int apenasConsoantes(char *s) {
    if (*s == '\0' || *s == '\n') return 1;

    char c = *s;
    // Verifica se é letra
    if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
        // Se for uma das vogais, não é apenas consoante
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return 0;
        }
    } else {
        return 0; // Se houver número ou espaço, invalida
    }

    return apenasConsoantes(s + 1);
}

// Função para verificar se é numero inteiro
int isInteiro(char *s) {
    if (*s == '\0' || *s == '\n') return 1;

    if (*s < '0' || *s > '9') return 0;

    return isInteiro(s + 1);
}

// Função para verificar se é numero real
int isReal(char *s, int pontos) {
    if (*s == '\0' || *s == '\n') return pontos <= 1;

    if (*s >= '0' && *s <= '9') {
        return isReal(s + 1, pontos);
    } else if (*s == '.' || *s == ',') {
        return isReal(s + 1, pontos + 1);
    }

    return 0; // Qualquer outro caractere
}
// Função para responder sim ou não
void imprimirResultado(int condicao) {
    if (condicao == 1) {
        fputs("SIM", stdout);
    } else {
        fputs("NAO", stdout);
    }
}

int main() {
    char buffer[500];

    while (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        // Condição de parada: se a string for "FIM"
        if (buffer[0] == 'F' && buffer[1] == 'I' && buffer[2] == 'M') break;

        // Chamada das funções e impressão manual com espaços
        imprimirResultado(apenasVogais(buffer));
        fputs(" ", stdout);

        imprimirResultado(apenasConsoantes(buffer));
        fputs(" ", stdout);

        imprimirResultado(isInteiro(buffer));
        fputs(" ", stdout);

        imprimirResultado(isReal(buffer, 0));
        fputs("\n", stdout);
    }

    return 0;
}