# CRUD de Produtos com Firebase Firestore

Este aplicativo Android permite gerenciar um cadastro de produtos, realizando operações CRUD (Criar, Ler, Atualizar e Deletar) usando o banco de dados Firebase Firestore. Cada operação pode ser realizada diretamente da interface, e as informações são exibidas ao usuário por meio de mensagens de confirmação ou erro.

## Estrutura do Projeto e Funcionamento das Funcionalidades

O projeto contém uma interface de usuário simplificada e uma lógica Java para operações no Firebase Firestore. Abaixo está uma descrição detalhada de cada funcionalidade e como o app opera.

### Funcionamento

1. **Inicialização do Firebase Firestore**: 
   - Ao abrir o aplicativo, uma instância do Firebase Firestore é criada para possibilitar as interações com o banco de dados. 
   - Isso permite ao app inserir, recuperar, atualizar e excluir dados de maneira direta, com o Firestore gerenciando a sincronização e a persistência dos dados.

2. **Componentes Visuais**:
   - A tela principal contém:
     - **Dois campos de entrada** (`EditText`) para o código e valor do produto.
     - **Quatro botões** para cada operação CRUD: `Cadastrar`, `Buscar`, `Alterar` e `Deletar`.
   - A interface é construída usando o `ConstraintLayout`, o que facilita a organização visual, com uma aparência responsiva.
---
### Funcionalidades CRUD

#### 1. Cadastro de Produto
   - **Ação**: Ao preencher os campos e clicar no botão "Cadastrar", o aplicativo cria um novo documento no Firestore com o código do produto como identificador único.
   - **Implementação**: 
     - O código e o valor do produto são capturados dos campos de entrada.
     - Verifica-se se os valores são válidos e, em seguida, os dados são organizados em um `Map`.
     - A função `.set()` grava os dados no Firestore. Se a gravação for bem-sucedida, o app exibe uma mensagem de "Produto cadastrado" e limpa os campos.
   - **Uso**:
     - Ideal para inserir novos produtos no banco de dados.

#### 2. Busca de Produto
   - **Ação**: Ao digitar o código do produto e clicar em "Buscar", o app pesquisa o documento correspondente no Firestore.
   - **Implementação**:
     - O código do produto é coletado e usado como referência de documento.
     - Com `.get()`, o app busca o produto no Firestore. Se encontrado, o valor do produto é exibido no campo apropriado; caso contrário, exibe "Produto não encontrado".
   - **Uso**:
     - Permite recuperar e exibir o valor de um produto específico no app.

#### 3. Alteração de Produto
   - **Ação**: O usuário deve buscar o produto pelo código, alterar o valor no campo e clicar em "Alterar" para atualizar o valor no Firestore.
   - **Implementação**:
     - Após buscar o produto e preencher o novo valor, o app usa `.update()` para atualizar o campo "value" do documento.
     - Ao completar a operação, o app exibe "Produto atualizado" e limpa os campos.
   - **Uso**:
     - Modifica o valor de produtos já cadastrados.

#### 4. Deleção de Produto
   - **Ação**: O usuário digita o código do produto e clica em "Deletar". O Firestore remove o documento correspondente.
   - **Implementação**:
     - O código do produto é usado como referência do documento a ser deletado.
     - O método `.delete()` remove o documento do Firestore, e o app exibe "Produto deletado". Após a deleção, os campos são limpos automaticamente.
   - **Uso**:
     - Para excluir produtos obsoletos ou indesejados.
