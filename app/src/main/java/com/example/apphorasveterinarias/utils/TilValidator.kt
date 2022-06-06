package com.example.apphorasveterinarias.utils

import com.google.android.material.textfield.TextInputLayout

class TilValidator constructor(til: TextInputLayout){

    private val til: TextInputLayout = til
    private val value: String? = til.editText?.text.toString()
    private var required: Boolean = false;
    private var invalid: Boolean = false;

    private fun setError(invalid: Boolean, message: String){
        if (invalid){
            this.invalid = true
            til.error = message
        } else{
            til.error = null
            til.isErrorEnabled = false
        }

    }

}