package bradley.quiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;



//start up
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method called when button is pushed
    public void playGame(View view){
        Intent intent =  new Intent(this, PlayActivity.class);
        startActivity(intent);
    }
}