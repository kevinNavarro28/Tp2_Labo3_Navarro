package com.example.tp2_labo3_navarro.ui.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp2_labo3_navarro.Modelo.Usuario;
import com.example.tp2_labo3_navarro.databinding.ActivityMainBinding;
import com.example.tp2_labo3_navarro.ui.ui.Registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        mv.getUsuarioM().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                //putExtra("usuario", usuario)
                intent.putExtra("usuario", usuario);
                startActivity(intent);
                finish();
            }
        });


        binding.BtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.loginUsuario(binding.EtUsuario.getText().toString(),binding.EtClave.getText().toString());

            }
        });

        binding.BtRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

    }
}