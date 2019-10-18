package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import bonch.dev.school.fragment.MyFragment
import bonch.dev.school.model.Counter


class FragmentActivity : AppCompatActivity() {

    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var counter: Counter
    private lateinit var textField: EditText
    private lateinit var attachFragmentButton: Button

    private var isClicked: Boolean = false
    private var str: String = ""
    private val fragment = MyFragment()

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

        attachFragmentButton.setOnClickListener() {
            str = textField.getText().toString()
            val fragmentManager = supportFragmentManager

            fragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .addToBackStack("fragment")
                .commit()

            val arg = Bundle()
            arg.putInt("TAP_KEY", counter.currentCount)
            arg.putBoolean("CLICK_KEY", isClicked)
            arg.putString("TEXT_KEY", str)
            fragment.arguments = arg
            
            attachFragmentButton.setEnabled(false)
        }

    }
    private fun initializeView(){
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        textField = findViewById(R.id.text_field)
        attachFragmentButton = findViewById(R.id.attach_fragment_button)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNTS", counter.currentCount)
        outState.putBoolean("CLICK_AMOUNTS", !indicatorButton.isEnabled())
        outState.putString("TEXT_AMOUNTS", textField.getText().toString())
    }
}

