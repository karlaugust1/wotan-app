package unifacear.edu.br.wotan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import unifacear.edu.br.wotan.controller.UsuarioController;
import unifacear.edu.br.wotan.model.Estudante;

public class LoginActivity extends AppCompatActivity {

    private EditText txtMatricula;
    private EditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtMatricula = findViewById(R.id.textUserLoggedInMatricula);
        txtPassword = findViewById(R.id.textSenha);

        txtMatricula.requestFocus();
        txtMatricula.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager keyboard = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                keyboard.showSoftInput(txtMatricula, 0);
            }
        }, 200);

        if (android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public void login(View view) {

        InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        String txtError = "";

        if (txtMatricula.getText().toString().isEmpty()) {
            txtError = "Matrícula não informada, por favor insira uma matrícula!";
        } else if (txtPassword.getText().toString().isEmpty()){
            txtError = "Senha não informada, por favor insira uma senha!";
        }

        if(!txtError.isEmpty()){
            Snackbar snackbar = Snackbar.make(view, txtError, Snackbar.LENGTH_LONG).setAction("Action", null);
            View sbView = snackbar.getView();
            sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
            snackbar.show();
        }

        Estudante estudante = new UsuarioController().login(new Estudante(txtMatricula.getText().toString(), txtPassword.getText().toString()));
//        Estudante estudante = new Estudante(1L, "2017000450", 1L, "Karl", "666");
        if(estudante == null){
            Snackbar snackbar = Snackbar.make(view, "Matrícula ou senha incorretas, por favor verifique e tente novamente!", Snackbar.LENGTH_LONG).setAction("Action", null);
            View sbView = snackbar.getView();
            sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
            snackbar.show();
        } else {
            MainActivity.estudante = estudante;
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
