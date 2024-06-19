package droid1.kandy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoView;

public class MainAct extends Activity{

    private static GeckoRuntime sRuntime;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        GeckoView view = findViewById(R.id.geckoview);
        GeckoSession session = new GeckoSession();

// Workaround for Bug 1758212
        session.setContentDelegate(new GeckoSession.ContentDelegate() {});

        if (sRuntime == null) {
            // GeckoRuntime can only be initialized once per process
            sRuntime = GeckoRuntime.create(this);
        }

        session.open(sRuntime);
        view.setSession(session);
        session.loadUri("about:buildconfig"); // Or any other URL...
    }

    public void btnperms(View v){
        requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},123);
    }

}
