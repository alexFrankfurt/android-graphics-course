package com.alex.test.gl

class SkyBox {
  import SkyBox._
  import java.nio.{FloatBuffer, ShortBuffer}

  val vertexBuffer: FloatBuffer = null
  val indexBuffer: ShortBuffer = null
  val PositionCount = 3 //number of position coordinates

  val CoordinatesPerVertex = PositionCount



}

object SkyBox {

  val cubeCoords: Array[Float] = Array(
    -1,  1,  1, // (0) Top-left near
     1,  1,  1, // (1) Top-right near
    -1, -1,  1, // (2) Bottom-left near
     1, -1,  1, // (3) Bottom-right near
    -1,  1, -1, // (4) Top-left far
     1,  1, -1, // (5) Top-right far
    -1, -1, -1, // (6) Bottom-left far
     1, -1, -1) // (7) Bottom-right far


  val indexArray: Array[Short] = Array(
    // Front
    1, 3, 0, 0, 3, 2,
    // Back
    4, 6, 5, 5, 6, 7,
    // Left
    0, 2, 4, 4, 2, 6,
    // Right
    5, 7, 1, 1, 7, 3,
    // Top
    5, 1, 4, 4, 1, 0,
    // Bottom
    6, 2, 7, 7, 2, 3)
}
