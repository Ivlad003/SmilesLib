# SmilesLib

Gradle

<a href='https://bintray.com/ivlad003/SmilesLib/smileslib?source=watch' alt='Get automatic notifications about new "smileslib" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>
```sh
repositories {
    maven {
        url 'https://dl.bintray.com/ivlad003/SmilesLib'
    }
}

compile 'com.github.ivlad003:smileslib:1.0.2'
```
![N|Solid](http://screenshots.collabstar.com/vz/Genymotion_for_personal_use_-_Samsung_Galaxy_S4_-_4_3_-_API_18_-_1080x1920__1080x1920__480dpi__-_192_168_56_101_1D8CAF4A.png)


Example use
```sh
 TextView textView= (TextView) findViewById(R.id.text);
 EmoticonsTextWatcher.sAddSmile("==+", R.mipmap.ic_launcher);
 textView.addTextChangedListener(EmoticonsTextWatcher.newInstance(textView));
 textView.setText(":) bla bla ==+");
```
       
sAddSmile add one smile         
parameters first: keySmile second: resId

sSetSmiles remove before all smile add

new Map<String,Integer> (<keySmile, resId>)
