package com.example.fragementstest
//ska innehålla en surfaceView som slumpar ut figurer baserat på den input som anges i fragment 1
//Med ”slumpar ut” menas att något/några attribut på figurer som ritas upp skall vara slumpmässiga
//(färg, position etc)
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.fragementstest.databinding.DrawingFragmentBinding


class DrawingFragment : Fragment() {
    private var _binding: DrawingFragmentBinding? = null
    private val binding get() = _binding!!

    private var automaticBallX = 100f
    private var automaticBallY = 100f
    private var automaticBallSpeedX = 5f
    private var automaticBallSpeedY = 5f

    private var draggableBallX = 300f
    private var draggableBallY = 300f
    private val draggableBallSize = 50f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DrawingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Lägg till en SurfaceView för att rita bollarna
        val surfaceView = SurfaceView(requireContext())
        val layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        surfaceView.layoutParams = layoutParams
        (view as FrameLayout).addView(surfaceView)

        // I din uppdateringsloop:
        surfaceView.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Kolla om användaren tryckte på den dragbara bollen
                    if (isCollision(
                            event.x,
                            event.y,
                            draggableBallX,
                            draggableBallY,
                            draggableBallSize
                        )
                    ) {
                        Toast.makeText(
                            requireContext(),
                            "Du tryckte på den dragbara bollen!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                MotionEvent.ACTION_MOVE -> {
                    // Uppdatera dragbar bolls position baserat på användarens input
                    draggableBallX = event.x
                    draggableBallY = event.y
                }
            }
            true
        }

        // Implementera en uppdateringsloop här och använd Canvas för att rita bollarna
        // Använd den befintliga uppdateringslogiken för den automatiskt rörande bollen
        // Kolla om bollarna kolliderar och ändra riktning om de gör det
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Funktion för att kolla om bollarna kolliderar
    private fun isCollision(x1: Float, y1: Float, x2: Float, y2: Float, radius2: Float): Boolean {
        val dx = x1 - x2
        val dy = y1 - y2
        val distance = Math.sqrt((dx * dx + dy * dy).toDouble()).toFloat()
        return distance < radius2
    }
}

