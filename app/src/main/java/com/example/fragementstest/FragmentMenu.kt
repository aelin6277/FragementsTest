package com.example.fragementstest

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragementstest.databinding.FragmentMenuBinding

class FragmentMenu : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    private var communicator: FragmentCommunicator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = context as? FragmentCommunicator
            ?: throw RuntimeException("$context must implement FragmentCommunicator")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSquare.setOnClickListener {
            communicator?.passDataToFragmentB("Draw squares")
        }
        binding.buttonTriangle.setOnClickListener {
            communicator?.passDataToFragmentB("Draw triangles")
        }
        binding.buttonCircle.setOnClickListener {
            communicator?.passDataToFragmentB("Draw circles")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}