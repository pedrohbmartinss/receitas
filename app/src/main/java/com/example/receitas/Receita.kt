package com.example.receitas

// Modelo imutável de uma receita (todos os campos são "val").
// A observação é opcional: pode ser nula quando a receita não tem dica extra.
data class Receita(
    val id: Int,
    val nome: String,
    val categoria: String,
    val tempoPreparoMinutos: Int,
    val ingredientes: List<String>,
    val modoPreparo: String,
    val observacao: String? = null
)
