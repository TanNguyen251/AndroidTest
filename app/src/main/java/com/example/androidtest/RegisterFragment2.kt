package com.example.androidtest

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_register2.view.*


class RegisterFragment2 : Fragment() {
    private var listener: OnRegisterFragment2Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register2, container, false)
        init(view)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity
    }

    interface OnRegisterFragment2Listener{
        fun onClick2(street: String, city: String, country: String)
    }

    private fun init(view: View){
        view.register2_button_send.setOnClickListener{
            var street = view.register2_edit_text_street.text.toString()
            var city = view.register2_edit_text_city.text.toString()
            var country = view.register2_edit_text_country.text.toString()
            listener?.onClick2(street, city, country)
        }

    }
}