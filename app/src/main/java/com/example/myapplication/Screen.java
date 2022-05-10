package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class Screen extends View implements Runnable {
    private Paint paint = new Paint();

    int x1 = 0;
    int x2 = 0;

    int bx = 0;
    int by = 0;

    public Screen(Context context) {
        super(context);
    }

    public Screen(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        by++;

//        bx += x1;
//        by += y1;
//
//        if(bx > this.getWidth()){
//            x1 = -stepX;
//        }
//
//        if(bx < 0){
//            x1 = stepX;
//        }
//
//        if(by > this.getHeight()){
//            y1 = -stepY;
//        }
//
//        if(by < 0){
//            y1 = stepY;
//        }


        paint.setARGB( 255,255,0,0 );
        canvas.drawRect( 450f + x1, 100f, 650f + x1, 200f, paint );

        paint.setARGB( 255,0,0,255 );
        canvas.drawRect( 450f + x2, 1400f, 650f + x2, 1500f, paint );

        paint.setARGB( 255,0,0,0 );

        canvas.drawLine( 0f, 800f, 1200f, 800f, paint );

        paint.setARGB( 255,0,255,0 );

        canvas.drawCircle( 555f + bx,800f + by,20f, paint );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if( event.getRawY() < 800 )
        {
            x1 += event.getRawX() > 600 ? 50 : -50;
        }

        else
        {
            x2 += event.getRawX() > 600 ? 50 : -50;
        }

        invalidate();

        return super.onTouchEvent(event);
    }

    @Override
    public void run() {
        try {

            while ( true )
            {
                invalidate();

                Thread.sleep( 100 );
            }
        }

        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
