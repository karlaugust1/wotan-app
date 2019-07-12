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
import android.widget.ImageView;
import android.widget.TextView;

import unifacear.edu.br.wotan.MainActivity;
import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.controller.HistoricoPerguntaController;
import unifacear.edu.br.wotan.model.HistoricoPergunta;

import static unifacear.edu.br.wotan.fragment.PerguntaAlternativasFragment.alternativaSelecionada;

public class ResultadoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.resposta_resultado_fragment, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {

        HistoricoPergunta historicoPergunta = new HistoricoPergunta();
        historicoPergunta.setEstudante(MainActivity.estudante.getId());
        historicoPergunta.setPergunta(PerguntasFragment.pergunta.getId());

        ImageView imageCorreta = view.findViewById(R.id.imageCorreta);
        ImageView imageErrada = view.findViewById(R.id.imageErrada);
        ImageView imageAnalise = view.findViewById(R.id.imageAnalise);

        TextView textResultado = view.findViewById(R.id.textResultado);

        imageCorreta.setVisibility(View.INVISIBLE);
        imageErrada.setVisibility(View.INVISIBLE);
        imageAnalise.setVisibility(View.INVISIBLE);

        if (alternativaSelecionada == null) {
            imageAnalise.setVisibility(View.VISIBLE);
            historicoPergunta.setResposta(PerguntaDissertativaFragment.resposta);
            textResultado.setText("Resposta em análise, aguarde");
        } else if (alternativaSelecionada.getCorreta()) {
            historicoPergunta.setAcertou(alternativaSelecionada.getCorreta());
            historicoPergunta.setAlternativa(alternativaSelecionada.getId());
            imageCorreta.setVisibility(View.VISIBLE);
            textResultado.setText("Parabéns! Você acertou!");
        } else {
            historicoPergunta.setAcertou(alternativaSelecionada.getCorreta());
            historicoPergunta.setAlternativa(alternativaSelecionada.getId());
            imageErrada.setVisibility(View.VISIBLE);
            textResultado.setText("Que pena! Você errou!");
        }

        Button btnVoltar = view.findViewById(R.id.buttonVoltarMenu);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PerguntasFragment fragment = new PerguntasFragment();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        new HistoricoPerguntaController().save(historicoPergunta);

    }


}