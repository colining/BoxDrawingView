package com.example.asus.boxdrawingview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.asus.boxdrawingview.Box;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/10/9.
 */
public class BoxDrawingView extends View {

    private  static  final  String TAG ="BoxDrawingView";
    private Box currentbox;
    private List<Box> boxes = new ArrayList<>();


    private Paint boxpaint;
    private Paint backgroundpaint;
    private  String BUNDLE_BOXEN;
    private  String BUNDLE_SUPER_VIEW_STATE;


    public BoxDrawingView(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        boxpaint = new Paint();
        boxpaint.setColor(0x22ff0000);
        backgroundpaint = new Paint();
        backgroundpaint.setColor(0xfff8efe0);

    }

    public boolean onTouchEvent(MotionEvent event)
    {
        PointF curr = new PointF(event.getX(),event.getY());

        Log.i(TAG,"received event at x= "+curr.x+",y="+curr.y+":");

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG,"action_down");
                currentbox =new Box(curr);
                boxes.add(currentbox);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG,"action_move");
                if(currentbox!=null)
                {
                    currentbox.setCurent(curr);
                    invalidate();

                }
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG,"action_up");
                currentbox =null;
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i(TAG,"action_cancel");
                currentbox=null;
                break;
        }
        return  true;
    }

    @Override
    protected  void  onDraw(Canvas canvas)
    {

        canvas.drawPaint(backgroundpaint);

            for (Box box : boxes) {
                float left = Math.min(box.getOrigin().x, box.getCurrent().x);
                float right = Math.max(box.getOrigin().x, box.getCurrent().x);
                float top = Math.min(box.getOrigin().y, box.getCurrent().y);
                float bottom = Math.max(box.getCurrent().y, box.getOrigin().y);

                canvas.drawRect(left, top, right, bottom, boxpaint);

        }
    }



    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(BUNDLE_BOXEN, (ArrayList<? extends Parcelable>) boxes);
        bundle.putParcelable(BUNDLE_SUPER_VIEW_STATE,super.onSaveInstanceState());
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if((state instanceof Bundle)) {
            Bundle bundle = (Bundle) state;
            state = bundle.getParcelable(BUNDLE_SUPER_VIEW_STATE);
            boxes = bundle.getParcelableArrayList(BUNDLE_BOXEN);

        }
        super.onRestoreInstanceState(state);
    }
}
