# CRUD de Produtos com Firebase Firestore 🛒✨

Este aplicativo Android permite gerenciar um cadastro de produtos, realizando operações CRUD (Criar, Ler, Atualizar e Deletar) usando o banco de dados Firebase Firestore. Cada operação pode ser realizada diretamente da interface, e as informações são exibidas ao usuário por meio de mensagens de confirmação ou erro.

---

## Estrutura do Projeto e Funcionamento das Funcionalidades 🏗️🔧

O projeto contém uma interface de usuário simplificada e uma lógica Java para operações no Firebase Firestore.

---

### Funcionalidades CRUD ⚙️

#### 1. Inicialização do Firebase Firestore
- O aplicativo inicia uma instância do Firestore para gerenciar operações de banco de dados, permitindo a inserção, recuperação, atualização e exclusão de produtos.

#### 2. Componentes Visuais
- A interface apresenta:
  - **Dois campos** (`EditText`) para entrada do código e valor do produto.
  - **Quatro botões** para operações CRUD: `Cadastrar`, `Buscar`, `Alterar` e `Deletar`.

---

### Interface 📱

| Cadastrar                                 | Alterar                                          |
|-------------------------------------------|--------------------------------------------------|
| ![Função Cadastrar](https://github.com/user-attachments/assets/7fceffc2-1bff-4dbd-9026-8bffb50721d8) | ![Alterar](https://github.com/user-attachments/assets/b3d84454-8fd3-4ac1-bd25-389283a5df3e) |

| Buscar                                    | Deletar                                          |
|-------------------------------------------|--------------------------------------------------|
| ![Buscar](https://github.com/user-attachments/assets/4532e2d4-46eb-4103-b7d4-6dc5b170f399)           | ![Deletar](https://github.com/user-attachments/assets/b66fca1c-0900-41ba-b57e-78343f6ba3fb) |


---

### Detalhamento das Funcionalidades CRUD 📋

- **Cadastro de Produto** ✍️: Preencha os campos e clique em "Cadastrar" para criar um novo documento no Firestore. O app valida os dados e confirma a operação com uma mensagem.

- **Busca de Produto** 🔍: Digite o código do produto e clique em "Buscar" para localizar o documento correspondente. O valor do produto é exibido, se encontrado.

- **Alteração de Produto** ✏️: Após buscar um produto, altere o valor e clique em "Alterar" para atualizar no Firestore. O app exibe uma mensagem de confirmação.

- **Deleção de Produto** 🗑️: Digite o código e clique em "Deletar" para remover o produto do Firestore, com confirmação após a operação.
