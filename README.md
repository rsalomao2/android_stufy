### Configrurando GIT hub no Android Studio

1. Abra o terminal la em baixo
2. git init
3. git add .
4. git commit -m"Texto que identifica o que voce quer salvar"
5. git remote add origin https://github.com/rsalomao2/android_stufy.git
6. git pull origin

## Criar branch com seu nome
1. git checkout -b <seu nome>
2. git push origin <seu nome>

  
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
  

  
