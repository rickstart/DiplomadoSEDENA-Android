package com.mobintum.miprimerfragmento;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class JugadorFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_PARAM_COLOR = "paramColor";
    private static final String ARG_PARAM_MESSAGE = "paramMessage";

    private int color;
    private String message;
    private TextView txtMessage;
    private RelativeLayout layoutPlayer;
    private ImageView imgPlayer, ball;
    private CharlaJugadores escucharCharla;
    private boolean showR;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.escucharCharla = (CharlaJugadores) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+" Tienes que implemetar la interface");
        }
    }

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
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_jugador, container, false);
        txtMessage = (TextView) view.findViewById(R.id.txtMessage);
        layoutPlayer = (RelativeLayout) view.findViewById(R.id.layoutPlayer);
        imgPlayer = (ImageView) view.findViewById(R.id.imgPlayer);
        ball = (ImageView) view.findViewById(R.id.ball);

        imgPlayer.setOnClickListener(this);
        showBall(showR);
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

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.imgPlayer:
                int index = randInt(0,5);
                if(index==0 || index == 5)
                    escucharCharla.goal(true);

                escucharCharla.pasarBalon(index);
                break;
        }

    }


    public interface CharlaJugadores {
        public void pasarBalon(int id);
        public void goal(boolean gol);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void showBall(boolean show){
        showR = show;

        if(show)
            ball.setVisibility(View.VISIBLE);
        else
            ball.setVisibility(View.GONE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("show", showR);
    }
}
