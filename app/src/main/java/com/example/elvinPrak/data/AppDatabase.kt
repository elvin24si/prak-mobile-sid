package com.example.elvinPrak.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.elvinPrak.data.dao.NoteDao
import com.example.elvinPrak.data.entity.NoteEntity

@Database(
    entities = [NoteEntity::class], // tambahkan entitas baru di sini
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    /*Tambahkan Dao baru disini */

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration() // Tambahkan baris ini, jika sudah selesai maka hapus
                    .build().also { INSTANCE = it }
            }
        }
    }
}