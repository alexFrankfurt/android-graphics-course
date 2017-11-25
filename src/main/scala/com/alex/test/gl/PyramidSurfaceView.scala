package com.alex.test.gl

import android.content.Context
import android.opengl.GLSurfaceView
import android.view.MotionEvent

class PyramidSurfaceView(ctx: Context, sr: PyramidGLRenderer)  extends GLSurfaceView(ctx) {
  setEGLContextClientVersion(2)

  setRenderer(sr)
  //  setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY)

}
