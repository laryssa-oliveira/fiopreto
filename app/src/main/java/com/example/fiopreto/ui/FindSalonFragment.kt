package com.example.fiopreto.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


import com.example.fiopreto.Cities
import com.example.fiopreto.R
import com.example.fiopreto.presentation.FindSalonViewModel
import com.example.fiopreto.presentation.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class FindSalonFragment : Fragment() {

    private lateinit var spinner: Spinner
    private lateinit var button: AppCompatButton
    private val findSalonViewModel by viewModel<FindSalonViewModel>()

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
        findSalonViewModel.getCities()
        /*val adapter = ArrayAdapter.createFromResource(requireContext(), android.R.layout.simple_spinner_item, user)
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        spinner.adapter = adapter*/

        setObservers()

        //spinner.adapter = adapter
        //(spinner.selectedItem as Cities).ibge

        button.setOnClickListener{
            val ibge = (spinner.selectedItem as Cities).ibge

            findNavController().navigate(
                FindSalonFragmentDirections.actionFindSalonFragmentToSalonFragment(ibge)
            )

        }

    }

    private fun setObservers() {
        findSalonViewModel.findSalonListLiveData.observe(viewLifecycleOwner, {
            when(it.state) {

                ViewState.State.SUCCESS -> onSuccess(it.data ?: listOf<Cities>())
                ViewState.State.ERROR -> onResultError(it.error)
                //ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })
    }

    private fun onSuccess(list: List<Cities>){
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, list)
        spinner.adapter = adapter

    }

    private fun onResultError(error: Throwable?) {
        Toast.makeText(requireContext(), error?.message?: "", Toast.LENGTH_LONG).show()
    }
}
