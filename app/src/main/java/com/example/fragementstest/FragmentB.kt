package com.example.fragementstest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragementstest.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun displayReceivedData(message: String) {
        binding.messageTextView.text = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
