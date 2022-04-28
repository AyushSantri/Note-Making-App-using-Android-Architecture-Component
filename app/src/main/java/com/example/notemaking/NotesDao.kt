package com.example.notemaking

import androidx.room.*

@Dao
interface NotesDao {

    @Delete
    suspend fun delete(notes : Notes)

    //onConflict = OnConflictStrategy.IGNORE it will not add any repetitive word
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(notes: Notes)

    @Query("SELECT * from notes_table ORDER by id ASC")
    fun getAllNotes() : List<Notes>
}



/*suspend means that particular function will be called from background thread or suspend function
* the main reason to do this was to not include it in our main thread
* as insert and delete operations are heavy and if we include it in our main thread, it will make our app laggy*/