package com.example.scriptsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.scriptsample.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // TODO Call setup when creating view
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // TODO Call setup when creating view v2
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }
    // TODO [E01-037] [Cool Title] When we call onDestroy we need to say goodbye v2
    // TODO [E01-037] [Cool Titleasdnasdas] When we call onDestroy we need to say goodbye v2
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    // TODO [E01-037] [**Cool Title :)**] When we call onDestroy we need to say goodbye
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}