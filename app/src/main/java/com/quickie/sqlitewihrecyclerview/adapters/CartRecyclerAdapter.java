package com.quickie.sqlitewihrecyclerview.adapters;

/**
 * Created by user on 6/15/2017.
 */

//public class CartRecyclerAdapter RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
//
//        ArrayList<Item> arrayList = new ArrayList<>();
//        Context context;
//
//        RecyclerAdapter (ArrayList<Item> arrayList, Context context) {
//        this.arrayList = arrayList;
//        this.context = context;
//        }
//
//
//@Override
//public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
//        MyViewHolder myViewHolder = new MyViewHolder(view,context,arrayList);
//        return myViewHolder;
//        }
//
//@Override
//public void onBindViewHolder(MyViewHolder holder, int position) {
//
//        Item item =arrayList.get(position);
//        holder.name.setText(item.getName());
//        holder.category.setText(item.getCategory());
//
//
//        }
//
//@Override
//public int getItemCount() {
//        return arrayList.size();
//        }
//
//public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
//{
//
//    TextView name,category,quantity,sale_price;
//    ArrayList<Item> items= new ArrayList<Item>();
//    Context context;
//
//    MyViewHolder(View view,Context context,ArrayList<Item> items){
//        super(view);
//        this.items=items;
//        view.setOnClickListener(this);
//        this.context = context;
//
//        name = (TextView) view.findViewById(R.id.item_grid_name);
//        category = (TextView) view.findViewById(R.id.category);
//
//
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        int position = getAdapterPosition();
//        Item item = this.items.get(position);
//
//
//
//
//    }
//}
//
//
