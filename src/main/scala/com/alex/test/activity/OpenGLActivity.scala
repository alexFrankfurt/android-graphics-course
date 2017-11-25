package com.alex.test
package activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alex.test.{TR, TypedViewHolder}
import gl._

class OpenGLActivity extends AppCompatActivity {

  implicit val ctx = this

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)


  }
}
