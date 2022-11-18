# Teste Prático.

# Esta aplicação foi criada como teste prático sobre desenvolvimento de APIs utilizando Linguagem de programação Java, o framework Spring e o SGBD MySQL.

# Para execução da aplicação é necessário fazer o download e instalação dos seguintes softwares:
## 1 - Open JDK-19;
## 2 - IDE Intellij;
## 3 - MySQL 8;
## 4 - Postman;
## 5 - DBvizualizer ou outra ferramenta de BI para facilitar a vizualização dos dados no banco (opcional).

# Importante: 
## Certifique-se de instalar e configurar corretamente os softwares necessários para executar a aplicação.
## Verique e altere suas credenciais do MySQL em /teste-pratico/src/main/resources/application.properties para garantir que a aplicação consiga acessar o seu banco de dados.



# Após instalar os softwares necessários é preciso realizar o download dos códigos ou clonar este repositório, logo após esse processo, basta abrir a IDE Intellij e executar o método main presente na classe "TestePraticoApplication".
## Dessa forma, a aplicação Spring é inicializada e permite que as chamadas dos métodos criados sejam realizadas através do servidor Tomcat pela porta 8080.
## Certifique-se de que a aplicação está rodando através da aba "Run" do Intellij. Se tudo estiver sendo executado corretamente, você poderá observar na aba Run algo do tipo: Started TestePraticoApplication...

# Outra forma de executar a aplicação é através do arquivo jar no qual a aplicação é empacotada com todos os recursos necessários para execução.
# Para gerar o arquivo jar basta ir até o diretório raiz do projeto e executar o comando:
## mvn clean package
### Se houver falha nos testes durante o processo de build acrescente a flag -DskipTests
## mvn clean package -DskipTests
## basta ir até o diretório no qual o arquivo .jar está localiza e executar o comando:
### java -jar teste-pratico-0.0.1-SNAPSHOT.jar

# Após executar a aplicação através do Intellij ou pelo arquivo jar você pode utilizar o software Postman para executar as operações e os seguintes formatos para cada uma das operações:
### Verificar o Status da aplicação (Se está disponível ou não):
#### GET localhost:8080/status
##### Se a aplicação estiver sendo executada corretamente você receberá no Postman a mensagem "online".
### Fazer uma consulta pelo CEP utilizando o serviço ViaCEP:
#### GET localhost:8080/endereco/cep/XXXXXXXX
##### Utilize o CEP desejado e substitua no local acima indicado pelos "X" utilizando apenas números.
##### Você receberá no POSTMAN todas as informações de acordo com CEP que você inserir de acordo com o que está cadastrado na plataforma do ViaCEP. Alguns CEPs podem conter informações incompletas, como por exemplo, o campo complemento. Além disso, irá aparecer as informações cadastradas no Intellij de acordo com o retorno da API ViaCEP.
### Fazer a inserção de um cliente utilizando e-mail e cep:
#### POST localhost:8080/endereco/salvar/seu-email-aqui@mail.com
##### Você deverá alterar o endereço de e-mail na instrução acima para o e-mail deseja cadastrar. 
#### Selecionar no Postman as opções Body -> raw -> JSON
#### Dentro do campo do espaço para escrever o arquivo JSON basta adicionar uma entrada como esta:
##### { "cep": "XXXXXXXX" }
##### Utilize apenas os números do CEP, caso contrário não irá ter o compartamente esperado. Além disso, matenha as aspas duplas para manter a sintaxe do formato JSON.
### Fazer uma consulta do endereço pelo e-mail do usuário.
#### localhost:8080/endereco/email/seu-email-aqui@mail.com
##### Você deverá alterar o endereço de e-mail na instrução acima para o e-mail deseja consultar.

## Dúvidas ou sugestões escreva para: escobarvasques@gmail.com.




