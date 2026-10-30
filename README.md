# Agenda Pessoal

Aplicativo Android de gerenciamento de contatos (nome, telefone e email),
desenvolvido em Kotlin com Jetpack Compose, Material 3 e Navigation Compose.

## Integrantes
- Heytor José de Souza Silva
- Heitor Oliveira Dias

## Como executar
1. Abra o projeto no Android Studio.
2. Aguarde o Gradle Sync.
3. Execute em emulador ou dispositivo (API 24+).
4. Rode `app`.

## Requisitos implementados
- RF01: listagem com 3 registros iniciais, atualização imediata após cadastro.
- RF02: formulário com 3 campos, validações (nome obrigatório, telefone ≥ 8 dígitos, email com @ e .), mensagens de erro, cancelar sem salvar.
- RF03: detalhes por ID via rota `{id}`, busca no estado compartilhado, tratamento de ID inexistente.
- RF04: tela Sobre/Ajuda com finalidade, instruções, autores e ACTION_SEND com try/catch.

## Organização
- `model/Contato.kt` — modelo.
- `data/ContatoStore.kt` — estado compartilhado (`mutableStateListOf`).
- `navigation/AppNavigation.kt` — NavHost, rotas, argumentos.
- `screens/` — Home, Cadastro, Detalhes, Sobre.
- `MainActivity.kt` — única Activity, inicia via `setContent`.

## Testes realizados
- Abrir item inicial e voltar — OK.
- Salvar formulário inválido — mensagens exibidas, nenhum item criado.
- Cadastrar item válido e abri-lo — aparece na lista e detalhes corretos.
- Cancelar cadastro — volta sem criar item.
- Abrir Sobre e compartilhar — chooser abre.
- Voltar repetidamente — sem telas duplicadas.

## Uso de IA
Utilizei [ferramenta] para revisar a arquitetura, identificar requisitos faltantes e revisar o código.
Correções feitas por mim: criação do `ContatoStore`, ajuste do `onSalvar` na navegação, validações no cadastro e `try/catch` no compartilhamento.

## Limitações
- Sem persistência após encerrar o processo (fora do escopo).
