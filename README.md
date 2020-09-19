# Onechoice-backend


## Construído com

* 	[Maven](https://maven.apache.org/) - Gerenciador de Dependências
* 	[JDK 11](http://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-2133151.html) - Java™️ Platform, Standard Edition Development Kit - Versão 11
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework utilizado facilitar e agilizar as Aplicações Springs
* 	[postgresql](https://www.postgresql.org/download/)-  um sistema gerenciador de banco de dados objeto relacional.
* 	[git](https://git-scm.com/) - Sistema de Controle de Versões, Open-Source
api REST

## Ferramenta Externa Usada

* [Postman](https://www.getpostman.com/) - Ambiente de Desenvolvimento de Testes e Documentação

## O problema
Requisitos funcionais
● Um CRUDL para o cadastro de hóspedes;
● No check in deve ser possível buscar hóspedes cadastrados pelo nome, documento
ou telefone;
● Consultar hóspedes que já realizaram o check in e não estão mais no hotel;
● Consultar hóspedes que ainda estão no hotel;
● As consultas devem apresentar o valor (valor total e o valor da última hospedagem)
já gasto pelo hóspede no hotel;
JSON exemplo do hóspede JSON exemplo do check in
{ {
“nome”: “Fulano da SIlva”, “hospede”: {...},
“documento”: “123456”, “dataEntrada”: “2018-03-14T08:00:00”,
“telefone”: “9925-2211” “dataSaida”: “2018-03-16T10:17:00”,
} “adicionalVeiculo”: false/true
}
* data no padrão ISO-8601
Regras de negócio
● Uma diária no hotel de segunda à sexta custa R$120,00;
● Uma diária no hotel em finais de semana custa R$150,00;
● Caso a pessoa precise de uma vaga na garagem do hotel há um acréscimo diário,
sendo R$15,00 de segunda à sexta e R$20,00 nos finais de semana;
● Caso o horário da saída seja após às 16:30h deve ser cobrada uma diária extra

