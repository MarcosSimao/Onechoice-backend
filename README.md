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

## Solução
 Irei mostrar primeiro  os verbos da api dos hospedes...
 o primeiro foi o GET e foi usado pra listar todos do Hotel e buscar por id,nome,documento e telefone...
 
 Listando todos os Clientes do Hotel:
 
 ````
GET http://localhost:8080/hospedes


[
    {
        "id": 14,
        "nome": "marcos andrade",
        "documento": "999999",
        "telefone": "8364738993"
    },
    {
        "id": 15,
        "nome": "lucas simao",
        "documento": "333333",
        "telefone": "8475649377"
    },
    {
        "id": 16,
        "nome": "leticia andrade",
        "documento": "222222",
        "telefone": "908466378"
    },
    {
        "id": 20,
        "nome": "goku severino",
        "documento": "343434",
        "telefone": "564738493"
    }
]

````
pegando Cliente do Hotel por id:

````
GET http://localhost:8080/hospedes/15

{
    "id": 15,
    "nome": "lucas simao",
    "documento": "333333",
    "telefone": "8475649377"
}

````
pegando Cliente pelo nome:

````
GET http://localhost:8080/hospedes/nome/lucas simao
{
    "id": 15,
    "nome": "lucas simao",
    "documento": "333333",
    "telefone": "8475649377"
}

````

pegando cliente pelo Documento:

````
GET http://localhost:8080/hospedes/documento/333333
{
    "id": 15,
    "nome": "lucas simao",
    "documento": "333333",
    "telefone": "8475649377"
}
````
pegando cliente pelo Telefone:

````
GET http://localhost:8080/hospedes/telefone/8475649377


{
    "id": 15,
    "nome": "lucas simao",
    "documento": "333333",
    "telefone": "8475649377"
}

o segundo vem o Verbo POST . Inserindo um Hospede:
````

````
POST http://localhost:8080/hospedes

{
    
    "nome": "Sandra Paula",
    "documento": "234564",
    "telefone": "8199344444"
}

GET http://localhost:8080/hospedes

[
    {
        "id": 14,
        "nome": "marcos andrade",
        "documento": "999999",
        "telefone": "8364738993"
    },
    {
        "id": 15,
        "nome": "lucas simao",
        "documento": "333333",
        "telefone": "8475649377"
    },
    {
        "id": 16,
        "nome": "leticia andrade",
        "documento": "222222",
        "telefone": "908466378"
    },
    {
        "id": 20,
        "nome": "goku severino",
        "documento": "343434",
        "telefone": "564738493"
    },
    {
        "id": 22,
        "nome": "Sandra Paula",
        "documento": "234564",
        "telefone": "8199344444"
    }
],
   
]

````
Agora vamos usar o Verbo PUT
e vamos alterar o telefone de um Hospede:

````
GET http://localhost:8080/hospedes/14

{
        "id": 14,
        "nome": "marcos andrade",
        "documento": "999999",
        "telefone": "8364738993"
    }
PUT http://localhost:8080/hospedes/14

{
    
    "nome": "marcos andrade",
    "documento": "999999",
    "telefone": "000000000"
}

GET http://localhost:8080/hospedes

[
    {
        "id": 15,
        "nome": "lucas simao",
        "documento": "333333",
        "telefone": "8475649377"
    },
    {
        "id": 16,
        "nome": "leticia andrade",
        "documento": "222222",
        "telefone": "908466378"
    },
    {
        "id": 20,
        "nome": "goku severino",
        "documento": "343434",
        "telefone": "564738493"
    },
    {
        "id": 22,
        "nome": "Sandra Paula",
        "documento": "234564",
        "telefone": "8199344444"
    },
    {
        "id": 14,
        "nome": "marcos andrade",
        "documento": "999999",
        "telefone": "000000000"
    }
]



````
Agora vamos Ver quem deu o checkIn . Usando Get para listar todos:

````
GET http://localhost:8080/checkin

[
    {
        "codigo": 19,
        "dataEntrada": "2001-07-04T12:08:56.000+00:00",
        "dataSaida": "2001-07-12T12:20:56.000+00:00",
        "adicionarVeiculos": false,
        "conta": 1020.0,
        "hospede": {
            "id": 16,
            "nome": "leticia andrade",
            "documento": "222222",
            "telefone": "908466378"
        }
    },
    {
        "codigo": 17,
        "dataEntrada": "2001-07-04T12:08:56.000+00:00",
        "dataSaida": "2001-07-13T12:20:56.000+00:00",
        "adicionarVeiculos": true,
        "conta": 1285.0,
        "hospede": {
            "id": 14,
            "nome": "marcos andrade",
            "documento": "999999",
            "telefone": "000000000"
        }
    },
    {
        "codigo": 21,
        "dataEntrada": "2001-07-04T12:08:56.000+00:00",
        "dataSaida": "2001-07-12T12:20:56.000+00:00",
        "adicionarVeiculos": false,
        "conta": 1020.0,
        "hospede": {
            "id": 20,
            "nome": "goku severino",
            "documento": "343434",
            "telefone": "564738493"
        }
    }
]
````
buscando  checkin por id do hospede:

````
GET http://localhost:8080/checkin/hospede/16

{
    "codigo": 19,
    "dataEntrada": "2001-07-04T12:08:56.000+00:00",
    "dataSaida": "2001-07-12T12:20:56.000+00:00",
    "adicionarVeiculos": false,
    "conta": 1020.0,
    "hospede": {
        "id": 16,
        "nome": "leticia andrade",
        "documento": "222222",
        "telefone": "908466378"
    }
}
````

buscando checkin por nome do Hospede:

````
GET http://localhost:8080/checkin/hospede/nome/leticia andrade

{
    "codigo": 19,
    "dataEntrada": "2001-07-04T12:08:56.000+00:00",
    "dataSaida": "2001-07-12T12:20:56.000+00:00",
    "adicionarVeiculos": false,
    "conta": 1020.0,
    "hospede": {
        "id": 16,
        "nome": "leticia andrade",
        "documento": "222222",
        "telefone": "908466378"
    }
}
````

buscando Checkin por documento do hospede:

````
GET http://localhost:8080/checkin/hospede/documento/222222

{
    "codigo": 19,
    "dataEntrada": "2001-07-04T12:08:56.000+00:00",
    "dataSaida": "2001-07-12T12:20:56.000+00:00",
    "adicionarVeiculos": false,
    "conta": 1020.0,
    "hospede": {
        "id": 16,
        "nome": "leticia andrade",
        "documento": "222222",
        "telefone": "908466378"
    }
}
````

buscando checkIn por telefone do hospede:

````
GET http://localhost:8080/checkin/hospede/telefone/908466378

{
    "codigo": 19,
    "dataEntrada": "2001-07-04T12:08:56.000+00:00",
    "dataSaida": "2001-07-12T12:20:56.000+00:00",
    "adicionarVeiculos": false,
    "conta": 1020.0,
    "hospede": {
        "id": 16,
        "nome": "leticia andrade",
        "documento": "222222",
        "telefone": "908466378"
    }
}
````

 agora usaremos o verbo POst para adicionar o Hospede no checkIN.
 Lembrando que cadastramos Sandra do id 22 no nosso Hotel, ela vai da o checkIn:
 
 ````
POST http://localhost:8080/checkin

{
    
    "dataEntrada": "2001-07-19T12:08:56.000+00:00",
    "dataSaida": "2001-07-30T12:20:56.000+00:00",
    "adicionarVeiculos": true,
    "conta": 1020.0,
    "hospede": {
        "id": 22
        
    }
}

GET http://localhost:8080/checkin
[
    {
        "codigo": 19,
        "dataEntrada": "2001-07-04T12:08:56.000+00:00",
        "dataSaida": "2001-07-12T12:20:56.000+00:00",
        "adicionarVeiculos": false,
        "conta": 1020.0,
        "hospede": {
            "id": 16,
            "nome": "leticia andrade",
            "documento": "222222",
            "telefone": "908466378"
        }
    },
    {
        "codigo": 17,
        "dataEntrada": "2001-07-04T12:08:56.000+00:00",
        "dataSaida": "2001-07-13T12:20:56.000+00:00",
        "adicionarVeiculos": true,
        "conta": 1285.0,
        "hospede": {
            "id": 14,
            "nome": "marcos andrade",
            "documento": "999999",
            "telefone": "000000000"
        }
    },
    {
        "codigo": 21,
        "dataEntrada": "2001-07-04T12:08:56.000+00:00",
        "dataSaida": "2001-07-12T12:20:56.000+00:00",
        "adicionarVeiculos": false,
        "conta": 1020.0,
        "hospede": {
            "id": 20,
            "nome": "goku severino",
            "documento": "343434",
            "telefone": "564738493"
        }
    },
    {
        "codigo": 23,
        "dataEntrada": "2001-07-19T12:08:56.000+00:00",
        "dataSaida": "2001-07-30T12:20:56.000+00:00",
        "adicionarVeiculos": true,
        "conta": 1625.0,
        "hospede": {
            "id": 22,
            "nome": "Sandra Paula",
            "documento": "234564",
            "telefone": "8199344444"
        }
    }
]
````

agora vamos usar o verbo PUT para alterar o dia de saida de sandra e tirar o carro da garagem :

````
GET http://localhost:8080/checkin/23


{
    "codigo": 23,
    "dataEntrada": "2001-07-19T12:08:56.000+00:00",
    "dataSaida": "2001-07-30T12:20:56.000+00:00",
    "adicionarVeiculos": true,
    "conta": 1625.0,
    "hospede": {
        "id": 22,
        "nome": "Sandra Paula",
        "documento": "234564",
        "telefone": "8199344444"
    }
}

PUT http://localhost:8080/checkin/23

{
    
    "dataEntrada": "2001-07-19T12:08:56.000+00:00",
    "dataSaida": "2001-07-31T12:20:56.000+00:00",
    "adicionarVeiculos": false,
    "conta": 1020.0,
    "hospede": {
        "id": 22
        
    }
}

GET http://localhost:8080/checkin/23

{
    "codigo": 23,
    "dataEntrada": "2001-07-19T12:08:56.000+00:00",
    "dataSaida": "2001-07-31T12:20:56.000+00:00",
    "adicionarVeiculos": false,
    "conta": 1560.0,
    "hospede": {
        "id": 22,
        "nome": "Sandra Paula",
        "documento": "234564",
        "telefone": "8199344444"
    }
}

````
 
