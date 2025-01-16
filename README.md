# 🔍 Busca Livros

Bem-vindo ao **Busca Livros**, uma aplicação simples e poderosa para pesquisar e organizar livros utilizando a API do [GutenDex](https://gutendex.com/)! Este projeto foi feito para facilitar sua vida como leitor ou desenvolvedor apaixonado por livros.

---

## ✨ Funcionalidades
- **Buscar livros por título:** Encontre informações detalhadas sobre livros com apenas uma palavra-chave.
- **Listar todos os livros:** Veja todos os livros armazenados no banco de dados.
- **Filtrar por idioma:** Pesquise livros em diferentes idiomas.
- **Listar autores:** Descubra todos os autores únicos cadastrados.
- **Filtrar autores por ano de publicação:** Encontre autores com base no ano de seus livros.

---

## 🚀 Como Executar

### Requisitos
- **Java 8+**
- **Maven 3.6+**
- **Banco de Dados MySQL**

### Passos
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/busca-livros.git
   cd busca-livros
   ```
2. **Configure o banco de dados:**
    - Certifique-se de que seu MySQL esteja em execução.
    - Crie um banco de dados chamado `busca_livros`.
    - Atualize as credenciais no arquivo `application.properties`:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/busca_livros
      spring.datasource.username=seu_usuario
      spring.datasource.password=sua_senha
      ```
3. **Construa o projeto:**
   ```bash
   mvn clean install
   ```
4. **Execute o JAR:**
   ```bash
   java -jar target/busca-livros-1.0.0.jar
   ```
5. **Acesse a aplicação:**
    - A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## 💡 Exemplos de Uso
### Buscar livro por título
```bash
GET http://localhost:8080/livros/titulo?nome=Orgulho e Preconceito
```
### Listar todos os livros
```bash
GET http://localhost:8080/livros
```
### Filtrar livros por idioma
```bash
GET http://localhost:8080/livros/idioma?idioma=en
```
### Listar autores
```bash
GET http://localhost:8080/autores
```

---

## 🎨 Contribuição
Amamos contribuidores! Siga estas etapas para ajudar:
1. Faça um fork do projeto.
2. Crie uma branch para sua funcionalidade ou correção: `git checkout -b minha-feature`.
3. Envie suas alterações: `git push origin minha-feature`.
4. Abra um Pull Request!

---

## 🌍 Licença
Este projeto está licenciado sob a [MIT License](LICENSE).

---

**Aproveite sua jornada literária com o Busca Livros!** ❤️

