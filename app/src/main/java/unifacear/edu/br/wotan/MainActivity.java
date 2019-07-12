package unifacear.edu.br.wotan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import unifacear.edu.br.wotan.fragment.ContentMainFragment;
import unifacear.edu.br.wotan.fragment.DisciplinaFragment;
import unifacear.edu.br.wotan.fragment.HistoricoFragment;
import unifacear.edu.br.wotan.fragment.PerguntasFragment;
import unifacear.edu.br.wotan.model.Estudante;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String ROOT_URL = "http://192.168.43.238:27015/wotan/api/v1/";

    public static Estudante estudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Acessar o header do drawer menu e settar o nome
        View headerView = navigationView.getHeaderView(0);
        TextView textUserLoggedInName = headerView.findViewById(R.id.textUserLoggedInName);
        TextView textUserLoggedInMatricula = headerView.findViewById(R.id.textUserLoggedInMatricula);
        textUserLoggedInName.setText(estudante.getNome());
        textUserLoggedInMatricula.setText(estudante.getMatricula());

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ContentMainFragment()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            MainActivity.estudante = null;
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if( id == R.id.nav_home){
            ContentMainFragment fragment = new ContentMainFragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_perguntas) {
            PerguntasFragment fragment = new PerguntasFragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_disciplinas) {
            DisciplinaFragment fragment = new DisciplinaFragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_historico) {
            HistoricoFragment fragment = new HistoricoFragment();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
