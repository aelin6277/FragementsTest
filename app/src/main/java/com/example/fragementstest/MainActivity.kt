package com.example.fragementstest
//Beh;ver skifta plats p[ drawing och meny, meny borde vara standard
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class MainActivity : AppCompatActivity() {

    private lateinit var menuFragment: MenuFragment
    private lateinit var drawingFragment: DrawingFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisera dina fragments
        menuFragment = MenuFragment
        drawingFragment = DrawingFragment

        // Visa som standard när aktiviteten skapas
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContaniner, menuFragment)
            .commit()

        val triangleButton = findViewById<Button>(R.id.triangleButton)//esta deberia estar en menuFragment?

        triangleButton.setOnClickListener {
            replaceFragment(menuFragment) //Esta correcto, o debe ser drawingFragment? Q esta pasando aca?
        }


        // Funktion för att byta till DrawingFragment
        fun showDrawingFragment(view: View) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, drawingFragment) //or should it say menuFragment here?
                    .addToBackStack(null)
                    .commit()
        }
    }

    private fun replaceFragment(menufragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, drawingFragment)
            .commit()

    }
}
