# Prototype

## Descrição

O padrão **Prototype** permite criar novos objetos copiando (clonando) um objeto existente, chamado protótipo, ao invés de criar a instância do zero. Isso é útil quando a criação do objeto é custosa ou complexa.

Em vez de usar construtores diretamente, o Prototype usa a clonagem para gerar novos objetos, o que torna o sistema mais flexível e pode melhorar a performance.

---

## Exemplo comparativo

| Sem o padrão (criação manual)                      | Com o padrão (clonagem do protótipo)                  |
|---------------------------------------------------|-------------------------------------------------------|
| Criar objetos repetidamente com construtores      | Clonar um objeto protótipo e modificar apenas o necessário |

- [Exemplo sem padrão](./prototype_sem_padrao.py)  
- [Exemplo com padrão](./prototype_com_padrao.py)

---

## ✅ Pontos Fortes

- Facilita a criação de cópias de objetos complexos e configurados  
- Reduz a duplicação de código na criação de objetos similares  
- Pode melhorar o desempenho ao evitar processos custosos de inicialização  
- Desacopla o código da classe concreta do objeto criado  

## ❌ Pontos Fracos

- Pode ser complexo implementar a clonagem profunda corretamente  
- Risco de erros se a clonagem não for feita de forma completa (deep copy)  
- A lógica de criação pode ficar “escondida”, dificultando a leitura do código  

---

## Quando Usar?

- Quando a criação do objeto é cara ou complexa  
- Quando se deseja evitar subclasse só para criar variações de objetos  
- Quando é necessário criar múltiplas cópias de objetos já configurados  

---

## Conclusão

O padrão Prototype é uma solução eficiente para criar cópias de objetos complexos, tornando o código mais flexível e reutilizável. Seu uso é ideal para situações onde a criação direta é custosa, embora exija cuidado na implementação correta da clonagem para evitar problemas com estados compartilhados.

---
