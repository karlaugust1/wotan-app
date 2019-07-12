package unifacear.edu.br.wotan.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.adapter.PerguntasListAdapter;
import unifacear.edu.br.wotan.controller.PerguntaController;
import unifacear.edu.br.wotan.model.Pergunta;

public class PerguntasFragment extends Fragment {

    List<Pergunta> perguntas = new ArrayList<>();
    public static Pergunta pergunta;
    public static Long idDisciplina;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.perguntas_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        pergunta = null;
        PerguntaAlternativasFragment.alternativaSelecionada = null;
        PerguntaDissertativaFragment.resposta = null;

        ListView list = view.findViewById(R.id.perguntas_list);
        try {
            if(idDisciplina != null){
                perguntas = new PerguntaController().execute(idDisciplina).get();
            } else {
                perguntas = new PerguntaController().execute().get();
            }
            PerguntasListAdapter adapter = new PerguntasListAdapter(getActivity(), perguntas);
            list.setAdapter(adapter);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pergunta = perguntas.get(position);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null);

                if(perguntas.get(position).getAlternativas().size() == 0){
                    PerguntaDissertativaFragment fragment = new PerguntaDissertativaFragment();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                } else {
                    PerguntaAlternativasFragment fragment = new PerguntaAlternativasFragment();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                }
                fragmentTransaction.commit();

            }
        });

        idDisciplina = null;
    }
}

