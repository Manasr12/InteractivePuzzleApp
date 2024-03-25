package msu.edu.cse476.dhillo17.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PuzzleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_puzzle);
        if(bundle != null) {
            // We have saved state
            getPuzzleView().loadInstanceState(bundle);
        }

        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.menu_shuffle)
        {
            getPuzzleView().getPuzzle().shuffle();
            getPuzzleView().invalidate();
            return true;
    }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_puzzle, menu);
        return true;
    }

    /**
     * Save the instance state into a bundle
     * @param bundle the bundle to save into
     */
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getPuzzleView().saveInstanceState(bundle);
    }
    /**
     * Get the puzzle view

     * @return PuzzleView reference
     */
    private PuzzleView getPuzzleView() {
        return (PuzzleView)this.findViewById(R.id.puzzleView);
    }
}