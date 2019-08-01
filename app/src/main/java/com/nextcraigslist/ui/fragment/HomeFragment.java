package com.nextcraigslist.ui.fragment;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.nextcraigslist.R;
import com.nextcraigslist.databinding.FragmentHomeBinding;
import com.nextcraigslist.model.HomeModel;
import com.nextcraigslist.ui.activity.HomeActivity;
import com.nextcraigslist.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by S.C. on 21/05/18.
 */

public class HomeFragment extends Fragment implements HomeAdapter.OnClickListener {

    /*public static final String TAG = HomeFragment.class.getName();
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view;

    RecyclerView recyclerView;
    Context mcontext;
    ImageView ivBack;
    TextView tvNoDataFound;
    List<CLListElement> clListElementList;
    List<CLListElement> finalList;
    ImageView ivFilter;


    CLListElement clListElement;
    GalleryAdapter galleryAdapter;


    protected String mParam1;
    private ArrayList<CityInfo> selectedcityList;
    private EndlessRecyclerViewScrollListener scrollListener;
    private String subcategory;

    Spinner spinner;
    ProgressBar progressBar;
    String cityUrl;
    int count = 120;
    int j = 1;
    BasicOperation addFragment;
    String searchKeyword;
    RadioGroup radioGroup;
    RadioButton rbDate, rbPriceUp, rbPriceDown;
    String sortdate = "";
    String priceup = "";
    String pricedown = "";
    String filterURL = "";
    CRUDOpration opration;
    ImageView ivSaveSearch;
    String strText = "";
    String fullfinalURL = "";
    RelativeLayout btn_reset;
    Dialog filterDialog;
    String SendString = "";

    String tempSrtringParam = "";
    String dbParam = "";

    String finalsearch = "";

    EditText editText4;
    EditText editText5;
    EditText editText6;
    EditText editText7;
    EditText editText8;
    EditText editText20;
    EditText editText21;
    EditText editText22;
    EditText editText29;

    TextView textView15;
    TextView textView16;
    TextView textView17;
    TextView textView18;
    TextView textView19;

    TextView textView23;
    TextView textView24;
    TextView textView25;
    TextView textView26;
    TextView textView27;
    TextView textView28;
    TextView textView30;
    TextView textView31;

    String Category;
    boolean tagTrue;

    CityInfo cityInfo;
    LinearLayoutManager linearLayoutManager;
    String countryName = "";
    String checkboxString = "";
    static String pos0 = "", pos1 = "", pos2 = "", pos3 = "", pos4 = "", pos5 = "", pos6 = "", pos7 = "", pos8 = "", pos9 = "", pos10 = "", pos11 = "", pos12 = "";
    SpinnerAdapter spinnerAdapter;
    List<SaveSearchInfo> list;*/

    int adapterPosition;

    boolean isDb;
    static  String  dbfinalUrl ="";

    //........................................................................................
    private FragmentHomeBinding binding;
    private final String BUNDLE_ID = "BUNDLE_ID";
    private List<HomeModel> homeList = new ArrayList<>();


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }

    private void initView() {
        homeList.add(new HomeModel(R.drawable.house1, R.string.desc1, R.string.property1_name));
        homeList.add(new HomeModel(R.drawable.house2, R.string.desc2, R.string.property2_name));
        homeList.add(new HomeModel(R.drawable.house3, R.string.desc3, R.string.property3_name));

        final HomeAdapter adapter = new HomeAdapter(getActivity(), homeList, this);
        binding.rvHome.hasFixedSize();
        binding.rvHome.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        final DetailsFragment detailsFragment = new DetailsFragment();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_ID, homeList.get(position));
        detailsFragment.setArguments(bundle);

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.flContainerHome, detailsFragment)
                .addToBackStack(SignupFragment.class.getSimpleName())
                .hide(HomeFragment.this)
                .commit();

        ((HomeActivity) getActivity()).detachFab();
        ((HomeActivity) getActivity()).moveToDetails();
    }
}