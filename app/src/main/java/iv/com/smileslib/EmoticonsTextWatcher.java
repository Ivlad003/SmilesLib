package iv.com.smileslib;

import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.TextView;

import java.util.Map;


public class EmoticonsTextWatcher implements TextWatcher {
    private TextView mTextMessages;

    public static EmoticonsTextWatcher newInstance(TextView mTextMessages) {
        EmoticonsTextWatcher emoticonsTextWatcher = new EmoticonsTextWatcher();
        emoticonsTextWatcher.setmTextMessages(mTextMessages);
        return emoticonsTextWatcher;
    }

    //"Smile code" , "Drawable id"
    //Example patternIntegerMap.put(":)", R.mipmap.emoji_1f642);
    public static void sSetSmiles(Map<String, Integer> patternIntegerMap) {
        SmilesHelper.replaceAllSmiles(patternIntegerMap);
    }

    //"Smile code" , "Drawable id"
    public static void sAddSmile(String smile, Integer idRes) {
        SmilesHelper.addSmile(smile, idRes);
    }

    public static void setSmileHeight() {

    }

    public void setmTextMessages(TextView mTextMessages) {
        this.mTextMessages = mTextMessages;
    }

    //"Smile code" , "Drawable id"
    //Example patternIntegerMap.put(":)", R.mipmap.emoji_1f642);
    public EmoticonsTextWatcher setSmiles(Map<String, Integer> patternIntegerMap) {
        SmilesHelper.replaceAllSmiles(patternIntegerMap);
        return this;
    }

    public static void sAddSmiles(Map<String, Integer> patternIntegerMap) {
        SmilesHelper.addSmiles(patternIntegerMap);
    }

    //"Smile code" , "Drawable id"
    public EmoticonsTextWatcher addSmile(String smile, Integer idRes) {
        SmilesHelper.addSmile(smile, idRes);
        return this;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable.length() != 0) {
            mTextMessages.removeTextChangedListener(this);
            Spannable spannable = SmilesHelper.getSmiledText(mTextMessages.getContext(),
                    editable.toString(), mTextMessages.getLineHeight());
            mTextMessages.setText("");
            mTextMessages.append(spannable);
            mTextMessages.addTextChangedListener(this);
        }
    }
}