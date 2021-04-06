package com.example.kotlinexample1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexample1.databinding.ActivityThirdBinding
import org.json.JSONArray
import org.json.JSONObject

class ThirdActivity : AppCompatActivity() {
    //read in the json file, creating array list of vbillagers
    //create adapter with list of villagers
    //set it to the recycler view

    private lateinit var villagersList:ArrayList<Villager>
    private lateinit var binding: ActivityThirdBinding
    private lateinit var recyclerView :RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerViewVillagers

        villagersList = ArrayList<Villager>()
        val json: JSONObject = JSONObject(loadJSONfromAssets("villagers.json"))

        val array : JSONArray = json.getJSONArray("villagers")

        for( i in 0 until array.length()) {
            var newJsonObj = array.getJSONObject(i)
            var villager = Villager(newJsonObj.getString("name"), newJsonObj.getString("birthday"), newJsonObj.getString("phrase"), newJsonObj.getString("house"),newJsonObj.getString("villager"), true)
            villagersList.add(villager)

        }

        recyclerView.adapter = VillagerAdapter(villagersList)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun loadJSONfromAssets(filename:String) : String {
        return applicationContext.assets.open(filename).bufferedReader().use {it.readText()}
    }
}