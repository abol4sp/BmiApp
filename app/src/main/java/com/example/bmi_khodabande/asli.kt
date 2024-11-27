package com.example.bmi_khodabande

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.bmi_khodabande.databinding.ActivityMainBinding
import com.example.bmi_khodabande.databinding.AsliBinding


@Suppress("DEPRECATION")
class asli:AppCompatActivity() {

    private lateinit var binding: AsliBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AsliBinding.inflate(layoutInflater)//(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        setContentView(binding.root)


        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.appCompatImageView.alpha = 0f // تنظیم شفافیت به صفر
        binding.appCompatImageView.animate().alpha(1f).duration = 4000


    binding.textView.translationX = 1000f
        binding.textView.animate().translationX(0f).duration = 3000












        binding.textView2.translationX = -1000f
        binding.textView2.animate().translationX(0f).duration = 3000




binding.button.setOnClickListener {
    val intent = Intent(this, MainActivity::class.java)
startActivity(intent)

}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {// برای منو
        menuInflater.inflate(R.menu.main_menu,menu )
return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id. menu_er-> {///


                    val dialog = AlertDialog.Builder(this)
                    dialog.setTitle("برای  ارتباط")
                    dialog.setMessage("abolfazllkhodabande@gmail.com")
                    dialog.setCancelable(false)
                    dialog.setPositiveButton("") { _, _ ->
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


