## Prospect Manager API
###

### Sobre o Projeto

O Desenvolvimento desta aplicação foi em coerência com as Histórias de Usuários, Requisitos Funcionais e Não-Funcionais e Regras de Negócios do sistema.

<br>

### Sobre a Aplicação

A aplicação foi desenvolvida utilizada a linguagem de programação Java em sua versão 18, o Framework Spring Boot em sua versão 3.2.x e utiliza o Banco de Dados MongoDB para persistência.

O foco desta aplicação é conter as Entidades e Regras de Negócios por trás de suas manipulações por clientes externos.

A aplicação permite o CRUD de Prospects que podem ser tanto Pessoas quanto Empresas.

Estes Prospects estão vinculados a uma Fila de Atendimento. Esta possui seus itens armazenados no Banco de Dados.

A cada requisição pela Fila, o objeto inicial é buscado e a fila é montada recursivamente.

Alterações na Entidade Prospect impactam em sua disposição na Fila. Atráves de Event Listeners, um fluxo assíncrono de atualização dos itens da fila impactados se iniciar por ação de alteração de Prospect.

<br>

