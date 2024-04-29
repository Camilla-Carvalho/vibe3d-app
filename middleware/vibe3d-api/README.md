# Projeto Vibe3dApi
Camilla Carvalho, Maio 2024.

Este é um projeto de uma aplicação para uma loja de impressões 3d utilizando o [Quarkus](https://quarkus.io/), um _Framework Java_ supersônico e subatômico.

## Executando o aplicativo em modo dev

Execute o aplicativo no modo de desenvolvimento que permite codificação ao vivo _(alive)_ usando a linha de comando abaixo:
```script de shell
./mvnw clean compile quarkus:dev
```

### REST

Acesse facilmente os serviços Web REST via Swagger, usando:

> **_Swagger:_** A _visão no modo Swagger_ está disponível em http://localhost:8080/q/swagger-ui/.

> **_Dev UI:_** O Quarkus agora vem com uma Dev UI, que está disponível no modo dev apenas em http://localhost:8080/q/dev/.

## Empacotando e executando o aplicativo para deployment

O aplicativo pode ser empacotado usando:
```script de shell
./mvnw package
ou
./mvnw install
```
Ele produz o arquivo `quarkus-run.jar` no diretório `target/quarkus-app/`.
Esteja ciente de que não é um _über-jar_ pois as dependências são copiadas para o diretório `target/quarkus-app/lib/`.

O aplicativo agora pode ser executado usando `java -jar target/quarkus-app/quarkus-run.jar`.

Se você deseja construir um _über-jar_, execute o seguinte comando:
```script de shell
./mvnw package -Dquarkus.package.type=uber-jar
```

O aplicativo, empacotado como um _über-jar_, agora pode ser executado usando `java -jar target/*-runner.jar`.

## Criando um executável nativo

Você pode criar um executável nativo usando:
```script de shell
./mvnw package -Dnative
```

Ou, se você não tiver o GraalVM instalado, você pode executar a compilação executável nativa em um contêiner usando:
```script de shell
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

Você pode então executar seu executável nativo com: `./target/vibe3d_api-1.0.0-SNAPSHOT-runner`

Para saber mais sobre como construir executáveis nativos, consulte https://quarkus.io/guides/maven-tooling.

## Guias relacionados

- REST ([guide](https://quarkus.io/guides/rest)): Uma implementação REST de Jacarta utilizando processamento de tempo de construção e Vert.x. Esta extensão não é compatível com a extensão quarkus-resteasy ou com qualquer uma das extensões que dela dependem.
