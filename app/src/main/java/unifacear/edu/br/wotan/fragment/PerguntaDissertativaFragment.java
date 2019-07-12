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
import android.widget.EditText;
import android.widget.TextView;

import unifacear.edu.br.wotan.R;

public class PerguntaDissertativaFragment extends Fragment {

    public static String resposta = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pergunta_dissertativa_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView pergunta = view.findViewById(R.id.textPerguntaDissertativas);
        Button btnResponder = view.findViewById(R.id.btnResponderDissertativa);
        final EditText textResposta = view.findViewById(R.id.textRespostaDissertativa);

        pergunta.setText(PerguntasFragment.pergunta.getDescricao());


        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resposta = textResposta.getText().toString();

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
