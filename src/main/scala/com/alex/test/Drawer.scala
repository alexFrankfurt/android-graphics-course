package com.alex.test

import android.graphics.{Color, Paint, Path, RectF}
import android.util.Log
import android.view.SurfaceHolder

class Drawer(sh: SurfaceHolder) extends Thread {



  override def run() = {
    val canvas = sh.lockCanvas()
    Log.e("jfdls", "Running thread")
    if (canvas != null) {
      val rectF = new RectF(100, 400, 300, 600)
      val arr: Array[Float] = Array(70,420, 240,300,240,300,410,420)
      val arc = new RectF(400, 400, 750, 600)
      val path: Path = new Path()
      val paint = new Paint()

      path.reset()
      path.moveTo(40, 420)
      path.lineTo(240, 300)
      path.lineTo(380, 420)


      paint.setColor(Color.RED)
      paint.setStrokeWidth(10)
      paint.setStyle(Paint.Style.FILL)

      canvas.drawRGB(210, 255, 210)
      canvas.drawRoundRect(rectF, 10, 10, paint)
      //    canvas.drawLines(arr, paint)
      canvas.drawPath(path, paint)

      path.reset()

      //    path.moveTo(200,150)
      //    path.quadTo(240,200, 280, 150)
      //    canvas.drawPath(path, paint)

      path.reset()

      path moveTo(160, 150)
      path.quadTo(300, 200, 310, 150)
      path.quadTo(450, 80, 520, 150)
      canvas.drawTextOnPath("Hello world from view lorem ipsum ipsum ipsum image text something", path, 0, 0, paint)
      canvas.drawCircle(540, 320, 50, paint)
      canvas.drawArc(arc,0, 120, true, paint)
    } else {
      Log.e("Drawer thread", "fail")
    }

  }
}
