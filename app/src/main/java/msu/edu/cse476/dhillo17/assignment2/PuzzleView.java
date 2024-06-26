package msu.edu.cse476.dhillo17.assignment2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
/**
 * Custom view class for our Puzzle.
 */
public class PuzzleView extends View {


    /**
     * The actual puzzle
     */
    private Puzzle puzzle;
    private Paint linePaint;
    public PuzzleView(Context context) {
        super(context);
        init(null, 0);
    }
    public PuzzleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    public PuzzleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return puzzle.onTouchEvent(this, event);
    }
    public Puzzle getPuzzle() {
        return puzzle;
    }
    private void init(AttributeSet attrs, int defStyle) {
        puzzle = new Puzzle(getContext(), this);
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(0xff008000);
        linePaint.setStrokeWidth(3);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        puzzle.draw(canvas);
    }
    /**
     * Save the puzzle to a bundle
     * @param bundle The bundle we save to
     */
    public void saveInstanceState(Bundle bundle) {
        puzzle.saveInstanceState(bundle);
    }
    /**
     * Load the puzzle from a bundle
     * @param bundle The bundle we save to
     */
    public void loadInstanceState(Bundle bundle) {
        puzzle.loadInstanceState(bundle);
    }

}