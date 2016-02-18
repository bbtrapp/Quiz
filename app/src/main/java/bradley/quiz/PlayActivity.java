package bradley.quiz;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayActivity extends AppCompatActivity implements
        PlayFragment.OnFragmentInteractionListener, PlayFragmentTwo.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, PlayFragmentTwo.newInstance(null, null))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
