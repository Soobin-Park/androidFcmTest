import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.galaxy.androidFcmTest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        // Firebase 디바이스 토큰을 처리할 메서드를 정의
        fun onTokenRefresh(token: String) {
            // 토큰을 이용하여 필요한 작업을 수행
            // 이 메서드를 호출하여 토큰을 MainActivity에서 처리할 수 있음
            // 예: 토큰을 서버로 보내거나 로컬 저장소에 저장
        }
    }

}
