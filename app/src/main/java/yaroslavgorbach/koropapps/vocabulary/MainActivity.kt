package yaroslavgorbach.koropapps.vocabulary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import kotlinx.coroutines.FlowPreview
import yaroslavgorbach.koropapps.vocabulary.data.exercises.local.model.Exercise
import yaroslavgorbach.koropapps.vocabulary.data.exercises.local.model.ExerciseName
import yaroslavgorbach.koropapps.vocabulary.feature.description.ui.DescriptionFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.alphabet.ExerciseAlphabetFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.antonimssininims.ExerciseAntonymsSynonymsFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.associations.ExerciseAssociationsFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.game.ExerciseGameFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.jar.ExerciseJarFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.narrator.ExerciseNarratorFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.rememberall.ExerciseRememberAllFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.tautograms.ExerciseTautogramsFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercise.ten.ExerciseTenFragment
import yaroslavgorbach.koropapps.vocabulary.feature.exercises.ui.ExercisesListFragment

@FlowPreview
class MainActivity : AppCompatActivity(R.layout.activity_main), ExercisesListFragment.Router,
    DescriptionFragment.Router {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val fragment = ExercisesListFragment()
            supportFragmentManager.commit {
                add(R.id.main_container, fragment)
                setPrimaryNavigationFragment(fragment)
            }
        }
    }

    override fun openDescription(exercise: Exercise) {
        val fragment = DescriptionFragment.getInstance(exercise.name)
        supportFragmentManager.commit {
            replace(R.id.main_container, fragment)
            addToBackStack(null)
        }
    }

    override fun openExercise(exerciseName: ExerciseName) {
        var fragment: Fragment = DescriptionFragment.getInstance(exerciseName)
        when (exerciseName) {
            ExerciseName.ALPHABET_ADJECTIVES -> {
                fragment = ExerciseAlphabetFragment.getInstance(exerciseName)
            }
            ExerciseName.ALPHABET_NOUN -> {
                fragment = ExerciseAlphabetFragment.getInstance(exerciseName)
            }
            ExerciseName.ALPHABET_VERBS -> {
                fragment = ExerciseAlphabetFragment.getInstance(exerciseName)
            }
            ExerciseName.TAUTOGRAMS -> {
                fragment = ExerciseTautogramsFragment()
            }
            ExerciseName.NARRATOR_ADJECTIVES -> {
                fragment = ExerciseNarratorFragment.getInstance(exerciseName)
            }
            ExerciseName.NARRATOR_NOUN -> {
                fragment = ExerciseNarratorFragment.getInstance(exerciseName)
            }
            ExerciseName.NARRATOR_VERBS -> {
                fragment = ExerciseNarratorFragment.getInstance(exerciseName)
            }
            ExerciseName.ANTONYMS_AND_SYNONYMS -> {
                fragment = ExerciseAntonymsSynonymsFragment()
            }
            ExerciseName.TEN -> {
                fragment = ExerciseTenFragment()
            }
            ExerciseName.ASSOCIATIONS -> {
                fragment = ExerciseAssociationsFragment()
            }
            ExerciseName.REMEMBER_ALL -> {
                fragment = ExerciseRememberAllFragment()
            }
            ExerciseName.GAME_I_KNOW_5_NAMES -> {
                fragment = ExerciseGameFragment()
            }
            ExerciseName.THREE_LITER_JAR -> {
                fragment = ExerciseJarFragment()
            }
        }
        supportFragmentManager.commit {
            replace(R.id.main_container, fragment)
            addToBackStack(null)
        }
    }
}