package com.example.watercleaningapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.watercleaningapp.databinding.ActivityMainBinding
import com.example.watercleaningapp.model.CleaningParam
import com.example.watercleaningapp.repository.CleaningParamsRepository

class MainActivity : AppCompatActivity() {
    private lateinit var doneBtn: Button
    private lateinit var k: EditText
    private lateinit var rust: EditText
    private lateinit var sand: EditText
    private lateinit var salt: EditText
    private lateinit var na: EditText
    private lateinit var fe: EditText
    private lateinit var uid: EditText

    private val repo = CleaningParamsRepository()

    private companion object {
        private const val SUCCESS = 1
        private const val ID_ERROR = -1
        private const val DATA_ERROR = -2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        doneBtn = binding.doneBtn
        k = binding.K
        rust = binding.Rust
        sand = binding.Sand
        salt = binding.Salt
        na = binding.Na
        fe = binding.Fe
        uid = binding.userId

        doneBtn.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            when (doReport()) {
                SUCCESS -> {
                    builder.setTitle("Параметри успішно встановлені")
                    builder.setPositiveButton("OK") { ignored1, ignored2 -> }
                    builder.create().show()
                }

                ID_ERROR -> {
                    builder.setTitle("Погане ID")
                    builder.setPositiveButton("OK") { ignored1, ignored2 -> }
                    builder.create().show()
                }

                DATA_ERROR -> {
                    builder.setTitle("Погані данниє")
                    builder.setPositiveButton("OK") { ignored1, ignored2 -> }
                    builder.create().show()
                }
            }
        }
    }


    private fun doReport(): Int {
        val kValue = k.text.toString().toFloat()
        val rustValue = rust.text.toString().toFloat()
        val saltValue = salt.text.toString().toFloat()
        val sandValue = sand.text.toString().toFloat()
        val naValue = na.text.toString().toFloat()
        val feValue = fe.text.toString().toFloat()
        val id: Int = uid.text.toString().toInt()

        if (id < 0) {
            return ID_ERROR
        }

        fun checkForDataIntegrity(): Boolean {
            return (kValue in 0.0..1.0) && (rustValue in 0.0..1.0) && (saltValue in 0.0..1.0)
                    && (sandValue in 0.0..1.0) && (naValue in 0.0..1.0) && (feValue in 0.0..1.0)
        }

        if (!checkForDataIntegrity()) {
            return DATA_ERROR
        }
        repo.save(id, CleaningParam(kValue, rustValue, saltValue, sandValue, naValue, feValue))
        return 1
    }
}