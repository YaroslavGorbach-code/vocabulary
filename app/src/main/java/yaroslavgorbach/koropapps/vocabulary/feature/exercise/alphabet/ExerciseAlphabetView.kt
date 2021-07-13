package yaroslavgorbach.koropapps.vocabulary.feature.exercise.alphabet

import yaroslavgorbach.koropapps.vocabulary.databinding.FragmentExerciseAlphabetBinding

class ExerciseAlphabetView(
    private val binding: FragmentExerciseAlphabetBinding,
    private val callback: Callback
) {
    interface Callback {
        fun onNewLetter()
    }

    init {
        binding.root.setOnClickListener {
            callback.onNewLetter()
        }
    }

    fun setLetter(letter: String) {
        binding.letter.text = letter
    }

    fun setText(text: String) {
        binding.text.text = text
    }

}