package com.example.TicTacToe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

class TicTacBoard extends View {
    private final int winningLineColor;
    private final Paint paint = new Paint();
    private int cellSize = getWidth()/3;
    public TicTacBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TicTacToeBoard,0,0);
        
        try {
            winningLineColor = a.getInteger(R.styleable.TicTacToeBoard_winningLineColor,0);
        } finally {
            a.recycle();
        }
    }
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        int dimensions = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimensions/3;
        setMeasuredDimension(dimensions, dimensions);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
    }
    protected void drawGameBoard(Canvas canvas) {
        paint.setStrokeWidth(16);
        for(int c = 1; c < 3; c++) {
            canvas.drawLine(cellSize*c,0,cellSize*c, canvas.getWidth(), paint);
        }

        for(int r = 1; r < 3; r++) {
            canvas.drawLine(0,cellSize*r,canvas.getWidth(), cellSize*r, paint);
        }
    }
}
