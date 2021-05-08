package com.himanshu.uitestapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.drawable.TransitionDrawable;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> interestList;
    ArrayList<String>[] INTEREST_FINAL;
    ConstraintLayout[] interestGridLayout;
    String[] interestArray, subInterestArray;
    String[][] subMultiArray;
    boolean isSelected[];
    int length;
    GridView gridViewInterest;
    TransitionDrawable transitionDrawable ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        transitionDrawable = (TransitionDrawable) getDrawable(R.drawable.background_transition);
        interestList = new ArrayList<>();
        interestGridLayout = new ConstraintLayout[]{findViewById(R.id.interestConstraint1), findViewById(R.id.interestConstraint2)};

        /*interestList = new ArrayList<>(Arrays.asList("NULL", "Interest1",
                "Interest2", "Interest3", "Interest4", "Interest5", "Interest6", "Interest7",
                "Interest8", "Interest9"));*/
        interestArray = new String[]{"Literature",
                "Music", "Binge Watching", "Sports", "Gaming", "Art", "Tech",
                "Anime", "Dance", "Movies", "Finance", "Fashion", "Travel", "Photography", "Food", "Writing",
        "Work/Career"};
        subInterestArray = new String[]{"SubInterest1","SubInterest2","SubInterest3","SubInterest4","SubInterest5",
                "SubInterest6","SubInterest7","SubInterest8","SubInterest9","SubInterest10"};
        subMultiArray = new String[][]{
                {"Romantic Era", "Poetry", "Classical Novels", "Harry Potter", "Game of Thrones", "Fiction", "Comics",
                "Graphic Novels", "Mystery & Thriller"},
                {"Metal", "HipHop", "Rock", "Pop", "Indie", "Classical Music", "Alternative R&B", "Bollywood Songs",
                "K Pop", "Instrumental"},
                {"The Office", "The Big Bang Theory", "Breaking Bad", "How I Met Your Mother", "Money Heist",
                "F.R.I.E.N.D.S.", "Scam 1992", "Sherlock", "Game of Thrones", "Fleabag"},
                {"Cricket", "Football", "Basketball", "Table Tennis", "Badminton", "Swimming", "Lawn Tennis",
                "Volleyball", "Chess", "Athletics"},
                {"Call of Duty", "Valorant", "DOTA", "Counter Strike", "Need for Speed", "FIFA", "Fortnite", "Freefire",
                "Among Us"},
                {"Painting", "Origami", "Sculpting", "Modern Art", "Graffiti", "Sketching", "Quilling"},
                {"Coding", "Electronics & Robotics", "Aeromodelling","Maths & Physics", "Energy", "BioX","Chemistry"},
                {"One Piece", "Naruto", "AOT", "Death Note", "Dragon Ball Z", "Manga", "Studio Ghibli",
                "Cowboy Bepop", "Haikyuu", "Tokyo Ghoul"},
                {"Classical", "Bollywood", "Hip Hop", "Street Dance", "Folk", "Freestyle"},
                {"Hollywood", "Bollywood", "South Indian", "Animated"},
                {"Trading", "Quants", "Cryptocurrency", "Fin Frauds"},
                {"Casual", "Indian", "Western", "Trending", "Vintage", "Just Shorts & Hoodie"},
                {"Europe", "America", "Australia", "Dubai", "Asian Countries","Domestic"},
                {"Portraits", "Fashion", "Still Life", "Nature", "Wildlife", "Landscapes"},
                {"Vegan", "Non-Veg", "Regional","Street Food", "Pizza", "KFC", "Burgers", "Donuts", "Chinese"},
                {"Philosophy", "Fiction", "Suspense", "Adventure", "School Stories", "Sensual"},
                {"Still Exploring", "Serious Plans"}
        };
        length = interestArray.length;
        INTEREST_FINAL = new ArrayList[length];
        for (int i = 0; i<length; i++) INTEREST_FINAL[i] = null;
        /*TextView[] interestButtons = new TextView[interestList.size()-1];
        for(int i = 0; i<interestList.size()-1; i++)
        {
            interestButtons[i].setBackground(getDrawable(R.drawable.subinterest_btn_unclicked));
            interestButtons[i].setText(interestList.get(i+1));

        }*/

        isSelected = new boolean[length];
        for(int i = 0; i<length; i++)
        {
            isSelected[i] = false;
        }



        /*gridViewInterest.setAdapter(interestAdapter);

        gridViewInterest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!isSelected[position])
                {
                    view.setBackground(getDrawable(R.drawable.subinterest_btn_clicked));
                    interestList.add(interestArray[position]);

                    isSelected[position] = true;
                }
                else{
                    view.setBackground((getDrawable(R.drawable.subinterest_btn_unclicked)));
                    if(!interestList.isEmpty()) interestList.add(interestArray[position]);
                    isSelected[position] = false;
                }

            }
        });*/

    }

    /*public void onClickInterestBtn(View view)
    {
        String str = getResources().getResourceName(view.getId()).toString();
        int sel = Integer.parseInt(String.valueOf(str.charAt(str.length()-1)));
        Log.d("ELEMENT", interestList.get(sel));
        if(!isSelected[sel-1])
        {
            view.setBackground(getDrawable(R.drawable.subinterest_btn_clicked));

            isSelected[sel-1] = true;
        }
        else{
            view.setBackground((getDrawable(R.drawable.subinterest_btn_unclicked)));

            isSelected[sel-1] = false;
        }
    }*/
    int id;
    public void onClickMainInterest(View view)
    {
        ConstraintLayout viewContainer;
        String idString = getResources().getResourceName(view.getId()).toString();

        try {
            id = Integer.parseInt((idString.substring(idString.length()-2)));
        }
        catch (NumberFormatException e)
        {
            id = Integer.parseInt(String.valueOf(idString.charAt(idString.length()-1)));
        }
        Log.d("CLICKED", Integer.toString(id));
        int mainPos = id-1;
        viewContainer = findViewById(view.getContext().getResources().getIdentifier("interestConstraint"+Integer.toString(id), "id", getPackageName()));
        /*if(!isSelected[id])
        {*/
            //interestGridLayout[0].setBackground(getDrawable(R.drawable.subinterest_btn_clicked));
            Dialog subinterestDialog = new Dialog(this);
            subinterestDialog.setContentView(R.layout.subinterest_picker);
            TextView textView = subinterestDialog.findViewById(R.id.subInterestHeading);
            GridView gridView = subinterestDialog.findViewById(R.id.subGrid);
            textView.setText(textView.getText() + interestArray[mainPos]);
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(subinterestDialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            subinterestDialog.show();
            subinterestDialog.getWindow().setAttributes(lp);
            Button OK = subinterestDialog.findViewById(R.id.subButtonOK);
            Button cancel = subinterestDialog.findViewById(R.id.subButtonCancel);
            InterestAdapter interestAdapter = new InterestAdapter(this, subMultiArray[mainPos]);
            gridView.setAdapter(interestAdapter);
            boolean[] subIsSelected = new boolean[subMultiArray[mainPos].length];
            for(int i = 0; i<subMultiArray[mainPos].length; i++) subIsSelected[i] = false;
            ArrayList<String> subList = new ArrayList<>();
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(!subIsSelected[position])
                    {
                        view.setBackground(getDrawable(R.drawable.subinterest_btn_clicked));
                        subList.add(subMultiArray[mainPos][position]);
                        Log.d("ADDED", subInterestArray[position]);
                        subIsSelected[position] = true;
                    }
                    else{
                        view.setBackground((getDrawable(R.drawable.main_unclicked)));
                        if(!subList.isEmpty()) subList.remove(subInterestArray[position]);
                        Log.d("REMOVED", subMultiArray[mainPos][position]);
                        subIsSelected[position] = false;
                    }
                }
            });
            OK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //for(int i = 0; i<subList.size(); i++) Log.d(Integer.toString(i+1), subList.get(i));
                    INTEREST_FINAL[id-1] = subList;
                    subinterestDialog.dismiss();
                    for(int i = 0; i<length; i++)
                    {
                        if(INTEREST_FINAL[i]!=null)
                        {
                            for (int j = 0; j < INTEREST_FINAL[i].size(); j++) {
                                Log.d(interestArray[i], INTEREST_FINAL[i].get(j));
                            }
                        }
                        Log.d("ENDL", "ENDL");
                    }
                    isSelected[id] = true;
                    if(!(INTEREST_FINAL[id-1].isEmpty())) viewContainer.setBackground(getDrawable(R.drawable.main_clicked));
                    else viewContainer.setBackground(getDrawable(R.drawable.main_unclicked));
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subinterestDialog.dismiss();
                    subList.clear();
                    for(int i = 0; i<subIsSelected.length; i++) subIsSelected[i]=false;
                    isSelected[id] = false ;
                }
            });
        /*}
        else
        {
        }*/
    }
}