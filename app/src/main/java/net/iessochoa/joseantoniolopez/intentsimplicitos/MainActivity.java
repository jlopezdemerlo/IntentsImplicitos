package net.iessochoa.joseantoniolopez.intentsimplicitos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnWeb, R.id.btnTelefono, R.id.btnMaps, R.id.btnFoto, R.id.btnCorreo,R.id.btnPermisos})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnWeb:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://iesseveroochoa.edu.gva.es/"));
                startActivity(intent);
                break;
            case R.id.btnTelefono:
                intent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:966912260"));
                //Aunque le hemos dado permiso en el AndroidManifest, nos marca en rojo porque Android 6 nos obliga a solicitar los permisos al usuario
                startActivity(intent);
                break;
            case R.id.btnMaps:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:38.278855,-0.716400?22"));
                startActivity(intent);
                break;
            case R.id.btnFoto:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
                break;
            case R.id.btnCorreo:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "asunto");
                intent.putExtra(Intent.EXTRA_TEXT, "texto del correo");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"email"});
                startActivity(intent);
                break;
            case R.id.btnPermisos:
                intent=new Intent(this,PermisosActivity.class);
                startActivity(intent);
                break;

        }
    }

}
