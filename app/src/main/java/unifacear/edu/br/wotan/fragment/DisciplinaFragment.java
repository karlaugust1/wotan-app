package unifacear.edu.br.wotan.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.adapter.DisciplinaListAdapter;
import unifacear.edu.br.wotan.controller.DisciplinaController;
import unifacear.edu.br.wotan.model.Disciplina;

public class DisciplinaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.disciplina_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ListView list = view.findViewById(R.id.disciplinas_list);
        List<Disciplina> disciplinas = new ArrayList<>();
        try {
            disciplinas = new DisciplinaController().execute().get();
            DisciplinaListAdapter adapter = new DisciplinaListAdapter(getActivity(), disciplinas);
            list.setAdapter(adapter);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
