package ad.browser.adbrowser;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ADITYA on 2/3/2017.
 */

public class ListViewAdapter extends ArrayAdapter<History> {
        Context context;
    public ListViewAdapter(Context context, ArrayList<History> hlist) {
        super(context, 0,hlist);
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_layout,null);
        TextView showtitle,showurl;
        showtitle = (TextView) view.findViewById(R.id.showTitle);
        showurl = (TextView) view.findViewById(R.id.showUrl);
        final History history = getItem(position);
        showtitle.setText(history.time+" - " +history.title);
        showurl.setText(history.url);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setClipboard(context, history.url );

                AlertDialog.Builder dlgAlert1 = new AlertDialog.Builder(context);
                dlgAlert1.setMessage("You can paste this Url in 'URL Field' of any Tab!");
                dlgAlert1.setTitle("Url Copied to Clipboard!");
                dlgAlert1.setPositiveButton("OK", null);
                dlgAlert1.setCancelable(true);
                dlgAlert1.create().show();
                return false;
            }
        });

        return view;
    }
    private void setClipboard(Context context, String text) {
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        } else {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
        }
    }
}
