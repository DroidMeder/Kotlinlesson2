package kg.geekteck.kotlinlesson2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kg.geekteck.kotlinlesson2.databinding.ActivityMainBinding
import kg.geekteck.kotlinlesson2.extentions.isImageUri
import kg.geekteck.kotlinlesson2.extentions.showToast
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val liisUrls = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialArray()
        letsDoJob()
        println("..$liisUrls.size")
    }

    private fun letsDoJob() {
        binding.btnRand.setOnClickListener{
            println("...$liisUrls.size")
            randomImage()
        }
        binding.btnSubmit.setOnClickListener{
            if (isImageUri(binding.etUrl.text.toString())){
                setImage(binding.etUrl.text.toString())
                liisUrls.add(binding.etUrl.text.toString())
            }else{
                showToast(getString(R.string.invalid_url))
            }
            binding.etUrl.setText("")
        }
    }

    private fun randomImage() {
        val random = Random()
        val randomIndex = random.nextInt(liisUrls.size)
        println("---$randomIndex")
        println("....$liisUrls.size")
        setImage(liisUrls[randomIndex])
    }

    private fun setImage(s: String) {
        Glide.with(this).load(s).centerCrop().into(binding.iv)
    }

    private fun initialArray() {
        liisUrls.add(getString(R.string.uri_1))
        liisUrls.add(getString(R.string.uri_2))
        liisUrls.add(getString(R.string.uri_3))
        liisUrls.add(getString(R.string.uri_4))
        liisUrls.add(getString(R.string.uri_5))
        liisUrls.add(getString(R.string.uri_6))
        liisUrls.add(getString(R.string.uri_7))
        liisUrls.add(getString(R.string.uri_8))
        liisUrls.add(getString(R.string.uri_9))
        liisUrls.add(getString(R.string.uri_10))
    }
}