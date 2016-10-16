package com.example.m_tomomi.marriagehunter.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.m_tomomi.marriagehunter.R;
import com.example.m_tomomi.marriagehunter.activities.ChatMessage;
import com.example.m_tomomi.marriagehunter.activities.HomeSchedule;
import com.example.m_tomomi.marriagehunter.activities.HomeScheduleAdapter;
import com.example.m_tomomi.marriagehunter.activities.ListViewAdapter;
import com.example.m_tomomi.marriagehunter.activities.ScheduleList;
import com.example.m_tomomi.marriagehunter.activities.ScheduleListAdapter;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScheduleListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScheduleListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private final
    String FIREBASE_URL = "https://marriagehunter-76346.firebaseio.com/";

    private Firebase mFirebaseRef;    //Firebase

    private ArrayAdapter mAryAdapter; //チャット一覧　データ格納

    public ScheduleListFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Context context) {
        ScheduleListFragment f = new ScheduleListFragment();
        return f;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleListFragment.
     */
    // TODO: Rename and change types and number of parameters
    //public static ScheduleListFragment newInstance(String param1, String param2) {
    //    ScheduleListFragment fragment = new ScheduleListFragment();
    //    Bundle args = new Bundle();
    //    args.putString(ARG_PARAM1, param1);
    //    args.putString(ARG_PARAM2, param2);
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
        View v = inflater.inflate(R.layout.fragment_schedule_list, container, false);

        //EditText mEddate = (EditText) container.findViewById(R.id.edit_txt_data);
        //mEddate.setText("15");
        //EditText mEdske = (EditText) container.findViewById(R.id.edit_txt_schedule);
        //mEdske.setText("スタートアップウィークエンド");

        //firebaseよりデータを取得。初期表示。
        Log.d("Firebase", "start --->");
        // クライアントライブラリにコンテキスト(Activity)をセットします。
        Firebase.setAndroidContext(getActivity());
        mFirebaseRef = new Firebase(FIREBASE_URL);
        //mAryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1);

        //mFirebaseRef.getRoot().child("").addValueEventListener(new ValueEventListener() {
        //    @Override
        //    public void onDataChange(DataSnapshot snapshot) {
        //        Log.d("Firebase", "：onDataChange1");
                //mAryAdapter.clear();

                /*
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String timestamp = (String) dataSnapshot.child("timestamp").getValue();
                    String sender = (String) dataSnapshot.child("sender").getValue();
                    String body = (String) dataSnapshot.child("body").getValue();

                    String data = timestamp.substring(0, 4) + "/" +
                            timestamp.substring(4, 6) + "/" +
                            timestamp.substring(6, 8);

                    Log.d("Firebase", String.format("timestamp:%s, sender:%s, body:%s", data, sender, body));

                    mAryAdapter.add(data + "：" + sender + "：" + body);
                }
                mListChat.setAdapter(mAryAdapter);
                mListChat.setSelection(mAryAdapter.getCount());
                */
        //    }

        //    @Override
        //    public void onCancelled(FirebaseError error) {
        //        Log.d("Firebase", "：onCancelled");
        //    }
        //});
        Log.d("Firebase", "<--- end");

        /*
        CalendarView calendarView =  (CalendarView) v.findViewById(R.id.calendar_view);
        //calendarView.addon
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //date = new Date(year, month, dayOfMonth);
                Log.d("year", "year" + year);
                int m = month + 1;
                TextView mTVdate = (TextView) getActivity().findViewById(R.id.txt_view_select_date);
                String temp = m + "/" + dayOfMonth;
                mTVdate.setText(temp);
            }
        });
*/
/*
        // カードリスト
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.cardListScheduleList);

        // RecyclerViewにはLayoutManagerが必要　★レイアウトマネージャー★
        LinearLayoutManager llManager = new LinearLayoutManager(v.getContext());

        // 縦スクロール
        llManager.setOrientation(LinearLayoutManager.VERTICAL);

        // recyclerView に llManager をセット。
        recyclerView.setLayoutManager(llManager);

        // MainDataクラスのArrayListを作成。
        ArrayList<ScheduleList> aryScheduleDate = new ArrayList<ScheduleList>();


        // テスト
        aryScheduleDate.add(new ScheduleList("","","","", 0));
        aryScheduleDate.add(new ScheduleList("10","00","AM","あいうえお", 1));
        aryScheduleDate.add(new ScheduleList("11","30","AM","あいうえおあいうえお", 1));
        aryScheduleDate.add(new ScheduleList("12","15","PM","かきくけこ", 1));
        aryScheduleDate.add(new ScheduleList("23","59","PM","かきくけこかきくけこ", 1));


        // ★★★　RecyclerView.Adapterとは？？
        // AnbayasiAdapter　に　AnbayasiDataのArrayList　を渡して、インスタンスを作成。
        // それを　RecyclerView.Adapter型の変数　にセット。
        RecyclerView.Adapter adapterSchedule = new ScheduleListAdapter(aryScheduleDate);
        recyclerView.setAdapter(adapterSchedule);
*/

        // MainDataクラスのArrayListを作成。
        ArrayList<ScheduleList> aryScheduleDate = new ArrayList<ScheduleList>();

        // テスト
        aryScheduleDate.add(new ScheduleList("","","","", 0));
        aryScheduleDate.add(new ScheduleList("","","","", 0));
        aryScheduleDate.add(new ScheduleList("","","","", 0));


        ListView listView = (ListView) v.findViewById(R.id.lvSchedule);

        // ListViewにadapterをセット
        ListViewAdapter adapter = new ListViewAdapter(getContext(), 0 ,aryScheduleDate);
        listView.setAdapter(adapter);



        // BaseAdapter を継承したadapterのインスタンスを生成
        // レイアウトファイル list.xml を activity_main.xml に inflate するためにadapterに引数として渡す
        // 配列をArrayListにコピー
        //ArrayList<String> itemNames = new ArrayList<String>(Arrays.asList(""));
        //ArrayList<Integer> itemImages = new ArrayList<Integer>(Arrays.asList(1));
        //BaseAdapter adapter = new ListViewAdapter(getContext(), R.layout.fragment_schedule_list, itemNames, itemImages);


        //listView.setOnItemClickListener(this);


        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        /*
        ImageButton imgbtnEdit = (ImageButton) getActivity().findViewById(R.id.img_btn_edit);
        imgbtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "hoge!", Toast.LENGTH_SHORT).show();
                //Lineに送信
                try {
                    //日付取得
                    TextView mTVdate = (TextView) getActivity().findViewById(R.id.txt_view_select_date);
                    //時刻取得
                    EditText mTVtime = (EditText) getActivity().findViewById(R.id.edit_txt_data);
                    //メッセージ部分
                    EditText mEMessage = (EditText) getActivity().findViewById(R.id.edit_txt_schedule);

                    //登録
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                    String strTimestamp = sdf.format(date).toString();


                    String strMassege = mTVdate.getText().toString() + " " + mTVtime.getText().toString() + "時から" + " " + mEMessage.getText().toString();


                    mFirebaseRef.child("/" + System.currentTimeMillis()).setValue(new ChatMessage(strTimestamp, "tomomi", strMassege), new Firebase.CompletionListener() {
                                @Override
                                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                                    if (firebaseError != null) {
                                        Log.d("setValue", firebaseError.getMessage(), firebaseError.toException());
                                    } else {
                                        Log.d("setValue", "data successfully saved!");
                                    }
                                }
                            });

                    //String lineString = "line://msg/text/" + mtvMessage.getText();
                    //Intent intent = Intent.parseUri(lineString, Intent.URI_INTENT_SCHEME);
                    //startActivity(intent);
                } catch (Exception e) {
                    //LINE投稿失敗
                }
            }
        });
       */
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

    /*
    @Override
    public void onClick(View view) {
        //
    }
    */

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
