package com.example.receitas

// Objeto único que guarda os dados simulados (mocks).
// Não usa API nem banco de dados: as receitas ficam em memória.
object RepositorioReceitas {

    // Lista fixa com as receitas exibidas no app
    val listaReceitas: List<Receita> = listOf(
        Receita(
            id = 1,
            nome = "Bolo de Cenoura",
            categoria = "Sobremesa",
            tempoPreparoMinutos = 60,
            ingredientes = listOf(
                "3 cenouras médias",
                "3 ovos",
                "1 xícara de óleo",
                "2 xícaras de açúcar",
                "2 xícaras de farinha de trigo",
                "1 colher de sopa de fermento"
            ),
            modoPreparo = "Bata no liquidificador as cenouras, os ovos e o óleo. " +
                "Misture com o açúcar e a farinha, junte o fermento e asse a 180 °C por 40 minutos.",
            observacao = "Para a cobertura, derreta chocolate com um pouco de leite."
        ),
        Receita(
            id = 2,
            nome = "Brigadeiro",
            categoria = "Doce",
            tempoPreparoMinutos = 20,
            ingredientes = listOf(
                "1 lata de leite condensado",
                "1 colher de sopa de manteiga",
                "2 colheres de sopa de chocolate em pó",
                "Chocolate granulado"
            ),
            modoPreparo = "Cozinhe o leite condensado, a manteiga e o chocolate em fogo baixo, " +
                "mexendo até soltar do fundo da panela. Espere esfriar, enrole e passe no granulado."
        ),
        Receita(
            id = 3,
            nome = "Arroz Carreteiro",
            categoria = "Prato principal",
            tempoPreparoMinutos = 45,
            ingredientes = listOf(
                "2 xícaras de arroz",
                "300 g de carne seca dessalgada",
                "1 cebola picada",
                "2 dentes de alho",
                "Cheiro-verde a gosto"
            ),
            modoPreparo = "Refogue a carne com a cebola e o alho. Junte o arroz, " +
                "cubra com água quente e cozinhe até secar. Finalize com cheiro-verde.",
            observacao = "Deixe a carne seca de molho na noite anterior, trocando a água algumas vezes."
        ),
        Receita(
            id = 4,
            nome = "Pão de Queijo",
            categoria = "Lanche",
            tempoPreparoMinutos = 40,
            ingredientes = listOf(
                "500 g de polvilho azedo",
                "1 xícara de leite",
                "1/2 xícara de óleo",
                "2 ovos",
                "200 g de queijo meia cura ralado",
                "Sal a gosto"
            ),
            modoPreparo = "Ferva o leite com o óleo e o sal e escalde o polvilho. " +
                "Quando amornar, junte os ovos e o queijo, faça bolinhas e asse a 200 °C por 25 minutos."
        ),
        Receita(
            id = 5,
            nome = "Feijoada",
            categoria = "Prato principal",
            tempoPreparoMinutos = 180,
            ingredientes = listOf(
                "1 kg de feijão preto",
                "500 g de costelinha de porco",
                "300 g de linguiça calabresa",
                "200 g de bacon",
                "1 cebola",
                "4 dentes de alho",
                "Folhas de louro"
            ),
            modoPreparo = "Cozinhe o feijão com o louro. Frite o bacon, a linguiça e a costelinha, " +
                "refogue a cebola e o alho e junte tudo ao feijão. Cozinhe em fogo baixo por 1 hora.",
            observacao = "Sirva com arroz, couve refogada, farofa e laranja."
        ),
        Receita(
            id = 6,
            nome = "Salada Tropical",
            categoria = "Entrada",
            tempoPreparoMinutos = 15,
            ingredientes = listOf(
                "1 pé de alface",
                "1 manga em cubos",
                "1 tomate",
                "Azeite, limão e sal a gosto"
            ),
            modoPreparo = "Lave e rasgue a alface, junte a manga e o tomate em cubos " +
                "e tempere com azeite, limão e sal na hora de servir."
        )
    )

    // Procura uma receita pelo id; devolve null se não encontrar
    fun buscarReceitaPorId(id: Int): Receita? {
        return listaReceitas.find { receita -> receita.id == id }
    }
}
