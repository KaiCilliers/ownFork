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
    // toDO [E0-002] [this_is_a_title_without_spaces] a helpful description
    // TODO [E0-002] [this_is_a_title_without_spaces_AGAIN] a helpful description
    // TODO [E02-002] [sigh_this_is_a_title_without_spaces_AGAIN] a helpful description here we are agiang
    // TODO [E02-002] [sigh_this_is_a_title_without_spaces_AGAIN] a helpful description here we are agiang
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    // TODO standard
    // TODO standardv2
    // TODO standardv3
    // TODO standardv3g
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
    // TODO [E01-037] [CoolTitleasdnasdas] When we call onDestroy we need to say goodbye v2
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
        // TODO [E02-002] [FROM_HOTFIX] yaya
        // TODO [E02-002] [FROM_HOTFIX_v2] yaya
        // TODO [E02-002] [FROM_HOTFIX_v3] yaya
        // TODO [E02-002] [i_solved_a_hotfix] yaya
        // TODO [E02-002] [v2_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v3_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v13_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v6_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v7_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v10_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v11_i_solved_a_hotfix] yaya
        // TODO [E02-002] [v12_i_solved_a_hotfix] yaya
        // TODO NORMAL
        println("")
    }
}