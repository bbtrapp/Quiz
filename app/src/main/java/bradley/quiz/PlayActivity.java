package bradley.quiz;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayActivity extends AppCompatActivity implements PlayFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment_container, PlayFragment.newInstance(null, null))

                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
