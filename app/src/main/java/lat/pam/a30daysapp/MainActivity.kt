package lat.pam.a30daysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "30 Days Of Wellness",
                        style = MaterialTheme.typography.h4.copy(fontSize = 28.sp),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    WellnessTipsList(tips = wellnessTips)
                }
            }
        }
    }
}


val wellnessTips = listOf(
    WellnessTip(1, "Spend 15 minutes outdoors", "Put some time on your callendar to take a walk outside or maybe take a meeting while you're srtolling through your neighborhood.", R.drawable.image1),
    WellnessTip(2, "Listen to a new podcast", "Listen to a podcast and explore a topic you've been itching to learn more about or discover a completely new topic or genre of podcast content.", R.drawable.image2),
    WellnessTip(3, "Study for 2 hours", "learn new things related to the world of technology.", R.drawable.image3),
    // Tambahkan data untuk 27 hari lainnya dengan judul dan deskripsi yang berbeda
)

@Composable
fun WellnessTipsList(tips: List<WellnessTip>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(tips) { tip ->
            TipCard(tip = tip)
        }
    }
}

@Composable
fun TipCard(tip: WellnessTip) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = Color(0xFFE8F5E9)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Day ${tip.day}", style = MaterialTheme.typography.h6, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = tip.title,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = tip.imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = tip.description, style = MaterialTheme.typography.body1)
        }
    }
}
