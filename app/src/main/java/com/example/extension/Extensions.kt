package com.example.extension

import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@OptIn(ExperimentalCoroutinesApi::class)
fun SearchView.searchListener(): Flow<String> = callbackFlow {
    val listener = object : OnQueryTextListener {
        override fun onQueryTextSubmit(p0: String?): Boolean {
                trySendBlocking(p0!!)
                    .onFailure { throwable -> Firebase.crashlytics.log(throwable!!.message!!) }
            return true
        }
        override fun onQueryTextChange(p0: String?): Boolean = false

    }
    setOnQueryTextListener(listener)
}

@OptIn(ExperimentalCoroutinesApi::class)
fun RecyclerView.scrollListener() : Flow<Boolean> = callbackFlow {
    val listener = object  :  RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (!recyclerView.canScrollVertically(1))
                trySendBlocking(true)
                    .onFailure { throwable -> Firebase.crashlytics.log(throwable!!.message!!) }
        }
    }
}