package bradley.quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayFragmentTwo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayFragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayFragmentTwo extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //not necessary since I only do one instance of this fragment
    //I added more instances of this fragment I would use
    //private String mParam1;
    //private String mParam2;

    private OnFragmentInteractionListener mListener;

    //for widget
    private Button B1;

    public PlayFragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayFragmentTwo.
     */

    public static PlayFragmentTwo newInstance(String param1, String param2) {
        PlayFragmentTwo fragment = new PlayFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //use if more than on instance
        //if (getArguments() != null)
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_play_two, container, false);

        //int id = getResources().getIdentifier("bradley.quiz:drawable/" + "car", null, null);
        //image =(ImageView)view.findViewById(R.id.imageView);
        //image.setImageResource(id);
        B1 = (Button)view.findViewById(R.id.B1);

        return view;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //should never be null
                EditText editText = (EditText)view.findViewById(R.id.editText);
                String text = editText.getText().toString().trim();
                editText.setText("");
                if (text.equals("red")) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(null, null, null, "one"))
                            .commit();
                }
                else {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, PlayFragment.newInstance(null, null, null, null))
                            .commit();
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
                    + " must implement OnFragmentInteractionListenerTwo");
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
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
