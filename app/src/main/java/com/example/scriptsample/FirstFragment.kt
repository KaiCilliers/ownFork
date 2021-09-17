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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        // TODO [E02-002] [FROM_HOTFIX] yaya
        // TODO [E02-002] [i_solved_a_hotfix] yaya
        // TODO [E02-002] [v2_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v3_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v6_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v7_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v10_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v11_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v12_i_solved_a_hotfix] yaya
        // TODO NORMAL
        println("")
    }
}