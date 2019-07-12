package unifacear.edu.br.wotan.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import unifacear.edu.br.wotan.R;
import unifacear.edu.br.wotan.model.Historico;

public class HistoricoListAdapter extends ArrayAdapter<Historico> {

    private final Activity context;
    private final List<Historico> historicoPerguntas;

    public  HistoricoListAdapter(Activity context, List<Historico> historicoPerguntas) {
        super(context, R.layout.historico_list, historicoPerguntas);

        this.context = context;
        this.historicoPerguntas = historicoPerguntas;

    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.historico_list, null, true);

        TextView textPerguntaHistorico = (TextView) rowView.findViewById(R.id.textPerguntaHistorico);
        TextView textDateHistoricoCriacao = (TextView) rowView.findViewById(R.id.textDateHistoricoCriacao);
        TextView textResposta = (TextView) rowView.findViewById(R.id.textResposta);
        TextView textDateHistoricoRespondida = (TextView) rowView.findViewById(R.id.textDateHistoricoRespondida);
        TextView textResultadoResposta = (TextView) rowView.findViewById(R.id.textResultadoResposta);

        textPerguntaHistorico.setText(historicoPerguntas.get(position).getPergunta());
        textDateHistoricoCriacao.setText(historicoPerguntas.get(position).getDataCriacao());
        textResposta.setText(historicoPerguntas.get(position).getResposta());
        textDateHistoricoRespondida.setText(historicoPerguntas.get(position).getDataResposta());
        if(historicoPerguntas.get(position).getCorreta() == null){
            textResultadoResposta.setText("Em análise");
        } else if(historicoPerguntas.get(position).getCorreta()){
            textResultadoResposta.setText("Correta");
        } else {
            textResultadoResposta.setText("Errada");
        }

        return rowView;

    }
}
