package com.example.kotlinlistviewdemoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CatsAdapter (context: Context, var mAnimalList: List<Cat>) : ArrayAdapter<Cat>(context, 0, mAnimalList) {

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Animalの取得
        val cat = mAnimalList[position]

        // レイアウトの設定
        var view = convertView
        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.list_item, parent, false)
        }

        // 各Viewの設定
        val imageView = view?.findViewById<ImageView>(R.id.image)
        imageView?.setImageResource(cat.imageId)

        val name = view?.findViewById<TextView>(R.id.name)
        name?.text = cat.name

        val age = view?.findViewById<TextView>(R.id.berthDay)
        age?.text = cat.berthDay.toString()

        return view!!
    }
}