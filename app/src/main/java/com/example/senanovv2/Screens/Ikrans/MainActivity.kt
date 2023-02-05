package com.example.senanovv2.Screens.Ikrans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.senanovv2.R
import com.example.senanovv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}