package com.alex.test.gl

import android.content.Context
import android.opengl.GLSurfaceView
import android.view.{ScaleGestureDetector, View}

class SkyBoxGLSurfaceView(ctx: Context, sr: SkyBoxGLRenderer)
  extends GLSurfaceView(ctx)
    with View.OnTouchListener {

  var previousX = .0f
  var previousY = .0f
  private val mScaleDetector: ScaleGestureDetector = null
  private val mScaleFactor = 3.0f

  setEGLContextClientVersion(2)

  setRenderer(sr)


  import android.view.{MotionEvent, View}

  /** Blah blahk
   *  jdflsf
   *  fjdlsjfds
   *  jdfdklsk
   *
   *  @param view
   *  @param motionEvent
   *  @return
   */
  def onTouch(view: View, motionEvent: MotionEvent): Boolean =
    if (motionEvent != null) {
      mScaleDetector.onTouchEvent(motionEvent)
      if (motionEvent.getAction == MotionEvent.ACTION_DOWN) {
        previousX = motionEvent.getX
        previousY = motionEvent.getY
      }
      else if (motionEvent.getAction == MotionEvent.ACTION_MOVE) {
        val deltaX = motionEvent.getX - previousX
        val deltaY = motionEvent.getY - previousY
        previousX = motionEvent.getX
        previousY = motionEvent.getY
        queueEvent(new Runnable() {
          override def run(): Unit = {
            //sr.changeMyView(deltaX, deltaY, mScaleFactor)
          }
        })
      }
      true
    }
    else false


  /** jdkfljsf
   *  fjdslfjd
   *  fdskl
   *
   *  @param i
   */
  def a(i: Int): Unit = ???
}
