package ad.browser.adbrowser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ADITYA on 2/3/2017.
 */

public class AutoCompleteAdapter extends ArrayAdapter<String> {
    Context context;
    public AutoCompleteAdapter(Context context, ArrayList<String> urllist) {
        super(context, 0,urllist);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(context);
        String url = getItem(position);
        textView.setText(url);
        textView.setPadding(10,50,10,50);

        return textView;
    }
}
