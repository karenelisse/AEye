package com.karenelisse.aeye.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class ImageModel: Serializable {

    var name: String? = null
    var modelPrediction: String? = null
    var modelCertainty: String? = null
    var actualDiagnosis: String? = null
    var first_top_left: Int = 0
    var first_top_right: Int = 0
    var first_bottom_left: Int = 0
    var first_bottom_right: Int = 0
    var second_top_left: Int = 0
    var second_top_right: Int = 0
    var second_bottom_left: Int = 0
    var second_bottom_right: Int = 0
    var image_drawable: Int = 0


    fun getNames(): String {
        return name.toString()
    }

    fun setNames(name: String) {
        this.name = name
    }

    fun getModelPredictions(): String {
        return modelPrediction.toString()
    }

    fun setModelPredictions(modelPrediction: String){
        this.modelPrediction = modelPrediction
    }

    fun getModelCertanties(): String {
        return modelCertainty.toString()
    }

    fun setModelCertainties(modelCertainty: String){
        this.modelCertainty = modelCertainty
    }

    fun getActualDiagnosises(): String {
        return actualDiagnosis.toString()
    }

    fun setActualDiagnosises(actualDiagnosis: String){
        this.actualDiagnosis = actualDiagnosis
    }



    // Getters and setters for First images

    fun getFirstTopLeftLocation(): Int {
        return first_top_left
    }

    fun setfirstTopLeftLocation(first_top_left: Int) {
        this.first_top_left = first_top_left
    }

    fun getFirstTopRightLocation(): Int {
        return first_top_right
    }

    fun setfirstTopRightLocation(first_top_right: Int) {
        this.first_top_right = first_top_right
    }

    fun getFirstBottomLeftLocation(): Int {
        return first_bottom_left
    }

    fun setfirstBottomLeftLocation(first_bottom_left: Int) {
        this.first_bottom_left = first_bottom_left
    }

    fun getFirstBottomRightLocation(): Int {
        return first_bottom_right
    }

    fun setfirstBottomRightLocation(first_bottom_right: Int) {
        this.first_bottom_right = first_bottom_right
    }

    // Getters and setters for Second images

    fun getSecondTopLeftLocation(): Int {
        return second_top_left
    }

    fun setSecondTopLeftLocation(second_top_left: Int) {
        this.second_top_left = second_top_left
    }

    fun getSecondTopRightLocation(): Int {
        return second_top_right
    }

    fun setSecondTopRightLocation(second_top_right: Int) {
        this.second_top_right = second_top_right
    }

    fun getSecondBottomLeftLocation(): Int {
        return second_bottom_left
    }

    fun setSecondBottomLeftLocation(second_bottom_left: Int) {
        this.second_bottom_left = second_bottom_left
    }

    fun getSecondBottomRightLocation(): Int {
        return second_bottom_right
    }

    fun setSecondBottomRightLocation(second_bottom_right: Int) {
        this.second_bottom_right = second_bottom_right
    }

    fun getImageDrawables(): Int {
        return image_drawable
    }

    fun setImageDrawables(image_drawable: Int) {
        this.image_drawable = image_drawable
    }

}