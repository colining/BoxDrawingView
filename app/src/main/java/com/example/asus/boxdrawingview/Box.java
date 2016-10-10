package com.example.asus.boxdrawingview;

import android.database.Cursor;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by asus on 2016/10/9.
 */
public class Box  implements Parcelable{
    private  PointF current;
    private  PointF origin;
    public PointF getOrigin() {
        return origin;
    }



    public PointF getCurrent() {
        return current;
    }



    public  Box(PointF  origin)
    {
        this.origin = current=origin;
    }

    protected Box(Parcel in) {
        origin = in.readParcelable(PointF.class.getClassLoader());
        current = in.readParcelable(PointF.class.getClassLoader());
    }
    public void  setCurent(PointF current)
    {
        this.current = current;
    }
    public static final Creator<Box> CREATOR = new Creator<Box>() {
        @Override
        public Box createFromParcel(Parcel in) {
            return new Box(in);
        }

        @Override
        public Box[] newArray(int size) {
            return new Box[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(origin);
        parcel.writeValue(current);
    }
}
