package com.alex.test

import android.content.Context
import android.content.res.TypedArray
import android.graphics.{Canvas, Color}
import android.util.{AttributeSet, Log}
import android.view.View

class Graph(ctx: Context, attrs: AttributeSet) extends View(ctx, attrs) {

  var showTitle = true
  var graphTitle = "Default"
  var numberX = 0
  var numberY = 0

  Log.w("text:", graphTitle)

  var grColor: Int = Color.rgb(0, 0, 0)
  var grBackColor: Int = Color.rgb(0, 0, 0)
  var axisColor: Int = Color.rgb(0, 0, 0)

  var height, width = 0.0
  var gh, gw = 0.0
  var x0, y0 = 0.09



  val ta: TypedArray = ctx.obtainStyledAttributes(attrs, R.styleable.BSUGraph)

  try {
    showTitle = ta.getBoolean(R.styleable.BSUGraph_showTitle, false)
    graphTitle = ta.getString(R.styleable.BSUGraph_graphTitle)
    numberX = ta.getInteger(R.styleable.BSUGraph_numberX, 5)
    numberY = ta.getInteger(R.styleable.BSUGraph_numberY, 5)
    grColor = ta.getColor(R.styleable.BSUGraph_grColor, 0)
  }finally {
    ta.recycle()
  }
  Log.w("text: ", graphTitle)
}
