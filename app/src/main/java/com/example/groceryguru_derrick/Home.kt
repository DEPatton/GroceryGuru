package com.example.groceryguru_derrick

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Home : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
  
        /*fun updateWeekView() {
            val calendar = Calendar.getInstance()
            val currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateWeekView()
    }

    private fun updateWeekView() {
        val calendar = Calendar.getInstance()
        val currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

        // Set the calendar to the start of the week (adjust based on your locale, e.g., Sunday in the US)
        calendar.add(Calendar.DAY_OF_MONTH, -currentDayOfWeek + 1)

        // Update each day view
        for (i in 1..7) {
            val dayViewId = resources.getIdentifier("day$i", "id", requireContext().packageName)
            val dayView = view?.findViewById<TextView>(dayViewId)

            // Format the date to display as "Mon\n12"
            val dayOfWeek = SimpleDateFormat("EEE", Locale.getDefault()).format(calendar.time)
            val dayOfMonth = SimpleDateFormat("d", Locale.getDefault()).format(calendar.time)
            dayView?.text = "$dayOfWeek\n$dayOfMonth"

            // Highlight today
            if (i == currentDayOfWeek) {
                dayView?.background = ResourcesCompat.getDrawable(resources, R.drawable.green_oval, null)
            } else {
                dayView?.background = null
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
