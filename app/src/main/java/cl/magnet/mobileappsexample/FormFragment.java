package cl.magnet.mobileappsexample;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import cl.magnet.mobileappsexample.db.Form;
import cl.magnet.mobileappsexample.db.FormViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {

    private FormViewModel formViewModel;


    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        formViewModel = ViewModelProviders.of(this).get(FormViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText name_input = view.findViewById(R.id.editTextName);
        final EditText date_input = view.findViewById(R.id.editTextDate);
        Button insertFormButton = view.findViewById(R.id.Submit);
        insertFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_input.getText().toString();
                String date = date_input.getText().toString();
                int randomNum = (int) (Math.random() * (1000000));
                Form form = new Form(randomNum, name, date);
                List<Form> forms = new ArrayList<>();
                forms.add(form);
                formViewModel.insert(forms);
            }
        });
    }
}
