package br.com.alura.orgs.ui.dao

import br.com.alura.orgs.ui.model.Produtos

class ProdutosDao {

    fun adiciona(produto : Produtos){
        produtos.add(produto)
    }

    fun buscaTodos() : List<Produtos>{
        return produtos.toList()
    }

    companion object {
        val produtos = mutableListOf<Produtos>()
    }

}