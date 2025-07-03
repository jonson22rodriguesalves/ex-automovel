package automovel;

import java.util.Scanner;

/**
 * Classe que representa um carro com controle de ignição, velocidade, marcha e direção.
 */
public class carro {
    // Atributos da classe
    private boolean ligado;          // Estado de ligado/desligado do carro
    private int velocidade;           // Velocidade atual em km/h
    private macha machaAtual;         // Objeto que representa a marcha atual
    private String direcao;           // Direção atual do carro (Reto, Esquerda, Direita)

    /**
     * Construtor da classe carro.
     * Inicializa o carro desligado, com velocidade zero, marcha neutro e direção reta.
     */
    public carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.machaAtual = new macha();
        this.direcao = "Reto";
    }

    /**
     * Liga o carro se estiver em condições seguras (neutro e velocidade zero).
     */
    public void ligar() {
        if (!ligado && machaAtual.getMachaAtual() == 0 && velocidade == 0) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("Não é possível ligar o carro. Verifique se está em neutro e velocidade zero.");
        }
    }

    /**
     * Desliga o carro se estiver em condições seguras (neutro e velocidade zero).
     */
    public void desligar() {
        if (ligado && machaAtual.getMachaAtual() == 0 && velocidade == 0) {
            ligado = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("Não é possível desligar o carro. Coloque em neutro e reduza a velocidade para zero.");
        }
    }

    /**
     * Acelera o carro, delegando a lógica para a classe macha.
     */
    public void acelerar() {
        if (ligado) {
            machaAtual.acelerar(this);
        } else {
            System.out.println("Carro desligado. Ligue o carro primeiro.");
        }
    }

    /**
     * Diminui a velocidade do carro, delegando a lógica para a classe macha.
     */
    public void diminuirVelocidade() {
        if (ligado) {
            machaAtual.diminuirVelocidade(this);
        } else {
            System.out.println("Carro desligado. Ligue o carro primeiro.");
        }
    }

    /**
     * Vira o carro para esquerda, se a velocidade estiver entre 1 e 40 km/h.
     */
    public void virarEsquerda() {
        if (ligado) {
            if (velocidade == 0) {
                System.out.println("A velocidade deve ser acima de 0 km/h para virar.");
            } else if (velocidade >= 1 && velocidade <= 40) {
                direcao = "Esquerda";
                System.out.println("Virando para esquerda.");
            } else {
                System.out.println("Reduza a velocidade para abaixo de 40 km/h para virar.");
            }
        } else {
            System.out.println("Carro desligado. Ligue o carro primeiro.");
        }
    }

    /**
     * Vira o carro para direita, se a velocidade estiver entre 1 e 40 km/h.
     */
    public void virarDireita() {
        if (ligado) {
            if (velocidade == 0) {
                System.out.println("A velocidade deve ser acima de 0 km/h para virar.");
            } else if (velocidade >= 1 && velocidade <= 40) {
                direcao = "Direita";
                System.out.println("Virando para direita.");
            } else {
                System.out.println("Reduza a velocidade para abaixo de 40 km/h para virar.");
            }
        } else {
            System.out.println("Carro desligado. Ligue o carro primeiro.");
        }
    }

    /**
     * Exibe a velocidade atual do carro.
     */
    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h");
    }

    /**
     * Troca a marcha do carro, delegando a lógica para a classe macha.
     * @param novaMacha A marcha desejada (0-6)
     */
    public void trocarMacha(int novaMacha) {
        if (ligado) {
            machaAtual.trocarMacha(this, novaMacha);
        } else {
            System.out.println("Carro desligado. Ligue o carro primeiro.");
        }
    }

    /**
     * Retorna a velocidade atual do carro.
     * @return velocidade em km/h
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     * Define a velocidade do carro.
     * @param velocidade nova velocidade em km/h
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    /**
     * Método principal que inicia a interface de controle do carro.
     * @param args argumentos da linha de comando (não utilizado)
     */
    public static void main(String[] args) {
        carro meuCarro = new carro();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU DO CARRO ===");
            System.out.println("1. Ligar carro");
            System.out.println("2. Desligar carro");
            System.out.println("3. Acelerar");
            System.out.println("4. Diminuir velocidade");
            System.out.println("5. Virar para esquerda");
            System.out.println("6. Virar para direita");
            System.out.println("7. Verificar velocidade");
            System.out.println("8. Trocar marcha");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    meuCarro.ligar();
                    break;
                case 2:
                    meuCarro.desligar();
                    break;
                case 3:
                    meuCarro.acelerar();
                    break;
                case 4:
                    meuCarro.diminuirVelocidade();
                    break;
                case 5:
                    meuCarro.virarEsquerda();
                    break;
                case 6:
                    meuCarro.virarDireita();
                    break;
                case 7:
                    meuCarro.verificarVelocidade();
                    break;
                case 8:
                    System.out.print("Informe a nova marcha (0-6): ");
                    int novaMacha = scanner.nextInt();
                    meuCarro.trocarMacha(novaMacha);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}