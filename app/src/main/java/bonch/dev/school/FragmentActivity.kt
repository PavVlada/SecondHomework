package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import bonch.dev.school.fragments.FirstFragment
import bonch.dev.school.fragments.SecondFragment


class FragmentActivity : AppCompatActivity() {

    val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        fragmentManager.beginTransaction()
            .add(R.id.fragment, firstFragment)
            .commit()

    }

    fun replaceFragment(){
        val secondFragment = SecondFragment()
        fragmentManager.beginTransaction()
            .replace(R.id.fragment, secondFragment)
            .addToBackStack("second+fragment")
            .commit()
    }
}
