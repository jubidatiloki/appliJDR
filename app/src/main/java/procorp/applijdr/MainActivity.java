package procorp.applijdr;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;
import procorp.applijdr.model.FragmentAccueil;
import procorp.applijdr.model.FragmentChoix;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private PersoManager persoManager = new PersoManager(this);

    private Perso perso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //On ouvre la base de données pour écrire dedans
        persoManager.open();
        //Toast.makeText(this, persoManager.getPersoByNom("brigitte").toString(), Toast.LENGTH_SHORT).show();

        //initialisation premier lancement
        if(premierLancement()) {
            Toast.makeText(this, "initialisation", Toast.LENGTH_LONG).show();
            initialisation();
        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if(id == R.id.naw_accueil){
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentAccueil()).commit();
        }else if(id == R.id.nav_layout_perso1) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentChoix()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean premierLancement() {
        if (this.persoManager.nbrePerso() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void initialisation(){
        this.perso = new Perso(persoManager.nbrePerso());
        perso.setNom(perso.getNom()+Integer.toString(perso.getIdPerso()));
        this.persoManager.insertPerso(this.perso);
        Toast.makeText(this, "nbre(1): " + persoManager.nbrePerso(), Toast.LENGTH_LONG).show();

        this.perso = new Perso(persoManager.nbrePerso());
        perso.setNom(perso.getNom()+Integer.toString(perso.getIdPerso()));
        this.persoManager.insertPerso(perso);
        Toast.makeText(this, "nbre(2): " + persoManager.nbrePerso(), Toast.LENGTH_LONG).show();
    }

}
