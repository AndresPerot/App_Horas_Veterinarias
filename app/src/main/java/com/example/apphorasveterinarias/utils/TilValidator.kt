package com.example.apphorasveterinarias.utils

import android.util.Patterns
import android.widget.Toast
import com.example.apphorasveterinarias.LoginActivity
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class TilValidator constructor(til: TextInputLayout) {


    private val til: TextInputLayout = til
    private val value: String = til.editText?.text.toString()
    private var required: Boolean = false;
    private var invalid: Boolean = false;

    private fun setError(invalid: Boolean, message: String) {
        if (invalid) {
            this.invalid = true
            til.error = message
        } else {
            til.error = null
            til.isErrorEnabled = false
        }
    }

    private fun mustValidate(): Boolean {
        return (!this.required && this.value.isNullOrEmpty() || !invalid)
    }

    fun required(): TilValidator {
        this.required = true
        val invalidField= this.value.isEmpty()
        this.setError(invalidField, "Campo Requerido")
        return this
    }
    fun isValid(): Boolean {
        return !this.invalid
    }

    fun email(): TilValidator{
        if(mustValidate()){
            val invalidField= !Patterns.EMAIL_ADDRESS.matcher(this.value).matches()
            this.setError(invalidField,"El valor no es un email valido")
        }
        return this
    }

    fun password(): TilValidator{
        if(mustValidate()){
            val invalidField= !(Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +        //at least 1 lower case letter
                    "(?=.*[A-Z])" +        //at least 1 upper case letter
                    "(?=.*[@#$%^&+=!])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$")).matcher(this.value).matches()
            this.setError(invalidField,"El valor de la contraseña es invalido")
        }
        return this
    }

    fun nombre(): TilValidator{
        if(mustValidate()){
            val invalidField= !(Pattern.compile("^" +
                    "(?=.*[A-Z])" +        //at least 1 upper case letter
                    "(?=.*[a-z])" +        //at least 1 lower case letter
                    ".{30,}" +               //at least 30 characters
                    "$")).matcher(this.value).matches()
            this.setError(invalidField,"Nombre mal escrito,Ej: Andres Ignacio")
        }

        return this
    }

    fun apellido(): TilValidator{
        if(mustValidate()){
            val invalidField= !(Pattern.compile("^" +
                    "(?=.*[A-Z])" +        //at least 1 upper case letter
                    "(?=.*[a-z])" +        //at least 1 lower case letter
                    ".{30,}" +               //at least 30 characters
                    "$")).matcher(this.value).matches()
            this.setError(invalidField,"Apellido mal escrito (Ej: Contreras Figueroa)")
        }

        return this
    }

    fun contacto(): TilValidator{
        if(mustValidate()){
            val invalidField= !(Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[+])" +    //at least 1 special character
                    ".{12,}" +               //at least 30 characters
                    "$")).matcher(this.value).matches()
            this.setError(invalidField,"Escriba bien el numero de contacto(Ej: +56123456789)")
        }

        return this
    }

}
