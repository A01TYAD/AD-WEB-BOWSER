package ad.browser.adbrowser;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import java.util.Calendar;

public class AD_browser extends Activity implements OnClickListener,
		OnTouchListener{

	DatabaseHelper dbhelper;

	WebView a, b, c, d, e;
	Button btnBack1, btnBack2, btnBack3, btnBack4, btnBack5, btnGo1, btnGo2,
			btnGo3, btnGo4, btnGo5, btnForward1, btnForward2, btnForward3,
			btnForward4, btnForward5, btnRefresh1, btnRefresh2, btnRefresh3,
			btnRefresh4, btnRefresh5, btnhome1, btnhome2, btnhome3, btnhome4,
			btnhome5, btnstop1, btnstop2, btnstop3, btnstop4, btnstop5,
			btnmenu1, btnmenu2, btnmenu3, btnmenu4, btnmenu5, bf1, bf2, bf3,
			bf4, bf5, bs1, bs2, bs3, bs4, bs5;

	AutoCompleteTextView txtUrl1, txtUrl2, txtUrl3, txtUrl4, txtUrl5;
	TabHost th;
	String et1,et2,et3,et4,et5;
	ProgressBar Pbar1, Pbar2, Pbar3, Pbar4, Pbar5;
	LinearLayout layout11, layout12, layout21, layout22, layout31, layout32,
			layout41, layout42, layout51, layout52;
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_ad_browser);
		dbhelper = new DatabaseHelper(this);
		iniatialize();
		getSettings();

		getHome();

		// setting up web view.

		e = (WebView) findViewById(R.id.wv5);
		// starting progress bar
		e.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {

				String txt5 = e.getUrl();
				if(txt5 == txtUrl5.getText().toString()){
				}else{
					txtUrl5.setText(txt5);
				}
				if (progress < 100 && Pbar5.getVisibility() == ProgressBar.GONE) {
					Pbar5.setVisibility(ProgressBar.VISIBLE);
				}
				Pbar5.setProgress(progress);
				if (progress == 100) {
                    saveHistory(e.getTitle(),txtUrl5.getText().toString());
					Pbar5.setVisibility(ProgressBar.GONE);
					refreshAutoCompleteAdapter();
				}
			}
		});
		e.getSettings().setUseWideViewPort(true);
		e.getSettings().setBuiltInZoomControls(true);
		e.setFocusable(true);
		e.setWebViewClient(new WebViewClient());
		e.requestFocus(View.FOCUS_DOWN);
		e.setOnTouchListener(this);

		b = (WebView) findViewById(R.id.wv2);
		b.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {

				String txt2 = b.getUrl();
				if(txt2 == txtUrl2.getText().toString()){
				}else{
				txtUrl2.setText(txt2);
				}
				if (progress < 100 && Pbar2.getVisibility() == ProgressBar.GONE) {
					Pbar2.setVisibility(ProgressBar.VISIBLE);
				}
				if (progress==100) {
					saveHistory(b.getTitle(),txtUrl2.getText().toString());
					Pbar2.setVisibility(ProgressBar.GONE);
					refreshAutoCompleteAdapter();
				}
				Pbar2.setProgress(progress);

			}
		});
		b.getSettings().setUseWideViewPort(true);
		b.getSettings().setBuiltInZoomControls(true);
		b.setWebViewClient(new WebViewClient());
		b.setFocusable(true);
		b.requestFocus(View.FOCUS_DOWN);
		b.setOnTouchListener(this);

		c = (WebView) findViewById(R.id.wv3);
		c.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				String txt3 = c.getUrl();

				if(txt3 == txtUrl3.getText().toString()){
				}else{
				txtUrl3.setText(txt3);
				}
				if (progress < 100 && Pbar3.getVisibility() == ProgressBar.GONE) {
					Pbar3.setVisibility(ProgressBar.VISIBLE);
				}
				Pbar3.setProgress(progress);
				if (progress == 100) {
                    saveHistory(c.getTitle(),txtUrl3.getText().toString());
					Pbar3.setVisibility(ProgressBar.GONE);
					refreshAutoCompleteAdapter();
				}
			}
		});
		c.getSettings().setUseWideViewPort(true);
		c.setWebViewClient(new WebViewClient());
		c.getSettings().setBuiltInZoomControls(true);
		c.setFocusable(true);
		c.requestFocus(View.FOCUS_DOWN);
		c.setOnTouchListener(this);

		d = (WebView) findViewById(R.id.wv4);
		d.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				String txt4 = d.getUrl();
				if(txt4 == txtUrl4.getText().toString()){
				}else{
				txtUrl4.setText(txt4);
				}
				if (progress < 100 && Pbar4.getVisibility() == ProgressBar.GONE) {
					Pbar4.setVisibility(ProgressBar.VISIBLE);
				}
				Pbar4.setProgress(progress);
				if (progress == 100) {
                    saveHistory(d.getTitle(),txtUrl4.getText().toString());
					Pbar4.setVisibility(ProgressBar.GONE);
					refreshAutoCompleteAdapter();

				}
			}
		});
		d.getSettings().setUseWideViewPort(true);
		d.getSettings().setBuiltInZoomControls(true);
		d.setWebViewClient(new WebViewClient());
		d.setFocusable(true);
		d.requestFocus(View.FOCUS_DOWN);
		d.setOnTouchListener(this);

		a = (WebView) findViewById(R.id.wv1);
		a.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				String txt1 = a.getUrl();
				if(txt1 == txtUrl1.getText().toString()){
				}else{
				txtUrl1.setText(txt1);
				}
				if (progress < 100 && Pbar1.getVisibility() == ProgressBar.GONE) {
					Pbar1.setVisibility(ProgressBar.VISIBLE);
				}
				Pbar1.setProgress(progress);
				if (progress == 100) {
                    saveHistory(a.getTitle(),txtUrl1.getText().toString());
					Pbar1.setVisibility(ProgressBar.GONE);
					refreshAutoCompleteAdapter();

				}
			}
		});
		a.getSettings().setUseWideViewPort(true);
		a.getSettings().setBuiltInZoomControls(true);
		a.setWebViewClient(new WebViewClient());
		a.setFocusable(true);
		a.requestFocus(View.FOCUS_DOWN);
		a.setOnTouchListener(this);
		// __________________________________________________________________________________________________________

		setTabHost();

	}

	private void setTabHost() {
		// TODO Auto-generated method stub
		// Setting up
		// tabs___________________________________________________________________________________________

		// set up TabHost
		th = (TabHost) findViewById(R.id.tabhost123);
		th.setup();

		// Tab1 setup
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tab1);
		specs.setIndicator("Tab 1");
		th.addTab(specs);

		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tab2);
		specs.setIndicator("Tab 2");
		th.addTab(specs);

		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tab3);
		specs.setIndicator("Tab 3");
		th.addTab(specs);

		specs = th.newTabSpec("tag4");
		specs.setContent(R.id.tab4);
		specs.setIndicator("Tab 4");
		th.addTab(specs);

		specs = th.newTabSpec("tag5");
		specs.setContent(R.id.tab5);
		specs.setIndicator("Tab 5");
		th.addTab(specs);
		// _______________________________________________________________________________________________________
	}

	@Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
        	new AlertDialog.Builder(this)
            .setTitle("Exit")
            .setMessage("Are you sure you want to close the browser?")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    exitt();
                }
             })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
             }).show();
        }
        return false;
    }

	private void iniatialize() {
		// TODO Auto-generated method stub

		Pbar1 = (ProgressBar) findViewById(R.id.prgBar1);
		Pbar2 = (ProgressBar) findViewById(R.id.prgBar2);
		Pbar3 = (ProgressBar) findViewById(R.id.prgBar3);
		Pbar4 = (ProgressBar) findViewById(R.id.prgBar4);
		Pbar5 = (ProgressBar) findViewById(R.id.prgBar5);

		layout11 = (LinearLayout) findViewById(R.id.layout11);
		layout12 = (LinearLayout) findViewById(R.id.layout12);
		layout21 = (LinearLayout) findViewById(R.id.layout21);
		layout22 = (LinearLayout) findViewById(R.id.layout22);
		layout31 = (LinearLayout) findViewById(R.id.layout31);
		layout32 = (LinearLayout) findViewById(R.id.layout32);
		layout41 = (LinearLayout) findViewById(R.id.layout41);
		layout42 = (LinearLayout) findViewById(R.id.layout42);
		layout51 = (LinearLayout) findViewById(R.id.layout51);
		layout52 = (LinearLayout) findViewById(R.id.layout52);

		btnGo1 = (Button) findViewById(R.id.btnGo1);
		btnGo2 = (Button) findViewById(R.id.btnGo2);
		btnGo3 = (Button) findViewById(R.id.btnGo3);
		btnGo4 = (Button) findViewById(R.id.btnGo4);
		btnGo5 = (Button) findViewById(R.id.btnGo5);

		btnBack1 = (Button) findViewById(R.id.btnBack1);
		btnBack2 = (Button) findViewById(R.id.btnBack2);
		btnBack3 = (Button) findViewById(R.id.btnBack3);
		btnBack4 = (Button) findViewById(R.id.btnBack4);
		btnBack5 = (Button) findViewById(R.id.btnBack5);

		btnForward1 = (Button) findViewById(R.id.btnForward1);
		btnForward2 = (Button) findViewById(R.id.btnForward2);
		btnForward3 = (Button) findViewById(R.id.btnForward3);
		btnForward4 = (Button) findViewById(R.id.btnForward4);
		btnForward5 = (Button) findViewById(R.id.btnForward5);

		btnRefresh1 = (Button) findViewById(R.id.btnRefresh1);
		btnRefresh2 = (Button) findViewById(R.id.btnRefresh2);
		btnRefresh3 = (Button) findViewById(R.id.btnRefresh3);
		btnRefresh4 = (Button) findViewById(R.id.btnRefresh4);
		btnRefresh5 = (Button) findViewById(R.id.btnRefresh5);

		btnhome1 = (Button) findViewById(R.id.btnhome1);
		btnhome2 = (Button) findViewById(R.id.btnhome2);
		btnhome3 = (Button) findViewById(R.id.btnhome3);
		btnhome4 = (Button) findViewById(R.id.btnhome4);
		btnhome5 = (Button) findViewById(R.id.btnhome5);

		btnstop1 = (Button) findViewById(R.id.btnstop1);
		btnstop2 = (Button) findViewById(R.id.btnstop2);
		btnstop3 = (Button) findViewById(R.id.btnstop3);
		btnstop4 = (Button) findViewById(R.id.btnstop4);
		btnstop5 = (Button) findViewById(R.id.btnstop5);

		btnmenu1 = (Button) findViewById(R.id.btnmenu1);
		btnmenu2 = (Button) findViewById(R.id.btnmenu2);
		btnmenu3 = (Button) findViewById(R.id.btnmenu3);
		btnmenu4 = (Button) findViewById(R.id.btnmenu4);
		btnmenu5 = (Button) findViewById(R.id.btnmenu5);

		bf1 = (Button) findViewById(R.id.btnfull1);
		bf2 = (Button) findViewById(R.id.btnfull2);
		bf3 = (Button) findViewById(R.id.btnfull3);
		bf4 = (Button) findViewById(R.id.btnfull4);
		bf5 = (Button) findViewById(R.id.btnfull5);

		bs1 = (Button) findViewById(R.id.btnsmall1);
		bs2 = (Button) findViewById(R.id.btnsmall2);
		bs3 = (Button) findViewById(R.id.btnsmall3);
		bs4 = (Button) findViewById(R.id.btnsmall4);
		bs5 = (Button) findViewById(R.id.btnsmall5);

		txtUrl1 = (AutoCompleteTextView) findViewById(R.id.txtUrl1);
		txtUrl2 = (AutoCompleteTextView) findViewById(R.id.txtUrl2);
		txtUrl3 = (AutoCompleteTextView) findViewById(R.id.txtUrl3);
		txtUrl4 = (AutoCompleteTextView) findViewById(R.id.txtUrl4);
		txtUrl5 = (AutoCompleteTextView) findViewById(R.id.txtUrl5);
		refreshAutoCompleteAdapter();


		a = (WebView) findViewById(R.id.wv1);
		b = (WebView) findViewById(R.id.wv2);
		c = (WebView) findViewById(R.id.wv3);
		d = (WebView) findViewById(R.id.wv4);
		e = (WebView) findViewById(R.id.wv5);

		btnGo1.setOnClickListener(this);
		btnGo2.setOnClickListener(this);
		btnGo3.setOnClickListener(this);
		btnGo4.setOnClickListener(this);
		btnGo5.setOnClickListener(this);

		btnBack1.setOnClickListener(this);
		btnBack2.setOnClickListener(this);
		btnBack3.setOnClickListener(this);
		btnBack4.setOnClickListener(this);
		btnBack5.setOnClickListener(this);

		btnForward1.setOnClickListener(this);
		btnForward2.setOnClickListener(this);
		btnForward3.setOnClickListener(this);
		btnForward4.setOnClickListener(this);
		btnForward5.setOnClickListener(this);

		btnRefresh1.setOnClickListener(this);
		btnRefresh2.setOnClickListener(this);
		btnRefresh3.setOnClickListener(this);
		btnRefresh4.setOnClickListener(this);
		btnRefresh5.setOnClickListener(this);

		btnhome1.setOnClickListener(this);
		btnhome2.setOnClickListener(this);
		btnhome3.setOnClickListener(this);
		btnhome4.setOnClickListener(this);
		btnhome5.setOnClickListener(this);

		btnstop1.setOnClickListener(this);
		btnstop2.setOnClickListener(this);
		btnstop3.setOnClickListener(this);
		btnstop4.setOnClickListener(this);
		btnstop5.setOnClickListener(this);

		btnmenu1.setOnClickListener(this);
		btnmenu2.setOnClickListener(this);
		btnmenu3.setOnClickListener(this);
		btnmenu4.setOnClickListener(this);
		btnmenu5.setOnClickListener(this);

		bs1.setOnClickListener(this);
		bs2.setOnClickListener(this);
		bs3.setOnClickListener(this);
		bs4.setOnClickListener(this);
		bs5.setOnClickListener(this);

		bf1.setOnClickListener(this);
		bf2.setOnClickListener(this);
		bf3.setOnClickListener(this);
		bf4.setOnClickListener(this);
		bf5.setOnClickListener(this);

		a.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent,
					String contentDisposition, String mimetype,
					long contentLength) {
				Intent ab = new Intent(Intent.ACTION_VIEW);
				ab.setData(Uri.parse(url));
				startActivity(ab);
			}
		});
		b.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent,
					String contentDisposition, String mimetype,
					long contentLength) {
				Intent cd = new Intent(Intent.ACTION_VIEW);
				cd.setData(Uri.parse(url));
				startActivity(cd);
			}
		});
		c.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent,
					String contentDisposition, String mimetype,
					long contentLength) {
				Intent ef = new Intent(Intent.ACTION_VIEW);
				ef.setData(Uri.parse(url));
				startActivity(ef);
			}
		});
		d.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent,
					String contentDisposition, String mimetype,
					long contentLength) {
				Intent gh = new Intent(Intent.ACTION_VIEW);
				gh.setData(Uri.parse(url));
				startActivity(gh);
			}
		});
		e.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent,
					String contentDisposition, String mimetype,
					long contentLength) {
				Intent ij = new Intent(Intent.ACTION_VIEW);
				ij.setData(Uri.parse(url));
				startActivity(ij);
			}
		});

		// getSettings();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {

		case R.id.btnGo1:
			String st1 = txtUrl1.getText().toString();
			if (st1 != " "){

			}
			if (st1.contains(".") && st1.contains(" ") || st1.length() < 4){
				st1 = "https://www.google.com.np/search?q="
						+ txtUrl1.getText().toString();

				a.loadUrl(st1);

			}
			if (st1.contains(".com") || st1.contains(".")) {

				if (st1.contains("http://") || st1.contains("https://")) {
					a.loadUrl(st1);
				} else if (txtUrl1.getText().toString().contentEquals("")) {

				} else {
					st1 = "http://" + txtUrl1.getText().toString();
					a.loadUrl(st1);
				}
			} else {
				if (txtUrl1.getText().toString().contentEquals("")) {
				} else {
					st1 = "https://www.google.com.np/search?q="
							+ txtUrl1.getText().toString();
					a.loadUrl(st1);
				}
			}
			// hiding keyboard
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(txtUrl1.getWindowToken(), 0);
			// XX

			break;
		case R.id.btnGo2:

			String st2 = txtUrl2.getText().toString();
			if (st2.contains(".") && st2.contains(" ")|| st2.length() < 4){
				st2 = "https://www.google.com.np/search?q="
						+ txtUrl2.getText().toString();
				b.loadUrl(st2);
			}
			if (st2.contains(".com") || st2.contains(".")) {

				if (st2.contains("http://") || st2.contains("https://")) {
					b.loadUrl(st2);
				} else if (txtUrl2.getText().toString().contentEquals("")) {

				} else {
					st2 = "http://" + txtUrl2.getText().toString();
					b.loadUrl(st2);
				}
			} else {
				if (txtUrl2.getText().toString().contentEquals("")) {
				} else {
					st2 = "https://www.google.com.np/search?q="
							+ txtUrl2.getText().toString();
					b.loadUrl(st2);
				}
			}
			// hiding keyboard
			InputMethodManager imm2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm2.hideSoftInputFromWindow(txtUrl2.getWindowToken(), 0);
			// XX
			break;

		case R.id.btnGo3:
			String st3 = txtUrl3.getText().toString();
			if (st3.contains(".") && st3.contains(" ")|| st3.length() < 4){
				st3 = "https://www.google.com.np/search?q="
						+ txtUrl3.getText().toString();
				c.loadUrl(st3);

			}
			if (st3.contains(".com") || st3.contains(".")) {

				if (st3.contains("http://") || st3.contains("https://")) {
					c.loadUrl(st3);

				} else if (txtUrl3.getText().toString().contentEquals("")) {

				} else {
					st3 = "http://" + txtUrl3.getText().toString();
					c.loadUrl(st3);

				}
			} else {
				if (txtUrl3.getText().toString().contentEquals("")) {
				} else {
					st3 = "https://www.google.com.np/search?q="
							+ txtUrl3.getText().toString();
					c.loadUrl(st3);
				}
			}
			// hiding keyboard
			InputMethodManager imm3 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm3.hideSoftInputFromWindow(txtUrl3.getWindowToken(), 0);
			// XX
			break;

		case R.id.btnGo4:
			String st4 = txtUrl4.getText().toString();

			if (st4.contains(".") && st4.contains(" ") || st4.length() < 4){
				st4 = "https://www.google.com.np/search?q="
						+ txtUrl4.getText().toString();
				d.loadUrl(st4);

            }

			if (st4.contains(".com") || st4.contains(".")) {

				if (st4.contains("http://") || st4.contains("https://")) {
					d.loadUrl(st4);

				} else if (txtUrl4.getText().toString().contentEquals("")) {

				} else {
					st4 = "http://" + txtUrl4.getText().toString();
					d.loadUrl(st4);

				}
			} else {
				if (txtUrl4.getText().toString().contentEquals("")) {
				} else {
					st4 = "https://www.google.com.np/search?q="
							+ txtUrl4.getText().toString();
					d.loadUrl(st4);

				}
			}
			// hiding keyboard
			InputMethodManager imm4 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm4.hideSoftInputFromWindow(txtUrl4.getWindowToken(), 0);
			// XX
			break;

		case R.id.btnGo5:
			String st5 = txtUrl5.getText().toString();
			if (st5.contains(".") && st5.contains(" ") || st5.length() < 4){
				st5 = "https://www.google.com.np/search?q="
						+ txtUrl5.getText().toString();
				e.loadUrl(st5);

            }

			if (st5.contains(".com") || st5.contains(".")) {

				if (st5.contains("http://") || st5.contains("https://")) {
					e.loadUrl(st5);
				} else if (txtUrl5.getText().toString().contentEquals("")) {

				} else {
					st5 = "http://" + txtUrl5.getText().toString();
					e.loadUrl(st5);

				}
			} else {
				if (txtUrl5.getText().toString().contentEquals("")) {
				} else {
					st5 = "https://www.google.com.np/search?q="
							+ txtUrl5.getText().toString();
					e.loadUrl(st5);

				}
			}

			// hiding keyboard-----
			InputMethodManager imm5 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm5.hideSoftInputFromWindow(txtUrl5.getWindowToken(), 0);
			// XXXXXXXXXXXXXXXXXXXX
			break;

		case R.id.btnForward1:
			if (a.canGoForward()) {
				a.goForward();
			}
			break;
		case R.id.btnForward2:
			if (b.canGoForward()) {
				b.goForward();
			}
		case R.id.btnForward3:
			if (c.canGoForward()) {
				c.goForward();
			}
			break;
		case R.id.btnForward4:
			if (d.canGoForward()) {
				d.goForward();
			}
			break;
		case R.id.btnForward5:
			if (e.canGoForward()) {
				e.goForward();
			}
			break;

		case R.id.btnBack1:
			if (a.canGoBack()) {
				a.goBack();
			}
			break;
		case R.id.btnBack2:
			if (b.canGoBack()) {
				b.goBack();
			}
			break;
		case R.id.btnBack3:
			if (c.canGoBack()) {
				c.goBack();
			}
			break;
		case R.id.btnBack4:
			if (d.canGoBack()) {
				d.goBack();
			}
			break;
		case R.id.btnBack5:
			if (e.canGoBack()) {
				e.goBack();
			}
			break;

		case R.id.btnRefresh1:
			a.reload();
			break;
		case R.id.btnRefresh2:
			b.reload();
			break;
		case R.id.btnRefresh3:
			c.reload();
			break;
		case R.id.btnRefresh4:
			d.reload();
			break;
		case R.id.btnRefresh5:
			e.reload();
			break;

		case R.id.btnhome1:
            if(et1!="")
			a.loadUrl(checkHomeUrlValidity(et1));
			break;
		case R.id.btnhome2:
            if(et2!="")
			b.loadUrl(checkHomeUrlValidity(et2));
			break;
		case R.id.btnhome3:
            if(et3!="")
			c.loadUrl(checkHomeUrlValidity(et3));
			break;
		case R.id.btnhome4:
            if(et4!="")
			d.loadUrl(checkHomeUrlValidity(et4));
			break;
		case R.id.btnhome5:
            if(et5!="")
			e.loadUrl(checkHomeUrlValidity(et5));
			break;

		case R.id.btnstop1:
			a.stopLoading();
			break;
		case R.id.btnstop2:
			b.stopLoading();
			break;
		case R.id.btnstop3:
			c.stopLoading();
			break;
		case R.id.btnstop4:
			d.stopLoading();
			break;
		case R.id.btnstop5:
			e.stopLoading();
			break;

		case R.id.btnmenu1:
			// TODO Auto-generated method stub;
			// this.openOptionsMenu();
			i = new Intent("ad.browser.adbrowser.HomeScreenSettings");
			startActivity(i);
			break;
		case R.id.btnmenu2:
			// this.openOptionsMenu();
			i = new Intent("ad.browser.adbrowser.HomeScreenSettings");
			startActivity(i);
			break;
		case R.id.btnmenu3:
			// this.openOptionsMenu();
			i = new Intent("ad.browser.adbrowser.HomeScreenSettings");
			startActivity(i);
			break;
		case R.id.btnmenu4:
			// this.openOptionsMenu();
			i = new Intent("ad.browser.adbrowser.HomeScreenSettings");
			startActivity(i);
			break;
		case R.id.btnmenu5:
			// this.openOptionsMenu();
			i = new Intent("ad.browser.adbrowser.HomeScreenSettings");
			startActivity(i);
			break;

		case R.id.wv1:
			txtUrl1.setSelected(false);
			break;
		case R.id.wv2:
			txtUrl2.setSelected(false);
			break;
		case R.id.wv3:
			txtUrl3.setSelected(false);
			break;
		case R.id.wv4:
			txtUrl4.setSelected(false);
		case R.id.wv5:
			txtUrl1.setSelected(false);
			break;

		case R.id.btnfull1:
			layout11.setVisibility(LinearLayout.GONE);
			layout12.setVisibility(LinearLayout.GONE);
			bf1.setVisibility(Button.GONE);
			bs1.setVisibility(Button.VISIBLE);
			break;
		case R.id.btnfull2:
			layout21.setVisibility(LinearLayout.GONE);
			layout22.setVisibility(LinearLayout.GONE);
			bf2.setVisibility(Button.GONE);
			bs2.setVisibility(Button.VISIBLE);
			break;
		case R.id.btnfull3:
			layout31.setVisibility(LinearLayout.GONE);
			layout32.setVisibility(LinearLayout.GONE);
			bf3.setVisibility(Button.GONE);
			bs3.setVisibility(Button.VISIBLE);
			break;
		case R.id.btnfull4:
			layout41.setVisibility(LinearLayout.GONE);
			layout42.setVisibility(LinearLayout.GONE);
			bf4.setVisibility(Button.GONE);
			bs4.setVisibility(Button.VISIBLE);
			break;
		case R.id.btnfull5:
			layout51.setVisibility(LinearLayout.GONE);
			layout52.setVisibility(LinearLayout.GONE);
			bf5.setVisibility(Button.GONE);
			bs5.setVisibility(Button.VISIBLE);
			break;

		case R.id.btnsmall1:
			layout11.setVisibility(LinearLayout.VISIBLE);
			layout12.setVisibility(LinearLayout.VISIBLE);
			bf1.setVisibility(Button.VISIBLE);
			bs1.setVisibility(Button.GONE);
			break;
		case R.id.btnsmall2:
			layout21.setVisibility(LinearLayout.VISIBLE);
			layout22.setVisibility(LinearLayout.VISIBLE);
			bf2.setVisibility(Button.VISIBLE);
			bs2.setVisibility(Button.GONE);
			break;
		case R.id.btnsmall3:
			layout31.setVisibility(LinearLayout.VISIBLE);
			layout32.setVisibility(LinearLayout.VISIBLE);
			bf3.setVisibility(Button.VISIBLE);
			bs3.setVisibility(Button.GONE);
			break;
		case R.id.btnsmall4:
			layout41.setVisibility(LinearLayout.VISIBLE);
			layout42.setVisibility(LinearLayout.VISIBLE);
			bf4.setVisibility(Button.VISIBLE);
			bs4.setVisibility(Button.GONE);
			break;
		case R.id.btnsmall5:
			layout51.setVisibility(LinearLayout.VISIBLE);
			layout52.setVisibility(LinearLayout.VISIBLE);
			bf5.setVisibility(Button.VISIBLE);
			bs5.setVisibility(Button.GONE);
			break;

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflatemenu = getMenuInflater();
		inflatemenu.inflate(R.menu.bmenu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.exit:
			exitt();
			break;
		case R.id.setting:
			Intent open = new Intent("ad.browser.adbrowser.HomeScreenSettings");
			startActivity(open);
			break;
		case R.id.clearHistory:
			Intent intent = new Intent("ad.browser.adbrowser.ViewHistory");
			startActivity(intent);
			//history();
			break;
		case R.id.clearCache:
			cache();
		}
		return false;
		// _____________________________________________________________________________________________________
	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub

		// OnTouch method is to bring up
		// keyboard___________________________________________________________________

		switch (arg0.getId()) {

		case R.id.txtUrl1:
			txtUrl1.setFocusableInTouchMode(true);
			txtUrl1.setSelected(true);
			txtUrl1.requestFocus();
			txtUrl1.setSelection(0, txtUrl1.getText().length() - 1);
			break;
		case R.id.txtUrl2:
			txtUrl2.setFocusableInTouchMode(true);
			txtUrl2.setSelected(true);
			txtUrl2.requestFocus();
			txtUrl2.setSelection(0, txtUrl2.getText().length() - 1);

		case R.id.txtUrl3:
			txtUrl3.setFocusableInTouchMode(true);
			txtUrl3.setSelected(true);
			txtUrl3.requestFocus();
			txtUrl3.setSelection(0, txtUrl3.getText().length() - 1);
			break;

		case R.id.txtUrl4:
			txtUrl4.setFocusableInTouchMode(true);
			txtUrl4.setSelected(true);
			txtUrl4.requestFocus();
			txtUrl4.setSelection(0, txtUrl4.getText().length() - 1);
			break;

		case R.id.txtUrl5:
			txtUrl5.setFocusableInTouchMode(true);
			txtUrl5.setSelected(true);
			txtUrl5.requestFocus();
			txtUrl5.setSelection(0, txtUrl5.getText().length() - 1);
			break;

		case R.id.wv1:
			switch (arg1.getAction()) {
			case MotionEvent.ACTION_DOWN:
				a.setSelected(true);
				txtUrl1.setSelected(false);
				b.setSelected(false);
				c.setSelected(false);
				d.setSelected(false);
				e.setSelected(false);
				break;
			case MotionEvent.ACTION_UP:
				if (!a.hasFocus()) {
					b.setSelected(false);
					c.setSelected(false);
					d.setSelected(false);
					e.setSelected(false);
					a.requestFocus();
				}
				break;
			}
			break;

		case R.id.wv2:
			switch (arg1.getAction()) {
			case MotionEvent.ACTION_DOWN:
				b.setSelected(true);
				txtUrl2.setSelected(false);
				a.setSelected(false);
				c.setSelected(false);
				d.setSelected(false);
				e.setSelected(false);
				break;
			case MotionEvent.ACTION_UP:
				if (!b.hasFocus()) {
					a.setSelected(false);
					c.setSelected(false);
					d.setSelected(false);
					e.setSelected(false);
					b.requestFocus();

				}
				break;
			}
			break;

		case R.id.wv3:
			switch (arg1.getAction()) {
			case MotionEvent.ACTION_DOWN:
				c.setSelected(true);
				txtUrl3.setSelected(false);
				b.setSelected(false);
				a.setSelected(false);
				d.setSelected(false);
				e.setSelected(false);
				break;
			case MotionEvent.ACTION_UP:
				if (!c.hasFocus()) {
					b.setSelected(false);
					a.setSelected(false);
					d.setSelected(false);
					e.setSelected(false);
					c.requestFocus();
				}
				break;
			}
			break;

		case R.id.wv4:
			switch (arg1.getAction()) {
			case MotionEvent.ACTION_DOWN:
				d.setSelected(true);
				txtUrl4.setSelected(false);
				b.setSelected(false);
				c.setSelected(false);
				a.setSelected(false);
				e.setSelected(false);
				break;
			case MotionEvent.ACTION_UP:

				if (!d.hasFocus()) {
					b.setSelected(false);
					c.setSelected(false);
					a.setSelected(false);
					e.setSelected(false);
					d.requestFocus();

				}
				break;
			}
			break;

		case R.id.wv5:
			switch (arg1.getAction()) {
			case MotionEvent.ACTION_DOWN:
				e.setSelected(true);
				txtUrl5.setSelected(false);
				b.setSelected(false);
				c.setSelected(false);
				a.setSelected(false);
				// e.setSelected(false);
				break;
			case MotionEvent.ACTION_UP:
				if (!e.hasFocus()) {
					b.setSelected(false);
					c.setSelected(false);
					d.setSelected(false);
					a.setSelected(false);
					e.requestFocus();
				}
				break;
			}
			break;
		}
		return false;
	}// ____________________________________________________________________________________________________

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		a.onPause();
		b.onPause();
		c.onPause();
		d.onPause();
		e.onPause();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getSettings();
		a.onResume();
		b.onResume();
		c.onResume();
		d.onResume();
		e.onResume();
	}

	public void cache() {
		a.clearCache(true);
		b.clearCache(true);
		c.clearCache(true);
		d.clearCache(true);
		e.clearCache(true);
		a.clearHistory();
		b.clearHistory();
		c.clearHistory();
		d.clearHistory();
		e.clearHistory();

		AlertDialog.Builder dlgAlert1 = new AlertDialog.Builder(this);
		dlgAlert1.setMessage("Cache Cleared Sucessfully!");
		dlgAlert1.setTitle("Cache");
		dlgAlert1.setPositiveButton("OK", null);
		dlgAlert1.setCancelable(true);
		dlgAlert1.create().show();
	}

	public void exitt() {
		a.clearHistory();
		b.clearHistory();
		c.clearHistory();
		d.clearHistory();
		e.clearHistory();
		a.clearCache(true);
		b.clearCache(true);
		c.clearCache(true);
		d.clearCache(true);
		e.clearCache(true);
		System.exit(0);
	}

	@SuppressWarnings("deprecation")
	private void getSettings() {
		// TODO Auto-generated method stub

		SharedPreferences getPrefs1 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean check1 = getPrefs1.getBoolean("checkJava", true);
		if (check1 == true) {
			a.getSettings().setJavaScriptEnabled(true);
			b.getSettings().setJavaScriptEnabled(true);
			c.getSettings().setJavaScriptEnabled(true);
			d.getSettings().setJavaScriptEnabled(true);
			e.getSettings().setJavaScriptEnabled(true);
		} else {
			a.getSettings().setJavaScriptEnabled(false);
			b.getSettings().setJavaScriptEnabled(false);
			c.getSettings().setJavaScriptEnabled(false);
			d.getSettings().setJavaScriptEnabled(false);
			e.getSettings().setJavaScriptEnabled(false);
		}

		SharedPreferences getPrefs2 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean check2 = getPrefs2.getBoolean("checkImages", true);
		if (check2 == true) {
			a.getSettings().setLoadsImagesAutomatically(true);
			b.getSettings().setLoadsImagesAutomatically(true);
			c.getSettings().setLoadsImagesAutomatically(true);
			d.getSettings().setLoadsImagesAutomatically(true);
			e.getSettings().setLoadsImagesAutomatically(true);
		} else {
			a.getSettings().setLoadsImagesAutomatically(false);
			b.getSettings().setLoadsImagesAutomatically(false);
			c.getSettings().setLoadsImagesAutomatically(false);
			d.getSettings().setLoadsImagesAutomatically(false);
			e.getSettings().setLoadsImagesAutomatically(false);
		}

		SharedPreferences getPrefs3 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean check3 = getPrefs3.getBoolean("checkOverview", true);
		if (check3 == true) {
			a.getSettings().setLoadWithOverviewMode(true);
			b.getSettings().setLoadWithOverviewMode(true);
			c.getSettings().setLoadWithOverviewMode(true);
			d.getSettings().setLoadWithOverviewMode(true);
			e.getSettings().setLoadWithOverviewMode(true);
		} else {
			a.getSettings().setLoadWithOverviewMode(false);
			b.getSettings().setLoadWithOverviewMode(false);
			c.getSettings().setLoadWithOverviewMode(false);
			d.getSettings().setLoadWithOverviewMode(false);
			e.getSettings().setLoadWithOverviewMode(false);
		}

		SharedPreferences getPrefs4 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean check4 = getPrefs4.getBoolean("checkCookies", true);
		if (check4 == true) {
			CookieManager.getInstance().setAcceptCookie(true);
		} else {
			CookieManager.getInstance().setAcceptCookie(false);
		}

		SharedPreferences getPrefs5 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean check5 = getPrefs5.getBoolean("checkPlug", true);
		if (check5 == true) {
			WebSettings webSettings1 = a.getSettings();
			webSettings1.setPluginState(PluginState.ON);

			WebSettings webSettings2 = b.getSettings();
			webSettings2.setPluginState(PluginState.ON);

			WebSettings webSettings3 = c.getSettings();
			webSettings3.setPluginState(PluginState.ON);

			WebSettings webSettings4 = d.getSettings();
			webSettings4.setPluginState(PluginState.ON);

			WebSettings webSettings5 = e.getSettings();
			webSettings5.setPluginState(PluginState.ON);
		} else {
			WebSettings webSettings1 = a.getSettings();
			webSettings1.setPluginState(PluginState.OFF);

			WebSettings webSettings2 = b.getSettings();
			webSettings2.setPluginState(PluginState.OFF);

			WebSettings webSettings3 = c.getSettings();
			webSettings3.setPluginState(PluginState.OFF);

			WebSettings webSettings4 = d.getSettings();
			webSettings4.setPluginState(PluginState.OFF);

			WebSettings webSettings5 = e.getSettings();
			webSettings5.setPluginState(PluginState.OFF);
		}

		SharedPreferences getPrefs6 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean check6 = getPrefs6.getBoolean("checkPass", true);
		if (check6 == true) {
			WebSettings webSettings1 = a.getSettings();
			webSettings1.setSaveFormData(true);
			webSettings1.setSavePassword(true);

			WebSettings webSettings2 = b.getSettings();
			webSettings2.setSaveFormData(true);
			webSettings2.setSavePassword(true);

			WebSettings webSettings3 = c.getSettings();
			webSettings3.setSaveFormData(true);
			webSettings3.setSavePassword(true);

			WebSettings webSettings4 = d.getSettings();
			webSettings4.setSaveFormData(true);
			webSettings4.setSavePassword(true);

			WebSettings webSettings5 = e.getSettings();
			webSettings5.setSaveFormData(true);
			webSettings5.setSavePassword(true);
		} else {
			WebSettings webSettings1 = a.getSettings();
			webSettings1.setSaveFormData(false);
			webSettings1.setSavePassword(false);

			WebSettings webSettings2 = b.getSettings();
			webSettings2.setSaveFormData(false);
			webSettings2.setSavePassword(false);

			WebSettings webSettings3 = c.getSettings();
			webSettings3.setSaveFormData(false);
			webSettings3.setSavePassword(false);

			WebSettings webSettings4 = d.getSettings();
			webSettings4.setSaveFormData(false);
			webSettings4.setSavePassword(false);

			WebSettings webSettings5 = e.getSettings();
			webSettings5.setSaveFormData(false);
			webSettings5.setSavePassword(false);
		}
	}

	private void getHome() {
		// TODO Auto-generated method stub

		SharedPreferences getData1 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		et1 = getData1.getString("editHome1", "");

		SharedPreferences getData2 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		et2 = getData2.getString("editHome2", "");

		SharedPreferences getData3 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		et3 = getData3.getString("editHome3", "");

		SharedPreferences getData4 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		et4 = getData4.getString("editHome4", "");

		SharedPreferences getData5 = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		et5 = getData5.getString("editHome5", "");

		SharedPreferences getPrefs = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		boolean check = getPrefs.getBoolean("checkHome", true);
		if (check == true) {
			  if(et1!="") {  //checking if et1 is empty or not
					 a.loadUrl(checkHomeUrlValidity(et1));
	          }
	          if(et2!="") {
	               txtUrl2.setText(et2);
	               b.loadUrl(checkHomeUrlValidity(et2));
	          }

			   if(et3!="") {
	               c.loadUrl(checkHomeUrlValidity(et3));
	            }
	          if(et4!="") {
	               d.loadUrl(checkHomeUrlValidity(et4));
	            }
	          if(et5!="") {
	               e.loadUrl(checkHomeUrlValidity(et5));
	            }
		} else {
		}
	}

    public String getTime(){
        Calendar c = Calendar.getInstance();
        int min = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
		int ampm = c.get(Calendar.AM_PM);
		String time;
		if(ampm ==0){
			time = hour+":"+min+" AM";
		}else{
			time = hour+":"+min+" PM";
		}
        return time;
    }

    public String getDate(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day  = c.get(Calendar.DAY_OF_MONTH);
        String date = day+"/"+month+"/"+year;
        return date;
    }

    public void saveHistory(String title, String url){
        ContentValues cv = new ContentValues();
        cv.put("time",getTime());
        cv.put("date",getDate());
        cv.put("title",title);
        cv.put("url",url);
        DatabaseHelper dbHelp = new DatabaseHelper(this);
        dbHelp.addHistory(cv);
    }

	public void refreshAutoCompleteAdapter(){
		txtUrl1.setAdapter(new AutoCompleteAdapter(this,dbhelper.getUrl()));
		txtUrl2.setAdapter(new AutoCompleteAdapter(this,dbhelper.getUrl()));
		txtUrl3.setAdapter(new AutoCompleteAdapter(this,dbhelper.getUrl()));
		txtUrl4.setAdapter(new AutoCompleteAdapter(this,dbhelper.getUrl()));
		txtUrl5.setAdapter(new AutoCompleteAdapter(this,dbhelper.getUrl()));
	}

	public String checkHomeUrlValidity(String url) {
		String st1 = null;
		if (url != "") {  //checking if et1 is empty or not
			st1 = url;
			if (st1.contains(".")) {
				if (st1.contains(".") && st1.contains(" ") || st1.length() < 4) {
					st1 = "https://www.google.com.np/search?q="
							+ url;

					return st1;
				}
				if (st1.contains(".com") || st1.contains(".")) {

					if (st1.contains("http://") || st1.contains("https://")) {
						return st1;
					} else {
						st1 = "http://" + url;
						return st1;
					}
				}
			}else{
				st1 = "https://www.google.com.np/search?q="
						+ url;
				return st1;
			}
		}
		return st1;
	}
}
