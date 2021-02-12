package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    // resource ID for the background color for this list of words
    private int colorResourceId;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the Word object located at this position in the list
        Word currentNumber = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok translate
        TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);

        // Get the version name from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentNumber.getMiwokTranslation());

        TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);

        defaultTextView.setText(currentNumber.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = listItemView.findViewById(R.id.image);
        if(currentNumber.hasImage()) {
            iconView.setImageResource(currentNumber.getImageSrc());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

    public WordAdapter(Activity context, ArrayList<Word> numbers, int colorResourceId) {
        super(context, 0, numbers);
        this.colorResourceId = colorResourceId;
    }
}
