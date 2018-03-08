package au.com.nextdot.demorecylerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sakib on 2/14/2018.
 */

class VerticalSpace extends RecyclerView.ItemDecoration {
    int space;
    public VerticalSpace(int i) {
        this.space=i;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(parent.getChildLayoutPosition(view)==0)
        {
            outRect.top=space;
        }
        outRect.left=space;
        outRect.right=space;
        outRect.bottom=space;
    }
}
