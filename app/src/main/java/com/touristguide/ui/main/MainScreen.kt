package com.touristguide.ui.main

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.touristguide.R
import com.touristguide.routing.Screen
import com.touristguide.ui.model.PlaceModel
import com.touristguide.ui.theme.TouristGuideAppTheme
import com.touristguide.ui.theme.brown
import com.touristguide.ui.theme.white
import com.touristguide.utils.RoundedButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val list = ArrayList<PlaceModel>().apply {
        add(PlaceModel(id = "", detail = "Dausa is a small ancient town named after a Sanskrit word Dhau-sa meaning Beautiful like Heaven. Also referred as Deva Nagri, located around 55 km from Jaipur, on National Highway 11. The city was the first headquarter of the former Kachhawaha Dynasty and has much history and archaeological importance linked to it. Situated away from the bustling cities, the town of Dausa", image = R.drawable.ic_dausa, name = "Dausa"))
        add(PlaceModel(id = "", detail = "Situated in the eastern part of Rajasthan, Dholpur became a separate district in 1982 comprising four tehsils of Bharatpur – namely Dholpur, Rajakhera, Bari and Baseri. Carved out of Bharatpur district, Dholpur is surrounded by Agra on the north, Morena district of Madhya Pradesh on the south and Karauli on the west.", image = R.drawable.ic_dholpur, name = "Dholpur"))
        add(PlaceModel(id = "", detail = "The small city of Karauli that has recently caught the attention of tourists is an exquisite home to well decorated havelis, peaceful shrines, picturesque views and imprinted chhatris that dot the entire city. This beauty of a place in Rajasthan shares its borders with the heart of India, Madhya Pradesh and is surrounded by Dausa, Dholpur and sawai Madhopur in Rajasthan.", image = R.drawable.ic_karauli, name = "Karauli"))
        add(PlaceModel(id = "", detail = "Located around 400 km from Delhi, Hanumangarh is a city best known for its temples and its historical significance given that it was once part of the Indus Valley Civilization. Recent excavations in the area have revealed some stunning artefacts belonging to an era of great significance to human history.", image = R.drawable.ic_hanumangarh, name = "Hanumangarh"))
        add(PlaceModel(id = "", detail = "Famous as the ‘city of textiles and looms’, Bhilwara is home to the world renowned Ramdwara of Ramsnehi Sampraday. The founder Guru of the Sampraday, Swami Ramcharanji Maharaj, preached to his followers here and later decided to move to Shahpura. The present day headquarters of the Ram Snehi Sampraday, known as Ram Niwas Dham are located in Shahpura.", image = R.drawable.ic_bhilwara, name = "Bhilwara"))
        add(PlaceModel(id = "", detail = "The realm of lovely havelis, harking back to the yester years, epitomizes the beauty of Shekhawati – a region that comprises of Sikar, Jhunjhunu and Churu. It is a major landmark tourist destination of colourful Rajasthan. Once the bastion of Rao Shekha, this magnificent land, located on the North of Rajasthan, derives its nomenclature from the former.", image = R.drawable.ic_shekhawati, name = "Shekhawati"))
        add(PlaceModel(id = "", detail = "A small town near the city of Jaipur, Tonk is one of the most interesting places in Rajasthan and is renowned for its old havelis and mosques. This elegant town of Jaipur was once ruled by the Pathans of Afghanistan. The ancient town takes pride in its beautiful architectural wonders, established during the Mughal era. The Nawab of Tonk was very fond of literature and built a large library of Persian and Arabic manuscripts. Founded in the 17th century, the town of Tonk serves as a host to several mansions, mosques and British colonial buildings.", image = R.drawable.ic_tonk, name = "Tonk"))
    }
    TouristGuideAppTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .background(color = brown)
                    .padding(top = 40.dp)
                    .verticalScroll(scrollState)
            ) {
                SmallTopAppBar(
                    title = {
                        Text(
                            text = "Home", color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                        )
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = brown,
                        titleContentColor = Color.White
                    )
                )
                Spacer(Modifier.height(10.dp))
                Column(modifier = Modifier.background(white)) {
                    list.forEachIndexed { index, placeModel ->
                        Box(Modifier) {
                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .height(150.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = placeModel.image),
                                    contentDescription = "Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .padding(start = 50.dp, end = 50.dp)
                                    .align(Center)
                                    .offset(0.dp, 32.dp)
                            ) {
                                RoundedButton(
                                    text = placeModel.name ,
                                    onClick = {
                                        navController.navigate(Screen.Detail.route + "/${placeModel.name}"+"/${placeModel.image}"+"/${placeModel.detail}")
                                    }
                                )
                            }
                        }

                    }
                }
            }
        }


    }

}