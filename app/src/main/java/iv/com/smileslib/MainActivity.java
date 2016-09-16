package iv.com.smileslib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmoticonsTextWatcher.sAddSmile("==+", R.mipmap.emoji_1f912);
        EditText editText = (EditText) findViewById(R.id.text);
        final TextView textView = (TextView) findViewById(R.id.texttv);
        editText.addTextChangedListener(EmoticonsTextWatcher.newInstance(editText));
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                textView.setText(editable);
            }
        });

        textView.addTextChangedListener(EmoticonsTextWatcher.newInstance(textView));
        textView.setText(":) tra tra");

    }
}
