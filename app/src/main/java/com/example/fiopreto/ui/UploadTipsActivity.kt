
package com.example.fiopreto.ui
/*
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fiopreto.R
import com.example.fiopreto.presentation.UploadImgTipsViewModel
import kotlinx.android.synthetic.main.upload_image.*
import kotlinx.android.synthetic.main.upload_image_tips.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.ByteArrayOutputStream

class UploadTipsActivity : AppCompatActivity() {

    private val viewModel by viewModel<UploadImgTipsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_image_tips)
        pick_button_feed.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    requestPermissions(permissions, PERMISSION_CODE);
                } else {
                    pickImageFromGallery();
                }
            } else {
                pickImageFromGallery();
            }
        }

        upload_feed.setOnClickListener {
            viewModel.uploadImageTips()
        }


    }

    private fun uploadImage() {

        val byteArrayOutputStream = ByteArrayOutputStream()
        //bitmap.compress(Bitmap.CompressFormat.JPEG,75, byteArrayOutputStream)
        val imageInByte: ByteArray = byteArrayOutputStream.toByteArray()

        val encodedImage: String = Base64.encodeToString(imageInByte, Base64.DEFAULT)

        Toast.makeText(this,encodedImage, Toast.LENGTH_SHORT).show()
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000;
        private val PERMISSION_CODE = 1001;
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    pickImageFromGallery()
                } else {
                    Toast.makeText(this, "Permissão negada", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            image_view_feed.setImageURI(data?.data)
            viewModel.imageUri = data?.data
        }

    }

}


 */

 */
