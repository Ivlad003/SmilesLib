package iv.com.smileslib;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SmilesHelper {
    private static final Spannable.Factory spannableFactory = Spannable.Factory
            .getInstance();
    private static final Map<Pattern, Integer> emoticons = new HashMap<>();
    private static int mSmileHeight = 0;

    static {
        addPattern(emoticons, ":)", R.mipmap.emoji_1f642);
        addPattern(emoticons, ":-)", R.mipmap.emoji_1f60a);
        addPattern(emoticons, ":-(", R.mipmap.emoji_1f641);
        addPattern(emoticons, ";-)", R.mipmap.emoji_1f609);
        addPattern(emoticons, ";-P", R.mipmap.emoji_1f61c);
        addPattern(emoticons, ":-P", R.mipmap.emoji_1f61d);
        addPattern(emoticons, "=-O", R.mipmap.emoji_1f62e);
        addPattern(emoticons, ":-[", R.mipmap.emoji_1f62b);
        addPattern(emoticons, ":-\\", R.mipmap.emoji_1f615);
        addPattern(emoticons, ":'(", R.mipmap.emoji_1f622);
        addPattern(emoticons, ":-D", R.mipmap.emoji_1f603);
        addPattern(emoticons, ":-!", R.mipmap.emoji_1f62c);
        addPattern(emoticons, ":-$", R.mipmap.emoji_1f633);
        addPattern(emoticons, ":-))", R.mipmap.emoji_1f604);
        addPattern(emoticons, ":' -(", R.mipmap.emoji_1f62a);
        addPattern(emoticons, ":'-(", R.mipmap.emoji_1f62a);
        addPattern(emoticons, ":-|", R.mipmap.emoji_1f610);
        addPattern(emoticons, ":-*", R.mipmap.emoji_1f618);
        addPattern(emoticons, ":~", R.mipmap.emoji_1f616);
        addPattern(emoticons, "=:O", R.mipmap.emoji_1f911);
        addPattern(emoticons, ":-}", R.mipmap.emoji_1f602);
        addPattern(emoticons, ">:)", R.mipmap.emoji_1f608);
        addPattern(emoticons, "(:V)", R.mipmap.emoji_1f913);
    }

    public static void setmSmileHeight(int mSmileHeight) {
        SmilesHelper.mSmileHeight = mSmileHeight;
    }

    private static void addPattern(Map<Pattern, Integer> map, String smile,
                                   int resource) {
        map.put(Pattern.compile(Pattern.quote(smile)), resource);
    }

    private static boolean addSmiles(Context context, Spannable spannable, int heigth) {
        boolean hasChanges = false;
        Log.d("addSmiles", "heigth " + heigth);
        for (Map.Entry<Pattern, Integer> entry : emoticons.entrySet()) {
            Matcher matcher = entry.getKey().matcher(spannable);
            while (matcher.find()) {
                boolean set = true;
                for (ImageSpan span : spannable.getSpans(matcher.start(),
                        matcher.end(), ImageSpan.class))
                    if (spannable.getSpanStart(span) >= matcher.start()
                            && spannable.getSpanEnd(span) <= matcher.end())
                        spannable.removeSpan(span);
                    else {
                        set = false;
                        break;
                    }
                if (set) {
                    hasChanges = true;
                    Bitmap smiley = BitmapFactory.decodeResource(context.getResources(), entry.getValue());
                    smiley = Bitmap.createScaledBitmap(smiley, heigth, heigth, true);
                    ImageSpan imageSpan = new ImageSpan(context, smiley);
                    spannable.setSpan(imageSpan,
                            matcher.start(), matcher.end(),
                            Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                }
            }
        }
        return hasChanges;
    }

    public static Spannable getSmiledText(Context context, CharSequence text, int height) {
        Spannable spannable = spannableFactory.newSpannable(text);

        addSmiles(context, spannable, SmilesHelper.mSmileHeight !=0
                ? SmilesHelper.mSmileHeight : height);

        return spannable;
    }

    public static void replaceAllSmiles(Map<String, Integer> patternIntegerMap) {
        emoticons.clear();
        for (Map.Entry<String, Integer> stringIntegerEntry : patternIntegerMap.entrySet()) {
            addPattern(emoticons, stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }

    public static void addSmiles(Map<String, Integer> patternIntegerMap) {
        for (Map.Entry<String, Integer> stringIntegerEntry : patternIntegerMap.entrySet()) {
            addPattern(emoticons, stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }

    public static void addSmile(String smileCode, Integer idRes) {
        addPattern(emoticons, smileCode, idRes);
    }
}
