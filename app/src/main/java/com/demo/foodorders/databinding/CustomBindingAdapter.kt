
import android.support.v7.widget.AppCompatTextView
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.demo.foodorders.R

public class CustomBindingAdapter {

    companion object {
        @android.databinding.BindingAdapter("imageRes")
        fun loadImage(imageView: ImageView, resID: Int) {
            if (resID == -1)
                return

            Glide.with(imageView.context)
                .load(resID)
                .into(imageView)
        }

        @android.databinding.BindingAdapter("android:src")
        fun setImageViewResource(imageView: ImageView, resource: Int) {
            imageView.setImageResource(resource)
        }

        @android.databinding.BindingAdapter("android:text")
        fun setFloat(view: AppCompatTextView, value: Float) {
            view.text = value.toString()
        }

        @android.databinding.BindingAdapter("android:text")
        fun setFloat(view: AppCompatTextView, value: Int) {
            view.text = value.toString()
        }

        @android.databinding.BindingAdapter("android:text")
        fun setFloat(view: AppCompatTextView, value: Long) {
            view.text = value.toString()
        }

        @android.databinding.BindingAdapter("android:text")
        fun setFloat(view: AppCompatTextView, value: Double) {
            view.text = value.toString()
        }

        @android.databinding.InverseBindingAdapter(attribute = "android:text")
        fun getFloat(view: AppCompatTextView): Float {
            val num = view.text.toString()
            if (num.isEmpty()) return 0.0f
            try {
                return java.lang.Float.parseFloat(num)
            } catch (e: NumberFormatException) {
                return 0.0f
            }

        }


        /**
         * Load image.
         *
         * @param imageView the image view
         * @param url       the url
         * @param resID     the res id
         */
        @android.databinding.BindingAdapter(value = ["imageUrl", "resId"], requireAll = false)
        fun loadImage(imageView: ImageView, url: String, resID: Int) {
            if (resID == -1) return
            Glide.with(imageView.context)
                .load(if (!TextUtils.isEmpty(url)) url else resID)
                .into(imageView)
        }


        /**
         * Bind fill icon.
         *
         * @param imageView        the image view
         * @param isSupportVisible the boolean
         */
        @android.databinding.BindingAdapter(value = ["bind:arrowIcon"], requireAll = false)
        fun bindArrowIcon(imageView: ImageView, isSupportVisible: Boolean) {
            if (!isSupportVisible) {
                imageView.setImageResource(R.mipmap.ic_launcher)
            } else {
                imageView.setImageResource(R.mipmap.ic_launcher)
            }
        }


        @android.databinding.BindingAdapter("remove")
        fun bindRemoveImage(img: ImageView, resId: Int) {
            img.setImageResource(resId)
        }




    }

}