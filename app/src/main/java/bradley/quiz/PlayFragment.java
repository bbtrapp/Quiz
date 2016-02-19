package bradley.quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 * This subclass also contains the game logic for the quiz
 *
 */
public class PlayFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";

    //score at the end of game
    private int score = 0;

    private Button A1;
    private Button A2;
    private Button A3;

    //questions and answers
    private String[][] a = {{"7","CS407","hair"},{"12","CS506","Leaves"},{"1","CS202","People"}};
    private String[] q = {"What is 4x3?" ,"What class is this HW for?", "What grows on tree branches?"};


    private String choice1;
    private String choice2;
    private String choice3;
    private String point;

    private OnFragmentInteractionListener mListener;

    public PlayFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayFragment.
     */
    public static PlayFragment newInstance(String param1, String param2, String param3, String param4) {
        PlayFragment fragment = new PlayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            choice1 = getArguments().getString(ARG_PARAM1);
            choice2 = getArguments().getString(ARG_PARAM2);
            choice3 = getArguments().getString(ARG_PARAM3);
            point = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_play, container, false);

        //connect to their widgets
        TextView question = (TextView) view.findViewById(R.id.question);
        A1 = (Button)view.findViewById(R.id.A1);
        A2 = (Button)view.findViewById(R.id.A2);
        A3 = (Button)view.findViewById(R.id.A3);

        if(choice1==null){
            question.setText(q[0]);
            A1.setText(a[0][0]);
            A2.setText(a[1][0]);
            A3.setText(a[2][0]);
        }
        else if(choice2==null){
            question.setText(q[1]);
            A1.setText(a[0][1]);
            A2.setText(a[1][1]);
            A3.setText(a[2][1]);
        }
        else{
            question.setText(q[2]);
            A1.setText(a[0][2]);
            A2.setText(a[1][2]);
            A3.setText(a[2][2]);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //question answer
        A1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(a[0][0], null, null,point))
                            .commit();

                }
                else if (choice2 == null){
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(choice1, a[0][1], null,point))
                            .commit();
                }
                else {
                    choice3 = (a[0][2]);
                    gameLogic();
                }
            }
        });

        A2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(a[1][0], null, null,point))
                            .commit();

                }
                else if (choice2 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(choice1, a[1][1], null,point))
                            .commit();
                }
                else{
                    choice3 = (a[1][2]);
                    gameLogic();

                }
            }
        });
        A3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choice1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(a[2][0], null, null, point))
                            .commit();

                } else if (choice2 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(choice1, a[2][1], null, point))
                            .commit();
                } else {
                    choice3 = (a[2][2]);
                    gameLogic();
                }
            }
        });
    }

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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     **/
    public interface OnFragmentInteractionListener  {
        void onFragmentInteraction(Uri uri);
    }

    private void gameLogic(){

        if(choice1.equals("12"))
            score++;
        if(choice2.equals("CS407"))
            score++;
        if(choice3.equals("Leaves"))
            score++;
        if(point!=null)
            score++;
        String s =  "" + score;
        displayScore(s);
    }

    private void displayScore(String score){

        //do a prompt about the winner
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("Your score was")
                .setMessage(score)
                .setPositiveButton("Replay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getFragmentManager().popBackStack();
                        getFragmentManager().popBackStack();
                        getFragmentManager().popBackStack();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                })
                .show();

    }
}
