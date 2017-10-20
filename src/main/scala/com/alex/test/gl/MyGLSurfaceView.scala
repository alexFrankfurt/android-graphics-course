package com.alex.test.gl

import android.content.Context
import android.opengl.GLSurfaceView
import android.view.MotionEvent

class MyGLSurfaceView(ctx: Context, sr: MyGLRenderer)  extends GLSurfaceView(ctx) {
  setEGLContextClientVersion(2)

  setRenderer(sr)
  setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY)

  override def onTouchEvent(event: MotionEvent) = {
    super.onTouchEvent(event)
  }
}
