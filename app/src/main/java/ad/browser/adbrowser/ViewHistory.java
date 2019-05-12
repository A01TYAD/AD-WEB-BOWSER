package ad.browser.adbrowser;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by ADITYA on 2/3/2017.
 */

public class ViewHistory extends Activity{


    Button btnClearHistory;
    ListView listViewHistory;
    DatabaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_history);

        helper = new DatabaseHelper(this);
        listViewHistory = (ListView) findViewById(R.id.listViewHistory);
        listViewHistory.setAdapter(new ListViewAdapter(this,helper.getHistory()));
        btnClearHistory = (Button) findViewById(R.id.btnClearHistory);
        btnClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db= new DatabaseHelper(ViewHistory.this);
                db.deleteHistory();

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(ViewHistory.this);
                dlgAlert.setMessage("History Cleared Sucessfully!");
                dlgAlert.setTitle("HISTORY");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                listViewHistory.setAdapter(new ListViewAdapter(ViewHistory.this,helper.getHistory()));
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
