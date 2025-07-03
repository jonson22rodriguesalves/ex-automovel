# Santander Boot Camp 2025

* 🚗 Automóvel - Simulador de Controle de Carro com Marchas
* Projeto Java para simulação de controle de um carro via terminal com gestão de marchas e velocidade, implementando:
* Fluxo interativo de operações de direção
* Sistema de marchas com limites de velocidade específicos
* Validação de estado do carro (ligado/desligado)
* Controle preciso de incremento/decremento de velocidade
* Arquitetura em camadas com classe especializada para marchas
 
* 🛠️ Tecnologias Utilizadas
* Java 17+
* Scanner para entrada de dados
* Classes especializadas (macha)
* Encapsulamento de propriedades do carro
* Menu interativo com switch-case
* Validações de regras de negócio
 
* 📚 Pré-requisitos
* Java JDK 17 ou superior
* Conhecimento básico de compilação Java
* Terminal/Console para execução
* Maven (opcional)
 
* 🚀 Como Executar
* Compile o programa:
 
* bash
* javac -d bin src/automovel/carro.java src/automovel/macha.java
* Execute o programa:
 
* bash
* java -cp bin automovel.carro
* Siga o fluxo interativo:
 
 
* === MENU DO CARRO ===
* 1. Ligar carro
* 2. Desligar carro
* 3. Acelerar
* 4. Diminuir velocidade
* 5. Virar para esquerda
* 6. Virar para direita
* 7. Verificar velocidade
* 8. Trocar marcha
* 0. Sair
*    Escolha uma opção:
 
* 🎯 Funcionalidades Implementadas
* ✔️ Controle completo do estado do carro (ligado/desligado)
* ✔️ Sistema de 6 marchas com limites de velocidade específicos
* ✔️ Classe macha especializada para controle de câmbio
* ✔️ Menu interativo com 8 operações de direção
* ✔️ Validação de regras de segurança para manobras
* ✔️ Incremento/decremento controlado de velocidade (1km/h)
* ✔️ Impedimento de pulo de marchas
* ✔️ Verificação de condições para desligar o carro
 
* 📝 Exemplo de Uso
 
* === MENU DO CARRO ===
* 1. Ligar carro
* 2. Desligar carro
* 3. Acelerar
* 4. Diminuir velocidade
* 5. Virar para esquerda
* 6. Virar para direita
* 7. Verificar velocidade
* 8. Trocar marcha
* 0. Sair
*    Escolha uma opção: 3
 
* Acelerando. Velocidade atual: 1 km/h
 
* Escolha uma opção: 8
* Informe a nova marcha (0-6): 1
* Marcha alterada para: 1
 
* Escolha uma opção: 5
* Virando para esquerda.
 
* ⚠️ Importante
* O sistema implementa regras de segurança para manobras e troca de marchas
* A velocidade máxima é limitada a 120 km/h
* Só é possível virar com velocidade entre 1-40 km/h
* O carro só pode ser desligado em marcha neutra e velocidade zero
 
* 📊 Diagrama de Classes

classDiagram
    class Carro {
        - ligado: boolean
        - velocidade: float
        - machaAtual: int
        - direcao: string
        + ligar()
        + desligar()
        + acelerar()
        + frear()
        + trocarMarcha()
        + virar()
    }

    class Marcha {
        - machaAtual: int
        + engatarMarcha()
        + reduzirMarcha()
    }

    class Validacoes {
        + verificaVelocidade()
        + verificaMarcha()
    }

    class InteracaoUsuario {
        + solicitarAcao()
        + exibirStatus()
    }

    class Main {
        + main()
    }

    Carro "1" *-- "1" Marcha : Contém
    Main ..> Carro : Usa
    Main ..> InteracaoUsuario : Usa
    Carro ..> Validacoes : Depende
    InteracaoUsuario ..> Carro : Atualiza

* 🔄 Fluxograma Básico

* [Início]
* ↓
* [Carro criado: desligado, neutro, 0km/h]
* ↓
* [Menu de opções]
* ↓
* ├─ Ligar → Verifica condições → Atualiza estado
* ├─ Desligar → Verifica condições → Atualiza estado
* ├─ Acelerar → Verifica marcha/limite → Incrementa velocidade
* ├─ Reduzir → Verifica marcha/limite → Decrementa velocidade
* ├─ Virar → Verifica velocidade → Executa manobra
* ├─ Trocar marcha → Verifica velocidade → Atualiza marcha
* └─ Sair → Encerra programa
 
* 📌 Observações
* Todas as operações exigem que o carro esteja ligado (exceto ligar/desligar)
 
* O sistema não permite trocar mais de uma marcha por vez
 
* As validações de velocidade/marcha seguem padrões de segurança veicular