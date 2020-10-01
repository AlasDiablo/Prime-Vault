package fr.alasdiablo.warframeprimevault

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        relicRecyclerView.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(relicRecyclerView.context, LinearLayoutManager.HORIZONTAL)
        relicRecyclerView.addItemDecoration(dividerItemDecoration)

        tab.addOnTabSelectedListener(TabListener(this))

        setRecyclerView("lith.json")

    }

    fun setRecyclerView(jsonName: String) {
        val json = loadJSONFromAsset(jsonName)

        val relics = if (json != null) {
            getRelicList(json)
        } else {
            listOf()
        }

        relicRecyclerView.adapter = RelicAdapter(relics, this)
    }

    private fun getRelicList(json: String): List<Relic> {
        try {
            val relicList = mutableListOf<Relic>()
            val jsonObject = JSONObject(json)
            val rawRelicList = jsonObject.getJSONArray("relic")
            for (i in 0 until rawRelicList.length()) {
                val relic = rawRelicList.getJSONObject(i)
                val dropTable = relic.getJSONObject("drop_table")
                relicList.add(Relic(
                    relic.getString("name"),
                    relic.getString("era"),
                    relic.getString("id"),
                    relic.getBoolean("vault"),
                    dropTable.getString("common_1"),
                    dropTable.getString("common_2"),
                    dropTable.getString("common_3"),
                    dropTable.getString("uncommon_1"),
                    dropTable.getString("uncommon_2"),
                    dropTable.getString("rare")
                ))
            }
            return relicList
        } catch (e: Exception) {
            e.printStackTrace()
            return listOf()
        }
    }

    private fun loadJSONFromAsset(jsonFileName: String): String? {
        val json: String?
        json = try {
            val `is`: InputStream = applicationContext.assets.open(jsonFileName)
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}
