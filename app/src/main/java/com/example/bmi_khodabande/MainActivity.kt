

package com.example.bmi_khodabande

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.example.bmi_khodabande.databinding.ActivityMainBinding
import java.text.DecimalFormat


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var sharedPreferences: SharedPreferences//برای ذخیره سازی

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)



        sharedPreferences = getSharedPreferences("BMI_Preferences", MODE_PRIVATE)//



        var result = ""

        binding.button2.setOnClickListener {
            binding.root.closeKeyboard()
            result = vazn()
            binding.txtresult.visibility = View.VISIBLE
            binding.txtresult.text = " $result".toString()


            val bmiValue = result.toFloatOrNull()
            if (bmiValue != null) {
                if (bmiValue <=18.5) {
                    binding.textifbody.visibility = View.VISIBLE
                    binding.textifbody.text = "کمبود وزن"
                } else {
                    if (bmiValue in 18.05..25.0) {
                        binding.textifbody.visibility = View.VISIBLE
                        binding.textifbody.text = "وزن سلامت"
                    }
                }


            } else {

            }
            if (bmiValue != null) {
                if (bmiValue in 25.0..30.0) {
                    binding.textifbody.visibility = View.VISIBLE
                    binding.textifbody.text = "اضافه وزن"
                } else {
                    if (bmiValue >=30) {
                        binding.textifbody.visibility = View.VISIBLE
                        binding.textifbody.text = "چاقی "
                    }
                }
            } else {

            }







        }



        binding.more.setOnClickListener {
            val intentg=   Intent(this, MoreActivity::class.java)
            intentg.putExtra  ("name"   ,  result)
            startActivity(intentg)
        }




        binding.thrashImage.setOnClickListener {
            binding.editTextGhad.text?.clear()
            binding.editTextVazn.text?.clear()
            binding.txtresult.text = " "
            binding.textifbody.text =""
        } //وقتی روی دکمه سطل زباله کلیک کرد



        restoreResult()//ذخیره سازی



    }


    fun View.closeKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {//منو ارتباط
        return when (item.itemId) {

            R.id.menu_er -> {

                val dialog = AlertDialog.Builder(this)
                dialog.setTitle("برای ارتباط با سازنده")
                dialog.setMessage("akhodabande@gmail.com")
                dialog.setCancelable(false)
                dialog.setPositiveButton("ok") { _, _ ->
                }
                dialog.create().show()
                true
            }
            R.id.exit -> {
                finishAffinity()
                true
            }
            else -> false
        }
    }

    private fun ghad(): Float {


        if (binding.editTextGhad.text.toString().isEmpty()) {
            Toast.makeText(this, "لطفا مقادیر را پر کنید", Toast.LENGTH_SHORT).show()
            return 0.0f
        }  //وقتی کاربر وزن وارد نکرد

        val number1 = binding.editTextGhad.text.toString().toFloat() //قد را گرفته
        val ashar = number1 / 100

        return ashar * ashar
    }

    private fun vazn(): String {

        if (binding.editTextVazn.text.toString().isEmpty()) {
            Toast.makeText(this, "لطفا مقادیر را پر کنید", Toast.LENGTH_SHORT).show()
            return ""

        }  //وقتی کاربر قد وارد نکرد

        val number2 = binding.editTextVazn.text.toString().toFloat()
        val result = number2 / ghad()   // وزن تقسیم بر قد
        return "%.1f".format(result)  // فقط یک رقم بعد از اعشار نمایش دهد

    }

    private fun restoreResult() {//
        val result = sharedPreferences.getString("bmi_result", "")
        if (result?.isNotEmpty() == true) {
            binding.txtresult.visibility = View.VISIBLE
            binding.txtresult.text = result
        }
    }

    private fun saveResult(result: String) {//
        val editor = sharedPreferences.edit()
        editor.putString("bmi_result", result)
        editor.apply()
    }
}

//private fun vazn(): String {
//val number2 = binding.editTextNumber4.text.toString().toInt()
//val result = number2 / ghad()
//return "$result"