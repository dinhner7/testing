package com.example.testing

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.compose.runtime.Composable
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tab2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tab2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    // for my dropdown menu


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    /* if view is non-null, we can populate spinner button etc */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab2, container, false)
        val dropdown_vals = mutableListOf("Option 1", "Option 2", "Option 3")
        val spinner = view.findViewById<Spinner>(R.id.Dropdown)

        // spinner array adapter
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.dropdown_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.setAdapter(adapter)
        }
        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            // there has to be a better way to get the selected button\

            val radio_group = view.findViewById<RadioGroup>(R.id.radioGroup3)
            val radio_button_ID = radio_group.checkedRadioButtonId
            val radio_button_obj = radio_group.findViewById<RadioButton>(radio_button_ID)
            val idx_of_button = radio_group.indexOfChild(radio_button_obj) + 1

            // dropdown selection
            val dropdown_selection = spinner.selectedItem.toString()

            val string_to_display = StringBuilder("You ")
            if (idx_of_button > 0) {
                string_to_display.append(" selected Option: " + idx_of_button + " for the radio button, " +
                        "and " + dropdown_selection + " for the dropdown menu.")
            } else {
                string_to_display.append(
                    " did not select a radio button option, but selected "
                            + dropdown_selection + " for the dropdown menu."
                )
            }

            val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
            builder.setMessage(string_to_display).setTitle("Dialog")
            val dialog = builder.create()
            dialog.show()
        }

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tab2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tab2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}