package com.example.tp2_labo3_navarro.ui.ui.login;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp2_labo3_navarro.Modelo.Usuario;
import com.example.tp2_labo3_navarro.request.ApiClient;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private ApiClient apiClient;
    private MutableLiveData<Usuario> usuarioM;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        context = application.getApplicationContext();
        apiClient = new ApiClient();


    }

    public LiveData<Usuario> getUsuarioM(){
        if(usuarioM==null){
            usuarioM = new MutableLiveData<>();
        }
        return usuarioM;
    }


    public void loginUsuario(String mail , String clave ){
        Usuario usuario = apiClient.loginUsuario(context,mail,clave);
        if(usuario !=null){
          usuarioM.setValue(usuario);
        }
        else {
            Toast.makeText(context,"Ingrese valores correctos",Toast.LENGTH_LONG).show();
        }


    }
}
