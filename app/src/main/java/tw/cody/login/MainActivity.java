package tw.cody.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean login = false;
    public final static int rc_login = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == rc_login) {
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra("password");
                Log.v("cody",""+text);
            } else {
                finish();
            }
        }
    }

    public void password(View view) {
        if (!login) {
            Intent intent = new Intent(MainActivity.this,passwordActivity.class);

            startActivityForResult(intent,rc_login);
//            startActivity(intent);
//            finish();
        }
    }
}