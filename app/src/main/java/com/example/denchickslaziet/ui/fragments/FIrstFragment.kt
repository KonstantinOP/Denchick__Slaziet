package com.example.denchickslaziet.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.denchickslaziet.R
import com.example.denchickslaziet.ui.screens.InputScreen
import com.example.denchickslaziet.viewmodel.InputViewModel

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
                            openSecondFragment(number)
                        }
                    )
                }
            }
        }
    }

    private fun openSecondFragment(number: Int) {
        parentFragmentManager.beginTransaction()
            .replace(
                R.id.fragment_container,
                SecondFragment.newInstance(number)
            )
            .addToBackStack(null)
            .commit()
    }
}
