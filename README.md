## Informações Gerais
O projeto é um diário simples de treinos de academia, seu objetivo é registrar os dados de cada treino para visibilidade de progressão de cargas e força.

## Funcionalidades
Cadastro de Treinos: Cada treino é identificado por um ID (número natural).

Adição de Exercícios: Inclui exercícios do tipo força a um treino, com registro detalhado de cada série (repetições e peso).

Exibição Detalhada: Visualização completa de todos os treinos ou de um treino específico.

Exclusão de Dados: Permite excluir treinos através do ID.

Persistência de Dados: Salva todos os registros em um arquivo de texto (treinos.txt), garantindo que os dados sejam mantidos entre as execuções.

## Informações sobre classes e suas relações 
Treino:
Representa um treino registrado.  
  - Possui um identificador único (ID) e uma lista de exercícios.  
  - Relação:Utiliza agregação/composição para armazenar os exercícios.

Exercicio (classe abstrata):
  - Define os atributos e métodos comuns a todos os exercícios, como o nome e uma lista de séries.  
  - Relação: Serve de base para herança, sendo que a classe `ExercicioDeForca` herda dela.

ExercicioDeForca: 
  - Implementa a classe abstrata `Exercicio` para exercícios de força.  
  - Especifica a forma como os detalhes do exercício são exibidos.

Serie:
  - Representa uma série de um exercício, armazenando informações como o número de repetições e o peso utilizado.  
  - Relação:Cada objeto do tipo `Exercicio` possui uma coleção de objetos do tipo `Serie` (composição).

TreinoController:
  - Gerencia as operações de negócio do sistema, como adição, busca e exclusão de treinos, e também a adição de exercícios a um treino.  
  - Faz a intermediação entre a entrada do usuário e a lógica de manipulação dos dados na camada Model.

Persistencia (Interface):
  - Define os métodos necessários para salvar e carregar os dados (treinos) do sistema.

FilePersistence: 
  - Implementa a interface `Persistencia` utilizando arquivos de texto para a persistência dos dados.  
  - Define um formato de arquivo que permite identificar treinos, exercícios e séries.
TreinoView: 
  - Responsável pela exibição dos dados dos treinos no console.  
  - Possui métodos para exibir a lista completa ou apenas um treino específico.
Main:
  - Contém o método `main` e é o ponto de entrada da aplicação.  
  - Apresenta um menu interativo para que o usuário execute as operações (inclusão, listagem, exclusão de treinos, etc.).

## Como executar o projeto 
### Pré-requisitos

- **Java JDK:**  
  Certifique-se de que o Java Development Kit (JDK) está instalado (versão 8 ou superior é recomendada).

- **Ambiente de Desenvolvimento:**  
  Pode ser utilizado qualquer IDE (como Eclipse, IntelliJ IDEA, VSCode) ou apenas o terminal para compilar e executar.
### Estrutura de Pastas
Organize os arquivos do projeto seguindo a estrutura abaixo:
├── Console │ └── Main.java ├── Controller │ ├── FilePersistence.java │ ├── Persistencia.java │ └── TreinoController.java ├── Model │ ├── Exercicio.java │ ├── ExercicioDeForca.java │ ├── Serie.java │ └── Treino.java └── View └── TreinoView.java

### Compilação e Execução

#### Pela Linha de Comando:
1. Navegue até a pasta raiz do projeto.

2. Compile todas as classes:
   ```bash
   javac Console/Main.java Controller/*.java Model/*.java View/*.java
3. Execute a aplicação: java Console.Main

## Uso do ChatGPT
A inteligência artificial foi utilizada em algumas etapas do desenvolvimento do projeto, principalmente em:
Auxílio em dúvidas sobre o código.
Planejamento e Arquitetura:O projeto foi desenhado com apoio de IA para estruturar corretamente pacotes, classes e relacionamentos.
Formulação da parte de documentação.