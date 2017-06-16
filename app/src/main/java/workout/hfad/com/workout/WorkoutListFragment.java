package workout.hfad.com.workout;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

    //Добавляем слушатель
    private WorkoutListListener listener;

    static interface WorkoutListListener {
        void itemClicked(long id);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Создаем массив строк с названием комплексов упражнения

        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }
        //Создаем адаптер массива
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                inflater.getContext(), android.R.layout.simple_list_item_1, names);

        //Связываем адаптер массива с списковым представлением
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //Методо onAttach вызывается при присоединение активности к фрагменту

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //Вызывается при соединение фрагмента с активностю
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (WorkoutListListener) activity;
    }

    //Сообщаем слушателю что на одном из вариантов был щелчок
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}
