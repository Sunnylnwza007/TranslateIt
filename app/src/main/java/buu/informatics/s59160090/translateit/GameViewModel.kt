package buu.informatics.s59160090.translateit

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    companion object {

        // Time when the game is over
        private const val DONE = 0L

        // Countdown time interval
        private const val ONE_SECOND = 1000L

        // Total time for the game
        private const val COUNTDOWN_TIME = 30000L

    }


    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    private val timer: CountDownTimer
    // The current word
    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish


    init {
        Log.i("GameViewModel", "GameViewModel created!")
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {

            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished/ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                onGameFinish()
            }
        }

        timer.start()
    }


    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
        timer.cancel()
    }
    data class Question(
        val text: String,
        val answers: List<String>)

    // The first answer is the correct one.  We randomize the answers before showing the text.
    // All questions must have four answers.  We'd want these to contain references to string
    // resources so we could internationalize. (Or better yet, don't define the questions in code...)
    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "President",
            answers = listOf("นายก", "ประยุทธ", "ประวิตร", "ทักษิณ")),
        Question(text = "Gunner",
            answers = listOf("มือปืน", "เสี่ย", "เปรมชัย", "แชร์คาล")),
        Question(text = "Girlfriend",
            answers = listOf("แฟน", "ความรัก", "ชู้รัก", "เมียน้อย")),
        Question(text = "Wife",
            answers = listOf("ภรรยา", "สามี", "เจ้าบ่าว", "เมียน้อย")),
        Question(text = "Notebook",
            answers = listOf("สมุดบันทึก", "คอมพิวเตอร์", "โทรศัพท์", "ปากกา"))
    )

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    var qIndex = 0
    var score = 0
    var stringScore = "0"
    var time = 30
    var stringTime = time.toString()

    fun setQuestion() {
        currentQuestion = questions[qIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }

    fun checkAns(num: Int ){

        if (answers[num] == currentQuestion.answers[0]){
            score+=150
            stringScore = score.toString()
        }
        qIndex++
        if (qIndex<=4){
            setQuestion()
        }
    }

    fun onGameFinish() {
        _eventGameFinish.value = true
    }
    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

}