package bonch.dev.school

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

const val REQUEST_CODE_SECOND_ACTIVITY = 1
const val REQUEST_CODE_THIRD_ACTIVITY = 2

class FirstActivity : AppCompatActivity() {

    private lateinit var secondActivityButton: Button
    private lateinit var thirdActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secondActivityButton = findViewById(R.id.second_activity_button)
        thirdActivityButton = findViewById(R.id.third_activity_button)

        secondActivityButton.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_SECOND_ACTIVITY)
        }

        thirdActivityButton.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_THIRD_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                REQUEST_CODE_SECOND_ACTIVITY -> Toast.makeText(this, "Button was clicked by SECOND activity!", Toast.LENGTH_SHORT).show()
                REQUEST_CODE_THIRD_ACTIVITY -> Toast.makeText(this, "Button was clicked by THIRD activity!", Toast.LENGTH_SHORT).show()
            }
        }
        else {
            Toast.makeText(this, "Button WASN'T clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
