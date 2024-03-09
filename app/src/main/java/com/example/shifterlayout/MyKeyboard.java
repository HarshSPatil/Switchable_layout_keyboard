package com.example.shifterlayout;

import android.inputmethodservice.InputMethodService;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.shifterlayout.databinding.KeyboardLayoutBinding;

public class MyKeyboard extends InputMethodService {
    private KeyboardLayoutBinding binding; // Declare binding variable

    @Override
    public View onCreateInputView() {
        binding = KeyboardLayoutBinding.inflate(LayoutInflater.from(this));
        View rootView = binding.getRoot();

        // Access viewFlipperLanguage, viewFlipperSymbols, and viewFlipperRareSymbols using binding
        ViewFlipper viewFlipperLanguage = binding.viewFlipperLanguage;
        ViewFlipper viewFlipperSymbols = binding.viewFlipperSymbols;
        ViewFlipper viewFlipperRareSymbols = binding.viewFlipperRareSymbols;

        // Access switchLanguage button inside viewFlipperLanguage using binding
        // Access switchLanguage button inside viewFlipperLanguage using binding
        ImageButton switchLanguage1 = binding.viewFlipperLanguage.findViewById(R.id.switchLanguage1);
        ImageButton switchLanguage2 = binding.viewFlipperLanguage.findViewById(R.id.switchLanguage2);
        Button switchToSymbols1 = binding.viewFlipperSymbols.findViewById(R.id.switchToSymbols1);
        Button switchToSymbols2 = binding.viewFlipperSymbols.findViewById(R.id.switchToSymbols2);
        Button switchToSymbols3 = binding.viewFlipperSymbols.findViewById(R.id.switchToSymbols3);
        Button switchToRareSymbols1 = binding.viewFlipperRareSymbols.findViewById(R.id.switchToRareSymbols1);
        Button switchToRareSymbols2 = binding.viewFlipperRareSymbols.findViewById(R.id.switchToRareSymbols2);


        // Set click listener for switchLanguage button
        switchLanguage1.setOnClickListener(view -> toggleLayout(viewFlipperLanguage));
        switchLanguage2.setOnClickListener(view -> toggleLayout(viewFlipperLanguage));
        switchToSymbols1.setOnClickListener(view -> toggleLayout(viewFlipperSymbols));
        switchToSymbols2.setOnClickListener(view -> toggleLayout(viewFlipperSymbols));
        switchToSymbols3.setOnClickListener(view -> toggleLayout(viewFlipperSymbols));
        switchToRareSymbols1.setOnClickListener(view -> toggleLayout(viewFlipperRareSymbols));
        switchToRareSymbols2.setOnClickListener(view -> toggleLayout(viewFlipperRareSymbols));

        return rootView;
    }

    private void toggleLayout(ViewFlipper viewFlipper) {
        // Toggle between layouts of the specified ViewFlipper
        if (viewFlipper.getDisplayedChild() == 0) {
            viewFlipper.setDisplayedChild(1); // Show shifted layout
        } else {
            viewFlipper.setDisplayedChild(0); // Show default layout
        }
    }
}
