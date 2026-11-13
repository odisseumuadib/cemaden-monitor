
package br.com.cemadenmonitor.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.cemadenmonitor.app.ui.theme.CEMADENMonitorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CEMADENMonitorTheme {
                MonitorScreen()
            }
        }
    }
}

@Composable
fun MonitorScreen() {
    var coverage by remember { mutableStateOf("Estado") }
    var hydrological by remember { mutableStateOf(true) }
    var landslide by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            Text(
                text = "Monitor CEMADEN",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(20.dp)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Cobertura geográfica",
                style = MaterialTheme.typography.titleMedium
            )

            listOf("Estado", "Regiões", "Municípios").forEach { option ->
                Row {
                    RadioButton(
                        selected = coverage == option,
                        onClick = { coverage = option }
                    )
                    Text(
                        text = option,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                }
            }

            HorizontalDivider()

            Text(
                "Tipos de alerta",
                style = MaterialTheme.typography.titleMedium
            )

            Row {
                Checkbox(
                    checked = hydrological,
                    onCheckedChange = { hydrological = it }
                )
                Text(
                    "Hidrológico",
                    modifier = Modifier.padding(top = 12.dp)
                )
            }

            Row {
                Checkbox(
                    checked = landslide,
                    onCheckedChange = { landslide = it }
                )
                Text(
                    "Movimento de massa",
                    modifier = Modifier.padding(top = 12.dp)
                )
            }

            HorizontalDivider()

            Text(
                "Configurações iniciais",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                "Cobertura selecionada: $coverage"
            )

            Text(
                "As preferências ainda não são salvas."
            )
        }
    }
}
