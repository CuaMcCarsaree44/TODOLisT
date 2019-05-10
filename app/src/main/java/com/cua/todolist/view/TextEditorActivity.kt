package com.cua.todolist.view

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.cua.todolist.R
import com.cua.todolist.databinding.ActivityTextEditorBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class TextEditorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextEditorBinding
    private val slideup by lazy{
        AnimationUtils.loadAnimation(this, R.anim.slide_up)
    }

    private val tocheck by lazy{
        getDrawable(R.drawable.avd_anim) as AnimatedVectorDrawable
    }

    private val showup by lazy{
        AnimationUtils.loadAnimation(this, R.anim.show_up)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_text_editor)
        init()
    }

    private fun init(){
        binding.apply{
            newnoteactivity.animation = slideup
            texteditornavbar.setOnNavigationItemSelectedListener { p0 ->
                when(p0.itemId){
                    R.id.savebutton -> {
                        p0.setIcon(R.drawable.avd_anim)
                        tocheck.start()
                        Toast.makeText(this@TextEditorActivity, "This Is Save Button", Toast.LENGTH_LONG).show()

                    }
                    R.id.countbutton -> Toast.makeText(this@TextEditorActivity, "This is Count Button", Toast.LENGTH_LONG).show()
                    R.id.settingbutton -> Toast.makeText(this@TextEditorActivity, "This is Setting Button", Toast.LENGTH_LONG).show()
                }

                true
            }

        }
    }
}
