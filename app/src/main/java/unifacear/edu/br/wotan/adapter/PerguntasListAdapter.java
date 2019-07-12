package unifacear.edu.br.wotan.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.model.Pergunta;

public class PerguntasListAdapter extends ArrayAdapter<Pergunta> {

    private final Activity context;
    private final List<Pergunta> perguntas;

    public PerguntasListAdapter(Activity context, List<Pergunta> perguntas) {
        super(context, R.layout.perguntas_list, perguntas);

        this.context = context;
        this.perguntas = perguntas;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.perguntas_list, null, true);

        TextView titleText = rowView.findViewById(R.id.title);
        TextView dateText = rowView.findViewById(R.id.textDate);

        titleText.setText(perguntas.get(position).getDescricao());
        dateText.setText("Criado em " + perguntas.get(position).getDataCriacao());

        return rowView;

    }
}

