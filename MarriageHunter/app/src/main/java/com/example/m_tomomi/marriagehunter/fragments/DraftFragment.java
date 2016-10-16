package com.example.m_tomomi.marriagehunter.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.m_tomomi.marriagehunter.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DraftFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DraftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DraftFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    //private ImageButton mImgBtnline;
    private TextView mtvMessage;
    private Spinner spinner_who;
    private Spinner spinner_where;

    private String mStrWho;
    private String mStrWhere;

    public DraftFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Context context) {
        DraftFragment f = new DraftFragment();
        return f;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DraftFragment.
     */
    // TODO: Rename and change types and number of parameters
    //public static DraftFragment newInstance(String param1, String param2) {
    //    DraftFragment fragment = new DraftFragment();
    //    Bundle args = new Bundle();
    //    args.putString(ARG_PARAM1, param1);
    //   args.putString(ARG_PARAM2, param2);
    //    fragment.setArguments(args);
    //    return fragment;
    //}

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
        View v =  inflater.inflate(R.layout.fragment_draft, container, false);

        //mImgBtnline = (ImageButton) getActivity().findViewById(R.id.img_btn_line);
        //v.setOnClickListener(this);


        // スピナーにアダプターを設定
        spinner_who = (Spinner)  v.findViewById(R.id.spinne_who);
        spinner_who.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, WORDS[position] + "が選択されました。", Toast.LENGTH_SHORT).show();

                // スピナー要素の文字列を取得
                String selectedItemString = (String) parent.getItemAtPosition(position);
                mStrWho = selectedItemString;
                Log.d("selectedItemString", "：" + selectedItemString);


                // 選択した要素で TextView を書き換え
                TextView helloWorldTextView = (TextView) getActivity().findViewById(R.id.txt_view_messege);
                TextView txtDate = (TextView) getActivity().findViewById(R.id.edit_date);

                String t1 =txtDate.getText().toString().substring(0,2).toString();
                String t2 =txtDate.getText().toString().substring(2,2).toString();

                helloWorldTextView.setText(mStrWho + "さん、" + "10/31" + "に" + mStrWhere + "へ遊びに行きませんか？");

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_where = (Spinner)  v.findViewById(R.id.spinne_where);
        spinner_where.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedItemString = (String) parent.getItemAtPosition(position);
                mStrWhere = selectedItemString;


                // 選択した要素で TextView を書き換え
                TextView helloWorldTextView = (TextView) getActivity().findViewById(R.id.txt_view_messege);
                TextView txtDate = (TextView) getActivity().findViewById(R.id.edit_date);

                String t1 =txtDate.getText().toString().substring(0,2).toString();
                String t2 =txtDate.getText().toString().substring(2,2).toString();

                helloWorldTextView.setText(mStrWho + "さん、" + "10/31" + "に" + mStrWhere + "へ遊びに行きませんか？");

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });









        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        ImageButton imgbtnline = (ImageButton)getActivity().findViewById(R.id.img_btn_line);
        imgbtnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "hoge!", Toast.LENGTH_SHORT).show();
                //Lineに送信
                try {
                    //メッセージ送信
                    mtvMessage = (TextView) getActivity().findViewById(R.id.txt_view_messege);

                    String lineString = "line://msg/text/" + mtvMessage.getText();
                    Intent intent = Intent.parseUri(lineString, Intent.URI_INTENT_SCHEME);
                    startActivity(intent);
                } catch (Exception e) {
                    //LINE投稿失敗
                }
            }
        });


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    */

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    //@Override
    //public void onClick(View v) {
    //    if (v.equals(mImgBtnline)) {
    //        //Lineに送信
    //        try {
    //            String lineString = "line://msg/text/" + "村上さん、もし予定が空いていれば、ディズニーへデートにいきませんか？";
    //            Intent intent = Intent.parseUri(lineString, Intent.URI_INTENT_SCHEME);
    //            startActivity(intent);
    //        } catch (Exception e) {
    //            //LINE投稿失敗
    //        }
    //    }
    //}

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
