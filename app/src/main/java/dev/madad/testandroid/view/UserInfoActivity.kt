package dev.madad.testandroid.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dev.madad.testandroid.databinding.ActivityUserInfoBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserInfoActivity : AppCompatActivity() {

    private val viewModel: UserInfoViewModel by viewModel()
    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val formAction = intent.getStringExtra("formAction")
        formAction?.let {
            val correctedFormAction = it.trimStart('/')
            viewModel.fetchUserInfo(correctedFormAction)
        }

        lifecycleScope.launch {
            viewModel.userInfo.collect { user ->
                user?.let {
                    binding.fullName.text = user.fullName
                    binding.position.text = user.position
                    binding.workHoursInMonth.text = user.workHoursInMonth.toString()
                    binding.workedOutHours.text = user.workedOutHours.toString()
                }
            }
        }

        lifecycleScope.launch {
            viewModel.error.collect { errorMessage ->
                errorMessage?.let {
                    Toast.makeText(this@UserInfoActivity, it, Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}