package com.nero.vyapar.loginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.nero.vyapar.MainActivity
import com.nero.vyapar.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.etEnterPhoneNumber
import kotlinx.android.synthetic.main.activity_otpactivity.*

class OTPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)

        var number: String = "964"

        if (intent != null && intent.extras != null) {
            val n1 = intent.getStringExtra("number")
            number = n1.toString()
        }
        tvEnterOtp.text = "Otp sent to $number."

        otpGenerator()

        btnSubmit.setOnClickListener {
            if (isDataValid()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    private fun otpGenerator() {
        Handler().postDelayed({
            etEnterOtp.setText("1940")
        }, 3000)
    }

    private fun isDataValid(): Boolean {

        if (etEnterOtp.text.toString().length != 4) {
            etEnterOtp.error = "Enter valid OTP"
            return false
        }
        return true
    }
}