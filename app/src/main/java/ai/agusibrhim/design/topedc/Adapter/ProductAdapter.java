package ai.agusibrhim.design.topedc.Adapter;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import ai.agusibrhim.design.topedc.R;
import java.util.*;
import ai.agusibrhim.design.topedc.Model.*;
import android.content.*;
import android.util.DisplayMetrics;
import com.loopj.android.image.*;
import java.text.NumberFormat;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Holdr>
{
	List<Product> data=new ArrayList<Product>();

	private float mWidth,mHeight ;
	public ProductAdapter(List<Product> data, Context ctx){
		this.data=data;
		DisplayMetrics dm=ctx.getResources().getDisplayMetrics();
		mWidth=dm.widthPixels/ctx.getResources().getDimension(R.dimen.grid_width);
		mHeight=dm.heightPixels/ctx.getResources().getDimension(R.dimen.grid_height);
	}
	@Override
	public ProductAdapter.Holdr onCreateViewHolder(ViewGroup p1, int p2) {
		return new Holdr(LayoutInflater.from(p1.getContext()).inflate(R.layout.item_product, null));
	}

	@Override
	public void onBindViewHolder(ProductAdapter.Holdr holdr, int pos) {
		Product cat=data.get(pos);
		holdr.name.setText(cat.name);
		holdr.img.setImageUrl(cat.img);
		holdr.store.setText(cat.store);
		holdr.price.setText(_priceFormat(""+cat.price));
		holdr.priceold.setText(_priceFormat(""+cat.price_old));
		holdr.priceold.setPaintFlags(holdr.priceold.getPaintFlags() |android.graphics.Paint.STRIKE_THRU_TEXT_FLAG);
		holdr.ratingbar.setRating(cat.rating);
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	public class Holdr extends RecyclerView.ViewHolder{
		TextView name, price, priceold, discount, store;
		SmartImageView img;
		RatingBar ratingbar;
		public Holdr(final View view){
			super(view);
			view.post(new Runnable(){
					@Override
					public void run() {
						ViewGroup.LayoutParams lp=view.getLayoutParams();
						lp.height=(int)mHeight;
						lp.width=(int)mWidth;
						view.setLayoutParams(lp);
					}
				});
			name=(TextView) view.findViewById(R.id.itemproductTextViewName);
			price=(TextView) view.findViewById(R.id.itemproductTextViewPrice);
			priceold=(TextView) view.findViewById(R.id.itemproductTextViewPold);
			discount=(TextView) view.findViewById(R.id.itemproductTextViewDisc);
			store=(TextView) view.findViewById(R.id.itemproductTextViewStore);
			img=(SmartImageView) view.findViewById(R.id.itemproductImageView1);
			ratingbar=(RatingBar) view.findViewById(R.id.itemproductRatingBar1);
		}
	}
	private static String _priceFormat(String s){
		double parsed = Double.parseDouble(s);
		String formatted = NumberFormat.getCurrencyInstance().format(parsed);
		return formatted;
	}
}
