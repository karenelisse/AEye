package com.karenelisse.aeye

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.karenelisse.aeye.model.ImageModel



class DisplayFinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.final_display)


        // Get the Intent that started this activity and extract the string
        val imageData = intent.getSerializableExtra(PAGE_THREE) as ImageModel

        findViewById<TextView>(R.id.modelPrediction).apply {
            setText(imageData.modelPrediction)
        }

        findViewById<TextView>(R.id.modelCertainty).apply {
            setText(imageData.modelCertainty)
        }

        findViewById<TextView>(R.id.actualDiagnosis).apply {
            setText(imageData.actualDiagnosis)
        }

        findViewById<ImageView>(R.id.finalImage).apply {
            setImageResource(imageData.image_drawable);
        }


    }


}
