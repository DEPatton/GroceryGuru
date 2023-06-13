package com.example.groceryguru_derrick
import java.util.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

        /*fun updateWeekView() {
            val calendar = Calendar.getInstance()
            val currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

            // Set the calendar to the start of the week (adjust based on your locale, e.g., Sunday in the US)
            calendar.add(Calendar.DAY_OF_MONTH, -currentDayOfWeek + 1)

            // Update each day view
            for (i in 1..7) {
                val dayViewId = resources.getIdentifier("day$i", "id", packageName)
                val dayView: TextView = findViewById(dayViewId)

                // Format the date to display as "Mon\n12"
                val dayOfWeek = SimpleDateFormat("EEE", Locale.getDefault()).format(calendar.time)
                val dayOfMonth = SimpleDateFormat("d", Locale.getDefault()).format(calendar.time)
                dayView.text = "$dayOfWeek\n$dayOfMonth"

                // Highlight today
                if (i == currentDayOfWeek) {
                    dayView.background = resources.getDrawable(R.drawable.green_oval, null)
                } else {
                    dayView.background = null
                }

                // Move to the next day
                calendar.add(Calendar.DAY_OF_MONTH, 1)
            }
        }

    }*/
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_home, container, false)
        }
}