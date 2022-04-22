package kg.geekteck.kotlinlesson2.extentions

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.webkit.MimeTypeMap
import android.widget.Toast
import java.util.*

private val liisUrls = arrayListOf("image/bmp", "image/gif","image/ico","image/ico",
    "image/ief","image/x-icon","image/x-ms-bmp","image/jpeg", "image/jpg", "image/jpe", "image/pcx",
    "image/png", "image/svg+xml", "image/svg", "image/tiff", "image/tif", "image/vnd.djvu",
    "image/vnd.djv", "image/vnd.wap.wbmp", "image/webp"
)

fun Context.isImageUri(uri: String): Boolean{
    if(liisUrls.contains(getMimeType(Uri.parse(uri)))){
        return true
    }
    return false
}

fun Context.getMimeType(uri: Uri): String? {
    val mimeType: String? = if (ContentResolver.SCHEME_CONTENT == uri.scheme) {
        val cr: ContentResolver = this.contentResolver
        cr.getType(uri)
    } else {
        val fileExtension = MimeTypeMap.getFileExtensionFromUrl(
            uri
                .toString()
        )
        MimeTypeMap.getSingleton().getMimeTypeFromExtension(
            fileExtension.lowercase(Locale.ENGLISH)
        )
    }
    return mimeType
}

fun Context.showToast(toast: String){
    Toast.makeText(this, toast, Toast.LENGTH_LONG).show()
}