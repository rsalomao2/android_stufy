### Configrurando GIT hub no Android Studio

1. Abra o terminal la em baixo
2. git init
3. git add .
4. git commit -m"Texto que identifica o que voce quer salvar"
5. git remote add origin https://github.com/rsalomao2/android_stufy.git
6. git pull origin

## Criar branch com seu nome
1. git checkout -b `<seu nome>`
2. git push origin `<seu nome>`

  
## Login Screen
  
1. Crie uma tela de login de acordo com design abaixo
  
<img src="https://user-images.githubusercontent.com/12714219/166169962-e089b6ea-b694-4736-830e-9e5397f57a96.png" width="200" height="400" />
  
2. Ao clicar em qualquer item é chamado uma segunda tela usando Activity
3. Ao clicar em qualquer item é chamado uma segunda tela usando Fragment
  
# Login with email Screen
  1. Ao clicar no botão Login with email o usuário sera direcionado para tela de login usando um email e senha com layout abaixo
  
  <img width="200" alt="Screen Shot 2022-05-01 at 9 03 12 PM" src="https://user-images.githubusercontent.com/12714219/166170127-26e479bb-c331-48af-9e63-91504ce44282.png">
  
  2. Ao clicar no botão SignIn, os campos de email e senha devem ser validados. Somente se a senha for usuario@valido.com com senha 123456 ele deve ser direcionado para tela de Home.
  3. Caso a senha esteja errada um error deve ser mostrado no campo que está errado. Caso email, erro no campo email, etc.
  4. Password deve ser oculto mostrando somente `***` ao ser digitado. 
  5. Deve haver uma botão em que a senha é revelada.
  
  
 # Register Screen
  1. Caso o usuário clique em Create Account ele deve ser direcionado para a tela de SignUp conforme layout abaixo
  
  <img width="200" alt="Screen Shot 2022-05-01 at 9 08 01 PM" src="https://user-images.githubusercontent.com/12714219/166170312-f38dca13-95e6-4c21-881e-156b7e09a574.png">
  
  2. First Name não pode ser vazio e maior que 3 letras
  3. Last name não pode ser vazio e maior que 3 letras
  4. O email deve ser um email valido. Validando casos como `dfasfsdf@.c`, `s@.er, etc
  5. Phone Number deve conter uma mascara ao ser preenchido. Ou seja, ao digitar 41988444123 ele aparecera (41) 98844-4123
  6. CPF deve conter uma mascara ao ser preenchido. Ou seja, ao digitar 12312312340 ele aparecera 123.123-123-40
  7. Password deve ser oculto mostrando somente `***` ao ser digitado. 
  8. Deve haver uma botão em que a senha é revelada.
  9. Ao clicar no botão registrar todos os campos devem ser validado. Casos todos estejam corretos, o usuario deve ser direcionado para tela de login
  10. Caso algum campo contenha erro, uma messagem deve descriminar o erro em baixo do campo com problema.

# Home Screen
  1. Na Home screen deve ser mostrado uma lista de usuarios contendo:
     * Imagem
     * Nome
     * Sobrenome
     * Telefone
     * CPF
     * email

  Como descrito na tela abaixo
  
<img width="200" alt="Screen Shot 2022-05-23 at 9 19 20 PM" src="https://user-images.githubusercontent.com/12714219/169924208-25f573f1-7703-4c2e-8322-ed4f726457d7.png">
  
  2. Ao clicar em um dos itens o usuario deve ser direcionado a uma tela de detalhes do item
  3. Na toolbar deve mostrar o nome Home Screen



# Detail Screen
  1. Na Detail screen deve ser mostrado todos os dados disponíveis do usuario:

  Algo similar, ou igual, a tela abaixo
  
<img width="200" alt="Screen Shot 2022-05-23 at 9 21 25 PM" src="https://user-images.githubusercontent.com/12714219/169924389-782a64bd-e934-4e99-be54-13c6ead7f5cb.png"><img width="200" alt="Screen Shot 2022-05-23 at 9 23 41 PM" src="https://user-images.githubusercontent.com/12714219/169924579-b6ea340c-bae7-4666-a11b-888ec5f87c94.png">

  
  2. A toolbar deve expandir e colapsar
  3. Quando a toolbar estiver expandida deve mostrar o titulo e a imagem
  4. Quando a toolbar estiver colapsada deve mostrar o titulo e o botão de voltar
  5. Ao clicar em voltar o usuário deve voltar para a Home Screen

## Parte 2

  Agora que temos a estrutura pronta, vamos obter a lista de um servidor ao invés de um arquivo local.
  
  Para isso vamos usar o serviço https://jsonplaceholder.typicode.com/users que retornará uma lista de usuários que devem ser listados na Home.
  
  1. Estudar o que é e como usar Retrofit2
  2. Instalar/Configurar Retrofit2 para consumir a URL acima
  3. O setup do retrofit tem que ficar dentro do MyApplication
  4. Na Home voce obterá a intancia unica (singleton) do Retrofit
  5. O retrofit deve ter um URL base (https://jsonplaceholder.typicode.com/)
  6. O projeto deve ter um arquivo chamdo `UserService` que irá conter o path (users) que obter os usuários

## Parte 3
  
  Com a lista de usuários na mão precisamos adicionar uma imagem já que os mesmos não vem com uma.
  
  1. Para cada usuário que vem da lista, adicionar uma URL aleatória de uma imagem.
  2. Carregar a imagem no item da lista usando o Glide
  3. Carregar a imagem na tela de detalhe usando o Glide
  
  
  ## Parte 4 
  
  Precisamos compartilhar a lista de usuários entre Home e Detail scren. Para isso vamos usar o banco de dados mais basico que temos. `SharedPreference`
  
  1. Ao obter os dados dos usuários, salva-los no sharedpreference
  2. Ao abrir a tela de Detalhes do item, vamos buscar o item clicado pelo ID
  
  
  
  
  
