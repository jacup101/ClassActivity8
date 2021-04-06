package com.example.kotlinexample1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.kotlinexample1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //var or val
    //var -> can change thevalue later
    //val -> can not (constant/final
    //

    //view binding - access these views "more easily" but in reality its the same
    private lateinit var buttonGo : Button;
    private lateinit var buttonVillager: Button;
    private lateinit var editTextName : EditText;
    private lateinit var binding : ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)

        buttonGo = findViewById(R.id.button_go)
        editTextName = findViewById(R.id.editText_name)
        */
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root); // root connects to all the views in this layout
        buttonGo = binding.buttonGo;
        buttonVillager = binding.buttonVillagers;
        editTextName = binding.editTextName;

        buttonGo.setOnClickListener {
            launchSecondActivity(editTextName.text.toString())
        }
        buttonVillager.setOnClickListener {
            launchThirdActivity()
        }
    }

    private fun toastInput(text : String) {
        Toast.makeText(this, text,Toast.LENGTH_LONG).show()
    }
    private fun launchSecondActivity(message :String ) {
        val intent = Intent(this, SecondActivity::class.java)//Standard way to do this
        intent.putExtra("name", message)
        startActivity(intent)
    }
    private fun launchThirdActivity() {
        val intent = Intent(this, ThirdActivity::class.java)//Standard way to do this
        startActivity(intent)
    }

}