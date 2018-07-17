package org.tobap.com.togetherbap.HowTo

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.howto_last_fragment.view.*
import org.goldenage.com.goldenage.MainActivity
import org.goldenage.com.goldenage.R

class HowToLastFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.howto_last_fragment, container, false)

        view.button.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }

        return view
    }
}