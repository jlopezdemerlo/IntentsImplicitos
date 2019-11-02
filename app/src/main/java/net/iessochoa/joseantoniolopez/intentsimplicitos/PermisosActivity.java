package net.iessochoa.joseantoniolopez.intentsimplicitos;

import android.os.Bundle;
import android.provider.CallLog;

import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PermisosActivity extends AppCompatActivity {

    @BindView(R.id.lytPrincipal)
    LinearLayout lytPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permisos);
        ButterKnife.bind(this);

    }

    void borrarLlamada() {
        getContentResolver().delete(CallLog.Calls.CONTENT_URI, "number='555555555'", null);
        Snackbar.make(lytPrincipal, "Llamadas borradas del registro.",
                Snackbar.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnBorrarLlamadas)
    public void onClick() {
        borrarLlamada();
    }
}
