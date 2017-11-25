package com.alex.test.gl

import javax.microedition.khronos.egl
import javax.microedition.khronos.opengles.GL10

import android.content.Context
import android.graphics.{Bitmap, BitmapFactory}
import android.opengl.GLES20._
import android.opengl.{GLSurfaceView, GLUtils}
import com.alex.test.R

class PyramidGLRenderer(ctx: Context) extends GLSurfaceView.Renderer {
  var pyramid: Pyramid = _

  private val mMVPMatrix = new Array[Float](16)
  private val mProjectionMatrix = new Array[Float](16)
  private val mViewMatrix = new Array[Float](16)
  private val mModelMatrix = new Array[Float](16)


  val textureIDs = new Array[Int](1)

  def loadShader(tpe: Int, shaderCode: String): Int = {
    val shader = glCreateShader(tpe)
    glShaderSource(shader, shaderCode)
    glCompileShader(shader)
    shader
  }


  def onDrawFrame(gl10: GL10) = {
    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
    pyramid.draw(mMVPMatrix);
  }

  def onSurfaceCreated(gl10: GL10, eglConfig: egl.EGLConfig) = {
    glClearColor(0.9f,1f,0.9f,1f)



    glGenTextures(1, textureIDs, 0)


    val options: BitmapFactory.Options = new BitmapFactory.Options()
    options.inScaled = false

    val bitmap: Bitmap  = BitmapFactory.decodeResource(ctx.getResources, R.drawable.texture, options)

    glActiveTexture(GL_TEXTURE0)

    glBindTexture(GL_TEXTURE_2D, textureIDs(0))

    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR)

    GLUtils.texImage2D(GL_TEXTURE_2D, 0, bitmap, 0)

    bitmap.recycle()
    glBindTexture(GL_TEXTURE_2D, 0)


    pyramid = new Pyramid(textureIDs(0))

  }

  def onSurfaceChanged(gl10: GL10, w: Int, h: Int) = {
    import android.opengl.{GLES20, Matrix}
    GLES20.glViewport(0, 0, w, h)
    val ratio =
      if (w > h)
        w.asInstanceOf[Float] / h
      else
        h.asInstanceOf[Float] / w
//    if (w > h)
//      Matrix.orthoM(mProjectionMatrix, 0, -ratio, ratio, -1f, 1f, -1f, 1f)
//    else
//      Matrix.orthoM(mProjectionMatrix, 0, -1f, 1f, -ratio, ratio, -1, 1)

    GLES20.glEnable(GLES20.GL_DEPTH_TEST)
    Matrix.setIdentityM(mModelMatrix, 0)
    //Matrix.rotateM(mModelMatrix,0,60f,1f,0f,0f);
    //Matrix.translateM(mModelMatrix, 0, 0f, -0.2f, 0f)
    // Matrix.scaleM(mModelMatrix,0,1.5f,1.2f,1.0f);


//    Matrix.setLookAtM(mViewMatrix, 0, 0f, 0.5f, 2.2f, 0f, 0f, 0f, 0f, 1f, 0)
    Matrix.setLookAtM(mViewMatrix,
      0,
      0f, 0.5f, 4f,
      0f, -0.4f, 0f,
      0f, 1f, 0f)
    Matrix.perspectiveM(mProjectionMatrix, 0, 45f, ratio, 0.1f, 10f)


    Matrix.multiplyMM(mMVPMatrix, 0, mViewMatrix, 0, mModelMatrix, 0)
    Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mMVPMatrix, 0)
  }
}
