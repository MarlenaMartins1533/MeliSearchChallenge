package com.searchchallenge.ui.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.searchchallenge.ui.composable.model.Product
import com.searchchallenge.ui.composable.parameterprovider.productListParameterProvider

@Composable
fun ProductListScreen(productItems: List<Product>) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                items(productItems.size) { index ->
                    ProductCard(product = productItems[index])
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
private fun ProductListScreenPreview() {
    ProductListScreen(productItems = productListParameterProvider)
}
