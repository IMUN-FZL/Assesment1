package imun.hacktiv8.assesment1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String USER_INPUT_KEY = "userInput";

    private EditText inputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.editText);
        restoreUserInput();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveUserInput();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreUserInput();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveUserInput();
    }

    private void saveUserInput() {
        String userInput = inputEditText.getText().toString();
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        preferences.edit().putString(USER_INPUT_KEY, userInput).apply();
    }

    private void restoreUserInput() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String savedInput = preferences.getString(USER_INPUT_KEY, "");
        inputEditText.setText(savedInput);
    }
}
