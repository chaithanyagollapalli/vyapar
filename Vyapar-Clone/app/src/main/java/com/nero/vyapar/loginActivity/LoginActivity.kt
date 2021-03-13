package com.nero.vyapar.loginActivity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.nero.vyapar.MainActivity
import com.nero.vyapar.PreferenceHelper
import com.nero.vyapar.R
import kotlinx.android.synthetic.main.activity_login.*
import org.intellij.lang.annotations.Language
import java.util.*

class LoginActivity : AppCompatActivity() {

    val PREF_BOOLEAN_KEY = "PREF_BOOLEAN_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val languages = resources.getStringArray(R.array.languageList)

        PreferenceHelper.getSharedPreferences(this)


//        val intentFilter = IntentFilter("Language.changed")

//        broadCastReceiver = BroadcastReceiver()
//        registerReceiver(broadCastReceiver, intentFilter)
        if (spinner2 != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
            spinner2.adapter = adapter
        }
        var bool2 = true
        val bool = PreferenceHelper.getBooleanFromPreference("lang")
        if (bool) {
            PreferenceHelper.writeBooleanToPreference("lang", false)
            bool2 = false
        }


        spinner2.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                val hindi: Boolean = true
//                PreferenceHelper.writeBooleanToPreference("lang", hindi)
                if (position == 1 && bool2) {
                    val locale = Locale("hi")
                    Locale.setDefault(locale)
                    val config = Configuration()
                    config.locale = locale
                    resources.updateConfiguration(config, resources.displayMetrics)
//                    val intent = Intent(this@LoginActivity, LoginActivity::class.java)
//                    startActivity(intent)
//                    recreate()
//                    sendBroadcast(Intent("Language.changed"))
                    PreferenceHelper.writeBooleanToPreference("lang", true)
                    recreate()


                } else {
                    val locale = Locale("en")
                    Locale.setDefault(locale)
                    val config = Configuration()
                    config.locale = locale
                    resources.updateConfiguration(config, resources.displayMetrics)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        openBottomSheet()

        btnGetOtp.setOnClickListener {
            if (isDataValid()) {
                val intent = Intent(this, OTPActivity::class.java)
                intent.putExtra("number", etEnterPhoneNumber.text.toString())
                startActivity(intent)
                finish()
            }
        }

        btnSignIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        spinner2.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 1) {
                    val locale = Locale("hi")
                    Locale.setDefault(locale)
                    val config = Configuration()
                    config.locale = locale
                    resources.updateConfiguration(config, resources.displayMetrics)


                } else {
                    val locale = Locale("en")
                    Locale.setDefault(locale)
                    val config = Configuration()
                    config.locale = locale
                    resources.updateConfiguration(config, resources.displayMetrics)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

//    override fun onDestroy() {
//        super.onDestroy()
////        unregisterReceiver(broadCastReceiver)
//    }

    private fun openBottomSheet() {
        val bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
        val view = layoutInflater.inflate(
            R.layout.login_bottom_sheet, findViewById(R.id.bsLogin)
        )
        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.setCanceledOnTouchOutside(true)
        bottomSheetDialog.show()

        val mBtnUse = bottomSheetDialog.findViewById<Button>(R.id.btnUseNumber)

        mBtnUse?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

//    private val broadCastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
//        override fun onReceive(context: Context?, intent: Intent?) {
//            startActivity(getIntent())
//        }
//    }

    private fun isDataValid(): Boolean {

        if (etEnterPhoneNumber.text.toString().length != 10) {
            etEnterPhoneNumber.error = "Enter valid phone number"
            return false
        }
        return true
    }

}