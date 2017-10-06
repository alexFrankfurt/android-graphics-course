package com.alex.test

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

class FormActivity extends AppCompatActivity {
  implicit val context = this



  override def onCreate(savedInstanceBundle: Bundle): Unit = {
    super.onCreate(savedInstanceBundle)

    val vh: TypedViewHolder.form = TypedViewHolder.setContentView(this, TR.layout.form)
  }

  def addElem(v: View): Unit = {

  }
}