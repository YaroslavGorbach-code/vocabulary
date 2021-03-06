package yaroslavgorbach.koropapps.vocabulary.feature.exercise.rememberall

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import yaroslavgorbach.koropapps.vocabulary.R
import yaroslavgorbach.koropapps.vocabulary.business.exercise.usecase.GetLettersUseCase
import yaroslavgorbach.koropapps.vocabulary.business.exercise.usecase.GetWordsNounsUseCase
import yaroslavgorbach.koropapps.vocabulary.data.exercise.repo.RepoExerciseImp

class ExerciseRememberAllVm(application: Application) : AndroidViewModel(application) {
    private val text = MutableLiveData<String>()
    private val getLettersUseCase: GetLettersUseCase =
        GetLettersUseCase(RepoExerciseImp(application))

    fun getText(): LiveData<String> {
        return text
    }

    init {
        generateText()
    }

    fun generateText() {
        text.value = getApplication<Application>().applicationContext.getString(
            R.string.remember_all_text,
            getLettersUseCase.invoke().random()
        )
    }
}