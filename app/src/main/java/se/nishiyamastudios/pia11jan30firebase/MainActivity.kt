package se.nishiyamastudios.pia11jan30firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    var fadapter = FruitAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fruitRecview = findViewById<RecyclerView>(R.id.fruitRV)

        fruitRecview.adapter = fadapter
        fruitRecview.layoutManager = LinearLayoutManager(this)

        loadFruits()

        findViewById<Button>(R.id.addFruitButton).setOnClickListener {

            val database = Firebase.database
            val fruitSallad = database.getReference("fruitsallad")
            var addfruitname = findViewById<EditText>(R.id.addFruitET).text.toString()
            val somefruit = Fruit(addfruitname, "")
            fruitSallad.push().setValue(somefruit)

            loadFruits()

        }


        //val myRef = database.getReference("testar")
        //myRef.setValue("Hello, World!")

        //Spara frukt
        /*
        val banan = Fruit("Banan","Gul")
        val fruitRef = database.getReference("androidfruit")
        fruitRef.setValue(banan)
         */

        //Hämta data
        /*
        val myRef = database.getReference("androidfruit")

        myRef.get().addOnSuccessListener {
            //val thetext = it.getValue<String>()
            val thefruit = it.getValue<Fruit>()

            Log.i("pia11debug", thefruit!!.fruitname!!)
        }
         */

        //Spara med autoid
        /*
        val somefruit = Fruit("Kiwi", "Grön")
        fruitSallad.push().setValue(somefruit)

         */

        //Hämta lista med objekt
        /*
        fruitSallad.get().addOnSuccessListener {

            val allfruits = mutableListOf<Fruit>()

            it.children.forEach {childsnap ->

                allfruits.add(childsnap.getValue<Fruit>()!!)

            }

            //val allfruits = it.getValue<List<Fruit>>()


            for (fruit in allfruits) {

                Log.i("pia11debug", fruit.fruitname!!)

            }

        }

         */



    }

    fun loadFruits() {

        val database = Firebase.database

        val fruitSallad = database.getReference("fruitsallad")

        fruitSallad.get().addOnSuccessListener {

            val fbfruits = mutableListOf<Fruit>()

            it.children.forEach {childsnap ->

                fbfruits.add(childsnap.getValue<Fruit>()!!)
            }

            fadapter.allfruit = fbfruits
            fadapter.notifyDataSetChanged()

        }
    }


}

data class Fruit(val fruitname: String? = null, val fruitcolor: String? = null) {

}