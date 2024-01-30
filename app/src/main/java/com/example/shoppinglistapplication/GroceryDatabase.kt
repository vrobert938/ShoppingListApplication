package com.example.shoppinglistapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DATABASE_NAME = "GroceryApp.db"

@Database(entities = [GroceryItems::class], version = 1, exportSchema = false)
abstract class GroceryDatabase : RoomDatabase() {

    abstract fun groceryDao(): GroceryDao

    companion object {
        @Volatile
        private var instance: GroceryDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context): GroceryDatabase =
            instance ?: synchronized(LOCK) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context): GroceryDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                GroceryDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}