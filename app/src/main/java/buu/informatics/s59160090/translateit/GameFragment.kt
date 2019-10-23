package buu.informatics.s59160090.translateit

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import buu.informatics.s59160090.translateit.databinding.FragmentGameBinding
import kotlin.math.log

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GameFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
            R.layout.fragment_game,container,false)

        binding.game = this
        setQuestion()

        binding.ans1.setOnClickListener {view : View ->
            // view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            if (qIndex <4){
                qIndex++
                checkAns(0)
                binding.invalidateAll()
            }else{
                checkAns(0)
                view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            }

        }
        binding.ans2.setOnClickListener {view : View ->
            // view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            if (qIndex <4){
                qIndex++
                checkAns(1)
                binding.invalidateAll()
            }else{
                checkAns(0)
                view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            }
        }
        binding.ans3.setOnClickListener {view : View ->
            // view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            if (qIndex <4){
                qIndex++
                checkAns(2)
                binding.invalidateAll()
            }else{
                checkAns(0)
                view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            }
        }
        binding.ans4.setOnClickListener {view : View ->
            // view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            if (qIndex <4){
                qIndex++
                checkAns(3)
                binding.invalidateAll()
            }else{
                checkAns(0)
                view.findNavController().navigate(R.id.action_gameFragment_to_endFragment2)
            }
        }
        // Bind this fragment class to the layout


        // Set the onClickListener for the submitButton

        return binding.root
    }

    private fun setQuestion() {
        currentQuestion = questions[qIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
    }

    private fun checkAns(num: Int ){
        if (answers[num] == currentQuestion.answers[0]){
            score+=150
            stringScore = score.toString()
        }

        setQuestion()

    }


}
