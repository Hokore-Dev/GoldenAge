package org.goldenage.com.goldenage

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ItemRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    var titles = arrayOf("test1", "test2", "test3", "test4","test4","test4","test4","test4","test4","test4","test4","test4","test4","test4")

    override fun getItemCount(): Int {
        return 14
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var view = holder as CustomViewHolder
        view.textview!!.text = titles[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view)
    }

    class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        var imageview: ImageView? = null
        var textview: TextView? = null

        init {
            imageview = view!!.findViewById(R.id.imageView2)
            textview = view!!.findViewById(R.id.textView4)
        }
    }
}