package com.example.recyclerviewwords;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewwords.databinding.WordItemListBinding;

import java.util.List;


/*****************3.- EXTIENDO LA CLASE WORDADATER QUE CONTIENE LA CLASE INTERNA WORDVIEWHOLER***********************/
public class WordAdapter  extends  RecyclerView.Adapter<WordAdapter.WordViewHolder>{
    /*****************1.Representación de los datosr***********************/
    private List<String> mwordlist;

    /***************** 7 Constructor que reciba los datos***********************/

    public WordAdapter(List<String >mwordlist){

        this.mwordlist=mwordlist;
    }


    //4 ESTE METODO INICIALIZA LAS VISTAS LAS INFLA
    // EN EL CONSTRUCTOR RECIBE UN OBJETO LE PASAMOS BINDING
    // INSTANCIAMOS VIEWBINDING PARA RETONAR NUESTRO VIEWHOLDER CON ESA DEPENDENCIA

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    WordItemListBinding mBinding= WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
    return  new WordViewHolder(mBinding);
    }

    //5 ESTE METODO INICIALIZA LAS VISTAS LAS INFLA
    // EN EL CONSTRUCTOR RECIBE UN OBJETO LE PASAMOS BINDING
    // INSTANCIAMOS VIEWBINDING PARA RETONAR NUESTRO VIEWHOLDER CON ESA DEPENDENCIA


    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String element = mwordlist.get(position);
        holder.textView.setText(element);

    }


    // 6 Este método lleva la cuenta de cuantos elementos hay en el listado
    @Override
    public int getItemCount() {
    return  mwordlist.size();
    }


    /*****************2.Crear clase interna que se llama ViewHolder***********************/
    // INICIALIZAMOs TEXVIEW QUE ES DENTRO DEL XML  Y LLAMAMOS MBINDING QUE ES DE LA CLASE XML QUE CONTIENE TEXVIEW
    // NOS PEDIRA IMPLEMENTAR SU CONSTRUCTOR DE LA SUPER CLASE
    // CAMBIAMOS EL ELEMENTO ANTERIOR Y REFERENCIAMOS A LA CLASE BINDING QUE REPRESENTA NUESTRO LAYOUT WORD ITEM LIST

    public class  WordViewHolder extends RecyclerView.ViewHolder{

     private TextView textView;
        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView= mBinding.textView;
        }
    }

}
