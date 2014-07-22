package com.comicon.pamphlet.ui.main;

import com.comicon.pamphlet.R;
import com.comicon.pamphlet.data.model.CircleModel;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class FavourateListener implements OnClickListener{
	CircleModel model;
	public FavourateListener(CircleModel model) {
		this.model = model;
	}

	@Override
	public void onClick(View v) {
		Toast.makeText(v.getContext(), model.getName()+"收藏", Toast.LENGTH_LONG).show();
		model.setFavoirite(!model.isFavorite());
		ImageButton button = (ImageButton) v.findViewById(R.id.favour);
		button.setImageResource(model.isFavorite()?R.drawable.rating_important:R.drawable.rating_not_important);
	}

}
