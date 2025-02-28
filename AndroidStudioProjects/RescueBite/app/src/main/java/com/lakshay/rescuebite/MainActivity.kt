import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.firebase.FirebaseApp
import com.lakshay.rescuebite.navigation.AppNavigation
import com.lakshay.rescuebite.ui.theme.RescueBiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            RescueBiteTheme {
                AppNavigation()
            }
        }
    }
}
