import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class City(
    val name: String,
    val time: String
)

@Composable
fun App() {

    var cityName by remember {
        mutableStateOf("")
    }

    var cities by remember {
        mutableStateOf(
            listOf(
                City("Mexico City", "17:40"),
                City("New York", "19:40")
            )
        )
    }

    MaterialTheme {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Text(
                text = "World Clock",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = cityName,
                onValueChange = {
                    cityName = it
                },
                label = {
                    Text("Enter city")
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {

                    if (cityName.isNotBlank()) {

                        cities = cities + City(
                            cityName,
                            "00:00"
                        )

                        cityName = ""
                    }
                }
            ) {
                Text("Add City")
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {

                items(cities) { city ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),
                        shape = RoundedCornerShape(20.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {

                            Text(
                                text = city.name,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = city.time,
                                fontSize = 36.sp
                            )
                        }
                    }
                }
            }
        }
    }
}