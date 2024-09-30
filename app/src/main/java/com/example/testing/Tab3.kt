package com.example.testing

import android.os.Bundle
import android.text.SpannableString
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get

/**
 * A simple [Fragment] subclass.
 */
class Tab3 : Fragment() {
    private var taskList: ArrayList<String> = ArrayList()
    private lateinit var tasksAdapter: ArrayAdapter<String>
    private var listView: ListView? = null
    private var btnAddTask: Button? = null
    private var pltxtNewTask: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout
        val view = inflater.inflate(R.layout.fragment_tab3, container, false)

        // Initialize/set up vars
        listView = view.findViewById(R.id.lstviewTasks)
        btnAddTask = view.findViewById(R.id.btnAddTask)
        pltxtNewTask = view.findViewById(R.id.pltxtInputTask)
        tasksAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, taskList)
        listView?.adapter = tasksAdapter

        // Set listeners
        setListViewListener()
        btnAddTask?.setOnClickListener(::onAddBtnClicked)

        return view
    }

    private fun onAddBtnClicked(view: View) {
        val sItemText: String = pltxtNewTask?.text.toString()

        // Check if task entered is not blank
        if (sItemText.isNotEmpty()) {
            tasksAdapter.add(sItemText)
            tasksAdapter.notifyDataSetChanged()
            pltxtNewTask?.setText("")
        } else {
            Toast.makeText(requireContext(), "An empty task cannot be added", Toast.LENGTH_LONG).show()
        }
    }

    private fun setListViewListener() {
        // Check which item was clicked
        listView?.setOnItemLongClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), "Task removed", Toast.LENGTH_SHORT).show()

            // Remove item at the clicked position
            taskList.removeAt(position)
            tasksAdapter.notifyDataSetChanged()
            true
        }
    }
}