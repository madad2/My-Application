package dev.madad.testandroid

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dev.madad.testandroid.databinding.ActivityMainBinding
import dev.madad.testandroid.model.models.UiConfig
import kotlinx.coroutines.launch



class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        progressBar = binding.progressBar

        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is UiState.Loading -> {
                        // показать индикатор загрузки
                        progressBar.visibility = View.VISIBLE
                    }

                    is UiState.Success -> {
                        // обновить UI с конфигурацией
                        applyUiConfig(state.uiConfiguration, binding.main)
                        progressBar.visibility = View.GONE
                    }

                    is UiState.Error -> {
                        // показать сообщение с ошибкой
                        progressBar.visibility = View.GONE
                    }
                }

            }
        }
    }

    private fun applyUiConfig(uiConfig: UiConfig, layout: LinearLayout) {
        val activityConfig = uiConfig.activities.first()

        val header = TextView(this).apply {
            text = activityConfig.layout.header
        }
        layout.addView(header)

        activityConfig.layout.form.text.forEach { field ->
            when (field.type) {
                "plain-text" -> {
                    val editText = EditText(this).apply {
                        hint = field.caption
                    }
                    layout.addView(editText)
                }

                "auto-complete-text-view" -> {
                    val autoCompleteTextView = AutoCompleteTextView(this).apply {
                        hint = field.caption
                        setAdapter(
                            ArrayAdapter(
                                this@MainActivity,
                                android.R.layout.simple_dropdown_item_1line,
                                field.suggestions ?: emptyList()
                            )
                        )
                    }
                    layout.addView(autoCompleteTextView)
                }
            }
        }

        activityConfig.layout.form.buttons.forEach { buttonConfig ->
            val button = android.widget.Button(this).apply {
                text = buttonConfig.caption
                setOnClickListener {
                    // прослушать кнопку
                }
            }
            layout.addView(button)
        }
    }
}