package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import bonch.dev.school.models.Counter

class FirstActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var counter: Counter
    private lateinit var textField: EditText
    private lateinit var nextActivityButton: Button

    private var isClicked: Boolean = false
    private var str: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        indicatorButton.setEnabled(true)
        counter = if(savedInstanceState == null){
            Counter()
        } else{
            Counter(savedInstanceState.getInt("TAP_AMOUNTS"))
        }
        isClicked = savedInstanceState?.getBoolean("CLICK_AMOUNTS") ?: false
        indicatorButton.setEnabled(!isClicked)
        str = savedInstanceState?.getString("TEXT_AMOUNTS") ?: textField.getText().toString()


        setListeners()
    }

    private fun setListeners() {
        indicatorButton.setOnClickListener {
            indicatorButton.setEnabled(false)
            isClicked = !indicatorButton.isEnabled()
        }

        counterButton.setOnClickListener{
            counter.increment()
        }

        nextActivityButton.setOnClickListener() {
            str = textField.getText().toString()
            val intent = Intent(FirstActivity@ this, SecondActivity::class.java)
            intent.putExtra("TAP_KEY", counter.currentCount)
            intent.putExtra("CLICK_KEY", isClicked)
            intent.putExtra("TEXT_KEY", str)
            startActivity(intent)
        }
    }

    private fun initializeView(){
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        textField = findViewById(R.id.text_field)
        nextActivityButton = findViewById(R.id.next_activity_button)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNTS", counter.currentCount)
        outState.putBoolean("CLICK_AMOUNTS", !indicatorButton.isEnabled())
        outState.putString("TEXT_AMOUNTS", textField.getText().toString())
    }
}
