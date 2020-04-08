package android.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        // Adding listener to the "Done" button
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)
        }
    }
    // Function to show the typed text below the input field and hide the keyboard
    private fun addNickname(view: View){
        // Show the typed text
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nameTextView = findViewById<TextView>(R.id.nickname_text)
        nameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickname_text.visibility = View.VISIBLE
        // Hide the keyboard
        val keyB = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyB.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
