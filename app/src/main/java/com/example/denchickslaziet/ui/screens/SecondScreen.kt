package com.example.denchickslaziet.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.denchickslaziet.R

@Composable
fun SecondScreen(onBackClick: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .padding(top = 120.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("this second activity", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(160.dp))
        Button(onClick = { onBackClick?.invoke() }) {
            Text("back to first activity", fontSize = 30.sp)
        }
    }
}

@Composable
fun ShowDialogScreen() {
    var showDialog by remember { mutableStateOf(false) }
    ShowDialogContent(showDialog = showDialog, onDialogChange = { showDialog = it })
}

@Composable
fun ShowDialogContent(showDialog: Boolean, onDialogChange: (Boolean) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onDialogChange(true) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(stringResource(R.string.button_text))
        }
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { onDialogChange(false) },
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(stringResource(R.string.dialog_title), fontSize = 20.sp)
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(R.string.dialog_clouse),
                            modifier = Modifier
                                .size(20.dp)
                                .clickable { onDialogChange(false) }
                        )
                    }
                },
                text = { Text(stringResource(R.string.dialog_message)) },
                confirmButton = {
                    Button(onClick = { onDialogChange(false) }) {
                        Text(stringResource(R.string.dialog_confirm))
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SecondScreenPreview() {
    SecondScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowDialogPreview() {
    ShowDialogScreen()
}
