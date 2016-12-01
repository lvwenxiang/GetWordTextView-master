package cn.droidlover.xrichtext;

import android.app.Application;

public class App extends Application {
	   @Override
	    public void onCreate() {
	        super.onCreate();

	        UILKit.init(getApplicationContext());        //≥ı ºªØUIL
	    }
}
