package ai.agusibrhim.design.topedc.Adapter;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import ai.agusibrhim.design.topedc.R;
import java.util.*;
import ai.agusibrhim.design.topedc.Model.*;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.Holdr>
{
	List<Category> data=new ArrayList<Category>();
	public CardAdapter(List<Category> data){
		this.data=data;
	}
	@Override
	public CardAdapter.Holdr onCreateViewHolder(ViewGroup p1, int p2) {
		return new Holdr(LayoutInflater.from(p1.getContext()).inflate(R.layout.item_card, null));
	}

	@Override
	public void onBindViewHolder(CardAdapter.Holdr holdr, int pos) {
		Category cat=data.get(pos);
		holdr.title.setText(cat.title);
		holdr.ic_cat.setImageResource(cat.icres);
		if(pos%2==1){
			holdr.divider.setVisibility(View.GONE);
		}else holdr.divider.setVisibility(View.VISIBLE);
	}

	@Override
	public int getItemCount() {
		return data.size();
	}
	
	public class Holdr extends RecyclerView.ViewHolder{
		TextView title;
		ImageView ic_cat;
		View divider;
		public Holdr(View view){
			super(view);
			title=(TextView) view.findViewById(R.id.itemcardTextView1);
			ic_cat=(ImageView) view.findViewById(R.id.itemcardImageView1);
			divider=view.findViewById(R.id.itemcardView1);
		}
	}
}
