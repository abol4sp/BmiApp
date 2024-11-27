package com.example.bmi_khodabande

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.bmi_khodabande.databinding.ActivityMainBinding
import com.example.bmi_khodabande.databinding.MoreBinding

class MoreActivity: AppCompatActivity() {
    private lateinit var binding: MoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        val name = intent.getStringExtra("name")

binding.textViewmore.text = name.toString()

}
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu )
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id. menu_er-> {///


                val dialog = AlertDialog.Builder(this)
                dialog.setTitle("برای ارتباط")
                dialog.setMessage("akhodabande@gmail.com")
                dialog.setCancelable(false)
                dialog.setPositiveButton("ok") { _, _ ->
                    Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()//rasty
                }
                dialog.setNegativeButton("") { _, _ ->

                }
                dialog.setNeutralButton("") { _, _ ->

                }
                dialog.create().show()
                true
            }

            R.id.exit-> {
                finish()
                true
            }

            else -> false
        }
    }

}