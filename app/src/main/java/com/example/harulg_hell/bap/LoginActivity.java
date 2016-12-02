package com.example.harulg_hell.bap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.harulg_hell.bap.util.SFCallback;
import com.example.harulg_hell.bap.util.userDTO;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginActivity extends Activity implements View.OnClickListener {

    public void toast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void setContentView(int layoutResID) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(layoutResID);
    }

    private Button _login;
    private EditText _id, _pw;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_signin:
                signIn();
                break;
            default:
                break;
        }
    }

    public void signIn() {
        _id.setError(null);
        _pw.setError(null);
        if (_id.getText().length() != 10) {
            _id.setError("유효한 정보를 입력하세요");
            return;
        }
        if (_pw.getText().length() < 5) {
            _pw.setError("유효한 패스워드를 입력하세요");
            return;
        }
        final ProgressDialog pdial = new ProgressDialog(this, R.style.AppTheme_Dark_Dialog);
        pdial.setMessage("계정 정보를 불러오는 중...");
        pdial.setCancelable(false);
        pdial.show();
        _login.setEnabled(false);
        LoadActivity.session = new userDTO(new SFCallback() {
            public void callback() {
                pdial.dismiss();
                _login.setEnabled(true);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }, new SFCallback() {
            public void callback() {
                pdial.dismiss();
                _login.setEnabled(true);
                toast("인터넷에 연결할 수 없습니다.");
            }
        }, new SFCallback() {
            public void callback() {
                pdial.dismiss();
                _login.setEnabled(true);
                toast("로그인을 실패하였습니다.");
            }
        }, _id.getText().toString(), _pw.getText().toString());
        LoadActivity.session.execute();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _login = (Button) findViewById(R.id.bt_signin);
        _id = (EditText) findViewById(R.id.idp);
        _pw = (EditText) findViewById(R.id.pwp);
        _login.setOnClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Login Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}