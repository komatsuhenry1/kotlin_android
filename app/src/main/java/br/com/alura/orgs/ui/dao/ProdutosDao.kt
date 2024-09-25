package br.com.alura.orgs.ui.dao

import br.com.alura.orgs.ui.model.Produtos
import java.math.BigDecimal

class ProdutosDao {

    fun adiciona(produto: Produtos) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produtos> {
        return produtos.toList()
    }

    companion object {
        val produtos = mutableListOf<Produtos>(
            Produtos(
                nome = "Salada de frutas",
                descricao = "Laranja, maçâ e uvas.",
                valor = BigDecimal("19.83")
            )
        )
    }

}