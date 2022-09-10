package ru.serlav.calculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numb_0.setOnClickListener { setText("0") }
        numb_1.setOnClickListener { setText("1") }
        numb_2.setOnClickListener { setText("2") }
        numb_3.setOnClickListener { setText("3") }
        numb_4.setOnClickListener { setText("4") }
        numb_5.setOnClickListener { setText("5") }
        numb_6.setOnClickListener { setText("6") }
        numb_7.setOnClickListener { setText("7") }
        numb_8.setOnClickListener { setText("8") }
        numb_9.setOnClickListener { setText("9") }

        btn_mult.setOnClickListener { setText("*") }
        btn_division.setOnClickListener { setText("/") }
        btn_plus.setOnClickListener { setText("+") }
        minus_btn.setOnClickListener { setText("-") }

        o_bracket.setOnClickListener { setText("(") }
        c_bracket.setOnClickListener { setText(")") }
        dot_btn.setOnClickListener { setText(".") }

        AC.setOnClickListener {
            match_operation.text = ""
            result.text = ""
        }

        back_btn.setOnClickListener {
            val str = match_operation.text.toString()
            if (str.isNotEmpty())
                match_operation.text = str.substring(0, str.length - 1)
            result.text = ""
        }
        equal_btn.setOnClickListener {
            val ex = ExpressionBuilder(match_operation.text.toString()).build()
            val res = ex.evaluate()

            val longRes = res.toLong()
            if (res == longRes.toDouble())
                result.text = longRes.toString()
            else
                result.text = res.toString()
        }

    }

    private fun setText(str: String) {
        if (result.text != "")
            match_operation.text = result.text
        result.text = ""
        match_operation.append(str)
    }
}