# REST

- Representational state of transfer
- Surgiu em 2000 por Roy Fielding em uma dissertação de doutorado
- Stateless => não trabalha com estados/sessões.
- Cacheável

## Níveis de maturidades

- Nível 0: The Swamp of POX
  - Tudo que é trafegado por HTTP realiza uma transação: INSERT, UPDATE, PROCEDURES
- Nível 1: Utilização de resources
  - GET | POST | PUT | DELETE
- Nível 2: Verbos HTTP
  - Utilizar o verbo certo para as requisições
- Nível 3: HATEOAS: Hypermedia as the engine of application state
  - Retorna, além do que é pedido na requisição, opções de rotas que você pode usar de acordo com o ponto atual que você está.

## Uma boa API REST

- Utilizar URIs únicas para serviços e itens que são expostos para esses serviços;
- Utilizar todos os verbos HTTP para realizar as operações em seus recursos, incluindo caching;
- Provê links relacionados para os recursos exemplificando o que pode ser feito

## Tipos de respostas

- REST HAL =: meida type: application/hal+json

ex:

```json
{
    "_links": {
        "self": {
            "href": "http://localhost:8080/user/wesley"
        }
    },
    "_embedded": {
        "family": {
             "_links": {
                "self": {
                    "href": "http://localhost:8080/user/mary"
                }
            }
        }
    }
}
```

***_link => mostra o recurso atual acessado***
***_embedded => mostra recursos relacionados ao que foi buscado***

## REST: HTTP METHOD NEGOTIATION

O HTTP possui um outro método: OPTIONS, esse método nos permite informar quais métodos são permitidos ou não em um determinado recurso.

***OPTIONS /api/product HTTP/1.1***
HOST: example.com.br

**Resposta pode ser:**

HTTP/1.1 200 0k
Allow GET, POST

***Caso envie a requisição em outro formato**
HTTP/1.1 405 Not Allowed

## REST: Content Negotiation

O processo de content negotiation é baseado na requisição que o cliente está faznedo para o servidor. Nesse caso, ele solicita o que e como ele quer a resposta. O server então retornará ou não a informação no formato desejado.

***Accept Negotiation***

- Cliente solicita a informação e o tipo de retorno pelo servidor baseaco no media type informado por ordem de prioridade.

GET /product
Accept: application/json

Resposta pode ser o retorno dos dados ou:

HTTP/1.1 406 Not Acceptable

- Através de um content-type no header da request, o servidor consegue verificar se ele irá conseguir processar informações para retornar a informação desejada.

POST /product HTTP/1.1
Accept: application/json
Content-Type: application/json

```json
{
  "name": "Product I"
}
```

Caso o servidor não aceite o content type, ele poderá retornar:

HTTP/1.1 415 Unsupported Media Type