package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) throws Exception {
        // Main Method
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };

        /*
         * Calling the resolution method of item 1:
         * for(String candidato: candidatos) {
         * selecionarCandidato(candidato);
         * }
         */

        // Calling the resolution method for items 2, 3 and 4:
        selecionarCandidatos(candidatos);
    }

    // origin:1800,bound:2200
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Resolution of item 1:
    static void selecionarCandidato(String candidato) {
        double salarioBase = 2000.0;
        double salarioPretendido = valorPretendido();

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O(A) CANDIDATO(A) " + candidato);
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O(A) CANDIDATO(A) " + candidato + ", COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }

    // Resolution of items 2 and 3:
    static void selecionarCandidatos(String[] candidatos) {
        double salarioBase = 2000.0;
        int candidatosSelecionados = 0;

        for (String candidato : candidatos) {
            double salarioPretendido = valorPretendido();
            if (salarioBase >= salarioPretendido && candidatosSelecionados < 5) {
                candidatosSelecionados++;
                // System.out.println("Ligar para o candidato " + candidato);
                entrandoEmContato(candidato);
            }
        }
    }

    // Resolution of item 4:
    static boolean atender() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    static void entrandoEmContato(String candidato) {
        int tentativas = 0;

        while (tentativas <= 3) {
            tentativas++;
            if (atender()) {
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " APÓS " + tentativas + " TENTATIVAS");
                break;
            } else if (tentativas == 3) {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM O(A) CANDIDATO(A) " + candidato);
                break;
            }
        }
    }
}