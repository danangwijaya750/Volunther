package com.dngwjy.infinite.sokongbencana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dngwjy.infinite.sokongbencana.R
import com.dngwjy.infinite.sokongbencana.ui.models.Disasters
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_bencana.*

class DisastersAdapter(val context: Context,val disasters: List<Disasters>,val listener:(Disasters)->Unit):RecyclerView.Adapter<DisastersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_bencana,parent,false))
    }

    override fun getItemCount(): Int {
        return disasters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(disasters[position],listener)
    }

    class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun bindData(data:Disasters,listener: (Disasters) -> Unit){
            judulBencana.text=data.disasterName
            alamatBencara.text=data.locationDisaster
            Glide.with(containerView).load(data.imageDisaster).into(image_bencana)
        }
    }
}