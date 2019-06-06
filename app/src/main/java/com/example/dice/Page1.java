package com.example.dice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Page1.OnPage1InteractionListener} interface
 * to handle interaction events.
 * Use the {@link Page1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Page1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnPage1InteractionListener mListener;

    Button roll;
    int random;
    int random1;
    ImageView dice1;
    ImageView dice2;

    public Page1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Page1.
     */
    // TODO: Rename and change types and number of parameters
    public static Page1 newInstance(String param1, String param2) {
        Page1 fragment = new Page1();
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
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_page1, container, false);

        roll=v.findViewById(R.id.roll);
        dice1=v.findViewById(R.id.dice1);
        dice2=v.findViewById(R.id.dice2);

        Animation anim= AnimationUtils.loadAnimation(getContext(),R.anim.bounce);
        MyBounceInterpolator interpolator=new MyBounceInterpolator(0.2,10);
        anim.setInterpolator(interpolator);
        roll.startAnimation(anim);


        roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                didTapRollbtn();
            }
        });

        return v;
    }
    public void didTapRollbtn()
    {
        double x=Math.random()*6+1;
        random= (int) x;
        double y=Math.random()*6+1;
        Log.d(TAG, "didTapRollbtn:"+random);
        random1=(int)y;
        Animation anim= AnimationUtils.loadAnimation(getContext(),R.anim.bounce);

        MyBounceInterpolator interpolator=new MyBounceInterpolator(0.2,10);
        anim.setInterpolator(interpolator);

        roll.startAnimation(anim);

        switch(random)
        {
            case 1:final Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice1.setImageResource(R.drawable.one);

                    }
                },1000);
                break;
            case 2:final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice1.setImageResource(R.drawable.two);

                    }
                },1000);
                break;
            case 3:final Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice1.setImageResource(R.drawable.three);

                    }
                },1000);
                break;
            case 4:final Handler handler4 = new Handler();
                handler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice1.setImageResource(R.drawable.four);

                    }
                },1000);
                break;
            case 5:final Handler handler5 = new Handler();
                handler5.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice1.setImageResource(R.drawable.five);

                    }
                },1000);
                break;
            case 6:final Handler handler6 = new Handler();
                handler6.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice1.setImageResource(R.drawable.six);

                    }
                },1000);
                break;
        }
        switch(random1)
        {
            case 1:final Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice2.setImageResource(R.drawable.one);

                    }
                },1000);
                break;
            case 2:final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice2.setImageResource(R.drawable.two);

                    }
                },1000);
                break;
            case 3:final Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice2.setImageResource(R.drawable.three);

                    }
                },1000);
                break;
            case 4:final Handler handler4 = new Handler();
                handler4.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice2.setImageResource(R.drawable.four);

                    }
                },1000);
                break;
            case 5:final Handler handler5 = new Handler();
                handler5.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice2.setImageResource(R.drawable.five);

                    }
                },1000);
                break;
            case 6:final Handler handler6 = new Handler();
                handler6.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dice2.setImageResource(R.drawable.six);

                    }
                },1000);
                break;
        }
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPage1Interaction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPage1InteractionListener) {
            mListener = (OnPage1InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnPage1InteractionListener {
        // TODO: Update argument type and name
        void onPage1Interaction(Uri uri);
    }
}
