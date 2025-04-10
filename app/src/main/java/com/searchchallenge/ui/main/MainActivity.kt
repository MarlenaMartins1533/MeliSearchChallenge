package com.searchchallenge.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.searchchallenge.ui.composable.ProductListScreen
import com.searchchallenge.ui.composable.SearchScreen
import com.searchchallenge.ui.composable.model.Product
import com.searchchallenge.ui.composable.parameterprovider.productListNamesParameterProvider
import com.searchchallenge.ui.theme.SearchChallengeTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SearchChallengeTheme {
                SearchProducts()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true)
    @Composable
    fun SearchProducts() {
        var productToShow: Product? by rememberSaveable { mutableStateOf(null) }
        var showBottomSheet by rememberSaveable { mutableStateOf(false) }
        val bottomSheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()
        var searchResults by rememberSaveable { mutableStateOf(productListNamesParameterProvider.first()) }

        SearchScreen(
            onSearch = { query ->
                searchResults = "Search result for: $query"
                mainViewModel.searchProducts(query)
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(Color.LightGray),
            ) {
                Text(searchResults)
                ProductListScreen(
                    productItems = mainViewModel.searchProductData.value,
                    openBottomSheet = {
                        productToShow = it
                        showBottomSheet = true
                    }
                )
            }

            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    Modifier.padding(2.dp),
                    sheetState = bottomSheetState
                ) {
                    productToShow?.let { product ->
                        val productImage = product.images.first().removePrefix("https://")
                        Log.e("productImage", productImage)
                        Log.e("productDescription", product.description)

                        Text(product.name)
                        Row {
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(productImage)
                                    .build(),
                                contentDescription = "Restaurant Image",
                                modifier =
                                    Modifier
                                        .size(120.dp)
                                        .shadow(4.dp, RoundedCornerShape(4.dp))
                                        .clip(RoundedCornerShape(4.dp)),
                                contentScale = ContentScale.Crop,
                            )
                            Text(
                                text = product.description,
                                textAlign = TextAlign.Justify,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.align(CenterVertically)
                            )
                        }
                    }
                    Column(modifier = Modifier.padding(16.dp)) {
                        Button(
                            onClick = {
                                scope.launch {
                                    bottomSheetState.hide()
                                }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) {
                                        showBottomSheet = false
                                    }
                                }
                            }
                        ) { Text("Add Carrinho") }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SearchScreenPreview() {
//    SearchChallengeTheme {
//        SearchProducts()
//    }
//}

