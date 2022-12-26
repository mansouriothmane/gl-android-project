package com.enseirb.myreceipts

import android.util.Log
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.net.URL

class CategoryService {

    public fun getCategories(){
        val url = URL("https://www.themealdb.com/api/json/v1/1/categories.php")

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
                        Log.d(
                            "OKHTTP",
                            "Got " + categoryResponse.categories?.count() + " results"
                        )
                        Log.d(
                            "OKHTTP",
                            "Got " + it1.toString() + " results"
                        )
                    }
                    Log.d("OKHTTP", "Got " + categoryResponse.categories?.count() + " results");
                    Log.d("OKHTTP","hey " + categoryResponse?.toString());
                }
            }
        })
    }

}