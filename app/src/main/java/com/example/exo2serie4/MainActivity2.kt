package com.example.exo2serie4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var titre = findViewById<TextView>(R.id.textView)
        var auteur = findViewById<TextView>(R.id.textView3)
        var description = findViewById<TextView>(R.id.textView4)
        val extras = intent.extras
        if (extras != null) {
            titre.text=extras.getString("titre")
            auteur.text=extras.getString("auteur")
            description.text=extras.getString("description")
        }

    }
}