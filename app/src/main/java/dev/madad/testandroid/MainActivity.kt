package dev.madad.testandroid

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dev.madad.testandroid.databinding.ActivityMainBinding
import dev.madad.testandroid.model.models.config.UiConfig
import dev.madad.testandroid.view.UserInfoActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
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
                        Toast.makeText(applicationContext, state.error, Toast.LENGTH_LONG)
                            .show()
                    }
                }

            }
        }
    }

    private fun applyUiConfig(uiConfig: UiConfig, layout: LinearLayout) {
        val activityConfig = uiConfig.activities.first()

        val header = TextView(this).apply {
            text = activityConfig.layout.header
            layout.gravity = Gravity.CENTER
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
                    val intent = Intent(this@MainActivity, UserInfoActivity::class.java).apply {
                        putExtra("formAction", buttonConfig.formAction)
                    }
                    startActivity(intent)
                }
            }
            layout.addView(button)
        }
    }
}