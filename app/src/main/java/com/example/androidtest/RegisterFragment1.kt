package com.example.androidtest

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_register1.view.*


class RegisterFragment1 : Fragment() {
    private var listener: OnRegisterFragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register1, container, false)
        init(view)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as MainActivity
    }

    interface OnRegisterFragmentListener{
        fun onClick1(name: String, email: String, phone: String)
    }

    private fun init(view: View){
        view.register1_button_send.setOnClickListener{
            var name = view.register1_edit_text_name.text.toString()
            var email = view.register1_edit_text_email.text.toString()
            var phone = view.register1_edit_text_phone.text.toString()
            listener?.onClick1(name, email, phone)
        }

    }
}