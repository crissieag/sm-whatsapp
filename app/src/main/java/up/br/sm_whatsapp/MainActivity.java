package up.br.sm_whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText inputEditTelefone;
    private TextInputEditText inputEditMensagem;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditTelefone = findViewById(R.id.textInputEditTelefone);
        inputEditMensagem = findViewById(R.id.textInputEditMensagem);
        btnEnviar = findViewById(R.id.btnEnviar);
//criar listener no botão
        // pegar os valores dos input
        // realizar o encode da mensagem do input
        // fazer a intent quando clicar no botão

        View.OnClickListener btnEnviarClick = view -> {
            String inputTelefone = inputEditTelefone.getText().toString();
            String inputMensagem = inputEditMensagem.getText().toString();

            String encodedMensagem = Uri.encode(inputMensagem);
            String linkWhats = String.format("https://wa.me/55%s?text=%s", inputTelefone, encodedMensagem);
            Uri webpage = Uri.parse(linkWhats);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

            startActivity(webIntent);
        };

        btnEnviar.setOnClickListener(btnEnviarClick);
    }

}