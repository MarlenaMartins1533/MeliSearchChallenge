package com.searchchallenge.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.searchchallenge.ui.composable.ProductListScreen
import com.searchchallenge.ui.composable.SearchScreen
import com.searchchallenge.ui.composable.parameterprovider.productListNamesParameterProvider
import com.searchchallenge.ui.theme.SearchChallengeTheme
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

    @Preview(showBackground = true)
    @Composable
    fun SearchProducts() {
        var searchResults by rememberSaveable { mutableStateOf(productListNamesParameterProvider.first()) }

        SearchScreen(
            onSearch = { query ->
                searchResults = "Search result for: $query"
                // Your search logic here.  For now, let's just update the searchResults:
                //chama fun da VM e traz os resultados da busca do Meli
                mainViewModel.searchProducts(query)
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(it).background(Color.LightGray),
            ) {
                Text(searchResults)
                ProductListScreen(productItems = mainViewModel.searchProductData.value)
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

