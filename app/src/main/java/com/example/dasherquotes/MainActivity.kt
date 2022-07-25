package com.example.dasherquotes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dasherquotes.quotes.api.APIService
import com.example.dasherquotes.quotes.api.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val arturoName = "Arturo"
const val fernandoName = "Fernando"
const val danielName = "Daniel"
const val lucaName = "Luca"
const val laloName = "Lalo"
const val malkiName = "Malki"
const val pepeName = "Pepe"

val names = arrayOf(
    arturoName, fernandoName, danielName, lucaName, laloName, malkiName, pepeName
)

val arturoQuotes = arrayOf(
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
val fernandoQuotes = arrayOf(
    "Boba Nomb.",
    "For the Motherland.",
    "Jow blob.",
    "Karoke?"
)
val danielQuotes = arrayOf(
    "The Game: The Movie 2: The Pre-Sequel.",
    "e uir.",
    "Tengo que e uir.",
    "Se ve muy oscuro en la oscuridad."
)
val lucaQuotes = arrayOf(
    "Vergurado.",
    "qur gluglr gaste alv.",
    "Ya lleue.",
    "A mira, soy una bolsa.",
    "Si consigues información tienes más información"
)
val laloQuotes = arrayOf(
    "Ichi coca.",
    "Ano-sumimasen...sobre?.",
    "No me gusta como se le ven los pelos de la punta."
)
val malkiQuotes = arrayOf(
    "¿¡Porqué no mejor me lo metes tu!?",
    "Quiero la gente lo tenga duro."
)
val pepeQuotes = arrayOf(
    "No jueguen destiny si les pica un huevo.",
    "Mujer con pito, my favourite."
)

val quotesPerPerson = hashMapOf(
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
        val newQuoteBtn = findViewById<Button>(R.id.newQuoteButton)

        newQuoteBtn.setOnClickListener {
            val samplesApi = RetrofitHelper.getInstance().create(APIService::class.java)
            // new coroutine
            CoroutineScope(Dispatchers.IO).launch {
                val result = samplesApi.getGames()
                runOnUiThread {
                    dasherName.text =
                        buildString {
                            append(result.body()?.get(0)?.id)
                            append("\n")
                            append(result.body()?.get(0)?.author)
                            append("\n")
                            append(result.body()?.get(0)?.content)
                        }
                    dasherQuote.text =
                        buildString {
                            append(result.body()?.get(0)?.date)
                            append("\n")
                            append(result.body()?.get(0)?.created_at)
                            append("\n")
                            append(result.body()?.get(0)?.updated_at)
                        }
                }
            }
        }
    }
}