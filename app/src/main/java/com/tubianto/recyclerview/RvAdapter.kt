package com.tubianto.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*

/**
 * Created by Tubianto on 04/01/2021.
 */
class RvAdapter(val context: Context, val items: ArrayList<DataItem>) : RecyclerView.Adapter<RvAdapter.DataHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): DataHolder {
        return DataHolder(
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list, viewGroup, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        holder.bindData(items[position])
        holder.cvItem.setOnClickListener{
            val link = items[position].link
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            context.startActivity(browserIntent)
        }
    }

    class DataHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener{
        override fun onClick(v: View?) {
            if (v != null) {
                this.myItemClickListener.onItemClick(v, layoutPosition)
            }
        }

        private lateinit var myItemClickListener: ItemClickListener
        var cvItem: CardView
        var ivItem: ImageView
        var tvTitle: TextView
        var tvDate: TextView
        init {
            cvItem = view.findViewById(R.id.cv_item)
            ivItem = view.findViewById(R.id.iv_item)
            tvTitle = view.findViewById(R.id.tv_title)
            tvDate = view.findViewById(R.id.tv_date)
            cvItem.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bindData(dataItem: DataItem) {
            itemView.apply {
                val image = dataItem.image
                val title = dataItem.title
                val date = dataItem.date
                image.let {
                    Glide.with(itemView.context)
                        .load(it)
                        .into(ivItem)
                }
                tvTitle.text = title
                tvDate.text = date
            }
        }

        fun setItemClickListener(ic: ItemClickListener) {
            this.myItemClickListener = ic
        }

        interface ItemClickListener {
            fun onItemClick(v: View, pos: Int)
        }
    }

    fun addItems(items: List<DataItem>) {
        this.items.apply {
            clear()
            addAll(items)
        }
    }

    fun clearItems(items: List<DataItem>){
        this.items.apply {
            clear()
        }
    }
}