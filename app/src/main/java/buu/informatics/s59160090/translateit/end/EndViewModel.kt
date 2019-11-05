package buu.informatics.s59160090.translateit.end

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import buu.informatics.s59160090.translateit.database.User
import buu.informatics.s59160090.translateit.database.UserDAO
import kotlinx.coroutines.*

class EndViewModel(
    val database: UserDAO,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var score = 0
    var finalScore = ""
    var name = ""
    init {
        Log.i("EndViewModel", "GameViewModel created!")
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("EndViewModel", "GameViewModel destroyed!")
        viewModelJob.cancel()
    }

    fun callInsert(user: User){
        uiScope.launch {
            insert(user)
        }

    }
    suspend fun insert(user: User) {
        withContext(Dispatchers.IO) {
            database.insert(user)
        }

    }
}



