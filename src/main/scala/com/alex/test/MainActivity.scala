package com.alex.test

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView

//var img: ImageView = _
//var text: TextView = _
//
//override def onCreate(savedInstanceState: Bundle): Unit = {
//super.onCreate(savedInstanceState)
//// type ascription is required due to SCL-10491
//val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)
//img = vh.imageView
//text = vh.text
//}
//
//
//override def onWindowFocusChanged(hasFocus: Boolean): Unit = {
//super.onWindowFocusChanged(hasFocus)
//val ih = img.getHeight
//val th = text.getHeight
//Log.d("log", ih.toString)
//
//val animator = ValueAnimator.ofInt(0, th - ih)
//animator.setInterpolator(new BounceInterpolator())
//animator.setDuration(3000L)
//animator.setRepeatMode(ValueAnimator.RESTART)
//animator.setRepeatCount(ValueAnimator.INFINITE)
//animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener {
//override def onAnimationUpdate(valueAnimator: ValueAnimator): Unit = {
//val y = valueAnimator.getAnimatedValue.asInstanceOf[Int]
//img.setY(y.asInstanceOf[Float]);
//img.invalidate();
//}
//})
//animator.start()
//}











//var img: ImageView = _
//var danim: AnimationDrawable = _
//
//override def onCreate(savedInstanceState: Bundle) = {
//super.onCreate(savedInstanceState)
//val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)
//
//img = vh.img
//img.setBackgroundResource(TR.drawable.anim.resid)
//danim = img.getBackground.asInstanceOf[AnimationDrawable]
//}
//
//
//override def onWindowFocusChanged(hasFocus: Boolean) = {
//super.onWindowFocusChanged(hasFocus)
//danim.start()
//
//}

class MainActivity extends AppCompatActivity {
    // allows accessing `.value` on TR.resource.constants
  implicit val context = this
  var vh: TypedViewHolder.main = _
  var tv: TextView = _
  var gr: Graph = _


  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)

    tv = vh.textView

    gr = findViewById(R.id.custGr).asInstanceOf[Graph]
    tv.setText(gr.graphTitle)

  }


  override def onWindowFocusChanged(hasFocus: Boolean) = {
    super.onWindowFocusChanged(hasFocus)
  }


  def openForm(v: View): Unit = {
    val intent = new Intent(context, classOf[FormActivity])
    startActivity(intent)
  }
}