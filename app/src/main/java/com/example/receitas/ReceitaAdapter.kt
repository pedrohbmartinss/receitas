package com.example.receitas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.receitas.databinding.ItemReceitaBinding

// Adapter: liga a lista de receitas às linhas do RecyclerView.
// "aoClicarReceita" é a função chamada quando o usuário toca em um item.
class ReceitaAdapter(
    private val receitas: List<Receita>,
    private val aoClicarReceita: (Receita) -> Unit
) : RecyclerView.Adapter<ReceitaAdapter.ReceitaViewHolder>() {

    // ViewHolder: guarda o binding de uma linha para ser reaproveitado
    class ReceitaViewHolder(val ligacao: ItemReceitaBinding) :
        RecyclerView.ViewHolder(ligacao.root)

    // Cria uma nova linha a partir do layout item_receita.xml
    override fun onCreateViewHolder(pai: ViewGroup, tipoView: Int): ReceitaViewHolder {
        val ligacao = ItemReceitaBinding.inflate(LayoutInflater.from(pai.context), pai, false)
        return ReceitaViewHolder(ligacao)
    }

    // Preenche a linha com os dados da receita da posição informada
    override fun onBindViewHolder(holder: ReceitaViewHolder, posicao: Int) {
        val receita = receitas[posicao]
        val contexto = holder.itemView.context

        holder.ligacao.textoNomeReceita.text = receita.nome
        holder.ligacao.textoCategoriaReceita.text = receita.categoria
        holder.ligacao.textoTempoReceita.text =
            contexto.getString(R.string.tempo_preparo, receita.tempoPreparoMinutos)

        // Ao tocar na linha, avisa a tela qual receita foi escolhida
        holder.ligacao.root.setOnClickListener { aoClicarReceita(receita) }
    }

    // Quantidade de itens da lista
    override fun getItemCount(): Int = receitas.size
}
