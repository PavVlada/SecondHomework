package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import bonch.dev.school.fragment.Dialog

class DialogActivity : AppCompatActivity() {

    private lateinit var dialogButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogButton = findViewById(R.id.dialog_button)

        val fragment = Dialog()
        val fragmentManager = supportFragmentManager

        dialogButton.setOnClickListener{
            fragment.show(fragmentManager, "dialog_tag")
        }
    }
}
