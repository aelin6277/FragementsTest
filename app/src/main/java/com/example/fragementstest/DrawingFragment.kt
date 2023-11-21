package com.example.fragementstest
//ska innehålla en surfaceView som slumpar ut figurer baserat på den input som anges i fragment 1
//Med ”slumpar ut” menas att något/några attribut på figurer som ritas upp skall vara slumpmässiga
//(färg, position etc)
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DrawingFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_drawing, container, false)
    }

}