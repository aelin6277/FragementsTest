package com.example.fragementstest


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragementstest.databinding.ActivityMainBinding

import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), FragmentCommunicator {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize FragmentA and FragmentB if the activity is newly created
        if (savedInstanceState == null) {
            setupFragment(R.id.fragmentAContainer, FragmentMenu())
            setupFragment(R.id.fragmentBContainer, FragmentB())
        }
    }


    // Helper function to set up fragments
    private fun setupFragment(containerId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(containerId, fragment)
            .commit()
    }

    override fun passDataToFragmentB(message: String) {
        // Find FragmentB and pass the message
        val fragmentB = supportFragmentManager.findFragmentById(R.id.fragmentBContainer) as? FragmentB
        fragmentB?.displayReceivedData(message)
    }
}





//
//
//
//
//
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.viewpager.widget.ViewPager
//import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var menuFragment: MenuFragment
//    private lateinit var drawingFragment: DrawingFragment
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Initialisera dina fragments
//        menuFragment = MenuFragment()
//        drawingFragment = DrawingFragment()
//
//        // Visa som standard när aktiviteten skapas
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, menuFragment)
//            .commit()
//
//        val triangleButton = findViewById<Button>(R.id.triangleButton)//esta deberia estar en menuFragment?
//
//        triangleButton.setOnClickListener {
//            replaceFragment(menuFragment) //Esta correcto, o debe ser drawingFragment? Q esta pasando aca?
//        }
//
//
//        // Funktion för att byta till DrawingFragment
//        fun showDrawingFragment(view: View) {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainer, drawingFragment) //or should it say menuFragment here?
//                    .addToBackStack(null)
//                    .commit()
//        }
//    }
//
//    private fun replaceFragment(menufragment: Fragment) {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainer, drawingFragment)
//            .commit()
//
//    }
//}
