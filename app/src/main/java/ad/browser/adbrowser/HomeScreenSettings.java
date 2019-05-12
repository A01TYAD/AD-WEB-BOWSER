package ad.browser.adbrowser;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class HomeScreenSettings extends PreferenceActivity{
@SuppressWarnings("deprecation")
@Override protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	addPreferencesFromResource(R.xml.prefs);
}
	@Override
	protected boolean isValidFragment(String fragmentName) {
		return super.isValidFragment(fragmentName);
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
