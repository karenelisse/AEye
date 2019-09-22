package com.karenelisse.aeye

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.karenelisse.aeye.model.ImageModel


const val PAGE_THREE = "com.karenelisse.aeye.DisplayFinalActivity"

class DisplaySecondImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_image_display)


        // Get the Intent that started this activity and extract the string
        val imageData = intent.getSerializableExtra(PAGE_TWO) as ImageModel


        findViewById<ImageView>(R.id.imageViewTopLeft).apply {
            setImageResource(imageData.second_top_left);
        }

        findViewById<ImageView>(R.id.imageViewTopRight).apply {
            setImageResource(imageData.second_top_right);
        }

        findViewById<ImageView>(R.id.imageViewBottomLeft).apply {
            setImageResource(imageData.second_bottom_left);
        }

        findViewById<ImageView>(R.id.imageViewBottomRight).apply {
            setImageResource(imageData.second_bottom_right);
        }

        val button = findViewById(R.id.goToFinalDisplayButton) as Button

        button.setOnClickListener {
            Toast.makeText(this@DisplaySecondImagesActivity, imageData.name, Toast.LENGTH_LONG).show()

            val intent = Intent(this, DisplayFinalActivity::class.java).apply {
                putExtra(PAGE_THREE, imageData)
            }
            startActivity(intent)
        }
    }


}
