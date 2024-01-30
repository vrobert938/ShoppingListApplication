package com.example.shoppinglistapplication

class GroceryRepository(private val groceryDatabase: GroceryDatabase) {

    suspend fun insert(items: GroceryItems) {
        groceryDatabase.groceryDao().insert(items)
    }

    suspend fun delete(items: GroceryItems) {
        groceryDatabase.groceryDao().delete(items)
    }

    fun getAllItems() = groceryDatabase.groceryDao().getAllGroceryItems()
}
