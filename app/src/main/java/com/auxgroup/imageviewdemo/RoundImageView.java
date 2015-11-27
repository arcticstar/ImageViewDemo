package com.auxgroup.imageviewdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.pdf.PdfDocument;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015-11-27.
 */
public class RoundImageView extends ImageView {

    private Bitmap mbitmap;
    private Paint mpaint = new Paint();
    private Rect mrect = new Rect();
    private Path mpath = new Path();
    private PaintFlagsDrawFilter pdf = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG);

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setMbitmap(Bitmap mbitmap) {
        this.mbitmap = mbitmap;
    }

    private void init() {
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mpaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mbitmap == null) {
            return;
        }
        mrect.set(0, 0, getWidth(), getHeight());
        canvas.save();
        canvas.setDrawFilter(pdf);
        mpath.addCircle(getWidth() / 2, getHeight() / 2, getHeight() / 2, Path.Direction.CCW);
        canvas.clipPath(mpath, Region.Op.REPLACE);
        canvas.drawBitmap(mbitmap, null, mrect, mpaint);
        canvas.restore();


    }
}
