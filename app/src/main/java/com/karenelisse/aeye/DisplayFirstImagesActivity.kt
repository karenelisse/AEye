package com.karenelisse.aeye

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import com.karenelisse.aeye.model.ImageModel



const val PAGE_TWO = "com.karenelisse.aeye.DisplaySecondImagesActivity"

class DisplayFirstImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_image_display)


        // Get the Intent that started this activity and extract the string
        val imageData = intent.getSerializableExtra(PAGE_ONE) as ImageModel


        findViewById<ImageView>(R.id.imageViewTopLeft).apply {
            setImageResource(imageData.first_top_left);
        }

        findViewById<ImageView>(R.id.imageViewTopRight).apply {
            setImageResource(imageData.first_top_right);
        }

        findViewById<ImageView>(R.id.imageViewBottomLeft).apply {
            setImageResource(imageData.first_bottom_left);
        }

        findViewById<ImageView>(R.id.imageViewBottomRight).apply {
            setImageResource(imageData.first_bottom_right);
        }

        val button = findViewById(R.id.goToSecondImagesButton) as Button

        button.setOnClickListener {
            Toast.makeText(this@DisplayFirstImagesActivity, imageData.name, Toast.LENGTH_LONG).show()

            val intent = Intent(this, DisplaySecondImagesActivity::class.java).apply {
                putExtra(PAGE_TWO, imageData)
            }
            startActivity(intent)
        }
    }


}
