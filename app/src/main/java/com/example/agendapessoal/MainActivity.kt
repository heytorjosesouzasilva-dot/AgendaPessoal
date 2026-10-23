package com.example.agendapessoal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.agendapessoal.navigation.AppNavigation
import com.example.agendapessoal.ui.theme.AgendaPessoalTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite que o app desenhe utilizando toda a área disponível da tela.
        enableEdgeToEdge()

        // setContent inicia a interface construída com Jetpack Compose.
        setContent {
            AgendaPessoalTheme {
                // A MainActivity não precisa conter todas as telas.
                // Ela apenas inicia a navegação principal do aplicativo.
                AppNavigation()
            }
        }
    }
}