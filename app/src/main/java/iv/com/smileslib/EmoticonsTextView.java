package iv.com.smileslib;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.TextView;


public class EmoticonsTextView extends TextView {
    public EmoticonsTextView(Context context) {
        super(context);
    }

    public EmoticonsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmoticonsTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EmoticonsTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        Spannable spannable = SmilesHelper.getSmiledText(getContext(),
                text, getLineHeight());
        super.onTextChanged(spannable, start, lengthBefore, lengthAfter);
    }
}
