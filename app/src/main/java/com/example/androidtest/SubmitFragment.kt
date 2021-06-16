package com.example.androidtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_submit.view.*


class SubmitFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getSerializable("USER") as User
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_submit, container, false)
        init(view)
        return view
    }

    private fun init(view: View){
        view.submit_text_name.text = user?.name
        view.submit_text_email.text = user?.email
        view.submit_text_phone.text = user?.phone
        view.submit_text_street.text = user?.street
        view.submit_text_city.text = user?.city
        view.submit_text_country.text = user?.country
        view.submit_button_submit.setOnClickListener{
            activity?.supportFragmentManager?.beginTransaction()?.replace(
                R.id.main_fragment_container,
                ThankYouFragment()
            )?.addToBackStack("")?.commit()
        }
    }

    companion object {

        @JvmStatic fun newInstance(user:User) =
                SubmitFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable("USER", user)
                    }
                }
    }
}