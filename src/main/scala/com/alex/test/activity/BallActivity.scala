package com.alex.test.activity

import android.animation.ValueAnimator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.BounceInterpolator
import android.widget.{ImageView, TextView}
import com.alex.test.{TR, TypedViewHolder}

class BallActivity extends AppCompatActivity {

  implicit val ctx = this

  var img: ImageView = _
  var text: TextView = _

  override def onWindowFocusChanged(hasFocus: Boolean): Unit = {
    super.onWindowFocusChanged(hasFocus)
    val ih = img.getHeight
    val th = text.getHeight
    Log.d("log", ih.toString)

    val animator = ValueAnimator.ofInt(0, th - ih)
    animator.setInterpolator(new BounceInterpolator())
    animator.setDuration(3000L)
    animator.setRepeatMode(ValueAnimator.RESTART)
    animator.setRepeatCount(ValueAnimator.INFINITE)
    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener {
      override def onAnimationUpdate(valueAnimator: ValueAnimator): Unit = {
        val y = valueAnimator.getAnimatedValue.asInstanceOf[Int]
        img.setY(y.asInstanceOf[Float])
        img.invalidate()
      }
    })
    animator.start()
  }


  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.ball = TypedViewHolder.setContentView(this, TR.layout.ball)

    img = vh.imageView
    text = vh.text

  }
}
