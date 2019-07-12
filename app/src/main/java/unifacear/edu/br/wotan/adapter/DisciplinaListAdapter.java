package unifacear.edu.br.wotan.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.fragment.PerguntasFragment;
import unifacear.edu.br.wotan.model.Disciplina;

public class DisciplinaListAdapter extends ArrayAdapter<Disciplina> {

    private final Activity context;
    private final List<Disciplina> disciplinas;

    public DisciplinaListAdapter(Activity context, List<Disciplina> disciplinas) {
        super(context, R.layout.disciplinas_list, disciplinas);

        this.context = context;
        this.disciplinas = disciplinas;

    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.disciplinas_list, null, true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        LinearLayout btnDisciplina = rowView.findViewById(R.id.btnDisciplina);

        titleText.setText(disciplinas.get(position).getDescricao());

        btnDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PerguntasFragment.idDisciplina = disciplinas.get(position).getId();

                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PerguntasFragment fragment = new PerguntasFragment();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        return rowView;

    }
}
