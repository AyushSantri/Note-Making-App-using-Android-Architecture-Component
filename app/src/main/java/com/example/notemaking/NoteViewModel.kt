package com.example.notemaking

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<Notes>>
    private val repository : NoteRepository

    init {
        val dao = NoteDatabase.getDatabase(application).getNotes()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    /*this means we are launching a function in viewModelScope i.e in background
    * Dispatcher.IO means we are doing input output operation in that function*/
    fun delete(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(notes)
    }
}