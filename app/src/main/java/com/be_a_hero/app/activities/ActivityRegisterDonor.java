package com.be_a_hero.app.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

import com.be_a_hero.app.R;
import com.be_a_hero.app.databinding.ActivityRegisterDonorBinding;

public class ActivityRegisterDonor extends BaseActivity {

    private static final String TAG = ActivityRegisterDonor.class.getSimpleName();

    ActivityRegisterDonorBinding binding;

    private View parent_view;
    boolean maleGenderPressed = false;
    boolean femaleGenderPressed = false;

    String selectedSex = null;

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityRegisterDonor.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @SuppressLint({"CheckResult", "SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register_donor);
        parent_view = findViewById(android.R.id.content);

        initToolbar(binding.toolbar,true);
        setToolbarTitle(null);

        // on click male gender
        binding.genderMaleImageView.setOnClickListener(v -> {
            // toggle button
            toggleGenderButtonStates(true);
        });

        // on click female gender
        binding.genderFemaleImageView.setOnClickListener(v -> {
            // toggle button
            toggleGenderButtonStates(false);
        });

//        Tools.systemBarLollipopTransparent(this);
    }

    private void toggleGenderButtonStates(boolean isMale) {
        if(isMale){
            selectedSex = "male";
            // set male views
            binding.genderMaleImageView.setImageState(new int[] {android.R.attr.state_pressed},true);
            binding.genderMaleImageView.setColorFilter(ContextCompat.getColor(activityContext, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.genderMaleTextView.setTextColor(ContextCompat.getColor(activityContext,R.color.be_hero_dark));

            // reset female views
            binding.genderFemaleImageView.setImageState(new int[] {-android.R.attr.state_pressed},true);
            binding.genderFemaleImageView.setColorFilter(ContextCompat.getColor(activityContext, R.color.be_hero_dark_grey), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.genderFemaleTextView.setTextColor(ContextCompat.getColor(activityContext,R.color.be_hero_dark_grey));
        }else{
            selectedSex = "female";
            // reset male views
            binding.genderMaleImageView.setImageState(new int[] {-android.R.attr.state_pressed},true);
            binding.genderMaleImageView.setColorFilter(ContextCompat.getColor(activityContext, R.color.be_hero_dark_grey), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.genderMaleTextView.setTextColor(ContextCompat.getColor(activityContext,R.color.be_hero_dark_grey));
            // set female views
            binding.genderFemaleImageView.setImageState(new int[] {android.R.attr.state_pressed},true);
            binding.genderFemaleImageView.setColorFilter(ContextCompat.getColor(activityContext, R.color.white), android.graphics.PorterDuff.Mode.MULTIPLY);
            binding.genderFemaleTextView.setTextColor(ContextCompat.getColor(activityContext,R.color.be_hero_dark));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void bloodGroupRadiosClicked(View view) {
        switch (view.getId()){
            case R.id.blood_group_radio_1:
                resetRadios(view.getId(),R.id.blood_group_radio_2,R.id.blood_group_radio_3,R.id.blood_group_radio_4,R.id.blood_group_radio_5,R.id.blood_group_radio_6,R.id.blood_group_radio_6,R.id.blood_group_radio_8);
            case R.id.blood_group_radio_2:
                ((RadioButton)findViewById(view.getId())).setChecked(true);
                resetRadios(view.getId(),R.id.blood_group_radio_1,R.id.blood_group_radio_3,R.id.blood_group_radio_4,R.id.blood_group_radio_5,R.id.blood_group_radio_6,R.id.blood_group_radio_6,R.id.blood_group_radio_8);
            case R.id.blood_group_radio_3:
                resetRadios(view.getId(),R.id.blood_group_radio_1,R.id.blood_group_radio_2,R.id.blood_group_radio_4,R.id.blood_group_radio_5,R.id.blood_group_radio_6,R.id.blood_group_radio_6,R.id.blood_group_radio_8);
            case R.id.blood_group_radio_4:
                resetRadios(view.getId(),R.id.blood_group_radio_1,R.id.blood_group_radio_2,R.id.blood_group_radio_3,R.id.blood_group_radio_5,R.id.blood_group_radio_6,R.id.blood_group_radio_6,R.id.blood_group_radio_8);
            case R.id.blood_group_radio_5:
                resetRadios(view.getId(),R.id.blood_group_radio_1,R.id.blood_group_radio_2,R.id.blood_group_radio_3,R.id.blood_group_radio_4,R.id.blood_group_radio_6,R.id.blood_group_radio_6,R.id.blood_group_radio_8);
            case R.id.blood_group_radio_6:
                resetRadios(view.getId(),R.id.blood_group_radio_1,R.id.blood_group_radio_2,R.id.blood_group_radio_3,R.id.blood_group_radio_4,R.id.blood_group_radio_5,R.id.blood_group_radio_7,R.id.blood_group_radio_8);
            case R.id.blood_group_radio_7:
                resetRadios(view.getId(),R.id.blood_group_radio_1,R.id.blood_group_radio_2,R.id.blood_group_radio_3,R.id.blood_group_radio_4,R.id.blood_group_radio_5,R.id.blood_group_radio_6,R.id.blood_group_radio_8);
            case R.id.blood_group_radio_8:
                resetRadios(view.getId(),R.id.blood_group_radio_1,R.id.blood_group_radio_2,R.id.blood_group_radio_3,R.id.blood_group_radio_4,R.id.blood_group_radio_5,R.id.blood_group_radio_6,R.id.blood_group_radio_7);

        }

    }

    private void resetRadios(int checkedId, int blood_group_radio_1, int blood_group_radio_2, int blood_group_radio_3, int blood_group_radio_4, int blood_group_radio_5
            , int blood_group_radio_6, int blood_group_radio_7) {
        int textColor = ContextCompat.getColor(activityContext,R.color.colorAccent);

        ((RadioButton)findViewById(blood_group_radio_1)).getBackground().setState(new int[] {-android.R.attr.state_checked,-android.R.attr.state_pressed});
        ((RadioButton)findViewById(blood_group_radio_1)).setTextColor(textColor);
        ((RadioButton)findViewById(blood_group_radio_2)).getBackground().setState(new int[] {-android.R.attr.state_checked,-android.R.attr.state_pressed});
        ((RadioButton)findViewById(blood_group_radio_2)).setTextColor(textColor);
        ((RadioButton)findViewById(blood_group_radio_3)).getBackground().setState(new int[] {-android.R.attr.state_checked,-android.R.attr.state_pressed});
        ((RadioButton)findViewById(blood_group_radio_3)).setTextColor(textColor);
        ((RadioButton)findViewById(blood_group_radio_4)).getBackground().setState(new int[] {-android.R.attr.state_checked,-android.R.attr.state_pressed});
        ((RadioButton)findViewById(blood_group_radio_4)).setTextColor(textColor);
        ((RadioButton)findViewById(blood_group_radio_5)).getBackground().setState(new int[] {-android.R.attr.state_checked,-android.R.attr.state_pressed});
        ((RadioButton)findViewById(blood_group_radio_5)).setTextColor(textColor);
        ((RadioButton)findViewById(blood_group_radio_6)).getBackground().setState(new int[] {-android.R.attr.state_checked,-android.R.attr.state_pressed});
        ((RadioButton)findViewById(blood_group_radio_6)).setTextColor(textColor);
        ((RadioButton)findViewById(blood_group_radio_7)).getBackground().setState(new int[] {-android.R.attr.state_checked,-android.R.attr.state_pressed});
        ((RadioButton)findViewById(blood_group_radio_7)).setTextColor(textColor);

        // the clicked button
        ((RadioButton)findViewById(checkedId)).setChecked(true);
        ((RadioButton)findViewById(checkedId)).setTextColor(ContextCompat.getColor(activityContext,R.color.white));
    }
}
