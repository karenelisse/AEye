package com.karenelisse.aeye

import com.karenelisse.aeye.db.dbConstants
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import android.R.attr.data

import com.karenelisse.aeye.model.ImageModel
import android.util.Log
import java.util.ArrayList
import android.widget.AdapterView.OnItemClickListener
import android.content.Intent
import android.widget.*
import android.widget.EditText
import java.io.Serializable


const val PAGE_ONE = "com.karenelisse.aeye.DisplayFirstImagesActivity"

var strJson = dbConstants.JSON_STRING
var jsonRootObject: JSONObject = JSONObject(strJson)
var jsonArray: JSONArray = jsonRootObject.optJSONArray("Images")

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var lv: ListView? = null
    private var customeAdapter: CustomAdapter? = null
    private var imageModelArrayList: ArrayList<ImageModel>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.listView) as ListView

        imageModelArrayList = populateList()
        customeAdapter = CustomAdapter(this, imageModelArrayList!!)
        lv!!.adapter = customeAdapter

        lv!!.setOnItemClickListener(this)
    }



    private fun populateList(): ArrayList<ImageModel> {
        val list = ArrayList<ImageModel>()

        var image = ""

        for (item in 0..(jsonArray.length() - 1)) {
            val imageModel = ImageModel()
            var jsonObject: JSONObject = jsonArray.getJSONObject(item)
            val id = Integer.parseInt(jsonObject.optString("id").toString())
            imageModel.setNames(jsonObject.optString("imageName").toString())

            // sets the model to have the images for the first page
            val drawableIdStringFirstTopLeft = jsonObject.optString("firstTopLeft").toString()
            val drawableIdFirstTopLeft = getResources().getIdentifier(drawableIdStringFirstTopLeft,"drawable", packageName);
            imageModel.setfirstTopLeftLocation(drawableIdFirstTopLeft)

            val drawableIdStringFirstTopRight = jsonObject.optString("firstTopRight").toString()
            val drawableIdFirstTopRight = getResources().getIdentifier(drawableIdStringFirstTopRight,"drawable", packageName);
            imageModel.setfirstTopRightLocation(drawableIdFirstTopRight)

            val drawableIdStringFirstBottomLeft = jsonObject.optString("firstBottomLeft").toString()
            val drawableIdFirstBottomLeft = getResources().getIdentifier(drawableIdStringFirstBottomLeft,"drawable", packageName);
            imageModel.setfirstBottomLeftLocation(drawableIdFirstBottomLeft)

            val drawableIdStringFirstBottomRight = jsonObject.optString("firstBottomRight").toString()
            val drawableIdFirstBottomRight = getResources().getIdentifier(drawableIdStringFirstBottomRight,"drawable", packageName);
            imageModel.setfirstBottomRightLocation(drawableIdFirstBottomRight)

            // sets the model to have the images for the second page

            val drawableIdStringSecondTopLeft = jsonObject.optString("secondTopLeft").toString()
            val drawableIdSecondTopLeft = getResources().getIdentifier(drawableIdStringSecondTopLeft,"drawable", packageName);
            imageModel.setSecondTopLeftLocation(drawableIdSecondTopLeft)

            val drawableIdStringSecondTopRight = jsonObject.optString("secondTopRight").toString()
            val drawableIdSecondTopRight = getResources().getIdentifier(drawableIdStringSecondTopRight,"drawable", packageName);
            imageModel.setSecondTopRightLocation(drawableIdSecondTopRight)

            val drawableIdStringSecondBottomLeft = jsonObject.optString("secondBottomLeft").toString()
            val drawableIdSecondBottomLeft = getResources().getIdentifier(drawableIdStringSecondBottomLeft,"drawable", packageName);
            imageModel.setSecondBottomLeftLocation(drawableIdSecondBottomLeft)

            val drawableIdStringSecondBottomRight = jsonObject.optString("secondBottomRight").toString()
            val drawableIdSecondBottomRight = getResources().getIdentifier(drawableIdStringSecondBottomRight,"drawable", packageName);
            imageModel.setSecondBottomRightLocation(drawableIdSecondBottomRight)

            // sets the image data
            imageModel.setModelPredictions(jsonObject.optString("modelPrediction").toString())
            imageModel.setModelCertainties(jsonObject.optString("modelCertainty").toString())
            imageModel.setActualDiagnosises(jsonObject.optString("actualDiagnosis").toString())



            // sets the images in the list on first page
            val drawableIdString = jsonObject.optString("location").toString()
            val drawableId = getResources().getIdentifier(drawableIdString,"drawable", packageName);
            imageModel.setImageDrawables(drawableId)
            list.add(imageModel)
        }

        return list
    }

    override fun onItemClick(p0: AdapterView<*>?, view: View?, position: Int, p3: Long) {
        val imageModel = lv!!.getItemAtPosition(position) as ImageModel
        Toast.makeText(applicationContext, imageModel.first_top_left.toString(), Toast.LENGTH_LONG).show()
        val intent = Intent(this, DisplayFirstImagesActivity::class.java).apply {
            putExtra(PAGE_ONE, imageModel)
//            putExtra(PAGE_ONE, imageModel as Serializable)
        }

        startActivity(intent)
    }
}
