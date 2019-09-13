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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.be_a_hero.app.R;
import com.be_a_hero.app.databinding.ActivityRegisterDonorBinding;
import com.be_a_hero.app.databinding.ActivityRequestBloodBinding;

public class ActivityRequestBlood extends BaseActivity {

    private static final String TAG = ActivityRequestBlood.class.getSimpleName();

    ActivityRequestBloodBinding binding;

    String[] persons = {"Friend", "Family", "Relative", "Patient", "Work Colleague", "Anonymous"};

    String[] cities = {"Mumbai", "Bengaluru", "Chennai", "Kolkata", "New Delhi", "Sorat"};

    private View parent_view;

    public static void start(Context context) {
        Intent intent = new Intent(context, ActivityRequestBlood.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    @SuppressLint({"CheckResult", "SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_request_blood);
        parent_view = findViewById(android.R.id.content);

        initToolbar(binding.toolbar,true);
        setToolbarTitle(null);

        // requesting for spinner
        ArrayAdapter personsAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, persons);
        personsAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        binding.requestForSpinner.setAdapter(personsAdapter);
        binding.requestForSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activityContext,parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // cities spinner
        ArrayAdapter citiesAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, cities);
        citiesAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        binding.citySpinner.setAdapter(citiesAdapter);
        binding.citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activityContext,"City "+parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        Tools.systemBarLollipopTransparent(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
