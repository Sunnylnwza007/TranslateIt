package buu.informatics.s59160090.translateit

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    init {
        Log.i("GameViewModel", "GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
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
}