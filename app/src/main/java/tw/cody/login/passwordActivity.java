package tw.cody.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class passwordActivity extends AppCompatActivity {
    private EditText editText;
    private int counter=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.password);

        editText = findViewById(R.id.input);
    }

    public void signIn(View view) {
        String text = editText.getText().toString();
//        Log.v("cody",text);
        counter++;
//        Log.v("cody","" + counter);
        String password = "55112";
        if (text.equals("55112")) {
            Intent intent = new Intent(passwordActivity.this,loginActivity.class);
            intent.putExtra("password",text);
            setResult(RESULT_OK,intent);
//            getIntent().putExtra("password",text);
//            setResult(RESULT_OK,getIntent());
//            startActivity(intent);
            finish();
        } else if (counter==1){
            Toast.makeText(passwordActivity.this,"請再試一次",Toast.LENGTH_SHORT).show();
        } else if (counter >= 2 && counter < 4) {
            Toast.makeText(passwordActivity.this,"剩餘"+(4-counter)+"次機會",Toast.LENGTH_SHORT).show();    
        } else if (counter == 4) {
            showDiaLog();
        }
    }


    private void showDiaLog() {
        AlertDialog dialog = new AlertDialog.Builder(passwordActivity.this)
                .setMessage("密碼輸入錯誤")
                .setCancelable(false)
                .setPositiveButton("ok", null)
                .create();
        dialog.show();
    }
}
