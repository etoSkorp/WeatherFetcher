package com.example.weatherfetcher

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.weatherfetcher.feature.weather_screen.ui.UIEvent
import com.example.weatherfetcher.feature.weather_screen.ui.ViewState
import com.example.weatherfetcher.feature.weather_screen.ui.WeatherViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private val viewModel: WeatherViewModel by viewModel()
    private val tvHello: TextView by lazy { requireActivity().findViewById(R.id.tvHello) }
    private val tvWind: TextView by lazy { requireActivity().findViewById(R.id.tvWind) }
    private val fabGetTemp: FloatingActionButton by lazy { requireActivity().findViewById(R.id.fabGetTemp) }
    private val spinner: Spinner by lazy { requireActivity().findViewById(R.id.spinnerSelectCity) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.cityName,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_item)
            spinner.adapter = adapter
        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        fabGetTemp.setOnClickListener {
            viewModel.processUIEvent(UIEvent.OnButtonClicked)
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val cityName: String = parent?.getItemAtPosition(position).toString()
                viewModel.processUIEvent(UIEvent.OnCitySelected(cityName))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun render(viewState: ViewState) {
        tvHello.text = "${viewState.title} ${viewState.temperature}"
        tvWind.text = "${viewState.windSpeedInfo}${viewState.windSpeed}"
    }
}