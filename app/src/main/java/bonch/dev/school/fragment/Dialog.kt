package bonch.dev.school.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import bonch.dev.school.R

class Dialog : DialogFragment(){

    private lateinit var okButton : Button
    private lateinit var cancelButton: Button
    private lateinit var textView : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dialog, container, false)

        okButton = view.findViewById(R.id.ok_button)
        cancelButton = view.findViewById(R.id.cancel_button)
        textView = view.findViewById(R.id.text_view)

        okButton.setOnClickListener{
            Toast.makeText(context, "OK was clicked", Toast.LENGTH_SHORT).show()
            dismiss()

        }

        cancelButton.setOnClickListener{
            Toast.makeText(context, "CANCEL was clicked", Toast.LENGTH_SHORT).show()
            dismiss()

        }
        return view
    }
}