package com.example.agendapessoal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(
    onVoltar: () -> Unit,
    onSalvar: () -> Unit
) {

    // rememberSaveable mantém estes valores durante recomposições
    // e consegue restaurar tipos simples em várias recriações da Activity.
    var nome by rememberSaveable {
        mutableStateOf("")
    }

    var telefone by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Novo contato") },
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

            OutlinedTextField(
                value = nome,
                onValueChange = {
                    // Quando o usuário digita, o estado muda.
                    // O Compose recompõe a parte necessária da interface.
                    nome = it
                },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = telefone,
                onValueChange = {
                    telefone = it
                },
                label = { Text("Telefone") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = onSalvar,
                // Validação simples apenas para fins didáticos.
                enabled = nome.isNotBlank() &&
                        telefone.isNotBlank(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Salvar")
            }

            Text(
                "Nesta prática o cadastro é apenas demonstrativo: " +
                        "os dados não serão gravados permanentemente."
            )
        }
    }
}