package com.alex.test

import android.app.ActivityManager
import android.content.{Context, Intent}
import android.content.pm.ConfigurationInfo
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.{LayoutInflater, View, ViewGroup}
import android.widget.{RelativeLayout, TextView}
import com.alex.test.gl.{MyGLRenderer, MyGLSurfaceView}

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
  import MainActivity._

    // allows accessing `.value` on TR.resource.constants
  implicit val context = this
  var vh: TypedViewHolder.main = _
  var tv: TextView = _
  var gr: Graph = _
  var am: ActivityManager = _
  var ci: ConfigurationInfo = _
  var sv: MyGLSurfaceView = _



  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)

    tv = vh.textView

    val v = getSystemService(Context.ACTIVITY_SERVICE)
      .asInstanceOf[ActivityManager]
        .getDeviceConfigurationInfo.reqGlEsVersion

    gr = findViewById(R.id.custGr).asInstanceOf[Graph]
    tv.setText(gr.graphTitle + s": ${Integer.toHexString(v)}")


    sv = new MyGLSurfaceView(this, new MyGLRenderer())
    setContentView(sv)

//
//    val inflater: LayoutInflater =
//      getSystemService(Context.LAYOUT_INFLATER_SERVICE).asInstanceOf[LayoutInflater]
//    val rl: RelativeLayout =
//      inflater.inflate(R.layout.butt, null).asInstanceOf[RelativeLayout]
//    val params: ViewGroup.LayoutParams =
//      new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                                 ViewGroup.LayoutParams.MATCH_PARENT)
//
//    addContentView(rl, params)

  }

  override def onWindowFocusChanged(hasFocus: Boolean) = {
    super.onWindowFocusChanged(hasFocus)
  }


  def openForm(v: View): Unit = {
    val intent = new Intent(context, classOf[FormActivity])
    startActivity(intent)
  }


  def colorplus(v: View) = {
    blue += 0.1f
    if (blue > 1) blue = 1
    sv.requestRender()
  }

  def colorminus(v: View) = {
    blue -= 0.1f
    if (blue < 0) blue = 0
    sv.requestRender()
  }
}

object MainActivity {
  @volatile var blue: Float = 1
  @volatile var green: Float = 0
}