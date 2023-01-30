package se.nishiyamastudios.pia11jan30firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val database = Firebase.database

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

        val fruitSallad = database.getReference("fruitsallad")

        val somefruit = Fruit("Kiwi", "Grön")

        fruitSallad.push().setValue(somefruit)

    }
}

data class Fruit(val fruitname: String? = null, val fruitcolor: String? = null) {

}