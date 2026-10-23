package com.example.agendapessoal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.agendapessoal.screens.CadastroScreen
import com.example.agendapessoal.screens.DetalhesScreen
import com.example.agendapessoal.screens.HomeScreen
import com.example.agendapessoal.screens.SobreScreen

// Centralizamos os nomes das rotas para evitar strings espalhadas pelo projeto.
object Routes {
    const val HOME = "home"
    const val CADASTRO = "cadastro"
    const val DETALHES = "detalhes"
    const val  SOBRE = "sobre"
}

@Composable
fun AppNavigation() {

    // O NavController é o "controlador de trânsito" entre as telas.
    // Ele sabe qual destino está sendo exibido e mantém a back stack.
    val navController = rememberNavController()

    // O NavHost define:
    // 1) qual controlador será usado;
    // 2) qual é a tela inicial;
    // 3) quais destinos existem no aplicativo.
    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        // Rota da primeira tela.
        composable(Routes.HOME) {
            HomeScreen(
                onCadastrar = {
                    // navigate adiciona um novo destino à back stack.
                    navController.navigate(Routes.CADASTRO)
                },
                onVerDetalhes = { contatoId ->
                    // Passamos somente o ID do contato na rota.
                    navController.navigate("${Routes.DETALHES}/$contatoId")
                },
                onSobre = {
                    navController.navigate(Routes.SOBRE)
                }
            )
        }

        // Rota da segunda tela.
        composable(Routes.CADASTRO) {
            CadastroScreen(
                onVoltar = {
                    // Remove a tela atual da pilha e volta para a anterior.
                    navController.popBackStack()
                },
                onSalvar = {
                    // Neste exemplo didático não persistiremos dados.
                    // Depois de "salvar", voltamos para a Home.
                    navController.popBackStack()
                }
            )
        }

        // A rota possui um argumento chamado "id".
        composable(
            route = "${Routes.DETALHES}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            // Recuperamos o argumento enviado pela tela anterior.
            val contatoId =
                backStackEntry.arguments?.getInt("id") ?: 0

            DetalhesScreen(
                contatoId = contatoId,
                onVoltar = {
                    navController.popBackStack()
                }
            )
        }
        composable(Routes.SOBRE){
            SobreScreen (
                 onVoltar = {
                     navController.popBackStack()
                 }
            )
        }
    }
}