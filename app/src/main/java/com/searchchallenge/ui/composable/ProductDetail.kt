package com.searchchallenge.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.searchchallenge.R
import com.searchchallenge.ui.composable.model.Product
import com.searchchallenge.ui.composable.parameterprovider.productListParameterProvider

@Composable
fun ProductDetail(product: Product) {
    rememberScrollState()
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .background(Color.Gray)
        ) {
            Text(
                text = product.name,
                textAlign = TextAlign.Center,
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            AsyncImage(
                model = product.images.first(),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                placeholder = painterResource(id = android.R.drawable.ic_menu_gallery),
                error = painterResource(id = R.drawable.baseline_add_shopping_cart_24),
                contentScale = ContentScale.Crop,
            )
            Row {
                Text(
                    text = product.description,
                    textAlign = TextAlign.Justify,
                    fontSize = 14.sp,
                    color = Color.White,
                )
                IconButton(
                    onClick = { /* Future Improvinment Handle expand click to see more infos: ProductDetails */ },
                    modifier = Modifier.align(CenterVertically)
                ) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_dialog_info),
                        tint = Color.White,
                        contentDescription = "Info Icon"
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ProductDetailPreview() {
    ProductCard(productListParameterProvider.first())
}
