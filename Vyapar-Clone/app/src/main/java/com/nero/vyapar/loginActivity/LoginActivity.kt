package com.nero.vyapar.loginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.nero.vyapar.MainActivity
import com.nero.vyapar.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        openBottomSheet()

        btnGetOtp.setOnClickListener {
          if (isDataValid()){
              val intent = Intent(this, OTPActivity::class.java)
              intent.putExtra("number",etEnterPhoneNumber.text.toString())
              startActivity(intent)
              finish()
          }
        }


    }

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

    private fun isDataValid(): Boolean {

        if (etEnterPhoneNumber.text.toString().length!=10){
            etEnterPhoneNumber.error = "Enter valid phone number"
            return false
        }
        return true
    }

}