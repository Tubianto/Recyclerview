package com.tubianto.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Tubianto on 04/01/2021.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var rvItem: RecyclerView
    private lateinit var adapter: RvAdapter
    private var dataItems = arrayListOf<DataItem>(
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Cara-mengubah-ViewGroup-menjadi-gambar-di-android-studio-734x414.png","Cara mengubah ViewGroup menjadi gambar di android studio","JUNI 25, 2021","https://tubianto.com/cara-mengubah-viewgroup-menjadi-gambar-di-android-studio/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Tutorial-membuat-aplikasi-alarm-sederhana-di-android-studio-732x414.png","Tutorial membuat aplikasi alarm sederhana di android studio","JUNI 22, 2021","https://tubianto.com/tutorial-membuat-aplikasi-alarm-sederhana-di-android-studio/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Tutorial-membuat-aplikasi-tanda-tangan-digital-dengan-android-studio-732x414.png","Tutorial membuat aplikasi tanda tangan digital dengan android studio","JUNI 21, 2021","https://tubianto.com/tutorial-membuat-aplikasi-tanda-tangan-digital-dengan-android-studio/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Mengambil-gambar-dari-kamera-atau-galeri-dan-ditampilkan-pada-ImageView-732x414.png","Mengambil gambar dari kamera atau galeri dan ditampilkan pada ImageView","JUNI 19, 2021","https://tubianto.com/mengambil-gambar-dari-kamera-atau-galeri-dan-ditampilkan-pada-imageview/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Membuat-aplikasi-QR-Code-Scanner-menggunakan-kotlin-731x414.png","Membuat aplikasi QR Code Scanner menggunakan kotlin","JUNI 18, 2021","https://tubianto.com/membuat-aplikasi-qr-code-scanner-menggunakan-kotlin/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Membuat-QR-Code-menggunakan-library-QRGen-733x414.png","Membuat aplikasi QR Code Generator menggunakan library QRGen","JUNI 17, 2021","https://tubianto.com/membuat-qr-code-menggunakan-library-qrgen/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Cara-membuat-session-untuk-login-dan-logout-menggunakan-SharedPreferences-731x414.jpg","Cara membuat session untuk login dan logout menggunakan SharedPreferences","JUNI 15, 2021","https://tubianto.com/cara-membuat-session-untuk-login-dan-logout-menggunakan-sharedpreferences/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Tutorial-print-atau-save-as-pdf-halaman-webview-dengan-PrintManager-594x414.jpg","Tutorial print atau save as pdf halaman webview dengan PrintManager","JUNI 10, 2021","https://tubianto.com/tutorial-print-atau-save-as-pdf-halaman-webview-dengan-printmanager/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Membuat-aplikasi-webview-dengan-kotlin-735x414.jpg","Membuat aplikasi webview dengan kotlin","MEI 27, 2021","https://tubianto.com/membuat-aplikasi-webview-dengan-kotlin/"),
        DataItem("https://tubianto.com/wp-content/uploads/2021/06/Membuat-splash-screen-sederhana-di-android-studio-733x414.jpg","Membuat splash screen sederhana di android studio","MEI 17, 2021","https://tubianto.com/membuat-splash-screen-sederhana-di-android-studio/")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        setupUI()
    }

    private fun init() {
        rvItem = findViewById(R.id.rv_item)
        rvItem.layoutManager = LinearLayoutManager(this)
        adapter = RvAdapter(this, arrayListOf())
        rvItem.adapter = adapter
    }

    private fun setupUI() {
        getData()
    }

    private fun getData() {
        retrieveList(dataItems)
    }

    private fun retrieveList(items: List<DataItem>) {
        adapter.apply {
            addItems(items)
            notifyDataSetChanged()
        }
    }
}