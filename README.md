# LuCar - A Locadora de veículos que mais cresce no Brasil!

Projeto para conclusão do terceiro módulo do curso de Java da ADA - POO-II
Professor do Módulo: Vinicius Martins Cornieri

## 🚀 Descrição e regras do Desafio:

Criar uma aplicação que gerencie o aluguel de veículos, onde cada item abaixo seja considerado:

Itens obrigatórios
Cadastrar os veículos;
Alterar um veículo cadastrado;
Buscar um veículo por parte do nome;
Cadastrar o cliente (pessoa física e jurídica)
Alterar o cliente (pessoa física e jurídica)
Alugar um veículo para pessoa física e jurídica;
Devolver um veículo para pessoa física e jurídica.

Regras de negócio
RN1: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade;
RN2: Tipos de veículos que serão considerados: pequeno, medio e SUV;
RN3: Os aluguéis e devoluções terão o local, data e horário;
RN4: Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.
RN5: Os veículos que estiverem alugados não poderão estar disponíveis;
RN6: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;
RN7: Regras de devolução:
Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto.
Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto.
Valores base da diária por tipo de veículo:

Tipo de Veículo	Valor por dia
pequeno	R$ 100,00
medio	R$ 150,00
SUV	R$ 200,00

Itens bônus - Opcionais
Paginar as listagem envolvidas;
Gravar os dados em arquivos;

Entrega
O projeto pode possuir um menu iterativo ou uma classe com o método main contendo a exemplificação das funcionalidades.

Entregar o link do repositório do projeto no GITHUB. Explicar no README do projeto os conceitos do módulo que teve facilidade e dificuldade em aplicar.
