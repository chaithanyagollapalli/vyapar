package com.nero.vyapar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_add_purchase.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.*

class AddPurchaseActivity : AppCompatActivity() {

//    private lateinit var bottomSheetDialog: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_purchase)

        btnSave.setOnClickListener {

            val bottomSheetDialog = BottomSheetDialog(this, R.style.BottomSheetDialogTheme)
            val view = LayoutInflater.from(applicationContext).inflate(
                R.layout.bottom_sheet_layout, findViewById(R.id.llBottomConatainer)
            )
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.setCanceledOnTouchOutside(true)
            bottomSheetDialog.show()
        }
    }
}