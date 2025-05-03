# 🧠 Leetcode Fetcher

This is a Java project that consumes LeetCode's [GraphQL API](https://leetcode.com) to fetch detailed information about problems using their **slug** (the short name used in the URL).

The goal is to automatically generate a `.md` (Markdown) file with problem details, making it easier to document and study problems.

---

## 📦 Features

- Connects to LeetCode's GraphQL API.
- Retrieves problem data by **slug**.
- Creates a `.md` file with the problem's title, difficulty, description, and tags.

---

## 🔧 Technologies and Libraries

- Java 21  
- Maven  
- [OkHttp](https://square.github.io/okhttp/) – HTTP requests  
- [Jackson](https://github.com/FasterXML/jackson) – JSON handling  
- [JUnit 5](https://junit.org/junit5/) – Testing  
- Maven Shade Plugin – Generates an executable JAR with all dependencies  

---

## 🛠️ How to Use

### 1. Clone the Repository

```bash
git clone https://github.com/Joao-Severgnini/Leetcode-Fetcher.git
cd Leetcode-Fetcher
```

### 2. Compile and Run

You can use the provided `run.sh` script:

```bash
./run.sh <problem-slug>
```

This script will:

- Clean the project  
- Compile and package everything using Maven  
- Run the final program  

### 3. Run Manually

Or run manually:

```bash
mvn clean package
java -jar target/leetcode-fetcher-1.0-SNAPSHOT-all.jar
```

---

## 🧪 Testing

To run JUnit tests:

```bash
mvn test
```

---

## 📄 Example Usage

When running the program, you need to enter the **problem slug** (for example: `two-sum`):

```bash
./run.sh two-sum
```

The program will create a folder for the problem, another 2 folders (description adn solution) and a file called `Solution.java` where you should write the solition code.

---

## 🗂️ Project Structure

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

## 📬 Contributions

Contributions are welcome! Feel free to open **Issues** or submit **Pull Requests**.

---

## 📜 License

This project is licensed under the MIT License.