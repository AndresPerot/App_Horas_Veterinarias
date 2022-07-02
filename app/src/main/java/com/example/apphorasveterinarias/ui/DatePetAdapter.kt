package com.example.apphorasveterinarias.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.apphorasveterinarias.Models.DatePet
import com.example.apphorasveterinarias.R

class   DatePetAdapter(private val ctx: Context, private val datepets: List<DatePet>) : BaseAdapter() {


    override fun getCount(): Int {
        return datepets.size
    }

    override fun getItem(i: Int): DatePet {
        return datepets[i]
    }

    override fun getItemId(i: Int): Long {
        return datepets[i].pet_id!!
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(ctx)

       val rowView = inflater.inflate(R.layout.item_datepet1, null)

        val datepet = datepets[i]

        val tvName = rowView.findViewById<TextView>(R.id.item_datepet_tv_name)
        val tvOwner = rowView.findViewById<TextView>(R.id.item_datepet_tv_title_tv_owner)
        val tvRace = rowView.findViewById<TextView>(R.id.item_datepet_tv_title_tv_race)
        val tvHour = rowView.findViewById<TextView>(R.id.item_datepet_tv_hour)
        val tvContact = rowView.findViewById<TextView>(R.id.item_datepet_tv_contact)

        tvName.text = datepet.namePet
        tvOwner.text= datepet.owner
        tvRace.text = datepet.race
        tvHour.text = datepet.hour
        tvContact.text = datepet.contact





        return rowView

    }


}

