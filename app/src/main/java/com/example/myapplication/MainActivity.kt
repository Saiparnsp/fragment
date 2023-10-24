package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import fragments.FragmentDown
import fragments.FragmentTop



class MainActivity : AppCompatActivity() {

    private  lateinit var activityMainBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.switchFragmentToptoDown.setOnClickListener {
            fragmentTopToDown(FragmentDown())
            activityMainBinding.switchFragmentToptoDown.visibility = View.GONE
        }

//        activityMainBinding.loginButton.setOnClickListener{
//            Toasty.success(this, "Login Success!", Toasty.LENGTH_SHORT, true).show();
//        }

    }


    private fun fragmentTopToDown(fragment :Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_top,fragment,"fragment_top_container_view_tag")
            .addToBackStack(null)
            .commit()
    }
}