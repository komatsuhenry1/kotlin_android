package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.ui.dao.ProdutosDao
import br.com.alura.orgs.ui.model.Produtos
import java.math.BigDecimal

class FormularioProdutoActivity :
    AppCompatActivity(R.layout.activity_formulario_produto) { // (androidx) appcompat é a importação das classes e bibliotecas do android SDK sem dar erro de compatibilidade de versão
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.activity_formulario_produto_botao_salvar) //busca id botao_salvar e armazena referencia na variavel botaoSalvar
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            //tudo que estiver neste escopo sera executado quando o botao for clicado
            val produtosNovo = criaProduto()
            dao.adiciona(produtosNovo)
            finish()

        }
    }

    private fun criaProduto(): Produtos {
        val campoNome =
            findViewById<EditText>(R.id.activity_formulario_produto_nome) //procura id nome no xml e adiciona a referencia(campos)  na variavel campoNome
        val nome =
            campoNome.text.toString() // pega o valor que o usuário digitou no EditText, transforma em String e armazena na variavel nome
        val campoDescricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao) //repete
        val descricao = campoDescricao.text.toString() //repete
        val campoValor = findViewById<EditText>(R.id.activity_formulario_produto_valor) //repete
        val valorEmTexto = campoValor.text.toString() //repete
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produtos(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}
