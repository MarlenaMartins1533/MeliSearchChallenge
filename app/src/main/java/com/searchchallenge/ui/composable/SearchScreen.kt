package com.searchchallenge.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.searchchallenge.ui.composable.parameterprovider.productListNamesParameterProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onSearch: (String) -> Unit,
    content: @Composable () -> Unit,
) {
    var query by remember { mutableStateOf(productListNamesParameterProvider.first()) }
    var active by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            SearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = query,
                        onQueryChange = { query = it },
                        onSearch = {
                            onSearch(query)
                            active = false
                        },
                        expanded = active,
                        onExpandedChange = { active = it },
                        placeholder = { Text("Search...") },
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Search,
                                contentDescription = "Search"
                            )
                        },
                    )
                },
                expanded = active,
                onExpandedChange = { active = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = SearchBarDefaults.fullScreenShape,
            ) {
                Text(
                    "Suggestions will appear here...",
                    modifier = Modifier.padding(16.dp)
                )
            }
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.LightGray,
        contentColor = Color.LightGray,
        content = { paddingValues ->
            Column(Modifier.padding(paddingValues)) {
                content()
            }
        },
    )
}

@Composable
@Preview(showBackground = true)
private fun SearchScreenPreview() {
    SearchScreen(
        onSearch = { "Search result for: ${productListNamesParameterProvider.first()}" },
        content = {
            Column {
                Text("Search Results:")
            }
        }
    )
}

