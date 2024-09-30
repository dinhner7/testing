package com.example.testing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Tab4 : Fragment() {

    private lateinit var profPic:ImageButton
    private lateinit var warningTxt:TextView
    private lateinit var closeB:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profPic = view.findViewById(R.id.profButton)
        warningTxt = view.findViewById(R.id.warningTxt)
        closeB = view.findViewById(R.id.closeButton)

        warningTxt.visibility = View.GONE
        closeB.visibility = View.GONE

        profPic.setOnClickListener {
            warningTxt.visibility = View.VISIBLE
            closeB.visibility = View.VISIBLE
        }

        closeB.setOnClickListener {
            warningTxt.visibility = View.GONE
            closeB.visibility = View.GONE
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tab4.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tab4().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}