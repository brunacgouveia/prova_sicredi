#language: pt

Funcionalidade: Adicionar e remover um cliente
Como um usuario,
Eu gostaria de uma pagina de gerenciamento de clientes
Para poder adicionar e remover clientes

Cenario: Validar insercao de um novo cliente
Dado um usuario que se encontra na tela de listagem de cliente
E estando na versao do produto "Bootstrap V4 Theme"
Quando clica no botao Add Customer
E preenche o campo Name do formulario com a informacao "Teste Sicredi"
E preenche o campo LastName do formulario com a informacao "Teste"
E preenche o campo ContactFirstName do formulario com a informacao "Bruna"
E preenche o campo Phone do formulario com a informacao "51 9999-9999"
E preenche o campo AddressLine1 do formulario com a informacao "Av Assis Brasil, 3970"
E preenche o campo AddressLine2 do formulario com a informacao "Torre D"
E preenche o campo City do formulario com a informacao "Porto Alegre"
E preenche o campo State do formulario com a informacao "RS"
E preenche o campo PostalCode do formulario com a informacao "91000-000"
E preenche o campo Country do formulario com a informacao "Brasil"
E preenche o campo fromEmployeer do formulario com a informacao "Fixter"
E preenche o campo CreditLimit do formulario com a informacao "200"
E clica no botao Save
Entao aparece uma mensagem de dados armazenados com sucesso

Cenario: Validar remocao de um cliente
Dado um usuario que se encontra na pagina de criacao de um cliente
Quando clica no link de voltar para a lista
E pesquisa pelo campo Name o valor "Teste Sicredi"
E seleciona o checkbox 
E clica no botao Delete
E confirma remocao de cliente na popup
Entao aparece mensagem de confirmacao de remocao
