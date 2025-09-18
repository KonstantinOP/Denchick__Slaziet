package com.example.denchickslaziet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
class SecondFragment : Fragment(){
    companion object{
        private const val ARG_NUMBER = "agr_number"
        fun newInstance(number : Int): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_NUMBER, number)}
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val number = arguments?.getInt(ARG_NUMBER) ?: 0
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    SecondScreen(
                        number = number,
                        onBack = {
                            parentFragmentManager.popBackStack() }
                    )
                }
            }
        }
    }
}
@Composable
fun SecondScreen(
    number: Int,
    onBack : () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Вы ввели число $number",
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(Modifier.height(32.dp))
            Button(
                onClick = onBack) {
                Text("Назад")
            }
        }
    }
}