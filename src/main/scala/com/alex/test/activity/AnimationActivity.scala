package com.alex.test.activity

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.alex.test.{TR, TypedViewHolder}

class AnimationActivity extends AppCompatActivity {

  implicit val ctx = this

  var img: ImageView = _
  var danim: AnimationDrawable = _

  override def onWindowFocusChanged(hasFocus: Boolean) = {
    super.onWindowFocusChanged(hasFocus)
    danim.start()

  }

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.animation = TypedViewHolder.setContentView(this, TR.layout.animation)
    img = vh.img
    img.setBackgroundResource(TR.drawable.anim.resid)
    danim = img.getBackground.asInstanceOf[AnimationDrawable]

  }
}
