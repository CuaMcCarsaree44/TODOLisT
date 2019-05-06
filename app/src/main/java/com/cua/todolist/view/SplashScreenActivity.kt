package com.cua.todolist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import com.cua.todolist.R
import com.cua.todolist.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySplashScreenBinding
    private lateinit var slidedown:Animation
    private lateinit var showup:Animation
    private lateinit var xfade:Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initial()
    }

    private fun initial() {
        binding = DataBindingUtil.setContentView(this@SplashScreenActivity, R.layout.activity_splash_screen)
        slidedown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        showup = AnimationUtils.loadAnimation(this, R.anim.show_up)
        xfade = AnimationUtils.loadAnimation(this, R.anim.xfade)

        binding.apply {
            splashimage.animation = slidedown
            titleSplash.animation = showup
        }

        slidedown.setAnimationListener(object: Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                val sleep = Handler()
                sleep.postDelayed({
                    binding.apply {
                        splashimage.clearAnimation()
                        titleSplash.clearAnimation()
                        splashimage.animation = xfade
                        titleSplash.animation = xfade
                    }
                }, 2000)
            }

            override fun onAnimationStart(animation: Animation?) {

            }

        })


        xfade.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.apply{
                    splashimage.visibility = View.GONE
                    titleSplash.visibility = View.GONE
                }
                move()
            }

        })
    }

    private fun move(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
