package com.example.recyclerviewwords;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclerviewwords.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
     //1 -Creamos un list que represente los datos
    private List<String> datalist= new ArrayList<>();


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // para probar las palabras
        Log.d("Listado",setData().toString());

        //1 Instanciar el adapter y le pasamos los datos con las palabras
        WordAdapter adapter = new WordAdapter(setData());
        //2 le pasamos el adapter al recyclerView
        binding.Rv.setAdapter(adapter);
        // paso 3 lñe indicamos al recyclerview como mostrar los datos

        binding.Rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.Rv.setHasFixedSize(true);

    }

    // PASO 2 CREAR UN LIST DE PALABRAS
    private List<String> setData() {

        for (int i = 0; i < 99; i++)
            datalist.add("Palabra" + i);

        return datalist;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}