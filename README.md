# Receitas

App Android de receitas culinárias, feito para a etapa Parcial da disciplina Programação Mobile 1.

## Objetivo

Mostrar uma lista de receitas e, ao tocar em uma delas, abrir uma segunda tela com os detalhes: categoria, tempo de preparo, ingredientes, modo de preparo e, quando existir, uma observação. Na tela de detalhes, o botão **Favoritar** muda o texto e o status exibido, e o estado é mantido ao girar a tela.

Os dados são simulados (mocks) no objeto `RepositorioReceitas`. Não há API nem banco de dados.

## Como rodar localmente

Requisito: Android Studio recente. O projeto usa `compileSdk 37`; se faltar o SDK, o Gradle Sync oferece baixar automaticamente.

1. Abra o Android Studio e escolha **File > Open**, selecionando esta pasta (`receitas`).
2. Aguarde o **Gradle Sync** terminar (ou clique em **Sync Project with Gradle Files**).
3. Escolha um dispositivo:
   - **Emulador:** crie um em **Device Manager** (API 24 ou superior).
   - **Celular:** ative as *Opções do desenvolvedor* e a *Depuração USB* e conecte via cabo.
4. Clique em **Run 'app'** (▶).

Pelo terminal também é possível gerar o APK de debug:

```bash
./gradlew assembleDebug
```

## Bibliotecas externas

| Biblioteca | Para que serve no app |
| --- | --- |
| `androidx.recyclerview:recyclerview` | Exibe a lista de receitas de forma eficiente, reaproveitando as linhas ao rolar. |
| `androidx.appcompat:appcompat` | Fornece a `AppCompatActivity`, base das duas telas, com compatibilidade para versões antigas do Android. |
| `com.google.android.material:material` | Tema Material 3 e componentes visuais, como os botões e os estilos de texto. |

Também são usadas `core-ktx` e `activity-ktx` (utilitários do Android, como `enableEdgeToEdge` e o tratamento das barras do sistema), que já vêm no projeto padrão.

## Estrutura de pastas

```
receitas/
├── app/
│   ├── build.gradle.kts              # Configuração do módulo (ViewBinding e dependências)
│   └── src/main/
│       ├── AndroidManifest.xml       # Registro da MainActivity e da DetalheActivity
│       ├── java/com/example/receitas/
│       │   ├── MainActivity.kt       # Tela 1: lista de receitas
│       │   ├── DetalheActivity.kt    # Tela 2: detalhes e botão de favoritar
│       │   ├── ReceitaAdapter.kt     # Adapter do RecyclerView
│       │   ├── Receita.kt            # Data class do modelo
│       │   └── RepositorioReceitas.kt# Dados simulados (mocks)
│       └── res/
│           ├── drawable/ic_receita.xml   # Ícone vetorial da receita
│           ├── layout/
│           │   ├── activity_main.xml     # Layout da lista
│           │   ├── activity_detalhe.xml  # Layout dos detalhes
│           │   └── item_receita.xml      # Layout de cada item da lista
│           └── values/
│               ├── strings.xml           # Todos os textos da interface
│               └── dimens.xml            # Espaçamentos e tamanhos
├── gradle/libs.versions.toml         # Versões das bibliotecas
└── README.md
```
