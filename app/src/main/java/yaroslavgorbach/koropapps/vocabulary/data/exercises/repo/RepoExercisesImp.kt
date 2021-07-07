package yaroslavgorbach.koropapps.vocabulary.data.exercises.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import yaroslavgorbach.koropapps.vocabulary.R
import yaroslavgorbach.koropapps.vocabulary.business.exercises.repo.RepoExercises
import yaroslavgorbach.koropapps.vocabulary.data.exercises.local.model.Exercise
import yaroslavgorbach.koropapps.vocabulary.data.exercises.local.model.ExerciseName

class RepoExercisesImp : RepoExercises {
    private val exercises: MutableStateFlow<List<Exercise>> = MutableStateFlow(emptyList())

    init {
        exercises.value = listOf(
            Exercise(ExerciseName.ALPHABET, R.drawable.ic_test),
            Exercise(ExerciseName.MONOPHONIC, R.drawable.ic_test),
            Exercise(ExerciseName.NOUN, R.drawable.ic_test),
            Exercise(ExerciseName.VERBS, R.drawable.ic_test),
            Exercise(ExerciseName.ANTONYMS_AND_SYNONYMS, R.drawable.ic_test),
            Exercise(ExerciseName.TEN, R.drawable.ic_test),
            Exercise(ExerciseName.ASSOCIATIONS, R.drawable.ic_test),
            Exercise(ExerciseName.REMEMBER_ALL, R.drawable.ic_test),
            Exercise(ExerciseName.LISTS, R.drawable.ic_test),
            Exercise(ExerciseName.ADJECTIVES, R.drawable.ic_test)
        )
    }

    override suspend fun getExercises(): Flow<List<Exercise>> {
        return exercises
    }
}