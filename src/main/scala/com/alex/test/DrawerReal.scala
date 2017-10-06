package com.alex.test

import android.content.Context
import android.util.Log
import android.view.{SurfaceHolder, SurfaceView}

class DrawerReal(ctx: Context) extends SurfaceView(ctx) with SurfaceHolder.Callback {
  Log.e("jfdls", "fjdkl")
  var dt: Drawer = _

  getHolder().addCallback(this)

  override def surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int): Unit = {
    dt = new Drawer(surfaceHolder)
    dt.start()
  }

  override def surfaceCreated(surfaceHolder: SurfaceHolder): Unit = {

  }


  override def surfaceDestroyed(surfaceHolder: SurfaceHolder): Unit = {
    var tryAgaint = true
    while (tryAgaint) {
      try {
        dt.join()
        tryAgaint = false
      } catch {
        case ie: InterruptedException =>
      }
    }
  }

}
