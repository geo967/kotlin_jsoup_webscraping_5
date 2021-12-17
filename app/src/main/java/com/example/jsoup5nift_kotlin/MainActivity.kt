package com.example.jsoup5nift_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jsoup5nift_kotlin.databinding.ActivityMainBinding
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getDataFromWeb()
    }

    private fun getDataFromWeb() {
        thread {
           val doc= Jsoup.connect("https://www.tutlane.com/tutorial/android/android-activity-lifecycle")
                .timeout(60000).validateTLSCertificates(false)
                .get()
            val getElement=doc.getElementsByClass("col-md-12 col-sm-12")
            val price=getElement[0].getElementsByTag("strong")
            this.runOnUiThread {
                binding.textId.text=price.text().toString()
            }
        /*    val doc= Jsoup.connect("https://www.bookmyforex.com/us-dollar/rates/kochi/")
                .timeout(60000).validateTLSCertificates(false)
                .get()
            val textElement=doc.getElementsByTag("h1")

            val textNew=doc.getElementsByTag("td")

            this.runOnUiThread {
                binding.textId.text=textNew[1].text()
            }*/


        }


    }
}