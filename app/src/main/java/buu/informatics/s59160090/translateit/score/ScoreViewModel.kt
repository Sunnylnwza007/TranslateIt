package buu.informatics.s59160090.translateit.score

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import buu.informatics.s59160090.translateit.database.User
import buu.informatics.s59160090.translateit.database.UserDAO
import buu.informatics.s59160090.translateit.formatUser
import kotlinx.coroutines.*

class ScoreViewModel(
    val database: UserDAO,
    application: Application
) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var score = 0
    var nameDb : ArrayList<String> = ArrayList()
    var scoreDb : ArrayList<Int> = ArrayList()
    var userList = database.getAll()
    var nameui: String = ""
    var scoreui:String = ""
    val userString = Transformations.map(userList) { nights ->
        formatUser(nights, application.resources)
    }
//    fun setScoreborad(){
//        Log.i("database2", "wow")
//        var i = 0
//        while (i < nameDb.size){
//            nameui = "$nameui\n $i ${nameDb[i]}"
//        }
//        Log.i("database2", "$nameui 55555")
//        var j = 0
//        while (j < scoreDb.size){
//            scoreui = "$scoreui\n ${scoreDb[j]}"
//            j++
//        }
//    }
    fun setScore(){
//    var i = 0
//    while (i < user1.size){
//        //nameDb.add(user1.get(i)!!.name)
//        nameui = "$nameui\n ${i+1} ${user1.get(i)!!.name} "
//
//        //scoreDb.add(user1.get(i)!!.score)
//        scoreui = "$scoreui\n ${user1.get(i)!!.score}"
//        i++
//    }
//        var i =0
//        while (i< userList.value!!.size){
//
//        }
    }
    var finalScore = ""
    init {
        Log.i("ScoreViewModel", "ScoreViewModel created!")
        initializeUser()
        setScore()
        Log.i("ScoreViewModel", "$nameui 555")

    }
     fun initializeUser() {
        uiScope.launch {

            var user1 = getUser()


        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ScoreViewModel", "GameViewModel destroyed!")
        viewModelJob.cancel()
    }

    private suspend fun getUser(): List<User?> {
        return withContext(Dispatchers.IO) {
            var user1 = database.get1()
            user1
        }
    }





}