package com.alex.test.gl

import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

import android.content.Context
import android.opengl.GLSurfaceView

class SkyBoxGLRenderer(ctx: Context) extends GLSurfaceView.Renderer {

  override def onDrawFrame(gl10: GL10) = ???

  override def onSurfaceCreated(gl10: GL10, eglConfig: EGLConfig) = ???

  override def onSurfaceChanged(gl10: GL10, i: Int, i1: Int) = ???
}
