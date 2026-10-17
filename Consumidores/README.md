Etapa 1.
Criado os módulos Consumidor e Transformador para cadastro de consumidores de energia elétrica.
Os dados da entidade Consumidor devem ser inseridos a um transformador.
Cada módulo possui suas respectivas camadas Service, Controller e Repository.
Tratamento de exceções foram inseridas, como cadastrar um consumidor que já foi cadastrado.

Etapa 2.
O relatório da Etapa 2 documenta a evolução da arquitetura do sistema de uma estrutura monolítica para um modelo distribuído de microsserviços, com a extração do módulo de Consumidores para um serviço independente (porta 8081) e a manutenção do módulo de Transformadores na aplicação principal (porta 8080). A integração entre as aplicações foi viabilizada via requisições REST com Spring Cloud OpenFeign, garantindo a padronização de tipos de dados (Long), a conversão para DTOs desacoplados (ConsumidorResponse) e o tratamento unificado de exceções remota via @RestControllerAdvice. Além de registrar o marco com a tag etapa-2 no repositório, o documento traz uma reflexão técnica ponderando os trade-offs da separação — como o aumento da complexidade de rede e o risco de falhas parciais — contra os benefícios de escalabilidade e desacoplamento de domínios.