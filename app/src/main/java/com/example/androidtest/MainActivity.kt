package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RegisterFragment1.OnRegisterFragmentListener,
    RegisterFragment2.OnRegisterFragment2Listener {
    private var name = ""
    private var email = ""
    private var phone = ""
    private var street = ""
    private var city = ""
    private var country = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        var fragmentManager = supportFragmentManager
        var fragmentTransaction = fragmentManager.beginTransaction()
        var fragment1 = RegisterFragment1()

        fragmentTransaction.add(R.id.main_fragment_container, fragment1)
        fragmentTransaction.commit()
    }

    override fun onClick1(name: String, email: String, phone: String) {
        this.name = name
        this.email = email
        this.phone = phone
        supportFragmentManager.beginTransaction().replace(
            R.id.main_fragment_container,
            RegisterFragment2()
        ).addToBackStack("").commit()
    }

    override fun onClick2(street: String, city: String, country: String) {
        this.street = street
        this.city = city
        this.country = country
        var user = User(this.name, this.email, this.phone, this.street, this.city, this.country)
        var submitFragment = SubmitFragment.newInstance(user)
        supportFragmentManager.beginTransaction().replace(
            R.id.main_fragment_container,
            submitFragment
        ).addToBackStack("").commit()
    }
}