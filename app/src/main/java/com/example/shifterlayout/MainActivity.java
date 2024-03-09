package com.example.shifterlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.shifterlayout.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnEnableKeyboard.setEnabled(!isKeyboardEnabled());

        binding.btnEnableKeyboard.setOnClickListener(view -> {
            if (!isKeyboardEnabled())
                openKeyboardSettings();
        });

        binding.btnChooseKeyboard.setOnClickListener(view -> {
            if (isKeyboardEnabled()) {
                openKeyboardChooserSettings();
            } else {
                Toast.makeText(MainActivity.this, "Choose the keyboard activation button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openKeyboardSettings() {
        Intent intent = new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS);
        startActivity(intent);
    }

    // Function to check if a specific keyboard is enabled
    private boolean isKeyboardEnabled() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        List<String> enabledInputMethodIds = new ArrayList<>();
        for (InputMethodInfo inputMethodInfo : inputMethodManager.getEnabledInputMethodList()) {
            enabledInputMethodIds.add(inputMethodInfo.getId());
        }
        return enabledInputMethodIds.contains("com.example.shifterlayout/.MyKeyboard");
    }

    // Function to open the keyboard settings to choose a keyboard
    private void openKeyboardChooserSettings() {
        InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        im.showInputMethodPicker();
    }
}
