package com.example.agendapessoal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesScreen(
    contatoId: Int,
    onVoltar: () -> Unit
) {

    // Simulamos a busca do contato pelo ID recebido.
    // Em um aplicativo real, a consulta poderia ocorrer em
    // um repositório, banco de dados ou ViewModel.
    val contato = when (contatoId) {
        1 -> Contato(1, "Ana", "(27) 99999-1111")
        2 -> Contato(2, "Bruno", "(27) 99999-2222")
        3 -> Contato(3, "Carlos", "(27) 99999-3333")
        else -> Contato(0, "Contato não encontrado", "-")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes") },
                navigationIcon = {
                    TextButton(onClick = onVoltar) {
                        Text("Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("ID recebido pela navegação: $contatoId")
            Text("Nome: ${contato.nome}")
            Text("Telefone: ${contato.telefone}")
        }
    }
}