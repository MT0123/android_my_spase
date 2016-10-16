package com.example.m_tomomi.marriagehunter.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.m_tomomi.marriagehunter.R;
import com.example.m_tomomi.marriagehunter.activities.HomeSchedule;
import com.example.m_tomomi.marriagehunter.activities.HomeScheduleAdapter;
import com.firebase.client.Firebase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private FragmentManager manager;

    private final
    String FIREBASE_URL = "https://marriagehunter-76346.firebaseio.com/";

    private Firebase mFirebaseRef;    //Firebase
    private ArrayAdapter mAryAdapter; //チャット一覧　データ格納
    private ListView mListChat;        //チャット一覧

    //レイアウト
    private LinearLayout mLayoutToday;
    private LinearLayout mLayoutPropose;
    private LinearLayout mLayoutSchedule;



    public MainFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(Context context) {
        MainFragment f = new MainFragment();
        return f;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    //public static MainFragment newInstance(String param1, String param2) {
    //    MainFragment fragment = new MainFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        // カードリスト
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.cardListSchedule);


        // RecyclerViewにはLayoutManagerが必要　★レイアウトマネージャー★
        LinearLayoutManager llManager = new LinearLayoutManager(v.getContext());

        // 縦スクロール
        llManager.setOrientation(LinearLayoutManager.VERTICAL);


        // recyclerView に llManager をセット。
        recyclerView.setLayoutManager(llManager);


        // MainDataクラスのArrayListを作成。
        ArrayList<HomeSchedule> aryScheduleDate = new ArrayList<HomeSchedule>();


        // テスト
        aryScheduleDate.add(new HomeSchedule("1111.11.11","Moday","11:11","AM","あいうえお", 0));
        aryScheduleDate.add(new HomeSchedule("2222.22.22","Moday","22:22","AM","かきくけこさしすせそ", 0));
        aryScheduleDate.add(new HomeSchedule("3333.33.33","Moday","33:33","PM","たちつてとなにぬねのはひふへほ", 0));
        aryScheduleDate.add(new HomeSchedule("4444.44.44","Moday","44:44","PM","まみむめも", 0));
        aryScheduleDate.add(new HomeSchedule("5555.55.55","Moday","55:55","PM","やゆよ", 0));

        aryScheduleDate.add(new HomeSchedule("","","","","○○○へはどうですか？", 1));

        aryScheduleDate.add(new HomeSchedule("1111.11.11","Wednesday","11:11","AM","あいうえお", 2));
        aryScheduleDate.add(new HomeSchedule("2222.22.22","Wednesday","22:22","AM","かきくけこさしすせそ", 2));
        aryScheduleDate.add(new HomeSchedule("3333.33.33","Wednesday","33:33","PM","たちつてとなにぬねのはひふへほ", 2));
        aryScheduleDate.add(new HomeSchedule("4444.44.44","Wednesday","44:44","PM","まみむめも", 2));
        aryScheduleDate.add(new HomeSchedule("5555.55.55","Wednesday","55:55","PM","やゆよ", 2));


        // ★★★　RecyclerView.Adapterとは？？
        // AnbayasiAdapter　に　AnbayasiDataのArrayList　を渡して、インスタンスを作成。
        // それを　RecyclerView.Adapter型の変数　にセット。
        RecyclerView.Adapter adapterSchedule = new HomeScheduleAdapter(aryScheduleDate);
        recyclerView.setAdapter(adapterSchedule);





        //recyclerView.setVisibility(View.GONE);

        //recyclerView.setAdapter(adapter2);

        //recyclerView.smoothScrollToPosition(aryMainDate.size() -1 );	//開いたときのポジションがラスト


        //mLayoutToday = (LinearLayout)v.findViewById(R.id.ll_today);
        //mLayoutPropose = (LinearLayout)v.findViewById(R.id.ll_propose);
        //mLayoutSchedule = (LinearLayout)v.findViewById(R.id.ll_schedule);
/*
        //線
        int color1 = getResources().getColor(R.color.colorSalmon);
        View v_line_today = new View(v.getContext());
        v_line_today.setBackgroundColor(color1);

        int color2 = getResources().getColor(R.color.colorDarkorange);
        View v_line_Propose = new View(v.getContext());
        v_line_Propose.setBackgroundColor(color2);

        int color3 = getResources().getColor(R.color.colorMediumaquamarine);
        View v_line_schedule = new View(v.getContext());
        v_line_schedule.setBackgroundColor(color3);

        // テキスト・フィールドを生成
        TextView tvToday = new TextView(v.getContext());
        tvToday.setText("2016.09.18 18:00 ソースから動的に追加");
        mLayoutToday.addView(v_line_today);
        mLayoutToday.addView(tvToday);

        // テキスト・フィールドを生成
        TextView tvPropose = new TextView(v.getContext());
        tvPropose.setText("2016.09.18 ソースから動的に追加");
        mLayoutPropose.addView(v_line_Propose);
        mLayoutPropose.addView(tvPropose);

        // テキスト・フィールドを生成
        TextView tvSchedule = new TextView(v.getContext());
        tvSchedule.setText("2016.09.30 ソースから動的に追加");
        mLayoutSchedule.addView(v_line_schedule);
        mLayoutSchedule.addView(tvSchedule);
*/

        /*
        //v.setOnClickListener(this);
        manager = this.getFragmentManager();

        //firebaseよりデータを取得。初期表示。
        Log.d("Firebase", "start --->");
        // クライアントライブラリにコンテキスト(Activity)をセットします。
        Firebase.setAndroidContext(getActivity());
        mFirebaseRef = new Firebase(FIREBASE_URL);

        mListChat = (ListView) v.findViewById(R.id.listView);
        mAryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1);

        mFirebaseRef.getRoot().child("").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d("Firebase", "：onDataChange1");
                mAryAdapter.clear();

                Log.d("Firebase", "：2");

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Log.d("Firebase", "：3");

                    String timestamp = (String) dataSnapshot.child("timestamp").getValue();
                    String sender = (String) dataSnapshot.child("sender").getValue();
                    String body = (String) dataSnapshot.child("body").getValue();

                    Log.d("Firebase", "：4");

                    String data = timestamp.substring(0, 4) + "/" +
                            timestamp.substring(4, 6) + "/" +
                            timestamp.substring(6, 8);

                    Log.d("Firebase", String.format("timestamp:%s, sender:%s, body:%s", data, sender, body));

                    //mAryAdapter.add(data + "：" + sender + "：" + body);
                    mAryAdapter.add(body);

                    Log.d("Firebase", "：5");
                }

                Log.d("Firebase", "：6");
                mListChat.setAdapter(mAryAdapter);

                Log.d("Firebase", "：7");
                mListChat.setSelection(mAryAdapter.getCount());

                Log.d("Firebase", "：8");
            }

            @Override
            public void onCancelled(FirebaseError error) {
                Log.d("Firebase", "：onCancelled");
            }
        });

        Log.d("Firebase", "<--- end");
        */

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        //ImageButton imgEdit = (ImageButton) getActivity().findViewById(R.id.imageButton);
        //imgEdit.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        //Toast.makeText(getActivity(), "hoge!", Toast.LENGTH_SHORT).show();
        //        //Lineに送信
        //        try {
        //            //FragmentManager manager = this.getFragmentManager();
        //            FragmentTransaction transaction = manager.beginTransaction();
        //            DraftFragment fragment = new DraftFragment();
        //            transaction.replace(R.id.container, fragment);
        //            transaction.commit();
        //        } catch (Exception e) {
        //            //LINE投稿失敗
        //        }
        //    }
        //});
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
        //Lineに送信
        try {
            //String lineString = "line://msg/text/" + "村上さん、もし予定が空いていれば、ディズニーへデートにいきませんか？";
            //Intent intent = Intent.parseUri(lineString, Intent.URI_INTENT_SCHEME);
            //startActivity(intent);


        } catch (Exception e) {
            //LINE投稿失敗
        }
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
