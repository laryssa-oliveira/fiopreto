package com.example.fiopreto.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fiopreto.PostFeed
import com.example.fiopreto.R
import com.example.fiopreto.presentation.FeedViewModel
import com.example.fiopreto.presentation.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {

    private val adapter by lazy { PostFeedAdapter(::clickItem) }
    private lateinit var recyclerView: RecyclerView
    private val feedViewModel by viewModel<FeedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewFeed)
        recyclerView.adapter = adapter
        feedViewModel.getPostsFeed()

        setObservers()
    }


    private fun setObservers() {
        feedViewModel.postFeedListLiveData.observe(viewLifecycleOwner, {
            when(it.state) {

                ViewState.State.SUCCESS -> onSuccess(it.data ?: listOf<PostFeed>())
                ViewState.State.ERROR -> onResultError(it.error)
                //ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })
    }

    private fun onSuccess(list: List<PostFeed>){
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
        Toast.makeText(requireContext(), error?.message?: "", Toast.LENGTH_LONG).show()
    }


    private fun clickItem(postFeed: PostFeed) {

    }
}