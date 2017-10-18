package inria.org.tictactoetutor;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;


public class BoardActivity extends ActionBarActivity {
    private static BoardView view;
    private static Menu lmenu;
    private MenuItem imenu;
    public static final String PREFS_NAME = "TictacToePref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        RelativeLayout rel = (RelativeLayout) findViewById(R.id.container);

        final BoardView rootView = new BoardView(rel.getContext());

        rootView.post(new Runnable() {
            @Override
            public void run() {
                rootView.init();
            }
        });
        BoardActivity.view = rootView;
        rel.addView(rootView);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        rootView.score[BoardView.CROSS][BoardView.EMPTY] = settings.getInt("a1", 0);
        rootView.score[BoardView.CROSS][BoardView.CROSS] = settings.getInt("a2", 0);
        rootView.score[BoardView.CROSS][BoardView.NOUGHT] = settings.getInt("a3", 0);
        rootView.score[BoardView.NOUGHT][BoardView.EMPTY] = settings.getInt("b1", 0);
        rootView.score[BoardView.NOUGHT][BoardView.CROSS] = settings.getInt("b2", 0);
        rootView.score[BoardView.NOUGHT][BoardView.NOUGHT] = settings.getInt("b3", 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_board, menu);
        lmenu = menu;
        imenu = menu.getItem(1);
        imenu.setTitle("* " + imenu.getTitle());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_restart) {
            view.init();
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_reset) {
            view.scoreInit();
            return true;
        }

        if (id == R.id.action_explore) {
            if (imenu != null) {
                CharSequence c = imenu.getTitle();
                imenu.setTitle(c.subSequence(2,c.length()));
            }
            imenu = item;
            imenu.setTitle("* " + imenu.getTitle());
            view.setState(BoardView.EMPTY);

            return true;
        }
        if (id == R.id.action_cross) {
            view.setState(BoardView.NOUGHT);
            if (imenu != null) {
                CharSequence c = imenu.getTitle();
                imenu.setTitle(c.subSequence(2, c.length()));
            }
            imenu = item;
            imenu.setTitle("* " + imenu.getTitle());
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    view.play(BoardView.NOUGHT);
                }
            }, 1000);
            return true;
        }
        if (id == R.id.action_nought) {
            view.setState(BoardView.CROSS);
            if (imenu != null) {
                CharSequence c = imenu.getTitle();
                imenu.setTitle(c.subSequence(2, c.length()));
            }
            imenu = item;
            imenu.setTitle("* " + imenu.getTitle());
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    view.play(BoardView.CROSS);
                }
            }, 1000);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onStop(){
        super.onStop();
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("a1", view.score[BoardView.CROSS][BoardView.EMPTY]);
        editor.putInt("a2", view.score[BoardView.CROSS][BoardView.CROSS]);
        editor.putInt("a3", view.score[BoardView.CROSS][BoardView.NOUGHT]);
        editor.putInt("b1", view.score[BoardView.NOUGHT][BoardView.EMPTY]);
        editor.putInt("b2", view.score[BoardView.NOUGHT][BoardView.CROSS]);
        editor.putInt("b3", view.score[BoardView.NOUGHT][BoardView.NOUGHT]);
        editor.commit();
    }


}
