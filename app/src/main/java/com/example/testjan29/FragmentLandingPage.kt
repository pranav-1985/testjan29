package com.example.testjan29

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment

class FragmentLandingPage : Fragment() {

    private lateinit var source: String
    private lateinit var country: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_landing_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showNewsButton: Button = view.findViewById(R.id.show_news_button)
        val spinner1: Spinner = view.findViewById(R.id.spinner_country)
        val spinner2: Spinner = view.findViewById(R.id.spinner_source)

        val items1 = arrayOf("US", "AU")
        val items2 = arrayOf("BBC", "CNN")

        val adapter1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items1)
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, items2)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner1.adapter = adapter1
        spinner2.adapter = adapter2

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                country = parentView.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                source = parentView.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
            }
        }

        showNewsButton.setOnClickListener {

            val fragment2 = RecyclerViewFragment()
            val bundle = Bundle()
            bundle.putString("source", source)
            bundle.putString("country", country)
            fragment2.arguments = bundle

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment2)
                .addToBackStack(null)
                .commit()

        }
    }

}