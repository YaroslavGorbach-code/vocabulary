package yaroslavgorbach.koropapps.vocabulary.feature.exercise.alphabet

import yaroslavgorbach.koropapps.vocabulary.databinding.FragmentExerciseAlphabetBinding

class ExerciseAlphabetView(
    private val binding: FragmentExerciseAlphabetBinding,
    private val callback: Callback
) {
    interface Callback {
        fun onNewLetter()
        fun onTimeEnd()
        fun onGameEnd()
    }

    init {
        binding.root.setOnClickListener {
            callback.onNewLetter()
        }
    }

    fun setLetter(letter: String?) {
        if (letter!=null){
            binding.letterProgress.setLetter(letter)
        }else{
            callback.onGameEnd()
        }
    }

    fun descriptionText(text: String) {
        binding.description.text = text
    }

    fun setProgress(progress: Int) {
        if (progress == 100) {
            callback.onTimeEnd()
        }
        binding.letterProgress.setProgress(progress)
    }
}