# Factory Method

##  Descrição

O padrão **Factory Method** fornece uma interface para criar objetos em uma superclasse, mas permite que subclasses alterem o tipo de objeto que será criado.

Em vez de instanciar objetos diretamente com `new`, o Factory Method delega a criação para subclasses, tornando o sistema mais flexível e desacoplado.

---

##  Exemplo comparativo

| Sem o padrão (código acoplado) | Com o padrão (código flexível) |
|-------------------------------|--------------------------------|
| `new Carro()` ou `new Moto()` diretamente no código | `fabrica.criarVeiculo()` que decide qual objeto instanciar |

-  [Exemplo sem padrão](./exemplo_sem_padrao.js)
-  [Exemplo com padrão](./exemplo_com_padrao.js)

---

## ✅ Pontos Fortes
- Facilita a extensão do sistema com novos tipos de produtos
- Reduz o acoplamento entre código cliente e classes concretas
- Centraliza a lógica de criação

## ❌ Pontos Fracos
- Pode adicionar complexidade com muitas classes
- Mais difícil de entender no início

---

##  Quando Usar?
- Quando o código precisa criar objetos, mas você não quer acoplar à classe concreta
- Quando o sistema deve ser flexível para introduzir novos tipos de produtos

---

##  Conclusão

O Factory Method ajuda a manter o código limpo, flexível e aberto para extensão. Ele é ideal para sistemas onde o tipo de objeto a ser criado pode variar.
