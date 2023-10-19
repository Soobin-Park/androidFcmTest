package com.galaxy.androidFcmTest

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FCM 설정, 토큰 값 가져오기
        MyFirebaseMessagingService().getFirebaseToken()

        //PostNotification 대응
        checkAppPushNotification()

        //DynamicLink 수신 확인
        initDynamicLink()
    }

    private fun checkAppPushNotification(){
        //android 13 이상 + 푸시권한 x
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU
            && PackageManager.PERMISSION_DENIED == ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)){
            //푸쉬 권한 x
            permissionPostNotification.launch(Manifest.permission.POST_NOTIFICATIONS)
            return
        }

        //권한 있는 경우
    }

    //권한 요청
    private val permissionPostNotification = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(isGranted){
            //권한 허용
        } else {
            //권한 비허용
        }
    }

    //DynamicLink
    private fun initDynamicLink(){
        val dynamicLinkData = intent.extras
        if(dynamicLinkData != null){
            var dataStr = "DynamicLink 수신받은 값\n"
            for (key in dynamicLinkData.keySet()){
                dataStr += "key: $key / value: ${dynamicLinkData.getString(key)}\n"
            }
            binding.tvToken.text = dataStr
        }

    }




}