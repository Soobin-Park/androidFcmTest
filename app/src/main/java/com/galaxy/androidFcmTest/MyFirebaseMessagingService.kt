import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseMessagingService : FirebaseMessagingService() {
    // 디바이스 토큰을 얻는 코드

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        // 새로운 토큰이 생성될 때 호출되며, 이벤트를 핸들링하거나 다른 컴포넌트에 전달할 수 있습니다.
        Log.d("MyFirebaseMessagingService", "Refreshed token: $token")

        // MainActivity에 토큰을 전달할 수 있음
        MainActivity.onTokenRefresh(token)
    }

}






