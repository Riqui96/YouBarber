package unicauca.movil.tubarberia.attrs;


import android.content.res.AssetManager;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Attrs {

    @BindingAdapter("app:imgUrl")// Esta linea llamamos  id el metodo para utlizarlo generalmente
    public static void loadImage(ImageView img, String url){
        Uri uri = Uri.parse(url);
        Picasso.with(img.getContext())
                .load(url)
                .into(img);
    }

    @BindingAdapter("app:fontTtf")
    public static void loadFonts(TextView txt, String font){
        AssetManager assetManager = txt.getContext().getAssets();

        Typeface typeface = Typeface.createFromAsset(assetManager, "fonts/"+font+".ttf");
        txt.setTypeface(typeface);
    }
}
