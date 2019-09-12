package com.adriano.recyclerviewdecorationdivider;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import android.support.annotation.*;
import android.support.v7.widget.*;
import android.content.*;
import android.support.v4.content.*;
import android.support.v4.view.*;


public class DecorationItemDivider extends RecyclerView.ItemDecoration {

	private Drawable mDivider;
	
	public DecorationItemDivider(Context context) {
		mDivider = ContextCompat.getDrawable(context,R.drawable.divider_decoration);
	 }

	@Override
	public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
		super.getItemOffsets(outRect, view, parent, state);

		if(parent.getChildAdapterPosition(view) == 0) {
			return;
		}
		outRect.top = mDivider.getIntrinsicHeight();
	}

	@Override
	public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
		super.onDraw(c, parent, state);

		int dividerLeft = 32;
		int dividerRight = parent.getWidth() - 32;

		for (int i = 0; i < parent.getChildCount() ;i ++) {
			
			if( i != parent.getChildCount() - 1) {
				View child = parent.getChildAt(i);

				RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

				int dividerTop = child.getBottom() + params.bottomMargin;
				int dividerBottom = dividerTop + mDivider.getIntrinsicHeight();

				mDivider.setBounds(dividerLeft, dividerTop, dividerRight,dividerBottom);
				mDivider.draw(c);
			}

		}
	}
}
