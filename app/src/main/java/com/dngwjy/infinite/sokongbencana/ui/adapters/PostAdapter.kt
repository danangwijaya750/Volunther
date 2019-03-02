package com.dngwjy.infinite.sokongbencana.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dngwjy.infinite.sokongbencana.R
import com.dngwjy.infinite.sokongbencana.ui.models.PoskoModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_pos.*

class PostAdapter (val postData:List<PoskoModel>,val context:Context,val listener:(PoskoModel)->Unit):
RecyclerView.Adapter<PostAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pos,parent,false))
    }

    override fun getItemCount(): Int {
        return postData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(postData[position],listener)
    }

    class ViewHolder(override val containerView: View):RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun bindData(data:PoskoModel,listen:(PoskoModel)->Unit){
            judulPos.text=data.namaPosko
            alamatPos.text=data.lokasiPosko
            Glide.with(containerView).load(data.imagePhoto).into(gambarPos)
        }
    }
}