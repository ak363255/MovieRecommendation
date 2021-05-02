package com.example.movierecommendation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.movierecommendation.fragments.MovieListFragment
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(MovieListFragment.getNewInstance())
    }

    fun getData(){
        Thread(Runnable {
            val userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36\n"
            val url =  "https://www.imdb.com/search/title/?genres=drama"
            var googleUrl = "https://www.google.com/search?q=apple"
            var doc = Jsoup.connect(url).userAgent(userAgent).get()
            var links = doc.select("div").addClass("lister-item-image")
            for(item in links){
                Log.d("doc","text "+item.select("img").attr("loadlate"))
            }
          //  Log.d("doc","df "+doc.outerHtml())
        }).start()
    }
    private fun changeFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment,null).commit()
    }
}