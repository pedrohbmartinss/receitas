package com.example.receitas

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.receitas.databinding.ActivityMainBinding

// Tela 1: mostra a lista de receitas
class MainActivity : AppCompatActivity() {

    // Binding gerado a partir de activity_main.xml (substitui o findViewById)
    private lateinit var ligacao: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Infla o layout pelo ViewBinding e define como conteúdo da tela
        ligacao = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ligacao.root)

        // Respeita as barras do sistema (status e navegação) com padding
        ViewCompat.setOnApplyWindowInsetsListener(ligacao.raizPrincipal) { view, insets ->
            val barrasSistema = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(barrasSistema.left, barrasSistema.top, barrasSistema.right, barrasSistema.bottom)
            insets
        }

        configurarLista()
    }

    // Prepara o RecyclerView com o Adapter e os dados do repositório
    private fun configurarLista() {
        ligacao.listaReceitas.layoutManager = LinearLayoutManager(this)
        ligacao.listaReceitas.adapter = ReceitaAdapter(RepositorioReceitas.listaReceitas) { receita ->
            abrirDetalhe(receita)
        }
    }

    // Abre a tela de detalhes com Intent explícita, enviando o id da receita
    private fun abrirDetalhe(receita: Receita) {
        val intencao = Intent(this, DetalheActivity::class.java)
        intencao.putExtra(DetalheActivity.CHAVE_ID_RECEITA, receita.id)
        startActivity(intencao)
    }
}
