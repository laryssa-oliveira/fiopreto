package com.example.fiopreto.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fiopreto.PostTips
import com.example.fiopreto.R
import com.example.fiopreto.presentation.TipsViewModel
import com.example.fiopreto.presentation.ViewState
import com.google.android.material.button.MaterialButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class TipsFragment : Fragment() {

    private val adapter by lazy { PostTipsAdapter(::clickItem) }
    private lateinit var recyclerView: RecyclerView
    private val tipsViewModel by viewModel<TipsViewModel>()
    private lateinit var buttonUpload: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tips, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerViewTips)
        recyclerView.adapter = adapter
        tipsViewModel.getPostsTips()
        buttonUpload = view.findViewById(R.id.buttonTips)


        setObservers()
        //setImageContent()
        buttonUpload.setOnClickListener {
            val intent = Intent(context, UploadTipsActivity::class.java)
            startActivity(intent)
        }
    }


    private fun setObservers() {
        tipsViewModel.postTipsListLiveData.observe(viewLifecycleOwner, {
            when(it.state) {

                ViewState.State.SUCCESS -> onSuccess(it.data ?: listOf<PostTips>())
                ViewState.State.ERROR -> onResultError(it.error)
                //ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })
    }

    private fun onSuccess(list: List<PostTips>){
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

    /*private fun configureView() {
        namePerson.text = args.name
        namePerson.movementMethod = ScrollingMovementMethod()
        //companyName.text = args.name
        //descriptionCompany.text = args.description
        //descriptionCompany.movementMethod = ScrollingMovementMethod()
        setImageContent()
    }


    private fun setImageContent() {
        Glide
            .with(this)
            .load("https://thispersondoesnotexist.com/image")
            .placeholder(R.drawable.logo)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .into(imageView)
    }*/


    private fun clickItem(postFeed: PostTips) {

    }


}

