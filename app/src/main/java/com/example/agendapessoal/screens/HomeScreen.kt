package com.example.agendapessoal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Modelo simples usado apenas para o exemplo.
data class Contato(
    val id: Int,
    val nome: String,
    val telefone: String
)

// Dados simulados.
// Em uma unidade futura eles poderiam vir de banco de dados ou API.
private val contatos = listOf(
    Contato(1, "Ana", "(27) 99999-1111"),
    Contato(2, "Bruno", "(27) 99999-2222"),
    Contato(3, "Carlos", "(27) 99999-3333")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    // A tela não precisa conhecer o NavController.
    // Ela apenas informa que determinados eventos ocorreram.
    onCadastrar: () -> Unit,
    onVerDetalhes: (Int) -> Unit,
    onSobre: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Agenda Pessoal") }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text("Meus contatos")

            Button(
                onClick = onCadastrar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cadastrar novo contato")
            }

            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(contatos) { contato ->

                    Card(
                        // Ao clicar no card, enviamos apenas o ID.
                        onClick = {
                            onVerDetalhes(contato.id)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(contato.nome)
                            Text(contato.telefone)
                            Text("Toque para ver detalhes")
                        }
                    }
                }
            }
            Button(
                onClick = onSobre,
                modifier = Modifier.fillMaxWidth()
            ) {Text("SOBRE")}
        }
    }
}