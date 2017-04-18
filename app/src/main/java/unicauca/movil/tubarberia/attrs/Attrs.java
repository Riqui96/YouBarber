package unicauca.movil.tubarberia.attrs;


import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Attrs {

    @BindingAdapter("app:imgUrl")// Esta linea llamamos e id el metodo para utlizarlo generalmente
    public static void loadImage(ImageView img, String url){
        Uri uri = Uri.parse(url);
        Picasso.with(img.getContext())
                .load(url)
                .into(img);
    }


}
