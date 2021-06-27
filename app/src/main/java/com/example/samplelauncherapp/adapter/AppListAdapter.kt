package com.example.samplelauncherapp.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.samplelauncherapp.AppDetailModel
import com.example.samplelauncherapp.R
import java.util.*


class AppListAdapter: RecyclerView.Adapter<AppListAdapter.ViewHolder>() {
    var appList = arrayListOf<AppDetailModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.app_list_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return appList.size
    }

    override fun onBindViewHolder(holder: AppListAdapter.ViewHolder, position: Int) {
        holder.textAppName.text = appList[position].appName
        holder.textPackageName.text = appList[position].packageName
        val appIcon: Drawable? = appList[position].icon

        holder.img.setImageDrawable(appIcon)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var textAppName = view.findViewById<AppCompatTextView>(R.id.tvAppName)
        var textPackageName = view.findViewById<AppCompatTextView>(R.id.tvAppPackage)
        var img = view.findViewById<AppCompatImageView>(R.id.ivAppIcon)
    }

    fun updateItem(itemList: ArrayList<AppDetailModel>) {
        this.appList = itemList
        notifyDataSetChanged()
    }
}