package media.backpack.simplebuttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
        }
    }
}

@Composable
fun MainView() {
    var times  = remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp),
            text = "Button hit: ${times.value}"
        )
        Spacer(modifier = Modifier.size(10.dp))
        Row (Modifier
            .align(alignment = CenterHorizontally)){
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = { times.value += 1 }
            ) {
                Text(text = "+")
            }
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = { times.value -= 1 }
            ) {
                Text(text = "-")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainView()
}