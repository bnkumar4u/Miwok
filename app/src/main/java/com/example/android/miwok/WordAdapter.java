package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word>{

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;
    public WordAdapter(@NonNull Context context, ArrayList<Word> words,int colorResourceId) {

        /**
         *  Here, we initialize the ArrayAdapter's internal storage for the context and the list.
         the second argument is used when the ArrayAdapter is populating a single TextView.
         Because this is a custom adapter for two TextViews , the adapter is not
         going to use this second argument, so it can be any value. Here, we used 0.
         */
        super(context, 0,words);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the version name from the current Word object and
        // set this text on the name TextView
        nameTextView.setText(currentWord.getMiwokTraslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        numberTextView.setText(currentWord.getDefaultTraslation());



        // Find the Imageview in the list_item.xml layout with the ID version_number
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);



        // checks whether image is passed or not
       if(currentWord.isImagePassed())
       {
           // Get the ResourceId from the current Word object and
           // set this image on the ImageView
           imageView.setImageResource(currentWord.getImageResourceId());
       }
       //set imageview to gone
       else
       {
           imageView.setVisibility(View.GONE);
       }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
