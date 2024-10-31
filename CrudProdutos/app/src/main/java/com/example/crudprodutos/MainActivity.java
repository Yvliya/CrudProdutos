package com.example.crudprodutos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button btnCadastrar, btnDeletar, btnBuscar, btnAlterar;
    private EditText etProductValue, etProductCode;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnDeletar = findViewById(R.id.btnDeletar);
        btnBuscar = findViewById(R.id.btnBuscar);
        btnAlterar = findViewById(R.id.btnAlterar);
        etProductCode = findViewById(R.id.etProductCode);
        etProductValue = findViewById(R.id.etProductValue);

        btnCadastrar.setOnClickListener(view -> {
            String code = etProductCode.getText().toString();
            String value = etProductValue.getText().toString();

            if (!code.isEmpty() && !value.isEmpty()) {
                try {
                    Map<String, Object> product = new HashMap<>();
                    product.put("code", Integer.parseInt(code));
                    product.put("value", Double.parseDouble(value));

                    db.collection("produtos").document(code)
                            .set(product)
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(MainActivity.this, "Produto cadastrado", Toast.LENGTH_SHORT).show();
                                // Limpa os campos após o cadastro
                                etProductCode.setText("");
                                etProductValue.setText("");
                            })
                            .addOnFailureListener(e ->
                                    Toast.makeText(MainActivity.this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show());
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Valores inválidos", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });


        btnBuscar.setOnClickListener(view -> {
            String code = etProductCode.getText().toString();

            if (!code.isEmpty()) {
                db.collection("produtos").document(code)
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                Double value = documentSnapshot.getDouble("value");
                                etProductValue.setText(value != null ? String.valueOf(value) : "");
                                Toast.makeText(MainActivity.this, "Produto encontrado", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Produto não encontrado", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(e ->
                                Toast.makeText(MainActivity.this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(MainActivity.this, "Informe o código do produto", Toast.LENGTH_SHORT).show();
            }
        });

        btnAlterar.setOnClickListener(v -> {
            String code = etProductCode.getText().toString();
            String newValue = etProductValue.getText().toString();

            if (!code.isEmpty() && !newValue.isEmpty()) {
                try {
                    db.collection("produtos").document(code)
                            .update("value", Double.parseDouble(newValue))
                            .addOnSuccessListener(aVoid -> Toast.makeText(this, "Produto atualizado", Toast.LENGTH_SHORT).show())
                            .addOnFailureListener(e -> Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show());
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Valor inválido", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            }
        });

        btnDeletar.setOnClickListener(v -> {
            String code = etProductCode.getText().toString();

            if (!code.isEmpty()) {
                db.collection("produtos").document(code)
                        .delete()
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(this, "Produto deletado", Toast.LENGTH_SHORT).show();
                            // Limpa os campos após a exclusão
                            etProductCode.setText("");
                            etProductValue.setText("");
                        })
                        .addOnFailureListener(e ->
                                Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            } else {
                Toast.makeText(this, "Informe o código do produto", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
