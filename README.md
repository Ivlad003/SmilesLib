# SmilesLib


| <a href='https://bintray.com/ivlad003/SmilesLib/smileslib?source=watch' alt='Get automatic notifications about new "smileslib" versions'><img src='https://www.bintray.com/docs/images/bintray_badge_color.png'></a>  | Version 1.0.4 |
| ------------- | ------------- |

```gradle

repositories {
    maven {
        url 'https://dl.bintray.com/ivlad003/SmilesLib'
    }
}

dependencies {
    compile 'com.github.ivlad003:smileslib:1.0.4'
}

```

![N|Solid](http://screenshots.collabstar.com/vz/Genymotion_for_personal_use_-_Samsung_Galaxy_S4_-_4_3_-_API_18_-_1080x1920__1080x1920__480dpi__-_192_168_56_101_1D8CAF4A.png)

Example use
```java
 
 TextView textView= (TextView) findViewById(R.id.text);
 EmoticonsTextWatcher.sAddSmile("==+", R.mipmap.ic_launcher);
 textView.addTextChangedListener(EmoticonsTextWatcher.newInstance(textView));
 textView.setText(":) bla bla ==+");
 
```
| Method | Info method|
| ------------- | ------------- |
| sSetSmiles  | set map in fromat <"Smile code" , "Drawable id">  |
| sAddSmile  | add smile parameter method "Smile code" , "Drawable id"  |
| sAddSmiles  | add new smiles map to old map smile  |
| setSmileHeight  | smile size `defoult line height` |

License
----

AGPL-V3
