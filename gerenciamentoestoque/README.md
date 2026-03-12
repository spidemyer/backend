## Requisitos do sistema

### 1. Requisitos Funcionais (RF)
| ID | Requisito  | Descrição  |
|----|------------|------------|
|RF01| Gestão de Acesso | Permitir login de funcionários com o NIF e a senha |
|RF02| Cadastro Autorizado | Validar o cadastro apenas para Nifs presentes no Bnaco de Dados |
|RF03| CRUD de Materiais | Cadastrar, consultar, editar e excluir itens do estoque |
|RF04| Movimentações | Registrar histórico de quem alterou o estoque com data/hora |

### 2. Requisitos Não Funcionais (RNF)
|RNF01 | Banco de Dados | Persistência de dados usando o PostgreSQL |
|RNF02 | Interface      | UI seguindo a identidade visual do SENAI  |
|RNF03 | Performance    | Cunsultas ao banco com tempo de resposta inferior a 2s|