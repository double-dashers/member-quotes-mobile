package com.example.dasherquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random

const val arturoName = "Arturo"
const val fernandoName = "Fernando"
const val danielName = "Daniel"
const val lucaName = "Luca"
const val laloName = "Lalo"
const val malkiName = "Malki"
const val pepeName = "Pepe"

val names = arrayOf<String>(
    arturoName, fernandoName, danielName, lucaName, laloName, malkiName, pepeName
)

val arturoQuotes = arrayOf<String>(
    "Escupí el pepino que tenía en la boca.",
    "No sé, pero siento que voy a terminar vergueado en algún punto.",
    "Mi ojo me dice que tengo hambre.",
    "No puedo creer que me diera ese platano.",
    "Dejen de dispararme con una verga.",
    "¿¡ALV por qué me pegan 47 veces?!",
    "Mientras voy a ver el video de un mamado.",
    "Supositorio a la verga",
    "Interesante, eso es como matar un homicidio?",
    "Lo hizió.",
    "Si fuera pobre, sí"
)
val fernandoQuotes = arrayOf<String>(
    "Boba Nomb.",
    "For the Motherland.",
    "Jow blob.",
    "Karoke?."
)
val danielQuotes = arrayOf<String>(
    "The Game: The Movie 2: The Pre-Sequel.",
    "e uir.",
    "Tengo que e uir.",
    "Se ve muy oscuro en la oscuridad."
)
val lucaQuotes = arrayOf<String>(
    "Vergurado.",
    "qur gluglr gaste alv.",
    "Ya lleue.",
    "A mira, soy una bolsa.",
    "Si consigues información tienes más información"
)
val laloQuotes = arrayOf<String>(
    "Ichi coca.",
    "Ano-sumimasen...sobre?.",
    "No me gusta como se le ven los pelos de la punta."
)
val malkiQuotes = arrayOf<String>(
    "¿¡Porqué no mejor me lo metes tu!?",
    "Quiero la gente lo tenga duro."
)
val pepeQuotes = arrayOf<String>(
    "No jueguen destiny si les pica un huevo.",
    "Mujer con pito, my favourite."
)

val quotesPerPerson = hashMapOf<String, Array<String>>(
    arturoName to arturoQuotes, fernandoName to fernandoQuotes,
    danielName to danielQuotes, lucaName to lucaQuotes, laloName to laloQuotes,
    malkiName to malkiQuotes, pepeName to pepeQuotes
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dasherName = findViewById<TextView>(R.id.dasherName)
        val dasherQuote = findViewById<TextView>(R.id.dasherQuote)

        val randomName = names[Random.nextInt(0, names.size)]
        val randomQuote = quotesPerPerson[randomName]

        dasherName.text = randomName
        dasherQuote.text = randomQuote?.get(Random.nextInt(0, randomQuote.size)) ?: ""
    }
}