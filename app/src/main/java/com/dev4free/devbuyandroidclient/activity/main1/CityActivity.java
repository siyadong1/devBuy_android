package com.dev4free.devbuyandroidclient.activity.main1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.dev4free.devbuyandroidclient.R;
import com.dev4free.devbuyandroidclient.activity.BaseActivity;
import com.dev4free.devbuyandroidclient.adapter.CityAdapter;
import com.dev4free.devbuyandroidclient.entity.City;
import com.dev4free.devbuyandroidclient.utils.ProgressDialogUtils;
import com.dev4free.devbuyandroidclient.utils.ToastUtils;
import com.dev4free.devbuyandroidclient.view.BladeView;
import com.dev4free.devbuyandroidclient.view.PinnedHeaderListView;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syd on 2016/4/26.
 */
public class CityActivity extends BaseActivity{



    List<City> listData = new ArrayList<City>();
    CityAdapter mCityAdatpter;

    private ProgressDialogUtils progressDialogUtils;
    private Context mContext;
    @ViewInject(R.id.phlv_city)
    PinnedHeaderListView phlv_city;
    @ViewInject(R.id.bv_city)
    BladeView bv_city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initTitle("所在城市");
        x.view().inject(this);
        mContext = this;
        progressDialogUtils = new ProgressDialogUtils(mContext);

        //data
        getCities();
        //adapter
        mCityAdatpter = new CityAdapter(this,listData);
        //bind
        phlv_city.setAdapter(mCityAdatpter);
        phlv_city.setOnScrollListener(mCityAdatpter);
        phlv_city.setPinnedHeaderView(getLayoutInflater().inflate(R.layout.view_city_pinnedheader,phlv_city,false));


        bv_city.setOnItemClickListener(new BladeView.OnItemClickListener() {
            @Override
            public void onItemClick(String s) {

                for (int i = 0; i <listData.size() ; i++) {

                    if (listData.get(i).getSymbol().equals(s)) {
                        phlv_city.setSelection(i);
                        break;
                    }

                }

            }
        });


    }

    /**
     * 获取城市列表
     */
    private void getCities() {

        for (int i = 0; i <2 ; i++) {
            City mCity = new City("A","测试城市A"+ i);
            listData.add(mCity);
        }
        for (int i = 0; i <10; i++) {
            City mCity = new City("B","测试城市B"+ i);
            listData.add(mCity);
        }
        for (int i = 0; i <10 ; i++) {
            City mCity = new City("C","测试城市C"+ i);
            listData.add(mCity);
        }
        for (int i = 0; i <10 ; i++) {
            City mCity = new City("D","测试城市D"+ i);
            listData.add(mCity);
        }
        for (int i = 0; i <10 ; i++) {
            City mCity = new City("E","测试城市E"+ i);
            listData.add(mCity);
        }
        for (int i = 0; i <10 ; i++) {
            City mCity = new City("F","测试城市F"+ i);
            listData.add(mCity);
        }
        for (int i = 0; i <10 ; i++) {
            City mCity = new City("G","测试城市G"+ i);
            listData.add(mCity);
        }

    }


    @Event(value = R.id.phlv_city,type = AdapterView.OnItemClickListener.class)
    private void ItemClickEvent(AdapterView<?> parent, View view, int position, long id) {

        ToastUtils.showToast("点击了" + listData.get(position).getName());

    }


}
