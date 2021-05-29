package com.example.fiopreto.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fiopreto.PostSalon
import com.example.fiopreto.R
import com.example.fiopreto.presentation.SalonViewModel
import com.example.fiopreto.presentation.ViewState
import com.google.android.material.button.MaterialButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class SalonFragment : Fragment() {

    private val adapter by lazy { SalonAdapter(::clickItem) }
    private lateinit var recyclerView: RecyclerView
    private val salonViewModel by viewModel<SalonViewModel>()
    private lateinit var button: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_salon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewSalon)
        recyclerView.adapter = adapter
        salonViewModel.getPostSalon()
        //button = view.findViewById(R.id.buttonSchedule)

        setObservers()
        /*button.setOnClickListener {
            //val intent = Intent(context, UploadFeedActivity::class.java)
            //startActivity(intent)
        }*/
    }

    private fun setObservers() {
        salonViewModel.postSalonListLiveData.observe(viewLifecycleOwner, {
            when (it.state) {

                ViewState.State.SUCCESS -> onSuccess(it.data ?: listOf<PostSalon>())
                ViewState.State.ERROR -> onResultError(it.error)
                //ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })
    }

    private fun onSuccess(list: List<PostSalon>) {
        adapter.setItems(list)

    }

    /*
    private fun onLoading(loading: Boolean) {
        if(loading)
            loadingGroup.visibility = View.VISIBLE
        else
            loadingGroup.visibility = View.GONE

    }*/

    private fun onResultError(error: Throwable?) {
        Toast.makeText(requireContext(), error?.message ?: "", Toast.LENGTH_LONG).show()
    }

    private fun clickItem(postSalon: PostSalon) {

    }

}