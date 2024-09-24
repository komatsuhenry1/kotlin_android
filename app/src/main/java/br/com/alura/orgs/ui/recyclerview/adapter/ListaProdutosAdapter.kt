package br.com.alura.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.ui.model.Produtos

class ListaProdutosAdapter(
    private val context : Context,
    produtos : List<Produtos>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos =  produtos.toMutableList()

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun vincula(produto: Produtos) {
            val nome = itemView.findViewById<TextView>(R.id.activity_formulario_produto_nome)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.activity_formulario_produto_descricao)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.activity_formulario_produto_valor)
            valor.text = produto.valor.toPlainString()
        }
    }

    //cria uma viewHolder, transforma o produto_item.xml para uma View,
    //essa view é passada para o viewHolder, e o viewHolder é passado para a recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { // separa cada item da recyler view em um ViewHolder
        val inflater = LayoutInflater.from(context) // Layout inflatter tranforma o layout em uma View
        val view = inflater.inflate(R.layout.produto_item, parent, false) // val view recebe o layout de produto_item e transforma o xml em uma view
        return ViewHolder(view) // retorna para a viewHolder, o produto_item.xml como uma view
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {  // indica qual viewHolder estamos, qual item da lista estamos localizados e o que faremos com esta informaçao
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size// retorna quantos itens teremos nessa lista

    fun atualiza(produtos: List<Produtos>) {
        this.produtos.clear() // Limpa a lista atual
        this.produtos.addAll(produtos) // Adiciona os novos itens
        notifyDataSetChanged() // Notifica o RecyclerView sobre as mudanças
    }


}
