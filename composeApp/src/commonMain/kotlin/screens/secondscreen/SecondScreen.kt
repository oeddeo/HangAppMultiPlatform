package screens.secondscreen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.NavigationIcon
import domain.extensions.koinViewModel
import me.sample.library.resources.Res
import me.sample.library.resources.select_location
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    onBackClick: () -> Unit = {},
    onNextClick: (String) -> Unit = {},
    answer: String,
) {
    val viewModel = koinViewModel<SecondScreenViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    var isExpanded by remember { mutableStateOf(false) }

    LaunchedEffect(answer) {
        viewModel.loadVisitors(answer)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(answer) },
                navigationIcon = { NavigationIcon(onClick = { onBackClick() }) }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Row(
                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                    .align(Alignment.CenterHorizontally)
            ) {

                DropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { isExpanded = false }) {
                    uiState.visitors?.forEach { visitor ->
                        DropdownMenuItem(
                            onClick = {
                                isExpanded = false
                            },
                            text = { Text(visitor.name) },
                            trailingIcon = {

                            })
                    }
                }
                Button(modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                    onClick = { isExpanded = !isExpanded }) {
                    Text(stringResource(Res.string.select_location))
                }
            }
        }
    }
}
