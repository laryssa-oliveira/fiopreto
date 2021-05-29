package com.example.fiopreto.ui

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.fiopreto.PostFeed
import com.example.fiopreto.R
import com.example.fiopreto.presentation.FeedViewModel
import com.example.fiopreto.presentation.SalonViewModel
import com.example.fiopreto.presentation.ViewState
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.item_post_feed.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {

    //private val args: FeedFragmentArgs by navArgs()

    private val adapter by lazy { PostFeedAdapter(::clickItem) }
    private lateinit var recyclerView: RecyclerView
    private val feedViewModel by viewModel<FeedViewModel>()
    private lateinit var buttonUpload: MaterialButton
    //private lateinit var namePerson: AppCompatTextView
    //private lateinit var imageView: AppCompatImageView

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
        buttonUpload = view.findViewById(R.id.buttonFeed)

        //imageView = view.findViewById(R.id.image_feed)
        //namePerson = view.findViewById(R.id.personName)


        setObservers()
        //setImageContent()
        buttonUpload.setOnClickListener {
            val intent = Intent(context, UploadFeedActivity::class.java)
            startActivity(intent)
        }
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


    private fun clickItem(postFeed: PostFeed) {

    }
}