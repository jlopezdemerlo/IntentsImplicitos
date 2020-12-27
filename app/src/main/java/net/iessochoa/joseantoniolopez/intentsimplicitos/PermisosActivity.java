package net.iessochoa.joseantoniolopez.intentsimplicitos;

import android.os.Bundle;
import android.provider.CallLog;

import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;


public class PermisosActivity extends AppCompatActivity {


    LinearLayout lytPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);
        lytPrincipal=findViewById(R.id.lytPrincipal);

    }

    void borrarLlamada() {
        getContentResolver().delete(CallLog.Calls.CONTENT_URI, "number='555555555'", null);
        Snackbar.make(lytPrincipal, "Llamadas borradas del registro.",
                Snackbar.LENGTH_SHORT).show();
    }


    public void onClick(View v) {
        borrarLlamada();
    }
}
