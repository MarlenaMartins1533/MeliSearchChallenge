package com.searchchallenge.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.searchchallenge.ui.composable.ProductListScreen
import com.searchchallenge.ui.composable.SearchScreen
import com.searchchallenge.ui.composable.parameterprovider.productListNamesParameterProvider
import com.searchchallenge.ui.composable.parameterprovider.productListParameterProvider
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
        val searchResults = remember { mutableStateOf(productListNamesParameterProvider.first()) }

        SearchScreen(
            onSearch = { query ->
                searchResults.value = "Search result for: $query"
                mainViewModel.searchProducts(query)
            }
        ) {
            Column {
                Text("Search Results:")
                ProductListScreen(productItems = productListParameterProvider)
            }
        }
    }
}
