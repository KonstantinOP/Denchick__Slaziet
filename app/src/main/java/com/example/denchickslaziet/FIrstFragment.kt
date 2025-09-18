package com.example.denchickslaziet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
class FIrstFragment : Fragment() {
    private val viewModel: InputViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    InputScreen(
                        viewModel = viewModel,
                        onValidInput = { number ->
                            parentFragmentManager.beginTransaction()
                                .replace(
                                    R.id.fragment_container,
                                    SecondFragment.newInstance(number)
                                )
                                .addToBackStack(null)
                                .commit()
                        }
                    )
                }
            }
        }
    }
}
@Composable
fun InputScreen(
    viewModel: InputViewModel,
    onValidInput : (Int) -> Unit
){
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
            onValueChange = {
                viewModel.onInputChange(it) },
            label = {
                Text("Введите число от 1 до 1000")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.onConfirm(onValidInput) },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("Подтвердить")
        }
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                viewModel.dismissDialog() },
            title = {
                Text("Ошибка") },
            text = {
                Text("Введите число от 1 до 1000")},
            confirmButton = {
                TextButton(onClick = {
                    viewModel.dismissDialog() }) {
                    Text("Ок")
                }
            }
        )
    }
}