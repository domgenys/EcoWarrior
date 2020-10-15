package com.example.Eco_warrior;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchByLogo extends AppCompatActivity {


    ListView lst;

    String[] recycleName={"Widely Recycled ",  "Widely Recycled - Rinse", "The Green Dot", "Mobius Loop", "Plastic resin codes",
            "Glass", "Recyclable aluminium", "Recyclable steel", "Tidyman", "Waste electricals",
            "Compostable", "Home composting", "Paper, card and wood" };

    String[] logoDesc= {"This label is applied to packaging that is collected by 75% or more of local authorities across the UK, for example plastic bottles.",
            "Rinsing packaging, for example food trays, ensures that any food residue doesn’t contaminate other materials, particularly if they are collected together with paper.\n" +
                    "\n" +
                    "It also helps to stop attracting vermin into the recycling sorting centres where people work.",
            "The Green Dot does not necessarily mean that the packaging is recyclable, will be recycled or has been recycled. It is a symbol used on packaging in some European countries and signifies that the producer has made a financial contribution towards the recovery and recycling of packaging in Europe.",
            "This indicates that an object is capable of being recycled, not that the object has been recycled or will be accepted in all recycling collection systems. Sometimes this symbol is used with a percentage figure in the middle to explain that the packaging contains x% of recycled material.",
            "This identifies the type of plastic resin used to make the item by providing a 'Resin Identification Code'. It is represented with a 'chasing arrows' symbol surrounding a a number between 1 and 7 that defines the resin used",
        "This symbol asks that you recycle the glass container. Please dispose of glass bottles and jars in a bottle bank, remembering to separate colours, or use your glass household recycling collection if you have one.",
            "This symbol indicates that the item is made from recyclable aluminium.", "This symbol means that the product is made of steel.\n" +
            "\n" +
            "All local authorities collect steel cans for recycling. Other steel or metal items can be taken to your household recycling centre.",
            "This symbol from Keep Britain Tidy asks you not to litter. It doesn't relate to recycling but is a reminder to be a good citizen, disposing of the item in the most appropriate manner.",
            "This symbol explains that you should not place the electrical item in the general waste. Electrical items can be recycled through a number of channels.",
        "Products certified to be industrially compostable according to the European standard EN 13432/14955 may bear the 'seedling' logo.\n" +
                "\n" +
                "Never place compostable plastic into the recycling with other plastics; as it is designed to break down it cannot be recycled and contaminates recyclable plastics. Plastics that carry this symbol can be recycled with your garden waste through your local authority.",
            "In addition to the seedling symbol for industrial composting, you may see this one which means that it is suitable to be home composted.",
            "The Forest Stewardship Council (FSC) logo identifies wood-based products from well managed forests independently certified in accordance with the rules of the FSC." };

    Integer[] logoId={R.drawable.widely_recycled, R.drawable.rinse, R.drawable.green_dot, R.drawable.mobius_loop,
        R.drawable.pet, R.drawable.glass, R.drawable.aluminium, R.drawable.steel,
        R.drawable.tidyman, R.drawable.electrical, R.drawable.seedling, R.drawable.homeokpost,
        R.drawable.fsc, };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        
        lst= (ListView) findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(this,recycleName,logoDesc,logoId);
        lst.setAdapter(customListview);

    }
}



