package com.example.testjan29

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testjan29.recyclerView.RecyclerViewAdapter
import com.example.testjan29.viewModel.ViewModel


class RecyclerViewFragment : Fragment(), RecyclerViewAdapter.ItemClickListener {

    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: RecyclerViewAdapter = RecyclerViewAdapter(this)
    private val viewModel by viewModels<ViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val source = arguments?.getString("source") ?: "empty!"
        val country = arguments?.getString("country") ?: "empty!"

        viewModel.getNewsInfo(country, source)

        viewModel.newsDetails.observe(viewLifecycleOwner) {
            mAdapter.updateData(it)
        }

        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mRecyclerView = view.findViewById(R.id.recyclerview)

        mRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mAdapter
        }

    }


    override fun onItemClick(view: View?, position: Int) {

    }
}
