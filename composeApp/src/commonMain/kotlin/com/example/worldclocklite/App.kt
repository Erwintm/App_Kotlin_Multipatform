import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class City(
    val name: String,
    val country: String,
    val time: String,
    val difference: String
)

@Composable
fun App() {

    val cities = listOf(
        City("Mexico City", "Mexico", "17:40", "Local Time"),
        City("New York", "USA", "19:40", "+2 Hours"),
        City("London", "UK", "00:40", "+7 Hours"),
        City("Tokyo", "Japan", "08:40", "+15 Hours")
    )

    MaterialTheme {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF4F4F4))
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Text(
                    text = "World Clock",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                LazyColumn {

                    items(cities) { city ->

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            shape = RoundedCornerShape(20.dp)
                        ) {

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)
                            ) {

                                Text(
                                    text = city.name,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = city.country,
                                    fontSize = 16.sp,
                                    color = Color.Gray
                                )

                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    text = city.time,
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    text = city.difference,
                                    fontSize = 16.sp,
                                    color = Color(0xFF1565C0)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}