package com.alex.test.gl

import java.nio.{ByteBuffer, ByteOrder}

import android.opengl.GLES20

class Triangle(textureID: Int) {

  val vertShaderCode: String =
    """
      |attribute vec4 vPosition;
      |void main() {
      |  gl_Position = vPosition;
      |}
    """.stripMargin

  val fragmentShaderCode: String =
    """
      |precision mediump float;
      |uniform vec4 vColor;
      |void main() {
      |  gl_FragColor = vColor;
      |}
    """.stripMargin




  val triangleCoords: Array[Float] = Array(   0f, 0.62f, 0f,
    -0.5f, -0.3f, 0f,
    -0.5f, -0.3f, 0f)

  val colors: Array[Float] = Array(0.6f, 0.77f, 0.2f, 1f)


  val CoordPerVertex = 3

  val vertCount = triangleCoords.length / CoordPerVertex
  val vertStride = CoordPerVertex * 4

  val bb: ByteBuffer = ByteBuffer.allocateDirect(triangleCoords.length * 4)
  bb.order(ByteOrder.nativeOrder())
  val vertBuf = bb.asFloatBuffer()
  vertBuf.put(triangleCoords)
  vertBuf.position(0)

  val vertShader = TriangleGLRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertShaderCode)
  val fragmShader = TriangleGLRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode)
  val prog = GLES20.glCreateProgram()
  var posBundle: Int = _
  var colorBundle: Int = _

  GLES20.glAttachShader(prog, vertShader)
  GLES20.glAttachShader(prog, fragmShader)
  GLES20.glLinkProgram(prog)



  def draw(): Unit = {
    GLES20.glUseProgram(prog)
    posBundle = GLES20.glGetAttribLocation(prog, "vPosition")
    GLES20.glEnableVertexAttribArray(posBundle)

    GLES20.glVertexAttribPointer(posBundle,CoordPerVertex,
      GLES20.GL_FLOAT, false, vertStride, vertBuf)

    colorBundle = GLES20.glGetUniformLocation(prog, "vColor")
    GLES20.glUniform4fv(colorBundle, 1, colors, 0)

    GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, vertCount)

    GLES20.glDisableVertexAttribArray(posBundle)
  }
}
