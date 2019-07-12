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

import unifacear.edu.br.wotan.MainActivity;
import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.adapter.HistoricoListAdapter;
import unifacear.edu.br.wotan.controller.HistoricoController;
import unifacear.edu.br.wotan.model.Historico;

public class HistoricoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.historico_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ListView list = view.findViewById(R.id.historico_list);
        List<Historico> historicoPerguntas = new ArrayList<>();
        try {
            historicoPerguntas = new HistoricoController().execute(MainActivity.estudante.getId()).get();
            HistoricoListAdapter adapter = new HistoricoListAdapter(getActivity(), historicoPerguntas);
            list.setAdapter(adapter);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
