# 🧠 Leetcode Fetcher

Este é um projeto Java que consome a API GraphQL do [LeetCode](https://leetcode.com) para buscar informações detalhadas sobre problemas, dado o **slug** (nome curto usado na URL).

O objetivo é gerar automaticamente um arquivo `.md` (Markdown) com os detalhes do problema, facilitando a documentação e estudo.

---

## 📦 Funcionalidades

- Conecta à API GraphQL do LeetCode.
- Busca dados de um problema a partir do **slug**.
- Cria um arquivo `.md` com título, dificuldade, descrição, e tags do problema.

---

## 🔧 Tecnologias e Bibliotecas

- Java 21
- Maven
- [OkHttp](https://square.github.io/okhttp/) – Requisições HTTP
- [Jackson](https://github.com/FasterXML/jackson) – Manipulação de JSON
- [JUnit 5](https://junit.org/junit5/) – Testes
- Maven Shade Plugin – Geração de um JAR executável com todas as dependências

---

## 🛠️ Como usar

### 1. Clonar o repositório

```bash
git clone https://github.com/Joao-Severgnini/Leetcode-Fetcher.git
cd Leetcode-Fetcher
```

### 2. Compilar e executar

Você pode usar o script `run.sh` incluído no projeto:

```bash
./run.sh
```

Esse script irá:

- Limpar o projeto
- Compilar e empacotar tudo com Maven
- Executar o programa final

### 3. Executar manualmente

Ou execute manualmente:

```bash
mvn clean package
java -jar target/leetcode-fetcher-1.0-SNAPSHOT-all.jar
```

---

## 🧪 Testes

Para rodar os testes JUnit:

```bash
mvn test
```

---

## 📄 Exemplo de uso

Ao rodar o programa, você será solicitado a inserir o **slug** do problema (por exemplo: `two-sum`):

```
Enter the LeetCode problem slug: two-sum
```

O programa criará um arquivo `two-sum.md` com a descrição completa do problema.

---

## 🗂️ Estrutura do projeto

```
Leetcode-Fetcher/
├── src/
│   ├── main/
│   │   └── java/com/github/Joao_Severgnini/leetcode/
│   │       └── LeetCodeFetcher.java
│   └── test/
│       └── java/com/github/Joao_Severgnini/leetcode/
│           └── LeetCodeFetcherTest.java
├── run.sh
├── pom.xml
└── README.md
```

---

## 📬 Contribuições

Contribuições são bem-vindas! Sinta-se livre para abrir **Issues** ou enviar **Pull Requests**.

---

## 📜 Licença

Este projeto está licenciado sob a licença MIT.
