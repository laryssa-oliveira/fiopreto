package com.example.fiopreto.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.fiopreto.R
import com.example.fiopreto.data.remote.postSalon.Cities
import kotlinx.android.synthetic.main.fragment_find_salon.*

class FindSalonFragment : Fragment() {

    private lateinit var spinner: Spinner
    private lateinit var button: AppCompatButton
    //private lateinit var arrayAdapter:

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_find_salon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner = view.findViewById(R.id.cities_salon)
        button = view.findViewById(R.id.search_salon)

        button.setOnClickListener{
            findNavController().navigate(
                FindSalonFragmentDirections.actionFindSalonFragmentToSalonFragment()
            )
        }

    }
}
