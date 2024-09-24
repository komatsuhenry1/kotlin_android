package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.databinding.ActivityListaProdutosBinding
import br.com.alura.orgs.ui.dao.ProdutosDao
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter

class ListaProdutosActivity : AppCompatActivity() {

    val dao = ProdutosDao()
    private val adapter= ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())
    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        ConfiguraRecyclerView()
    }


    override fun onResume() {
        //ctrl + alt + m = tranforma em funcao
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
        configuraFab()

    }

    private fun configuraFab() {
        val fab = binding.acivityListaProdutosFloatingActionButton
//        val fab =
//            findViewById<FloatingActionButton>(R.id.acivity_lista_produtos_floatingActionButton) // passando a referencia pelo id do xml para a variavel fab (floatingactionbutton)
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        //qnd o botao é clicado, este escopo é executado
        //Intent é um obj que realiza uma ação, neste caso, abrindo outra activity
        val intent = Intent(
            this,
            FormularioProdutoActivity::class.java
        ) // this é o contexto atual (MainActivity), o resto refere a ação de abrir FormularioProdutoActivity
        startActivity(intent) // inicia FormularioProdutoActivity
    }

    private fun ConfiguraRecyclerView() {
        val recyclerView = binding.acivityListaProdutosRecyclerView
        //val recyclerView = findViewById<RecyclerView>(R.id.acivity_lista_produtos_recyclerView)
        recyclerView.adapter = adapter
    }
}
