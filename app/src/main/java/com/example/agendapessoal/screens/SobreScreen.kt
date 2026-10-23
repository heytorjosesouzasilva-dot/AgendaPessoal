package com.example.agendapessoal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import android.content.Intent
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SobreScreen(
    onVoltar: () -> Unit

) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sobre Agenda Pessoal") },
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

            Text(
                textAlign = TextAlign.Center,
                text = "Aplicativo desenvolvido para facilitar a organização de compromissos, tarefas e lembretes do dia a dia." +
                        "\nAutores: Heytor José de Souza Silva e Heitor Oliveira Dias." +
                        "\nVersão: 1.0"
            )
            Button(onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(
                        Intent.EXTRA_TEXT,
                        "Conheça o Agenda Pessoal!"
                    )
                }
                context.startActivity(
                    Intent.createChooser(intent, "Compartilhar usando")
                )
            }) {
                Text("Compartilhar")
            }
        }
    }
}