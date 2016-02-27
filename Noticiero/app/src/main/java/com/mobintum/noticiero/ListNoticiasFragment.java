package com.mobintum.noticiero;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListNoticiasFragment extends Fragment {

    private ListView listNoticias;
    private NoticiaAdapter adapter;


    public ListNoticiasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_noticias, container, false);
        listNoticias = (ListView) view.findViewById(R.id.listNoticias);
        adapter = new NoticiaAdapter(getContext(),R.layout.item_noticia,Noticia.getData());
        listNoticias.setAdapter(adapter);

        return view;
    }

}
