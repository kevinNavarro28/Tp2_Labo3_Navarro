package com.example.tp2_labo3_navarro.ui.ui.Registro;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp2_labo3_navarro.Modelo.Usuario;
import com.example.tp2_labo3_navarro.databinding.ActivityRegistroBinding;
import com.example.tp2_labo3_navarro.ui.ui.login.MainActivityViewModel;

public class RegistroActivity extends AppCompatActivity {

    private ActivityRegistroBinding binding;

    private RegistroActivityViewModel mv;


    private MainActivityViewModel main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroActivityViewModel.class);
        main = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);




        binding.BtRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.registrarUsuario(binding.EtNombre.getText().toString(),binding.EtApellido.getText().toString(),binding.EtDni.getText().toString(),binding.EtMail.getText().toString(),binding.Etclave.getText().toString());
            }
        });

        mv.getUsuarioM().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.EtNombre.setText(usuario.getNombre());
                binding.EtApellido.setText(usuario.getApellido());
                binding.EtDni.setText(String.valueOf(usuario.getDni()));
                binding.EtMail.setText(usuario.getMail());
                binding.Etclave.setText(usuario.getClave());
            }
        });

        mv.leerUsuario();



    }
}