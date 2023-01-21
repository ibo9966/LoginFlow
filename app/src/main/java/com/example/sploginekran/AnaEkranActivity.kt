package com.example.sploginekran

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ana_ekran.*
import kotlinx.android.synthetic.main.activity_main.*

class AnaEkranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ana_ekran)

        val sp=getSharedPreferences("GirisBilgi", Context.MODE_PRIVATE)

        val ka = sp.getString("kullaniciAdi","kullanıcı adı yok")
        val s = sp.getString("sifre","şifre yok")

        textViewCikti.text="Kullanıcı Adı : $ka Şifre : $s"


        buttonCikisYap.setOnClickListener{

            val editor = sp.edit()
            editor.remove("kullaniciAdi")
            editor.remove("sifre")
            editor.commit()

            startActivity(Intent(this@AnaEkranActivity,MainActivity::class.java))
            finish()
        }
    }
}