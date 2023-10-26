package com.example.limonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.limonada.ui.theme.LimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimonadaTheme {

            }
        }
    }
}

@Preview (showSystemUi = true)
@Composable
fun AppLimonada(){

    var mudar by remember { mutableStateOf(1) }
    var idImagem = 1
    var idString = 1
    var onClickImagem:() -> Unit =  {}
    var qtdclick by remember { mutableStateOf(0) }

    when (mudar){
        1 ->{
            idImagem= R.drawable.limoeiro
            idString= R.string.limoeiro
            onClickImagem={
                mudar =2
                qtdclick = (2..4).random()
            }
        }
       2 -> {
           idImagem= R.drawable.limao
           idString= R.string.limao
           onClickImagem={
               if(qtdclick >1 && qtdclick < 5)
                   qtdclick--
               else
                   mudar =3
           }
       }
       3 -> {
           idImagem= R.drawable.limonada
           idString= R.string.limonda
           onClickImagem={
               mudar =4
           }
       }

        4 -> {
            idImagem= R.drawable.copo_vazio
            idString= R.string.copo_vazio
            onClickImagem={
                mudar =1
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = null,
            modifier = Modifier.clickable(onClick = onClickImagem)
        )
        Text(
            text = stringResource(id= idString) + qtdclick
        )

        }

}

