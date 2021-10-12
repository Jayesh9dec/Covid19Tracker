 package com.example.covid19tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Callback

 class MainActivity : AppCompatActivity() {

     lateinit var adapter:ListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataset()
    }

    private fun getDataset() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = withContext(Dispatchers.IO) {
                Client.data.execute()
            }
            if (response.isSuccessful) {
                val list_of_data = Gson().fromJson(response.body?.string(), Response::class.java)
                launch(Dispatchers.Main) {
                    attachCountData(list_of_data.statewise[0])
                    attachListData(list_of_data.statewise.subList(1,list_of_data.statewise.size))
                }
            }
        }
    }

     private fun attachListData(listOfData:List<StatewiseItem>) {
         adapter= ListAdapter(listOfData)
         rv.layoutManager=LinearLayoutManager(this)
         rv.adapter=adapter
     }

     private fun attachCountData(stateItem: StatewiseItem) {
         confirmedcount.text=stateItem.confirmed
         activecount.text=stateItem.active
         deceasedcount.text=stateItem.deaths
         recoveredcount.text=stateItem.recovered
     }
 }