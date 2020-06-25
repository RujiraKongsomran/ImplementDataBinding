package com.rujirakongsomran.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rujirakongsomran.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Initialize variable
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Assign variable
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get text from edit text
                String sText = binding.etInput.getText().toString().trim();
                // Check condition
                if (!sText.equals("")) {
                    // When text is not empty
                    // Set text on text view
                    binding.tvOutput.setText(sText);
                } else {
                    // When text is empty
                    // Display toast
                    Toast.makeText(getApplicationContext(),
                            "Please enter text",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        // Initialize fragment
        Fragment fragment = new MainFragment();
        // Commit fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, fragment).commit();

    }
}