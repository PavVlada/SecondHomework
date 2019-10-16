package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.text_view)

        val counterValue = intent.getIntExtra("TAP_KEY", 0)
        val clickedBool = intent.getBooleanExtra("CLICK_KEY", false)
        val strVal = intent.getStringExtra("TEXT_KEY")
        textView.setText("Button was tapped ${counterValue} times\nText: ${strVal}\nIndicator button ${when(clickedBool){
                    true-> "was clicked"
                    false->"was not clicked"
                }
                }")
    }

}
