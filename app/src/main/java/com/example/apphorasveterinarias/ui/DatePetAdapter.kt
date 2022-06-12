package com.example.apphorasveterinarias.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apphorasveterinarias.Models.DatePet
import com.example.apphorasveterinarias.R

class DatePetAdapter(private val ctx: Context, private val datepets: List<DatePet>) : BaseAdapter() {


    override fun getCount(): Int {
        return datepets.size
    }

    override fun getItem(i: Int): DatePet {
        return datepets[i]
    }

    override fun getItemId(i: Int): Long {
        return datepets[i].id!!
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)

       val rowView = inflater.inflate(R.layout.item_datepet, null)

        val datepet = datepets[i]

        val tvName = rowView.findViewById<TextView>(R.id.item_datepet_tv_name)
        val tvRace = rowView.findViewById<TextView>(R.id.item_datepet_tv_title_tv_race)
        val tvHour = rowView.findViewById<TextView>(R.id.item_datepet_tv_hour)
        val tvPhone = rowView.findViewById<TextView>(R.id.item_datepet_tv_phone)

        tvName.text = datepet.namePet
        tvRace.text = datepet.race
        tvHour.text = datepet.hour
        tvPhone.text = datepet.phone





        return rowView

    }


}

