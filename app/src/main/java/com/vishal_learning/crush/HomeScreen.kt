package com.vishal_learning.crush

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vishal_learning.crush.ui.theme.bellotaFontFamily

@Composable
fun HomeScreen() {
    var selectedItemIndex by remember { mutableIntStateOf(0) }

    val items = listOf(
        SmallBoxData(
            R.drawable.img,
            "The day we met is a day I will cherish until the end of time. I never feel as happy as I do when you are at my side."
        ),
        SmallBoxData(
            R.drawable.img_2,
            "I was thinking about you today and couldn't help but smile. Your presence has a way of making everything better."
        ),
        SmallBoxData(
            R.drawable.img_3,
            "Since you have come into my life, every moment I live is like a moment spent in heaven. I have never felt so much alive in life."
        ),
        SmallBoxData(
            R.drawable.img_4,
            "Love isn’t just appreciating each other for anything and everything. It’s about knowing what we are together and never giving up on what we dream together."
        ),
        SmallBoxData(
            R.drawable.img_5,
            "I knew my feelings for you were real when I spent more time thinking about you than worrying about myself."
        ),
        SmallBoxData(
            R.drawable.img_6,
            "What else can heaven offer me if I already have you in life? I don’t know if I’m dead or alive. I just know that I’m in love!"
        ),
        SmallBoxData(
            R.drawable.img_7,
            "Take my hand, take my whole life too. For I can’t help falling in love with you."
        ),
        SmallBoxData(
            R.drawable.img_8,
            "You are my best friend, my human diary, and my other half you mean the world to me and I love you."
        ),
        SmallBoxData(
            R.drawable.img_9,
            "I have stopped making wishes on spotting falling starsDo you know why? Because I have you and that’s all I want in my life."
        ),
        SmallBoxData(
            R.drawable.img_10,
            " For once in my life, I don’t have to try to be happy when I’m with you, it just happens."
        ),
        SmallBoxData(
            R.drawable.img_11,
            " I could never say how much I like you and just how special you are to me. But I can say that my world all smiles whenever I am with you. I love you a lot."
        ),
        SmallBoxData(
            R.drawable.img_12,
            "If I chose between breathing and loving you, I would use my last breath to utter I love you."
        ),
        SmallBoxData(
            R.drawable.img_13,
            "I believe that dreams can come true because mine did when I met you, my love. I will always love you. I swear."
        ),
        SmallBoxData(
            R.drawable.img_14,
            "I wonder if you know how I truly feel and how happy my heart is when we are together? I would count the ways, but I would run out of time because I am sure one lifetime wouldn’t be enough."
        ),
        SmallBoxData(
            R.drawable.img_15,
            " I will never forget the moment when my soul had found its eternal mate in you"
        ),
        SmallBoxData(
            R.drawable.img_16,
            "The most beautiful addition in my life came in disguise from you."
        )
    )

    var selectedImage by remember { mutableIntStateOf(items[selectedItemIndex].image) }
    var selectedText by remember { mutableStateOf(items[selectedItemIndex].text) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(selectedImage),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop
        )
        Content(
            selectedImage = selectedImage,
            selectedText = selectedText,
            onBackClick = {
                // Decrease the index and update image and text
                selectedItemIndex = (selectedItemIndex - 1 + items.size) % items.size
                selectedImage = items[selectedItemIndex].image
                selectedText = items[selectedItemIndex].text
            },
            onForwardClick = {
                // Increase the index and update image and text
                selectedItemIndex = (selectedItemIndex + 1) % items.size
                selectedImage = items[selectedItemIndex].image
                selectedText = items[selectedItemIndex].text
            }
        )
    }
}

@Composable
fun Content(
    selectedImage: Int,
    selectedText: String,
    onBackClick: () -> Unit,
    onForwardClick: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 200.dp, height = 200.dp)
                            .offset(y = 54.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        // Blurred background
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White.copy(alpha = 0.3f)) // Adjust transparency here
                                .blur(200.dp) // Adjust blur radius here
                        )

                        // Text on top of the blurred background
                        Text(
                            text = selectedText,
                            color = Color.Black,
                            fontSize = 19.sp,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            fontFamily = bellotaFontFamily,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(selectedImage),
                        contentDescription = "crush",
                        modifier = Modifier
                            .offset(y = 16.dp)
                            .size(width = 140.dp, height = 249.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.LightGray)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                OutlinedButton(
                    onClick = {
                        // Decrease the index and update image and text
                        onBackClick()
                    },
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.CenterVertically)
                        .offset(y = 126.dp),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.outlinedButtonColors(Color.White.copy(alpha = 0.2f))
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "Back arrow",
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedButton(
                    onClick = {
                        // Increase the index and update image and text
                        onForwardClick()
                    },
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.CenterVertically)
                        .offset(y = 126.dp),
                    shape = CircleShape,
                    contentPadding = PaddingValues(0.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.outlinedButtonColors(Color.White.copy(alpha = 0.2f))
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Forward arrow",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun ContentPreview() {
    HomeScreen()
}


