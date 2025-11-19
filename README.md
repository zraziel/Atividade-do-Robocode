Atividade Robocode – POO

Este repositório contém os dois robôs desenvolvidos para a atividade da disciplina de Programação Orientada a Objetos (POO).
O objetivo do trabalho é aplicar conceitos fundamentais de orientação a objetos através da criação de robôs inteligentes no Robocode, utilizando classes, herança, sobrescrita de métodos, eventos e comportamentos autônomos.

Link do Slide: https://www.canva.com/design/DAG49swTLBM/UG1U9b2SNLyvPdsQXqddBw/edit?utm_content=DAG49swTLBM&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton

👥 Integrantes do Grupo

-Rafael Wesley Da Silva Felizardo

-Pedro Henrique Costa Dos Santos

-Maycon Douglas Da Silva

-Márcio Luiz De França Filho

🤖 Robôs Desenvolvidos
1. MacacosSapientes

Robô focado em movimentação constante e mira adaptativa.
Comportamentos principais:

Se movimenta lateralmente ao inimigo.

Ajusta a mira de acordo com a posição atual do oponente.

Mantém distância segura e evita paredes.

Radar sempre atualizado, seguindo o alvo.

2. Aizen

Robô mais avançado com previsão de movimento.
Comportamentos principais:

Trava o radar no inimigo.

Movimento em zig-zag para evitar tiros.

Ajuste de tiro baseado em previsão (leading shot).

Controle de distância para não ser aprisionado.

Resposta imediata quando é atingido.

📂 Estrutura do Repositório
/meusrobos
 ├── MacacosSapientes.java
 ├── MacacosSapientes.class
 ├── Aizen.java
 └── Aizen.class

🧠 Conceitos de POO Utilizados
• Classe

Cada robô é uma classe independente (MacacosSapientes e Aizen), representando um objeto com comportamentos próprios.

• Herança

Ambas as classes herdam de AdvancedRobot, aproveitando métodos e eventos já prontos do Robocode.

• Sobrescrita (Override)

Os métodos como onScannedRobot(), onHitWall() e onHitByBullet() são sobrescritos para definir o comportamento personalizado dos robôs.

• Encapsulamento

A lógica interna dos robôs fica dentro das classes, escondida do restante do sistema.

• Polimorfismo

Cada robô sobrescreve os mesmos métodos, mas com comportamentos totalmente diferentes — movimento orbital, zig-zag, previsão, mira adaptativa, etc.

▶️ Como rodar os robôs

Abra o Robocode.

Coloque a pasta meusrobos dentro da pasta robots do Robocode.

Inicie uma batalha e selecione os robôs MacacosSapientes e Aizen.

📑 Objetivo da Atividade

Criar dois robôs utilizando:

conceitos de programação orientada a objetos;

lógica de movimentação, mira e detecção;

diferentes estratégias de combate;

código limpo e organização em classes.
