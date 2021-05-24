package com.example.fiopreto.data.local

import androidx.room.*

@Dao
interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createPost(postsLocal: PostsLocal)

    @Query("SELECT * FROM posts_table WHERE id = :idPost")
    suspend fun getPostById(idPost: Int) : List<PostsLocal>

    @Update
    suspend fun updatePost(postsLocal: PostsLocal)

    @Delete
    suspend fun deletePost(headersLocal: HeadersLocal)
}