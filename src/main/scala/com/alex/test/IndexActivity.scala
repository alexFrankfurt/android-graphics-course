package com.alex.test

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.alex.test.activity.{AnimationActivity, BallActivity}

class IndexActivity extends AppCompatActivity {

  implicit val ctx = this

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.index = TypedViewHolder.setContentView(this, TR.layout.index)

    setContentView(new gl.SkyBoxGLSurfaceView(ctx, new gl.SkyBoxGLRenderer(ctx)))


  }

  def start[T](c: Class[T]) = startActivity(new Intent(ctx, c))

  def ballPane(view: View) =
    start(classOf[BallActivity])


  def animationPane(view: View): Unit =
    start(classOf[AnimationActivity])


}
