package com.example.myapplication

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.util.*

class CanvasView : View {

    var value=0f

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (i in 0..1000) {
            val paint = Paint();
            paint.color = Color.rgb(Random().nextInt(255),Random().nextInt(255),Random().nextInt(255))
            val path = Path()
            path.moveTo(0f+5f*i, 0f+5f*i)
            path.lineTo(0f+5f*i, 100f+5f*i)
            path.lineTo(100f+5f*i, 100f+5f*i)
            path.lineTo(100f+5f*i, 0f+5f*i)
            path.lineTo(0f+5f*i, 0f+5f*i)
            val pathMeasure1 = PathMeasure()
            val newPath=Path()
            pathMeasure1.setPath(path, false)
            do {
                pathMeasure1.getSegment(0f, pathMeasure1.length * value, newPath, true)
            } while (pathMeasure1.nextContour())
            canvas?.drawPath(newPath, paint)
        }
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }


}