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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.adapter.AlternativasListAdapter;
import unifacear.edu.br.wotan.model.Alternativa;

public class PerguntaAlternativasFragment extends Fragment {

    public static int position;
    public static Alternativa alternativaSelecionada;
    List<Alternativa> alternativas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pergunta_alternativas_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        position = 0;

        ListView list = view.findViewById(R.id.alternativas_list);
        TextView pergunta = view.findViewById(R.id.textPerguntaAlternativas);
        Button btnResponder = view.findViewById(R.id.btnResponder);

        pergunta.setText(PerguntasFragment.pergunta.getDescricao());
        alternativas = PerguntasFragment.pergunta.getAlternativas();

        AlternativasListAdapter adapter = new AlternativasListAdapter(getActivity(), alternativas);
        list.setAdapter(adapter);

        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alternativaSelecionada = alternativas.get(position);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ResultadoFragment fragment = new ResultadoFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

}
