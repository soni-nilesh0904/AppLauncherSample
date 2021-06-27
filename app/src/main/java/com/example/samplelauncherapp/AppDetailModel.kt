package com.example.samplelauncherapp

import android.graphics.drawable.Drawable

data class AppDetailModel(
    val appName: String? = "",
    val packageName: String? = "",
    val icon: Drawable? = null,
    val mainActivityName: String? = "",
    val className: String? = "",
    val versionCode: Int? = 0,
    val versionName: String? = ""
)