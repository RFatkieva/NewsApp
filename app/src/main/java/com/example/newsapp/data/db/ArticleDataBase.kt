package com.example.newsapp.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ArticleDataBase:RoomDatabase() {
    abstract fun getArticleDao():ArticleDao
    companion object {
        @Volatile
        private var instance:ArticleDataBase?= null
        private var LOCK=Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK) {
            instance?: createDatabase (context).also { instance=it }
                    }
        private  fun createDatabase(context: Context):ArticleDataBase{
            return Room.databaseBuilder(
                context.applicationContext,
                ArticleDataBase::class.java,
                "article_database"
            ).build()
        }
    }

}