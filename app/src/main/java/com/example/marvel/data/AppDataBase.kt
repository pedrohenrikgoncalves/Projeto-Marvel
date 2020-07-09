package com.example.marvel.data

import android.content.Context
import androidx.room.*
import androidx.room.TypeConverter
import com.example.marvel.model.characters.CharacterRoom
import com.example.marvel.model.characters.ResultsCharacters
import java.lang.reflect.Type

@Database(
        entities = [CharacterRoom::class],
        version = 2,
        exportSchema = false
)
@TypeConverters(com.example.marvel.data.TypeConverter::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun characterdao(): CharacterDao
}

object DatabaseBuilder {
    private var instance: AppDataBase? = null

    @JvmStatic
    fun getAppDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): AppDataBase {
        val database = Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java, "database"
        )
        database.allowMainThreadQueries()
        val appDatabase = database.build()
        instance = appDatabase
        return appDatabase
    }

    @JvmStatic
    fun destroyInstance() {
        instance = null
    }
}