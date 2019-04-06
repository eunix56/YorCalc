package eunix56.example.com.yorcalc

import android.text.InputFilter
import android.text.Spanned

class InputMax(min: Int, max: Int): InputFilter {
    var min = min
    var max = max

    override fun filter(p0: CharSequence?, p1: Int, p2: Int, p3: Spanned?, p4: Int, p5: Int): CharSequence? {
        try {
            var input = p3.toString().substring(0, p4) + p3.toString().substring(p5, p3.toString().length)
            input = input.substring(0, p4) + p0.toString() + input.substring(p4, input.length)
            var value = input.toInt()
            if (inRange(min, max, value)) return null
        }catch (e: NumberFormatException){
            e.printStackTrace()
        }
        return ""
    }

    private fun inRange(a: Int, b: Int, c: Int): Boolean{
        return if (b>a) c in a..b
        else c in b..a
    }
}