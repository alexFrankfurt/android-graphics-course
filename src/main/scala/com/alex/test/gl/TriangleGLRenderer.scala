package com.alex.test.gl

import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

import android.graphics.{Bitmap, BitmapFactory, Color}
import android.opengl.GLES20._
import android.opengl.{GLES20, GLES30, GLSurfaceView, GLUtils}
import com.alex.test.{MainActivity, R}

class TriangleGLRenderer extends GLSurfaceView.Renderer {

  var triangle: Triangle = _


  override def onDrawFrame(gl10: GL10) = {
    //    GLES20.glClearColor(0f, MainActivity.green, MainActivity.blue, 1)
    //    GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)
    GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT)
    triangle.draw()
  }

  override def onSurfaceCreated(gl10: GL10, eglConfig: EGLConfig) = {
    //    GLES20.glClearColor(0, 4, 3, 2)
    GLES20.glClearColor(.9f, 1, .9f, 1)


    triangle = new Triangle(1)
  }

  override def onSurfaceChanged(gl10: GL10, w: Int, h: Int) = {
    GLES20.glViewport(0, 0, w, h)
  }
}


object TriangleGLRenderer {
  def loadShader(tpe: Int, shaderCode: String) = {
    val shader = GLES20.glCreateShader(tpe)
    GLES20.glShaderSource(shader, shaderCode)
    GLES20.glCompileShader(shader)
    shader
  }
}