package com.example.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    // States for user input (height and weight)
    var heightInput by mutableStateOf("")   // meters (e.g. 1.88)
        private set

    var weightInput by mutableStateOf("")   // kg (e.g. 90)
        private set

    fun onHeightChange(newValue: String) {
        heightInput = newValue
    }

    fun onWeightChange(newValue: String) {
        weightInput = newValue
    }

    // BMI result as a computed property
    val bmi: Double?
        get() {
            // handle diffent decimal values
            val h = heightInput.replace(',', '.').toDoubleOrNull()
            val w = weightInput.replace(',', '.').toDoubleOrNull()
            // if input is invalid, return null
            if (h == null || w == null) return null
            if (h <= 0.0) return null
            // return calculated BMI
            return w / (h * h)
        }
}