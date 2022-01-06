package uz.pdp.listunderthehood

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var linearLayout: LinearLayout
    private lateinit var loadButton: Button
    private lateinit var laptops: ArrayList<Laptop>
    private val TAG = "MainLifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: ")

        laptops = ArrayList()

        for (i in 0..5) {
            laptops.add(Laptop(R.drawable.laptop_image,
                "Acer Aspire VX 15",
                "Компания Acer уже достаточно давно выделила свою игровую продукцию в отдельную линейку и создала для неё дочерний бренд Predator. При этом серия рабочих лошадок Aspire осталась на своём месте, продолжая расширяться и обновляться. Ноутбук, попавший к нам на обзор, балансирует на грани этих двух модельных направлений. Acer Aspire VX15 — игровой ноутбук, принадлежащий к более скромному семейству, чем Predator, с более гуманным ценником."))
        }

        initViews()

        if (savedInstanceState != null) {
            val savedLaptops = savedInstanceState.getParcelableArrayList<Laptop>("laptops")
            savedLaptops!!.forEach {
                linearLayout.addView(addItem(it))
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelableArrayList("laptops", laptops)
        super.onSaveInstanceState(outState)
    }
    private fun initViews() {

        linearLayout = findViewById(R.id.container_root)
        loadButton = findViewById(R.id.btn_load)

        loadButton.setOnClickListener {
            for (laptop in laptops) {
                linearLayout.addView(addItem(laptop))
            }
        }


    }

    private fun addItem(laptop: Laptop): LinearLayout {

        val tempLinearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val parms = LinearLayout.LayoutParams(-1, -2)
            parms.setMargins(50, 50, 50, 50)
            background = getDrawable(R.drawable.rounder_backround)
            layoutParams = parms
        }

        val imageView = ImageView(this).apply {
            val parms = LinearLayout.LayoutParams(-1, 350)
            parms.setMargins(50, 50, 50, 50)
            setImageResource(laptop.image)
            layoutParams = parms
        }

        val titleTextView = TextView(this).apply {
            text = laptop.title
            val parms = LinearLayout.LayoutParams(-1, -2)
            parms.setMargins(50, 50, 50, 50)
            layoutParams = parms
            textSize = 20f
        }

        val descTextView = TextView(this).apply {
            val parms = LinearLayout.LayoutParams(-1, -2)
            parms.setMargins(50, 50, 50, 50)
            layoutParams = parms
            text = laptop.description
        }

        tempLinearLayout.addView(imageView)
        tempLinearLayout.addView(titleTextView)
        tempLinearLayout.addView(descTextView)

        return tempLinearLayout

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

}