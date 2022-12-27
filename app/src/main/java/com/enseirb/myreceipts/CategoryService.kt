package com.enseirb.myreceipts

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL
import android.view.View


class CategoryService {

     fun getCategories(recyclerView: RecyclerView, applicationContext:  Context, activity: MainActivity){
        val url = URL("https://www.themealdb.com/api/json/v1/1/categories.php")

        var categoriesAdapter: CategoriesAdapter

        val request = Request.Builder().url(url).build();

        val client = OkHttpClient();

        client.newCall(request).enqueue( object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("OKHTTP", e.localizedMessage)
            }

            override fun onResponse(call: Call, response: Response) {
                response.body?.string()?.let {
                    val gson = Gson()
                    val categoryResponse = gson.fromJson(it, CategoryResponse::class.java)
                    categoryResponse.categories?.let { it1 ->
                        activity.runOnUiThread {
                            categoriesAdapter = CategoriesAdapter(it1)
                            recyclerView.adapter = categoriesAdapter
                            recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                        }
                    }
                    Log.d("OKHTTP", "Got " + categoryResponse.categories?.count() + " results");
                }
            }
        })
    }

}
