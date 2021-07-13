package yaroslavgorbach.koropapps.vocabulary.feature.exercise.alphabet

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import yaroslavgorbach.koropapps.vocabulary.R
import yaroslavgorbach.koropapps.vocabulary.business.exercise.usecase.GetLettersUseCase
import yaroslavgorbach.koropapps.vocabulary.data.exercise.repo.RepoExerciseImp
import yaroslavgorbach.koropapps.vocabulary.data.exercises.local.model.ExerciseName

class ExerciseAlphabetVm(application: Application) : AndroidViewModel(application) {
    private val letters = MutableLiveData(GetLettersUseCase(RepoExerciseImp(application)).invoke())
    private val currentLetter = MutableLiveData<String>()

    fun getLetter(): LiveData<String> {
        return currentLetter
    }

    init {
        setNewLetter()
    }

    fun getText(exerciseName: ExerciseName): String {
        return when (exerciseName) {
            ExerciseName.ALPHABET_ADJECTIVES -> {
                getApplication<Application>().getString(R.string.alphabet_a_text)
            }
            ExerciseName.ALPHABET_NOUN -> {
                getApplication<Application>().getString(R.string.alphabet_n_text)
            }
            ExerciseName.ALPHABET_VERBS -> {
                getApplication<Application>().getString(R.string.alphabet_v_text)
            }
            else -> ""
        }
    }

    fun setNewLetter() {
        currentLetter.value = letters.value?.first()
            .also { letter -> letters.value = letters.value?.filter { it != letter } }
    }
}