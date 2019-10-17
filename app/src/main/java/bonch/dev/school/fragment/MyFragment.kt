package bonch.dev.school.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import bonch.dev.school.R

class MyFragment: Fragment() {

    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_fragment, container, false)

        textView = view.findViewById(R.id.text_view)
        val bundle: Bundle? = getArguments()
        if(bundle != null) {
            val counterValue = bundle.getInt("TAP_KEY")
            val clickedBool = bundle.getBoolean("CLICK_KEY")
            val strVal = bundle.getString("TEXT_KEY")
            textView.setText(
                "Button was tapped ${counterValue} times\nText: ${strVal}\nIndicator button ${when (clickedBool) {
                    true -> "was clicked"
                    false -> "was not clicked"
                }
                }"
            )
        }

        return view
    }

}