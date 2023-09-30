### Prospect Manager
##

### Sobre o Projeto

Sistema para Gerenciamento de Prospects

### Histórias de Usuário

- HU001: Como área de Comercialização da Cielo, desejo manter um pré-cadastro de clientes (prospect) para possibilitar uma futura oferta de produtos e serviços a esses clientes.
- HU002: Como área de Comercialização da Cielo, desejo ter uma fila de atendimento aos prospect, para que cada cliente possa ser analisado de forma sequencial pelos gestores comerciais.
- HU003: Como área de Comercialização da Cielo, desejo poder realizar a gestão de pré-cadastro de clientes e, no mesmo sistema, fornecer aos gestores comerciais a possibilidade de recuperar dados dos prospects da fila de atendimento

### Processo de Definição de Requisitos

Os Requisitos Funcionais e Não-Funcionais e Regras de Negócio deste Projeto foram definidos de acordo com as Histórias de Usuário. Ainda, alguns foram solicitados junto à estas.

### Requisitos Funcionais

- RF001: Permitir CRUD de Prospects
- RF002: Permitir Análise de Prospects
- RF003: Permitir CRUD de Empresas
- RF004: Permitir CRUD de Pessoas

### Requisitos Não-Funcionais

- RNF001: O sistema deve ser responsivo para diferentes dispositivos
- RNF002: O sistema deve ser acessível de acordo com as diretrizes WCAG2
- RNF003: O sistema deve seguir boas práticas de Design
- RNF004: O sistema deve ser amigável e seguir boas práticas de UX

### Regras de Negócio

- O cadastro de Pessoa deve solicitar Nome, CPF, E-mail e MCC
- O cadastro de Empresa deve solicitar Razão Social, CNPJ, MCC e Nome, CPF e E-mail de um representante da empresa
- Nome e Razão Social deve possuir no máximo 50 caracteres
- CPF deve possuir 11 caracteres
- CNPJ deve possuir 14 caracteres
- E-mail deve seguir um Pattern
- MCC, Merchant Category Code, é um número que deve possuir até 4 caracteres
- CPFs e CNPJs deverão ser únicos por registro
- A disposição dos clientes para análise deve seguir a lógica de uma Fila(FIFO), ou seja, o primeiro Prospect cadastro, será o primeiro analisado
- Ao atualizar um Prospect, este deverá ser movido para o final da fila
- Ao deletar um Prospect, seu registro na fila também será

### Composição do Sistema

O sistema será composto por um Front-End e uma API REST.

### Tecnologias

Para o Front-End será utilizado o Framework Angular. Para o Back-End, linguagem de programação Java e o Framework Spring Boot.

### Como executar o Sistema

As instruções para execução deste divididas por aplicação.

Na raiz deste repositório, estão dispostos os diretórios de ambas aplicações que compõem este projeto.

Nestas, se encontram as instruções para execução das aplicações.

Obs.: O devido comportamento do sistema ocorrerá apenas caso ambas aplicações estejam em execução.