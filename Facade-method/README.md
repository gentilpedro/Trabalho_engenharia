# Facade

## Descrição

O padrão **Facade** fornece uma interface simplificada para um subsistema mais complexo. Ele atua como uma *fachada*, escondendo os detalhes internos e oferecendo um ponto de acesso único e de alto nível.

Esse padrão é útil para tornar um sistema mais fácil de usar, reduzir o acoplamento entre clientes e subsistemas, e organizar melhor o código.

---

## Exemplo comparativo

| Sem o padrão (código acoplado) | Com o padrão (código organizado) |
|-------------------------------|----------------------------------|
| Código chama diretamente vários serviços, como `ServicoPagamento`, `ServicoEstoque`, `ServicoEnvio` | Cliente chama apenas `lojaFacade.finalizarCompra()` que coordena tudo |

- [Exemplo sem padrão](./exemplo_sem_facade.js)  
- [Exemplo com padrão](./exemplo_com_facade.js)

---

## ✅ Pontos Fortes

- Oculta a complexidade de subsistemas
- Facilita o uso e manutenção do sistema
- Reduz o acoplamento entre o cliente e as classes internas
- Permite alterações nos subsistemas sem afetar os clientes

---

## ❌ Pontos Fracos

- Pode se tornar uma "classe Deus" se assumir muitas responsabilidades
- Risco de mascarar funcionalidades importantes dos subsistemas

---

## Quando Usar?

- Quando o sistema tem muitas classes complexas e interdependentes
- Quando você deseja fornecer uma API mais simples para uso externo
- Quando quer desacoplar o cliente da lógica interna do sistema

---

## Conclusão

O padrão Facade é ideal para estruturar sistemas complexos de forma mais simples e coesa. Ele não altera o funcionamento interno do sistema, mas torna sua utilização muito mais amigável e modular.
