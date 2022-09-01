package com.example.weatherfetcher

import android.os.Bundle
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
    private val fabGetTemp: FloatingActionButton by lazy { findViewById(R.id.fabGetTemp) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this, ::render)

        fabGetTemp.setOnClickListener {
            viewModel.processUIEvent(UIEvent.OnButtonClicked)
        }
    }

    private fun render(viewState: ViewState) {
        tvHello.text = "${viewState.title} ${viewState.temperature}"
    }
}