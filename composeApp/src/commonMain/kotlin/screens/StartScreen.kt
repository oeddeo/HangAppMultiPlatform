package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.sample.library.resources.Res
import me.sample.library.resources.select_location
import me.sample.library.resources.start_screen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import viewModels.StartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(onNextClick: (String) -> Unit = {}) {

    val viewModel = StartViewModel()
    val uiState by viewModel.uiState.collectAsState()
    var isExpanded by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(Res.string.start_screen)) },
                navigationIcon = {}
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                DropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { isExpanded = false }) {
                    viewModel.countries().forEach { (name, flag) ->
                        DropdownMenuItem(
                            onClick = {
                                viewModel.updateCountry(name)
                                isExpanded = false
                            },
                            text = { Text(name) },
                            trailingIcon = {
                                Image(
                                    painter = painterResource(flag),
                                    contentDescription = "$flag flag",
                                    modifier = Modifier.size(50.dp).padding(end = 10.dp)
                                )
                            })
                    }
                }
            }
            Button(modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                onClick = { isExpanded = !isExpanded }) {
                Text(stringResource(Res.string.select_location))
            }


            Button(onClick = { onNextClick(uiState.currentCountry.name) }) {
                Text("${stringResource(Res.string.select_location)} ${uiState.currentCountry.name}")
            }
        }
    }
}

