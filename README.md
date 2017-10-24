# discovery_mars

## Objetivo

Explorar o planeta Marte utilizando sondas espaciais

## Como funciona?

Um conjunto de sondas é enviado pela NASA à Marte e irá pousar num planalto. 
Logo após as sondas terem pousado em Marte, é possivel movimenta-las através de requisições via API.


## Documentação da API

## Criar um planalto.
```
POST /api/v1/planalto
```
Exemplo
```
curl -X POST \
  /api/v1/planalto \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 4daf8457-2e22-0102-f03e-de27d8ba88df' \
  -d '{
    "coordenadas": {
      "x": 5,
      "y": 5
   }
}'
```

## Consultar um planalto.
```
GET /api/v1/planalto/1
```
Exemplo
```
curl -X GET \
  /api/v1/planalto/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 5e7d4a64-1ef6-506e-6bfd-4573aa80ef9c'
```

## Implantar uma sonda no Planalto.
```
PACH /api/v1/planalto/1/sonda
```
Exemplo
```
curl -X PATCH \
  /api/v1/planalto/1/sonda \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 1b2a546f-7e46-0401-4ebc-9652a1788c7c' \
  -d '{
	"direcao": "N",
	"coordenadas": {
		"x": 1,
		"y": 2
	}
}'
```
## Buscar uma Sondao.
```
GET /api/v1/sonda/1
```
Exemplo
```
curl -X GET \
  /api/v1/sonda/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 43b8b511-cd9f-7faa-885b-21561ced2834'
```

## Mover uma Sonda.
```
PATCH /api/v1/sonda/1
```
Exemplo
```
curl -X PATCH \
  /api/v1/sonda/1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: dccebdee-9fa3-18b6-8f1b-47ccb754b64c' \
  -d '{
	"comandos": ["L","M","L","M","L","M","L","M","M"]
}'
```

### Requisitos
- Java 8
- maven
