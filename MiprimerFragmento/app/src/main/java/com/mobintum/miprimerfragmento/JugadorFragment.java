package com.mobintum.miprimerfragmento;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JugadorFragment extends Fragment {

    private static final String ARG_PARAM_COLOR = "paramColor";
    private static final String ARG_PARAM_MESSAGE = "paramMessage";

    private int color;
    private String message;
    private TextView txtMessage;
    private RelativeLayout layoutPlayer;

    public  static JugadorFragment newInstance(int color, String message){
        JugadorFragment fragment = new JugadorFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM_COLOR, color);
        args.putString(ARG_PARAM_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    public JugadorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            this.color = getArguments().getInt(ARG_PARAM_COLOR);
            this.message = getArguments().getString(ARG_PARAM_MESSAGE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jugador, container, false);
        txtMessage = (TextView) view.findViewById(R.id.txtMessage);
        layoutPlayer = (RelativeLayout) view.findViewById(R.id.layoutPlayer);
        txtMessage.setText(message);
        switch (color){
            case 1:
                layoutPlayer.setBackgroundColor(getResources().getColor(R.color.blue));
                break;
            case 2:
                layoutPlayer.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case 3:
                layoutPlayer.setBackgroundColor(getResources().getColor(R.color.purple));
                break;
            case 4:
                layoutPlayer.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            case 5:
                layoutPlayer.setBackgroundColor(getResources().getColor(R.color.orange));
                break;

        }


        return view;
    }

}
