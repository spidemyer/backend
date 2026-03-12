## 1. Requisitos do sistema

### 1. Requisitos Funcionais (RF)
| ID | Requisito  | Descrição  |
|----|------------|------------|
|RF01| Gestão de Acesso | Permitir login de funcionários com o NIF e a senha |
|RF02| Cadastro Autorizado | Validar o cadastro apenas para Nifs presentes no Bnaco de Dados |
|RF03| CRUD de Materiais | Cadastrar, consultar, editar e excluir itens do estoque |
|RF04| Movimentações | Registrar histórico de quem alterou o estoque com data/hora |
|RF05| Adção de Material | Permitir que o usúario adcione materiais |

### 2. Requisitos Não Funcionais (RNF)
* **RNF01 (Banco de Dados):** Persistência de dados utilizando PostgreSQL.
* **RNF02 (Interface):** UI seguindo a identidade visual do SENAI.
* **RNF03 (Tecnologias):** Back-end: Java 17+ / Spring Boot | Front-end: Thymeleaf / CSS3.
* **RNF04 (Performance):** Consultas ao banco com tempo de resposta inferior a 2s.
* **RNF05 (interface):** Listar todos os materiais.


## 2. Schema do Banco de Dados (ER)

O sistema utiliza o banco de dados PostgreSQL. Abaixo está a representação das tabelas e seus relacionamentos:

### 1. Tabela `funcionarios_autenticados`
*Lista de controle (White List) que define quem tem permissão para criar uma conta.*
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| **id** (PK) | BIGINT | Identificador único (Auto-incremento). |
| **nome** | VARCHAR(120) | Nome completo do colaborador autorizado. |
| **nif** | VARCHAR(20) | Número de Identificação Fiscal (Único). |
| **ativo** | BOOLEAN | Define se o acesso ainda é válido. |

### 2. Tabela `funcionarios`
*Dados dos usuários que já realizaram o cadastro no sistema.*
| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| **id** (PK) | BIGINT | Identificador único (Auto-incremento). |
| **nome** | VARCHAR(255) | Nome vindo do cadastro. |
| **nif** | VARCHAR(20) | NIF (FK lógica para autenticados). |
| **senha** | VARCHAR(255) | Senha de acesso. |
| **ativo** | BOOLEAN | Status da conta do usuário. |