package bonch.dev.school

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class FirstActivity : AppCompatActivity() {

    private lateinit var secondActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secondActivityButton = findViewById(R.id.second_activity_button)

        secondActivityButton.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK)
            Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Button WASN'T clicked!", Toast.LENGTH_SHORT).show()
    }
}

