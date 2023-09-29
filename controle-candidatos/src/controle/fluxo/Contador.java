package controle.fluxo;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro:");
        int parametroUm = scanner.nextInt();
        System.out.println("Digite o segundo parâmetro:");
        int parametroDois = scanner.nextInt();
        scanner.close();
        try {
            // chamando o método que contém a lógica de contagem (controle de fluxo)
            contar(parametroUm, parametroDois);

        } catch (ParametrosInvalidosException exception) {
            // imprima a mensagem: O segundo parâmetro deve ser maior que o primeiro
            System.out.println(exception.getMessage());
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // valida (parametroUm é MAIOR que parametroDois) and throw the exception
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException();
        }
        int contagem = parametroDois - parametroUm;
        // execute for para imprimir os números com base na variável de contagem
        for (int i = 0; i < contagem; i++) {
            System.out.println("Imprimindo o número " + (i + 1));
        }
    }
}