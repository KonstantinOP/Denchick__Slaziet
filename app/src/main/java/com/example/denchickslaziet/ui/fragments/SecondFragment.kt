package com.example.denchickslaziet.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.denchickslaziet.ui.screens.SecondScreen

class SecondFragment : Fragment() {
    companion object {
        private const val ARG_NUMBER = "agr_number"
        fun newInstance(number: Int): SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_NUMBER, number)
                }
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
                            parentFragmentManager.popBackStack()
                        }
                    )
                }
            }
        }
    }
}
