package com.searchchallenge.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.searchchallenge.R
import com.searchchallenge.ui.composable.model.Product
import com.searchchallenge.ui.composable.parameterprovider.productListParameterProvider

@Composable
fun ProductCard(
    product: Product,
    onExpandedClick: @Composable ()-> Unit
) {
    rememberScrollState()
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(Color.Gray)
        ) {
//            AsyncImage(
//                model = product.images.first(),
//                contentDescription = product.name,
//                modifier = Modifier
//                    .padding(2.dp)
//                    .clip(shape = RoundedCornerShape(10.dp)),
//                placeholder = painterResource(id = android.R.drawable.ic_menu_gallery),
//                error = painterResource(id = R.drawable.baseline_add_shopping_cart_24),
//                contentScale = ContentScale.Crop,
//            )
            Image(
                painter = painterResource(id = R.drawable.baseline_add_shopping_cart_24),
                contentDescription = "Product image",
                modifier = Modifier
                    .size(120.dp)
                    .padding(1.dp)
                    .align(CenterVertically)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(CenterVertically)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = product.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = product.description,
                    textAlign = TextAlign.Justify,
                    fontSize = 14.sp,
                    color = Color.White,
                )
            }
            IconButton(
                onClick = { onExpandedClick() },
                modifier = Modifier.align(Alignment.CenterVertically)
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

@Composable
@Preview(showBackground = true)
private fun ProductCardPreview() {
    ProductCard(productListParameterProvider.first())
}
