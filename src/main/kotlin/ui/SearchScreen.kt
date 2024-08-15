package ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import utilities.SearchAlgorithm
import kotlin.random.Random
import utilities.binarySearch
import utilities.linearSearch
import utilities.MenuItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(){

    val numberItems = remember { mutableStateOf("") }
    val itemsList = remember { mutableStateListOf<Any>() }

    val searchText = remember { mutableStateOf("") }


    val foundItemIndex = remember { mutableStateOf(-1) }


    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var selectedSearchAlgorithm by remember { mutableStateOf(SearchAlgorithm.Linear) }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {

            OutlinedTextField(
                value = numberItems.value,
                onValueChange = { numberItems.value = it },
                label = { Text("Number of Items") }
            )


            OutlinedTextField(
                value = searchText.value,
                onValueChange = { searchText.value = it },
                label = { Text("Search") }
            )

            SearchAlgorithm.values().forEach { algorithm ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedSearchAlgorithm == algorithm,
                        onClick = { selectedSearchAlgorithm = algorithm }
                    )
                    Text(algorithm.name)
                }
            }

            Button(
                onClick = {

                    val numItems = numberItems.value.toIntOrNull()
                    if (numItems != null) {
                        itemsList.clear()
                        repeat(numItems) {
                            itemsList.add(Random.nextInt(0, 100))
                        }
                    }



                    val typedArray = itemsList.map { it as Int }.toTypedArray()

                    foundItemIndex.value = when (selectedSearchAlgorithm) {
                        SearchAlgorithm.Linear -> linearSearch(typedArray, searchText.value.toInt())
                        SearchAlgorithm.Binary -> {
                            typedArray.sort()
                            itemsList.sortBy { it as Int}
                            binarySearch(typedArray, searchText.value.toInt())
                        }
                    }



                    if (foundItemIndex.value != -1) {
                        coroutineScope.launch {
                            listState.scrollToItem(foundItemIndex.value)
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                enabled = numberItems.value.isNotBlank()
            ) {
                Text("Search")
            }



            Text(
                text =
                when {
                    foundItemIndex.value != -1 -> "$selectedSearchAlgorithm: Found index: ${foundItemIndex.value}"
                    itemsList.isEmpty() -> ""
                    else -> "$selectedSearchAlgorithm: NOT FOUND"
                }
            )
        }

        LazyColumn(
            state = listState,
            modifier = Modifier.weight(1f)
        ) {
            itemsIndexed(itemsList) { index, item ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(2.dp),
                    shape = RoundedCornerShape(4.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Text(
                        text = "$index: $item",
                        modifier = Modifier.padding(start = 8.dp),
                        color = if (index == foundItemIndex.value)
                            MaterialTheme.colorScheme.error
                        else MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

