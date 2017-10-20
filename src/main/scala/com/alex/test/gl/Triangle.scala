package com.alex.test.gl

import java.nio.{ByteBuffer, ByteOrder, FloatBuffer}

import android.opengl.GLES20

class Triangle {

  val bb: ByteBuffer = ByteBuffer.allocateDirect(triangleCoords.length * 4)
  bb.order(ByteOrder.nativeOrder())
  val vertBuf = bb.asFloatBuffer()
  vertBuf.put(triangleCoords)
  vertBuf.position(0)

  val vertShader = MyGLRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertShaderCode)
  val fragmShader = MyGLRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode)
  val prog = GLES20.glCreateProgram()

  GLES20.glAttachShader(prog, vertShader)
  GLES20.glAttachShader(prog, fragmShader)
  GLES20.glLinkProgram(prog)

  val triangleCoords: Array[Float]
    = Array(   0f, 0.62f, 0f,
            -0.5f, -0.3f, 0f,
            -0.5f, -0.3f, 0f)

  val colors: Array[Float] = Array(0.6f, 0.77f, 0.2f, 1f)

  val vertShaderCode
    =
      """
        |attribute vec4 vPosition;
        |void main() {
        |  gl_Position = vPosition;
        |}
      """.stripMargin

  val fragmentShaderCode
    =
      """
        |precision mediump float;
        |uniform vec4 vColor;
        |void main() {
        |  gl_FragColor = vColor;
        |}
      """.stripMargin

  val CoordPerVert = 3

  val vertCount = triangleCoords.length / CoordPerVert
  val vertStride = CoordPerVert * 4k
}
