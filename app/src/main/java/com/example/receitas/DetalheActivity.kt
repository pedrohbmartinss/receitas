package com.example.receitas

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.receitas.databinding.ActivityDetalheBinding

// Tela 2: mostra os detalhes da receita escolhida na lista
class DetalheActivity : AppCompatActivity() {

    // Chaves usadas para passar e guardar dados
    companion object {
        const val CHAVE_ID_RECEITA = "id_receita"
        private const val CHAVE_ESTA_FAVORITA = "esta_favorita"
    }

    // Binding gerado a partir de activity_detalhe.xml
    private lateinit var ligacao: ActivityDetalheBinding

    // Estado do botão de favoritar
    private var estaFavorita = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ligacao = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(ligacao.root)

        // Respeita as barras do sistema (status e navegação)
        ViewCompat.setOnApplyWindowInsetsListener(ligacao.raizDetalhe) { view, insets ->
            val barrasSistema = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(barrasSistema.left, barrasSistema.top, barrasSistema.right, barrasSistema.bottom)
            insets
        }

        // Lê o id enviado pela MainActivity (-1 se não vier nada)
        val idReceita = intent.getIntExtra(CHAVE_ID_RECEITA, -1)
        val receita = RepositorioReceitas.buscarReceitaPorId(idReceita)

        // Se a receita não existir, avisa e fecha a tela
        if (receita == null) {
            Toast.makeText(this, R.string.receita_nao_encontrada, Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        mostrarReceita(receita)

        // Recupera o favorito depois de girar a tela (savedInstanceState não é nulo nesse caso)
        estaFavorita = savedInstanceState?.getBoolean(CHAVE_ESTA_FAVORITA) ?: false
        atualizarFavorito()

        // Ao tocar no botão, inverte o estado e atualiza a tela
        ligacao.botaoFavoritar.setOnClickListener {
            estaFavorita = !estaFavorita
            atualizarFavorito()
        }

        // Volta para a lista fechando esta tela
        ligacao.botaoVoltar.setOnClickListener { finish() }
    }

    // Preenche as Views com os dados da receita
    private fun mostrarReceita(receita: Receita) {
        ligacao.textoNomeDetalhe.text = receita.nome
        ligacao.textoCategoriaDetalhe.text = receita.categoria
        ligacao.textoTempoDetalhe.text = getString(R.string.tempo_preparo, receita.tempoPreparoMinutos)

        // Junta os ingredientes em um texto, um por linha, com marcador
        ligacao.textoIngredientes.text = receita.ingredientes.joinToString("\n") { ingrediente -> "• $ingrediente" }
        ligacao.textoModoPreparo.text = receita.modoPreparo

        // Observação é opcional: só mostra o bloco quando ela existe
        val observacao = receita.observacao
        if (observacao != null) {
            ligacao.textoObservacao.text = observacao
            ligacao.blocoObservacao.visibility = View.VISIBLE
        } else {
            ligacao.blocoObservacao.visibility = View.GONE
        }
    }

    // Atualiza o texto do botão e do status conforme o estado de favorito
    private fun atualizarFavorito() {
        if (estaFavorita) {
            ligacao.botaoFavoritar.setText(R.string.botao_desfavoritar)
            ligacao.textoStatusFavorito.setText(R.string.status_favorita)
        } else {
            ligacao.botaoFavoritar.setText(R.string.botao_favoritar)
            ligacao.textoStatusFavorito.setText(R.string.status_nao_favorita)
        }
    }

    // Guarda o estado antes da tela ser recriada (por exemplo, ao girar)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(CHAVE_ESTA_FAVORITA, estaFavorita)
    }
}
