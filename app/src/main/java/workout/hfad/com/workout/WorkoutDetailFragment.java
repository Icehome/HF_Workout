package workout.hfad.com.workout;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Задаем значение workoutId

        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
        }

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);

    }

    //Сохраняем значение workoutId в объекте saveInstanceStateтипа Bundle перед уничтожением фрагмента.
    //Позднее сохраненное значение читается в onCreateView().
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putLong("workoutId", workoutId);
    }

    @Override
    public void onStart() {
        super.onStart();

        //Метод getView() получаєт корневой объект View фрагмента. Далее полученный фрагмент
        //используется для получения ссылок на надписи, предназначены для названия и описания
        //комплекса упражнений

        View view = getView();
        if (view != null) {

            Workout workout = Workout.workouts[(int) workoutId];

            TextView title = (TextView) view.findViewById(R.id.textTitle);
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());

        }
    }

    public void setWorkout(long id) {
        this.workoutId = id;
    }


}
