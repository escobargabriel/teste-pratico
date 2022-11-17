# teste-pratico

# Esta aplicação foi criada como teste prático sobre desenvolvimento de APIs utilizando Linguagem de programação Java, o framework Spring e o SGBD MySQL.

# Requisitos para executar a aplicação:
## 1 - Open JDK-19;
## 2 - IDE Intellij;
## 3 - MySQL;
## 4 - Postman;
## 5 - DBvizualizer ou outra ferramenta de BI para facilitar a vizualização dos dados no banco (opcional).

# Importante: 
## Verique e altere suas credenciais do MySQL em /teste-pratico/src/main/resources/application.properties para garantir que a aplicação consiga acessar o seu banco de dados.

# Para executar a aplicação é preciso abrir a IDE Intellij e executar o método main presente na classe "TestePraticoApplication".
## Dessa forma, a aplicação Spring é inicializada e permite que as chamadas dos métodos criados sejam realizadas através do servidor Tomcat pela porta 8080.

# Após executar a aplicação através do Intellij é necessário utilizar o software Postman para executar as operações e os seguintes formatos para cada uma das operações:
### Verificar o Status da aplicação (Se está disponível ou não):
#### GET localhost:8080/usuario/status
##### Se a aplicação estiver sendo executada corretamente você receberá no Postman a mensagem "online".
### Fazer uma consulta pelo CEP utilizando o serviço ViaCEP:
#### GET localhost:8080/endereco/cep/XXXXXXXX
##### Utilize o CEP desejado e substitua no local acima indicado pelos "X" utilizando apenas números.
##### Você receberá no POSTMAN todas as informações de acordo com CEP que você inserir de acordo com o que está cadastrado na plataforma do ViaCEP. Alguns CEPs podem conter informações incompletas, como por exemplo, o campo complemento. Além disso, irá aparecer as informações cadastradas no Intellij de acordo com o retorno da API ViaCEP.
#### Realizar a consulta dos usuários através do e-mail cadastrado no banco de dados:
##### GET localhost:8080/usuario/email/seu-email-aqui@mail.com
##### Você deve alterar o endereço de e-mail na instrução acima para o qual deseja consultar.
### Fazer a inserção de um cliente utilizando e-mail e cep:
#### POST localhost:8080/endereco/salvar/seu-email-aqui@mail.com
##### Você deverá alterar o endereço de e-mail na instrução acima para o e-mail deseja cadastrar. 
#### Selecionar no Postman as opções Body -> raw -> JSON
#### Dentro do campo do espaço para escrever o arquivo JSON basta adicionar uma entrada como esta:
##### { "cep": "XXXXXXXX" }
##### Utilize apenas os números do CEP, caso contrário não irá ter o compartamente esperado. Além disso, matenha as aspas duplas para manter a sintaxe do formato JSON.




