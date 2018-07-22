package org.goldenage.com.goldenage

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.SeekBar
import kotlinx.android.synthetic.main.plus_dialog.*

class PlusDialog(_context : Context, _controller : LifeEventController?) : Dialog(_context)
{
    var controller : LifeEventController? = null

    init {
        controller = _controller
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.plus_dialog)

        button_cancel.setOnClickListener {
            dismiss()
        }

        button_add.setOnClickListener {
            addEvent()
        }

        seekBar.progress = 100
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textView_seekbar.text = (progress - 100).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    fun addEvent()
    {
        controller!!.addLifeEvent(LifeEvent(
                editText_Age.text.toString().toInt(),
                editText_Month.text.toString().toInt(),
                editText_desc.text.toString(),
                seekBar.progress - 100
        ))

        dismiss()
    }
}