package eunix56.example.com.yorcalc

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class YorubaActivity : AppCompatActivity(), View.OnClickListener, TextWatcher{
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun afterTextChanged(p0: Editable?) {
        when(p0){
            first_input -> if (first_input.text.length == 4){
                first_input.clearFocus();
                operator.requestFocus();
            }
            operator -> if (operator.text.length == 1){
                operator.clearFocus()
                second_input .requestFocus();}
            second_input -> if (second_input.text.length == 4){
                second_input.clearFocus()
            }
        }

    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }


    override fun onClick(p0: View?) {

        when(p0){
            button_one -> textWatch(first_input, second_input, "1")
            button_two -> textWatch(first_input, second_input, "2")
            button_three -> textWatch(first_input, second_input, "3")
            button_four -> textWatch(first_input, second_input, "4")
            button_five -> textWatch(first_input, second_input, "5")
            button_six -> textWatch(first_input, second_input, "6")
            button_seven -> textWatch(first_input, second_input, "7")
            button_eight -> textWatch(first_input, second_input, "8")
            button_nine -> textWatch(first_input, second_input, "9")
            button_zero -> textWatch(first_input, second_input, "0")
            button_plus ->
                if (operator.text.isEmpty()){
                    operator.setText("+")
                    operator.setSelection(operator.text.length)
                    add = true
                }
//
//                operator.setText("+")
//            }
            button_minus ->  if (operator.text.isEmpty()){
                operator.setText("-")
                operator.setSelection(operator.text.length)
                sub = true
            }
//                if (operator.text.isEmpty()){
//                operator.setText("-")
//            }
            button_multiply ->  if (operator.text.isEmpty()){
                operator.setText("x")
                operator.setSelection(operator.text.length)
                mul = true
            }
//                if (operator.text.isEmpty()){
//                operator.setText("x")
//            }
            button_divide ->  if (operator.text.isEmpty()){
                operator.setText("/")
                operator.setSelection(operator.text.length)
                div = true
            }
            button_equal -> result.text = equal().toString()
//                if (operator.text.isEmpty()){
//                operator.setText("/")
//            }
            button_c ->
              clear()
        }
    }

    private lateinit var button_one: Button
    private lateinit var button_two: Button
    private lateinit var button_three: Button
    private lateinit var button_four: Button
    private lateinit var button_five: Button
    private lateinit var button_six: Button
    private lateinit var button_seven: Button
    private lateinit var button_eight: Button
    private lateinit var button_nine: Button
    private lateinit var button_zero: Button
    private lateinit var button_plus: Button
    private lateinit var button_minus: Button
    private lateinit var button_multiply: Button
    private lateinit var button_divide: Button
    private lateinit var button_equal: Button
    private lateinit var button_c: Button
    private lateinit var first_input: EditText
    private lateinit var operator: EditText
    private lateinit var second_input: EditText
    private lateinit var result: TextView
    private lateinit var yor_result: TextView
    private lateinit var yor_f_input: TextView
    private lateinit var yor_s_input: TextView
    private lateinit var yor_operator: TextView
    private lateinit var firstText:Editable
    private lateinit var secondText:Editable
    private lateinit var operate:Editable
    var add = false
    var sub = false
    var mul = false
    var div = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoruba)



        button_one = findViewById(R.id.button_one)
        button_two = findViewById(R.id.button_two)
        button_three = findViewById(R.id.button_three)
        button_four= findViewById(R.id.button_four)
        button_five = findViewById(R.id.button_five)
        button_six = findViewById(R.id.button_six)
        button_seven = findViewById(R.id.button_seven)
        button_eight = findViewById(R.id.button_eight)
        button_nine = findViewById(R.id.button_nine)
        button_zero = findViewById(R.id.button_zero)
        button_equal = findViewById(R.id.button_equal)
        button_plus = findViewById(R.id.button_plus)
        button_minus = findViewById(R.id.button_minus)
        button_divide = findViewById(R.id.button_div)
        button_multiply = findViewById(R.id.button_mul)
        button_c = findViewById(R.id.button_clear)
        first_input = findViewById(R.id.first_input)
        second_input = findViewById(R.id.second_input)
        operator = findViewById(R.id.operator)
        result = findViewById(R.id.result)
        yor_f_input = findViewById(R.id.yor_f_input)
        yor_s_input = findViewById(R.id.yor_s_input)
        yor_operator = findViewById(R.id.yor_operator)
        yor_result = findViewById(R.id.yor_result)


        button_one.setOnClickListener(this)
        button_two.setOnClickListener(this)
        button_three.setOnClickListener(this)
        button_four.setOnClickListener(this)
        button_five.setOnClickListener(this)
        button_six.setOnClickListener(this)
        button_seven.setOnClickListener(this)
        button_eight.setOnClickListener(this)
        button_nine.setOnClickListener(this)
        button_zero.setOnClickListener(this)
        button_plus.setOnClickListener(this)
        button_minus.setOnClickListener(this)
        button_multiply.setOnClickListener(this)
        button_divide.setOnClickListener(this)
        button_equal.setOnClickListener(this)
        button_c.setOnClickListener(this)

        firstText = first_input.text
        secondText = second_input.text
        operate = operator.text



    }

    fun textWatch(finput: EditText, linput: EditText, text: String){
        if (finput.isFocused && finput.text.isEmpty()){
            finput.setText(text)
            finput.setSelection(finput.text.length)
        }
        else if (finput.isFocused && finput.text.length < 4){
            finput.append(text)
            finput.setSelection(finput.text.length)
        }
        else if (linput.isFocused && linput.text.isEmpty()){
            finput.clearFocus()
            linput.setText(text)
            linput.setSelection(linput.text.length)
        }
        else if (linput.isFocused && linput.text.length < 4){
            linput.append(text)
            linput.setSelection(linput.text.length)
        }
    }

    fun clear(){
        first_input.setText("")
        yor_f_input.text = ""
        operator.setText("")
        yor_operator.text = ""
        second_input.setText("")
        yor_s_input.text = ""
        result.text = ""
        yor_result.text = ""
        first_input.requestFocus()
    }

    fun equal(): Double{
        return if (first_input.text.toString().isNotEmpty() && second_input.text.toString().isNotEmpty()) {
            when (operator.text.toString()) {
                "+" -> first_input.text.toString().toDouble() + second_input.text.toString().toDouble()
                "-" -> first_input.text.toString().toDouble() - second_input.text.toString().toDouble()
                "*" -> first_input.text.toString().toDouble() * second_input.text.toString().toDouble()
                "/" -> first_input.text.toString().toDouble() / second_input.text.toString().toDouble()
                else -> 0.0
            }
        }else{
            0.0
        }
    }
    fun operate(operand: String, ans: TextView){
        var answer = 0.0
        if (firstText.isEmpty() || operate.isEmpty() || secondText.isEmpty())
            return
        else {
            when (operand){
                "+" -> answer = firstText.toString().toDouble() + secondText.toString().toDouble()
                "-" -> if (firstText.toString().toDouble() > secondText.toString().toDouble()) {
                    answer = firstText.toString().toDouble() - secondText.toString().toDouble()
                }
                "x" -> answer = firstText.toString().toDouble() * secondText.toString().toDouble()
                "/" -> answer = firstText.toString().toDouble()
            }
            ans.text = answer.toString()

        }
    }

    fun hidekey(){

    }
}
