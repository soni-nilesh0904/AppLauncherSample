package com.example.samplelauncherapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplelauncherapp.adapter.AppListAdapter
import kotlinx.android.synthetic.main.fragment_app_list.*


class FragmentAppList: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_app_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = AppListAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        rvAppList.layoutManager = layoutManager
        rvAppList.adapter = adapter

        val listOfApps = setUpApps()

        adapter.updateItem(listOfApps)
    }

    fun setUpApps(): ArrayList<AppDetailModel> {
        val pManager = context?.packageManager
        val appsList = ArrayList<AppDetailModel>()
        val i = Intent(Intent.ACTION_MAIN, null)
        i.addCategory(Intent.CATEGORY_LAUNCHER)
        val allApps = pManager?.queryIntentActivities(i, 0)

        Log.d("", "" + allApps)

        allApps?.let {
            for (ri in allApps) {
                val app = AppDetailModel(
                    appName = ri.loadLabel(pManager).toString(),
                    packageName = ri.activityInfo.packageName,
                    icon = ri.activityInfo.loadIcon(pManager),
                    mainActivityName = ri.activityInfo.targetActivity,
                    className = "",
                    versionCode = 1,
                    versionName = "1"

                )
                appsList.add(app)
            }
        }
        return appsList
    }
}