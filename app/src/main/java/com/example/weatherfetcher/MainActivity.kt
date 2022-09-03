package com.example.weatherfetcher

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherfetcher.feature.weather_screen.ui.UIEvent
import com.example.weatherfetcher.feature.weather_screen.ui.ViewState
import com.example.weatherfetcher.feature.weather_screen.ui.WeatherViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModel()
    private val tvHello: TextView by lazy { findViewById(R.id.tvHello) }
    private val tvWind: TextView by lazy { findViewById(R.id.tvWind) }
    private val fabGetTemp: FloatingActionButton by lazy { findViewById(R.id.fabGetTemp) }
    private val spinner: Spinner by lazy { findViewById(R.id.spinnerSelectCity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ArrayAdapter.createFromResource(
            this,
            R.array.cityName,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_item)
            spinner.adapter = adapter
        }

        viewModel.viewState.observe(this, ::render)

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
        tvWind.text =
            "${viewState.windDegInfo}${viewState.windDeg}\n${viewState.windSpeedInfo}${viewState.windSpeed}"
    }
}