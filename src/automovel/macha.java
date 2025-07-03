package automovel;

/**
 * Classe que representa o sistema de marchas do carro.
 * Controla as mudanças de marcha e validações relacionadas à velocidade.
 */
class macha {
    private int machaAtual;  // Marcha atual do carro (0 = neutro, 1-6 = marchas)

    /**
     * Construtor da classe macha.
     * Inicializa o carro em marcha neutro (0).
     */
    public macha() {
        this.machaAtual = 0; // Começa em neutro
    }

    /**
     * Retorna a marcha atual do carro.
     * @return número da marcha atual (0-6)
     */
    public int getMachaAtual() {
        return machaAtual;
    }

    /**
     * Troca a marcha do carro com validações de segurança.
     * @param carro Objeto carro para verificar velocidade
     * @param novaMacha Marcha desejada (0-6)
     */
    public void trocarMacha(carro carro, int novaMacha) {
        if (novaMacha < 0 || novaMacha > 6) {
            System.out.println("Marcha inválida. Deve ser entre 0 (neutro) e 6.");
            return;
        }

        if (Math.abs(novaMacha - machaAtual) > 1) {
            System.out.println("Não é possível pular marchas. Mude uma marcha por vez.");
            return;
        }

        int velocidade = carro.getVelocidade();
        boolean podeTrocar = false;

        // Verifica se a velocidade está adequada para a marcha desejada
        switch (novaMacha) {
            case 0: // Neutro
                podeTrocar = true;
                break;
            case 1:
                podeTrocar = (velocidade >= 0 && velocidade <= 20);
                break;
            case 2:
                podeTrocar = (velocidade >= 20 && velocidade <= 40);
                break;
            case 3:
                podeTrocar = (velocidade >= 40 && velocidade <= 60);
                break;
            case 4:
                podeTrocar = (velocidade >= 60 && velocidade <= 80);
                break;
            case 5:
                podeTrocar = (velocidade >= 80 && velocidade <= 100);
                break;
            case 6:
                podeTrocar = (velocidade >= 100 && velocidade <= 120);
                break;
        }

        if (podeTrocar) {
            machaAtual = novaMacha;
            System.out.println("Marcha alterada para: " + machaAtual);
        } else {
            System.out.println("Não é possível engatar a marcha " + novaMacha +
                    " na velocidade atual de " + velocidade + " km/h.");
        }
    }

    /**
     * Acelera o carro, respeitando os limites da marcha atual.
     * @param carro Objeto carro para controlar a velocidade
     */
    public void acelerar(carro carro) {
        if (machaAtual == 0) {
            System.out.println("Não é possível acelerar em neutro. Engate uma marcha.");
            return;
        }

        int novaVelocidade = carro.getVelocidade() + 1;

        // Verifica limites de velocidade para a marcha atual
        boolean podeAcelerar = false;
        switch (machaAtual) {
            case 1:
                podeAcelerar = (novaVelocidade <= 20);
                break;
            case 2:
                podeAcelerar = (novaVelocidade <= 40);
                break;
            case 3:
                podeAcelerar = (novaVelocidade <= 60);
                break;
            case 4:
                podeAcelerar = (novaVelocidade <= 80);
                break;
            case 5:
                podeAcelerar = (novaVelocidade <= 100);
                break;
            case 6:
                podeAcelerar = (novaVelocidade <= 120);
                break;
        }

        if (podeAcelerar) {
            carro.setVelocidade(novaVelocidade);
            System.out.println("Acelerando. Velocidade atual: " + novaVelocidade + " km/h");
        } else {
            System.out.println("Não é possível acelerar mais nesta marcha. Troque para uma marcha superior.");
        }
    }

    /**
     * Diminui a velocidade do carro, respeitando os limites da marcha atual.
     * @param carro Objeto carro para controlar a velocidade
     */
    public void diminuirVelocidade(carro carro) {
        int novaVelocidade = carro.getVelocidade() - 1;

        if (novaVelocidade < 0) {
            System.out.println("Velocidade já está no mínimo (0 km/h).");
            return;
        }

        // Verifica limites mínimos de velocidade para a marcha atual
        boolean podeReduzir = true;
        switch (machaAtual) {
            case 1:
                podeReduzir = (novaVelocidade >= 0);
                break;
            case 2:
                podeReduzir = (novaVelocidade >= 20 || novaVelocidade == 0);
                break;
            case 3:
                podeReduzir = (novaVelocidade >= 40 || novaVelocidade == 0);
                break;
            case 4:
                podeReduzir = (novaVelocidade >= 60 || novaVelocidade == 0);
                break;
            case 5:
                podeReduzir = (novaVelocidade >= 80 || novaVelocidade == 0);
                break;
            case 6:
                podeReduzir = (novaVelocidade >= 100 || novaVelocidade == 0);
                break;
        }

        if (podeReduzir) {
            carro.setVelocidade(novaVelocidade);
            System.out.println("Reduzindo velocidade. Velocidade atual: " + novaVelocidade + " km/h");
        } else {
            System.out.println("Não é possível reduzir mais nesta marcha. Troque para uma marcha inferior.");
        }
    }
}