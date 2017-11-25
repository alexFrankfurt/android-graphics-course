package com.alex.test.gl

import java.nio.ShortBuffer

import android.opengl.GLES20
import android.opengl.GLES20._

class Pyramid(textureID: Int) {

  import java.nio.{ByteBuffer, ByteOrder, FloatBuffer}


  var vertexBuffer: FloatBuffer = _
  var orderBuffer: ShortBuffer = _
  val PositionCount = 3 //number of position coordinates
  val TextureCount = 2

  val textureIDs = new Array[Int](1)

  private val CoordinatesPerVertex = PositionCount


  val pyramidCoords: Array[Float] = Array(
    0f, -0.8f, 0f,    0.5f, 0f,
    -0.8f, 0f, 0.8f,  0f,   1f,
    0.8f, 0f, 0.8f,   1f,   1f,
    0.8f, 0f, -0.8f,  0.5f, 0f,
    -0.8f, 0f, -0.8f, 0f,   1f,
    0f, 0f, 0f,       1f,   1f
  )

  val order: Array[Short] = Array(
    0, 2, 1,
    0, 1, 4,
    0, 4, 3,
    0, 3, 2,

    1, 5, 4,
    1, 2, 5,
    2, 3, 5,
    3, 4, 5
  )

  val colors: Array[Float] = Array(
    0f, 1f, 0f, 0.5f,
    1f, 0f, 0.5f, 0.5f,
    0.2f, 0f, 0.5f, 0.5f,
    0.1f, 0.1f, 0.3f, 0.4f,

    0f, 1f, 0f, 0.5f,
    1f, 0f, 0.5f, 0.5f,
    0.2f, 0f, 0.5f, 0.5f,
    0.1f, 0.1f, 0.3f, 0.4f
  )

  //Rendering
  private val vertexShaderCode =
    """
      |attribute vec4 vPosition;
      |attribute vec2 aTexCoord;
      |
      |uniform mat4 uMVPMatrix;
      |varying vec2 vTexCoord;
      |void main() {
      |  vTexCoord = aTexCoord;
      |  gl_Position = uMVPMatrix*vPosition;
      |}
    """.stripMargin


  private val fragmentShaderCode =
    """
      |precision mediump float;
      |uniform sampler2D uTextureUnit;
      |varying vec2 vTexCoord;
      |void main() {
      |  gl_FragColor = texture2D(uTextureUnit,vTexCoord);
      |}
    """.stripMargin

  private var mProgram = 0


  var mPositionHandle = 0
  var mColorHandle = 0
  var mMVPMatrixHandle = 0
  var mTextCoordHandle = 0
  var mTextUnitHandle = 0


  private val vertexCount = pyramidCoords.length / CoordinatesPerVertex
  private val vertexStride = CoordinatesPerVertex * 4 // 4 bytes per vertex



  // Constr
  val bb: ByteBuffer =
    ByteBuffer.allocateDirect(pyramidCoords.length*4);//4 bytes for 1 float
  bb.order(ByteOrder.nativeOrder())
  vertexBuffer = bb.asFloatBuffer()
  vertexBuffer.put(pyramidCoords)

  val ob: ByteBuffer =
    ByteBuffer.allocateDirect(order.length * 2)
  ob.order(ByteOrder.nativeOrder())

  orderBuffer = ob.asShortBuffer()
  orderBuffer.put(order)



  val vertexShader: Int = TriangleGLRenderer.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
  val fragmentShader: Int = TriangleGLRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);

  mProgram = glCreateProgram()
  glAttachShader(mProgram, vertexShader)
  glAttachShader(mProgram, fragmentShader)
  glLinkProgram(mProgram)

  def draw(mvpMatrix: Array[Float]): Unit = {
    glUseProgram(mProgram)
    mPositionHandle = glGetAttribLocation(mProgram, "vPosition")
    mTextCoordHandle = glGetAttribLocation(mProgram, "aTexCoord")
    mTextUnitHandle = glGetUniformLocation(mProgram, "uTextureUnit")
//    mColorHandle = glGetUniformLocation(mProgram, "uColor")
    mMVPMatrixHandle = glGetUniformLocation(mProgram, "uMVPMatrix")


    //glUniformMatrix4fv(int location, int count, boolean transpose, float[] value, int offset)
    glUniformMatrix4fv(mMVPMatrixHandle, 1, false, mvpMatrix, 0)
    vertexBuffer.position(0)
    orderBuffer.position(0)

    glVertexAttribPointer(
      mPositionHandle,
      PositionCount,
      GL_FLOAT,
      false,
      vertexStride,
      vertexBuffer)
    glVertexAttribPointer(
      mTextCoordHandle,
      TextureCount,
      GL_FLOAT,
      false,
      vertexStride,
      vertexBuffer)

    glEnableVertexAttribArray(mPositionHandle)
    glEnableVertexAttribArray(mTextCoordHandle)

    glActiveTexture(GL_TEXTURE0)
    glBindTexture(GL_TEXTURE_2D, textureID)
    glUniform1i(mTextUnitHandle, 0)

    for (i <- 0 until 8) {
      glUniform4fv(mColorHandle, 1, colors, i * 4)

      orderBuffer.position(i * 3)
      glDrawElements(GLES20.GL_TRIANGLES, 3, GL_UNSIGNED_SHORT, orderBuffer)

      glBindTexture(GL_TEXTURE_2D, i)

    }

    glDisableVertexAttribArray(mPositionHandle)
    glDisableVertexAttribArray(mTextCoordHandle)
  }

}
