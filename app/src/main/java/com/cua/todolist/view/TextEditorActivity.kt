package com.cua.todolist.view

import android.content.DialogInterface
import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.cua.todolist.R
import com.cua.todolist.databinding.ActivityTextEditorBinding
import com.cua.todolist.repository.Onruncache
import com.cua.todolist.viewmodel.activityvm.TextEditorViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class TextEditorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextEditorBinding


    private val slideup by lazy{
        AnimationUtils.loadAnimation(this, R.anim.slide_up)
    }

    private val showup by lazy{
        AnimationUtils.loadAnimation(this, R.anim.show_up)
    }

    private val viewmodel by lazy{
        ViewModelProviders.of(this).get(TextEditorViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_text_editor)
        init()
    }

    private fun init(){
        binding.apply{
            viewmodels = viewmodel
            newnoteactivity.animation = slideup
            texteditornavbar.selectedItemId = R.id.countbutton
            texteditornavbar.setOnNavigationItemSelectedListener { p0 ->
                when(p0.itemId){
                    R.id.savebutton -> {

                    }

                    R.id.countbutton -> {
                        val dialog = AlertDialog.Builder(this@TextEditorActivity)
                        dialog.setTitle("String Counter")
                        dialog.setIcon(R.drawable.ic_remove_red_eye_black_24dp)
                        dialog.setMessage("""Characters: ${viewmodels!!.stringCount(contenttextbox.text.toString())}"""
                                + "\n" +
                                """Words: ${viewmodels!!.wordsCount(contenttextbox.text.toString())}""".trimIndent())
                        dialog.show()
                    }

                    R.id.settingbutton -> {
                        Toast.makeText(this@TextEditorActivity, "This is Setting Button",
                            Toast.LENGTH_LONG).show()
                    }
                }

                true
            }

            titletextbox.addTextChangedListener(object: TextWatcher{
                override fun afterTextChanged(s: Editable?) {

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    var x = titletextbox.text.toString()
                    viewmodels!!.setTitleDraft(x)
                }

            })

            contenttextbox.addTextChangedListener(object: TextWatcher{
                override fun afterTextChanged(s: Editable?) {

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    var x = contenttextbox.text.toString()
                    viewmodels!!.setContentDraft(x)
                }

            })


        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        /*
        binding.apply{
            if (!contenttextbox.text.toString().equals("")) {
                val dialog = AlertDialog.Builder(this@TextEditorActivity)
                dialog.setTitle("Save as Draft?")
                dialog.setMessage("Do you want to save current notes into draft?")
                dialog.setIcon(R.drawable.ic_save_black_24dp)
                dialog.setPositiveButton("OK") { _, _ -> }

                dialog.setNegativeButton("NO") { _, which ->
                    viewmodels!!.setContentDraft("")
                    viewmodels!!.setTitleDraft("")
                }

                dialog.setCancelable(false)
                dialog.create().show()
            }
           */
        }

}
