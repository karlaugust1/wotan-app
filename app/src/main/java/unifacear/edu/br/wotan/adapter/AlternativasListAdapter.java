package unifacear.edu.br.wotan.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.fragment.PerguntaAlternativasFragment;
import unifacear.edu.br.wotan.model.Alternativa;

public class AlternativasListAdapter extends ArrayAdapter<Alternativa> {

    private final Activity context;
    private final List<Alternativa> alternativas;

    public AlternativasListAdapter(Activity context, List<Alternativa> alternativas) {
        super(context, R.layout.alternativas_pergunta_responder, alternativas);

        this.context = context;
        this.alternativas = alternativas;

    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.alternativas_pergunta_responder, null, true);

        TextView titleText = rowView.findViewById(R.id.textAlternativa);

        titleText.setText(alternativas.get(position).getDescricao());

        CheckBox checkBox = rowView.findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerguntaAlternativasFragment.position = position;
            }
        });

        return rowView;

    }
}