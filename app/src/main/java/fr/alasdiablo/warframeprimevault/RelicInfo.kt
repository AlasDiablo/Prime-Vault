package fr.alasdiablo.warframeprimevault

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RelicInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relic_info)
        val bundle = intent.extras!!

        findViewById<TextView>(R.id.relic_name).text = bundle.getString("title")

        findViewById<TextView>(R.id.common_1).text = bundle.getString("common_1")
        findViewById<TextView>(R.id.common_2).text = bundle.getString("common_2")
        findViewById<TextView>(R.id.common_3).text = bundle.getString("common_3")

        findViewById<TextView>(R.id.uncommon_1).text = bundle.getString("uncommon_1")
        findViewById<TextView>(R.id.uncommon_2).text = bundle.getString("uncommon_2")

        findViewById<TextView>(R.id.rare_1).text = bundle.getString("rare_1")
    }
}
