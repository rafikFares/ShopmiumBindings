package com.example.shopmiumbindings.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.ViewModelProvider
import com.example.shopmiumbindings.R
import com.example.shopmiumbindings.ui.theme.ShopmiumCompozeTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            ShopmiumCompozeTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DefaultContentView(viewModel)
                }
            }
        }
    }
}

@Composable
fun DefaultContentView(viewModel: MainViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(White)
    ) {
        val (headerImage, list, button) = createRefs()

        HeaderImageView(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Black)
                .constrainAs(headerImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(list.top)
                }
        )
        ListView(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
                .constrainAs(list) {
                    top.linkTo(headerImage.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(button.top)
                    height = Dimension.fillToConstraints
                },
            viewModel.itemDataList
        )
        BottomButton(
            modifier = Modifier
                .width(200.dp)
                .height(70.dp)
                .padding(bottom = 20.dp)
                .constrainAs(button) {
                    top.linkTo(list.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            viewModel.onButtonClick()
        }
    }
}

@Composable
fun ListView(modifier: Modifier, itemDataList: List<ItemData>) {
    LazyColumn(modifier = modifier) {
        items(itemDataList) { item ->
            ItemView(item)
        }
    }
}

@Composable
fun ItemView(itemData: ItemData) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = itemData.data,
            fontSize = 30.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(Black)
                .align(Alignment.BottomCenter)
        ) {
        }
    }
}

@Composable
fun HeaderImageView(modifier: Modifier) {
    Image(
        painterResource(id = R.drawable.ic_shopmium_logo),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun BottomButton(modifier: Modifier, onClick: () -> Unit) {
    var buttonText by remember {
        mutableStateOf("Click Me ?")
    }

    Button(
        onClick = {
            buttonText = "Clicked!!"
            onClick.invoke()
        },
        modifier = modifier
    ) {
        Text(text = buttonText)
    }
}
