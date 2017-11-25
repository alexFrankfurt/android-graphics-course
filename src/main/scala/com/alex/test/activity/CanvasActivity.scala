package com.alex.test.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alex.test.{TR, TypedViewHolder}

class CanvasActivity extends AppCompatActivity {

  implicit val ctx = this

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)


  }
}
