package com.mustofin.expandablenavigationdrawer.data;

import com.mustofin.expandablenavigationdrawer.R;
import com.mustofin.expandablenavigationdrawer.fragment.BerandaFragment;
import com.mustofin.expandablenavigationdrawer.fragment.NotifikasiFragment;
import com.mustofin.expandablenavigationdrawer.fragment.TemanDekatFragment;
import com.mustofin.expandablenavigationdrawer.fragment.TemanDekatSekaliFragment;
import com.mustofin.expandablenavigationdrawer.navigationdrawer.NavMenuModel;

import java.util.ArrayList;

/**
 * Created by miki on 7/7/17.
 */

public class Constant {

    public static ArrayList<NavMenuModel> getMenuNavigasi(){
        ArrayList<NavMenuModel> menu = new ArrayList<>();

        menu.add(new NavMenuModel("Hotel", R.drawable.ic_beranda, BerandaFragment.newInstance()));

        menu.add(new NavMenuModel("Tour promotion", R.drawable.ic_notifikasi, NotifikasiFragment.newInstance()));
        menu.add(new NavMenuModel("IH Travel's Partner", R.drawable.ic_teman,
                new ArrayList<NavMenuModel.SubMenuModel>() {{
                    add(new NavMenuModel.SubMenuModel("Spa and message", TemanDekatFragment.newInstance()));
                    add(new NavMenuModel.SubMenuModel("Coffee and Restaurant", TemanDekatSekaliFragment.newInstance()));
        }}));




        return menu;
    }
}
