### Como realizar o Deployment dos Arquivos no Kubernetes

Para aplicarmos os arquivos YAML no ambiente Kubernetes, navegue até o diretório raiz do projeto vibe3d e execute os seguintes comandos:

> $ kubectl apply -f k8s/postgresql/secret.yaml
> $ kubectl apply -f k8s/postgresql/service.yaml
> $ kubectl apply -f k8s/postgresql/deployment.yaml
> $ kubectl apply -f k8s/vibe3d-api/service.yaml
> $ kubectl apply -f k8s/vibe3d-api/deployment.yaml
> $ kubectl apply -f k8s/vibe3d-app/service.yaml
> $ kubectl apply -f k8s/vibe3d-app/deployment.yaml

Esta pasta do k8s serve para mantermos todos os manifestos Kubernetes organizados em um único local, facilitando o gerenciamento e a manutenção do projeto Vibe3D.