package ai.agusibrhim.design.topedc;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.*;
import java.util.*;
import android.support.v7.widget.RecyclerView;
import android.widget.*;
import ai.agusibrhim.design.topedc.Model.*;
import ai.agusibrhim.design.topedc.Adapter.*;
import android.support.v7.widget.GridLayoutManager;
import android.graphics.*;
import android.graphics.drawable.*;
import android.content.*;
import android.support.v4.widget.NestedScrollView;
import android.content.res.Resources;
import java.io.InputStream;
import org.json.*;
import android.support.v7.widget.*;
import android.view.ViewGroup.*;
import android.support.v4.graphics.drawable.DrawableCompat;

public class MainActivity extends AppCompatActivity {
	Toolbar toolbar;
	private LinearLayout llroot;
	private EditText searchbox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		searchbox=(EditText)findViewById(R.id.search_box);
		llroot = (LinearLayout) findViewById(R.id.mainLinearLayout1);
		setupSearchBox(searchbox);
		loadjson(llroot, "Terlaris",0,25);
		for(String cardtitle:Constant.cards.keySet()){
			View card=getLayoutInflater().inflate(R.layout.card, null);
			RecyclerView rv=(RecyclerView) card.findViewById(R.id.cardListView1);
			rv.setNestedScrollingEnabled(false);
			TextView tv=(TextView) card.findViewById(R.id.cardTextView1);
			tv.setText(cardtitle);
			Map<Integer, String> cats=Constant.cards.get(cardtitle);
			List<Category> datacat=new ArrayList<Category>();
			for (int ic:cats.keySet()) {
				datacat.add(new Category(ic, ic, cats.get(ic), false));
			}
			rv.addItemDecoration(new SimpleDividerItemDecoration(this));
			rv.setAdapter(new CardAdapter(datacat));
			rv.setLayoutManager(new GridLayoutManager(this, 2));
			
			llroot.addView(card);
		}
		loadjson(llroot, "Produk Terbaru", 26,0);
		
	}
	
	private void loadjson(LinearLayout root, String title, int startpos, int endpos){
		try {
			Resources res = getResources();
			InputStream in_s = res.openRawResource(R.raw.bldata);
			byte[] b = new byte[in_s.available()];
			in_s.read(b);
			View v=getLayoutInflater().inflate(R.layout.product_horizontal, null);
			RecyclerView rv=(RecyclerView)v.findViewById(R.id.producthorizontalRecyclerView1);
			TextView tv=(TextView)v.findViewById(R.id.producthorizontalTextView1);
			tv.setText(title);
			List<Product> pdata=new ArrayList<Product>();
			JSONArray jdata=new JSONObject(new String(b)).getJSONArray("products");
			for(int i=startpos;i<(endpos==0?jdata.length():endpos);i++){
				JSONObject p=jdata.getJSONObject(i);
				String name=p.getString("name");
				long price=p.getLong("price");
				long oprice=price-1000;
				String store=p.getString("seller_name");
				String img=p.getJSONArray("images").getString(0);
				float rating=Float.parseFloat( p.getJSONObject("rating").getString("average_rate")+"f");
				pdata.add(new Product(name, store, price, oprice, img, rating, 10));
			}
			rv.setAdapter(new ProductAdapter(pdata, this));
			rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
			rv.setNestedScrollingEnabled(false);
			rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
			rv.scrollToPosition(rv.getAdapter().getItemCount()-1);
			root.addView(v);
		} catch (Exception e) {}

	}
	private void setupSearchBox(EditText sb){
		Drawable ic_magnify=setTint(getResources().getDrawable(R.drawable.ic_magnify), Color.GRAY);
		Drawable ic_menu=setTint(getResources().getDrawable(R.drawable.ic_menu), Color.GRAY);
		sb.setCompoundDrawablesRelativeWithIntrinsicBounds(ic_menu,null,ic_magnify,null);
		sb.clearFocus();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	public class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
		private Drawable mDivider;
		public SimpleDividerItemDecoration(Context context) {
			mDivider = context.getResources().getDrawable(R.drawable.line_divider);
		}

		@Override
		public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
			int left = parent.getPaddingLeft();
			int right = parent.getWidth() - parent.getPaddingRight();
			int childCount = parent.getChildCount();
			for (int i = 0; i < childCount; i++) {
				View child = parent.getChildAt(i);
				RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
				int top = child.getBottom() + params.bottomMargin;
				int bottom = top + mDivider.getIntrinsicHeight();
				mDivider.setBounds(left, top, right, bottom);
				mDivider.draw(c);
			}
		}
	}
	public static Drawable setTint(Drawable d, int color) {
		Drawable wrappedDrawable = DrawableCompat.wrap(d);
		DrawableCompat.setTint(wrappedDrawable, color);
		return wrappedDrawable;
	}
}
