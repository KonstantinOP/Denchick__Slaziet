package com.example.denchickslaziet.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.denchickslaziet.viewmodel.InputViewModel

@Composable
fun InputScreen(
    viewModel: InputViewModel,
    onValidInput: (Int) -> Unit
) {
    val input by viewModel.input.collectAsState()
    val showDialog by viewModel.showDialog.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = input,
            onValueChange = { viewModel.onInputChange(it) },
            label = { Text("Введите число от 1 до 1000") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { viewModel.onConfirm(onValidInput) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Подтвердить")
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { viewModel.dismissDialog() },
            title = { Text("Ошибка") },
            text = { Text("Введите число от 1 до 1000") },
            confirmButton = {
                TextButton(onClick = { viewModel.dismissDialog() }) {
                    Text("Ок")
                }
            }
        )
    }
}
