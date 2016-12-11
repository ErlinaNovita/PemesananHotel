package id.sch.smktelkom_mlg.learn.pemesananhotel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Button bOK;
    TextView tvHasil;
    RadioButton rbGold, rbSilver;
    Spinner spService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbGold = (RadioButton) findViewById(R.id.radioButtonGold);
        rbSilver = (RadioButton) findViewById(R.id.radioButtonSilver);

        spService = (Spinner) findViewById(R.id.spinnerService);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bOK = (Button) findViewById(R.id.buttonOK);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });
        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });
    }

    private void doProcess() {

        String hasil = null;
        if (rbGold.isChecked()) {
            hasil = rbGold.getText().toString();
        } else if (rbSilver.isChecked()) {
            hasil = rbSilver.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Belum memilih status");
        }

        if (isValid()) {
            String nama = etNama.getText().toString();
            tvHasil.setText("saya atas nama " + nama + " memesan paket " + hasil + " dengan tambahan service " + spService.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 5) {
            etNama.setError("Nama minimal 5 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }
}
