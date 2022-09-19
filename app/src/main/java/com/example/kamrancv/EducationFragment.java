package com.example.kamrancv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EducationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EducationFragment extends Fragment {


    String[] sp = {"Education","Class 10th","Class 12th","Graduation"};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EducationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EducationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EducationFragment newInstance(String param1, String param2) {
        EducationFragment fragment = new EducationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_education, container, false);
         Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,sp);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spin = adapterView.getItemAtPosition(i).toString();

                if (i == 0){
                    return;
                }
                else if (i == 1){
                    FragmentTransaction fragmentTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.container, new Class10Fragment());
                    fragmentTransaction1.commit();
                }
                else if (i == 2){
                    FragmentTransaction fragmentTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.container, new Class12Fragment());
                    fragmentTransaction1.commit();
                }
                else {
                    FragmentTransaction fragmentTransaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.container, new GraduationFragment());
                    fragmentTransaction1.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return view;
    }
}