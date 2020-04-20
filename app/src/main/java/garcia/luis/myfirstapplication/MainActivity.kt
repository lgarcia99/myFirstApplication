package garcia.luis.myfirstapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var mas = 100
    var menos = 0
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etiqueta: TextView = findViewById(R.id.etiqueta)
        val up: Button = findViewById<Button>(R.id.up)
        val down: Button = findViewById<Button>(R.id.down)
        val generate: Button = findViewById<Button>(R.id.generate)
        val correct: Button = findViewById<Button>(R.id.correct)
        val restart: Button = findViewById<Button>(R.id.restart)

        generate.setOnClickListener {
            num = Random.nextInt(0, 100)
            etiqueta.text = "" + num
            with(generate) { setEnabled(false) }
        }

        up.setOnClickListener {
            menos = num
            num = Random.nextInt(0, mas)
            etiqueta.text = "" + num
        }

        down.setOnClickListener {
            mas = num
            num = Random.nextInt(menos, 100)
            etiqueta.text = "" + num
        }

        correct.setOnClickListener {
            etiqueta.text = "Su número es: $num"
        }

        restart.setOnClickListener {
            with(generate) { setEnabled(true) }
            mas = 100
            menos = 0
            num = 0
            etiqueta.text = "Presiona el botón de generar"
        }
    }
}
