package com.example.kamrancv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction ft;
    ActionBarDrawerToggle toggle;
    NavigationView nav;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav = findViewById(R.id.navigationview);
        drawerLayout = findViewById(R.id.drawerlayout);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();
        //nav.setCheckedItem(R.id.home);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new HomeFragment());
                        ft.commit();
                        break;
                    case R.id.contact:
                        Toast.makeText(MainActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new ContactFragment());
                        ft.commit();
                        break;
                    case R.id.education:
                        Toast.makeText(MainActivity.this, "Education", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new EducationFragment());
                        ft.commit();
                        break;
                    case R.id.pl:
                        Toast.makeText(MainActivity.this, "Programming Language", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new ProgrammingLangFragment());
                        ft.commit();
                        break;
                    case R.id.db:
                        Toast.makeText(MainActivity.this, "Database", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new DatabaseFragment());
                        ft.commit();
                        break;
                    case R.id.skills:
                        Toast.makeText(MainActivity.this, "Skills", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new SkillsFragment());
                        ft.commit();
                        break;
                    case R.id.certificate:
                        Toast.makeText(MainActivity.this, "Certificate", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new CertificateFragment());
                        ft.commit();
                        break;
                    case R.id.experience:
                        Toast.makeText(MainActivity.this, "Experience", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new ExperienceFragment());
                        ft.commit();
                        break;
                    case R.id.share:
                        Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.container,new ShareFragment());
                        ft.commit();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;



            }
        });

    }
}