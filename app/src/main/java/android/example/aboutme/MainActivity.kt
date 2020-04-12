package android.example.aboutme

import android.content.Context
import android.example.aboutme.databinding.MainActivityBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    // Instantiation of the binding variable
    private lateinit var binding: MainActivityBinding
    private val myName: MyName = MyName("SrLitem")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Creation of the binding object and association of the layout with the current activity
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        // Assigning the data name
        binding.myName = myName
        // Adding listener to the "Done" button
        binding.doneButton.setOnClickListener{
            addNickname(it)
        }
    }
    // Function to show the typed text below the input field and hide the keyboard
    private fun addNickname(view: View){
        // Show the typed text
        // Kotlinizing the function
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll() //! Refreshes the UI with the new data by invalidating the current binding expressions
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val keyB = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyB.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
