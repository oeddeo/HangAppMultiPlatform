package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import components.NavigationIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    onBackClick: () -> Unit = {},
    onNextClick: (String) -> Unit = {},
    answer: String,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(answer) },
                navigationIcon = { NavigationIcon(onClick = { onBackClick() }) }
            )
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text("Nothing to see")
        }
    }
}
