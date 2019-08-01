package com.nextcraigslist.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.nextcraigslist.R

/**
 * Created by S.C. on 20/05/18.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
           /* supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flContainer, LoginFragment.newInstance())
                    .commit()*/

            var intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
