package com.example.notemaking

import androidx.room.*

@Dao
interface NotesDao {

    @Delete
    fun delete(notes : Notes)

    //onConflict = OnConflictStrategy.IGNORE it will not add any repetitive word
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(notes: Notes)

    @Query("SELECT * from notes_table ORDER by id ASC")
    fun getAllNotes() : List<Notes>
}