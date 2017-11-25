package com.alex.test

import android.app.ActivityManager
import android.content.pm.ConfigurationInfo
import android.content.{Context, Intent}
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.alex.test.gl.{TriangleGLRenderer, TriangleGLSurfaceView}

class MainActivity extends AppCompatActivity {
  import MainActivity._

    // allows accessing `.value` on TR.resource.constants
  implicit val context = this
  var vh: TypedViewHolder.main = _
  var tv: TextView = _
  var gr: Graph = _
  var am: ActivityManager = _
  var ci: ConfigurationInfo = _
  var sv: TriangleGLSurfaceView = _

  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    val vh: TypedViewHolder.main = TypedViewHolder.setContentView(this, TR.layout.main)

    tv = vh.textView

    // Get Device's GL version
    val v = getSystemService(Context.ACTIVITY_SERVICE)
      .asInstanceOf[ActivityManager]
        .getDeviceConfigurationInfo.reqGlEsVersion
    tv.setText(gr.graphTitle + s": ${Integer.toHexString(v)}")

    gr = findViewById(R.id.custGr).asInstanceOf[Graph]


    sv = new TriangleGLSurfaceView(this, new TriangleGLRenderer())
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