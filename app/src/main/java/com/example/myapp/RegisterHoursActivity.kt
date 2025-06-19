package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapp.databinding.ActivityRegisterHoursBinding
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class RegisterHoursActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterHoursBinding
    private val db by lazy { HoursDatabase.getDatabase(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterHoursBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEntry.setOnClickListener {
            lifecycleScope.launch {
                db.hoursDao().insert(HourEntry(time = LocalDateTime.now(), type = "entry"))
            }
        }

        binding.btnExit.setOnClickListener {
            lifecycleScope.launch {
                db.hoursDao().insert(HourEntry(time = LocalDateTime.now(), type = "exit"))
            }
        }
    }
}