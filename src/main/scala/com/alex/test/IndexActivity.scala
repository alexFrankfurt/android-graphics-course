package com.alex.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class IndexActivity extends AppCompatActivity {

  implicit val ctx = this

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)


  }
}
