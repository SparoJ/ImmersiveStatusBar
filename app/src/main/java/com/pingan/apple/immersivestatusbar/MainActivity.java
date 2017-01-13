package com.pingan.apple.immersivestatusbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.pingan.apple.immersivestatusbar.StatusBarCompat.getStatusBarHeight;


/**
 *  该类 处理了以下功能的模拟实现
 *  1.json数据的解析展示（JSONObject JSONArray 遍历等）
 *  2.沉浸式状态栏的实现（5.0上下）
 *  3. list/gridview perform click 的实现 (模拟点击)
 *  4. 使用Android 原生Api 解析 已知的经纬度信息 并转换成 具体的地址信息 country／city／street／feature
 *  5.使用drawable 及标志位 实现 button 滑动switch 状态
 *  6. 基础自定义view 入口
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private RelativeLayout to;
    private SystemBarTintManager mSystemBarTintManager;
    private TextView mTv;
    private Button mBtn;
    private boolean mIsOpenRepaymentRemind = true; // 默认打开 还款提醒
    private CompoundButton mBtn_toggle;
    private CompoundButton mBtn_toggle_second;
    private TextView mTvLocation;
    private GridView mGridView;
    private ArrayList<Button> mList;
    private MyAdapter mAdapter;
    private Button mBtnSimpleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        to = (RelativeLayout) findViewById(R.id.toolbar);
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            getWindow().getDecorView().setFitsSystemWindows(true);

        }
/*            mSystemBarTintManager = new SystemBarTintManager(this);
//            mSystemBarTintManager.setStatusBarTintColor(Color.RED);
            mSystemBarTintManager.setStatusBarTintEnabled(true);*/

//        to.setBackgroundColor(Color.parseColor("#009959"));
        /*Drawable background = to.getBackground();
        ColorDrawable colorDrawable = (ColorDrawable) background;
        int color = colorDrawable.getColor();
        Log.e("ceshi color", "onCreate: "+color+"Color.parseColor(\"#009959\")"+ Color.parseColor("#009959"));
        StatusBarCompat.compat(this, color);*/

        /*SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);*/
        //透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        mTv = (TextView) findViewById(R.id.toolbar);
//        String str = "patoa://pingan.com/3rd?source=anydoor&url=patoa%3A%2F%2Fpingan.com%2Fshop%2Ffund&extra=%7B%22fail%22%3A%7B%22pluginID%22%3A%22PA02100000000_02_WXYJ%22%2C%22param%22%3A%22%22%7D%7D";
//        String str = "patoa://pingan.com/3rd?source=anydoor&url=patoa%3A%2F%2Fpingan.com%2Ffund%2Ftoapay%2Ftransaction&extra=%7B%22fail%22%3A%7B%22pluginID%22%3A%22PA02100000000_02_WXYJ%22%2C%22param%22%3A%22%22%7D%7D";
//        String str = "patoa://pingan.com/3rd?source=anydoor&url=patoa://pingan.com/shop/fund&extra&extra={\"fail\":{\"pluginID\":\"PA02100000000_02_WXYJ\",\"param\":\"\"}}";
        String str = "{\"data\":{\"department\":\"杭州\",\"departmentId\":1,\"groupId\":2,\"groupName\":\"片区负责人\",\"userId\":7,\"username\":\"test\"},\"success\":0}";

        try {
            JSONObject jsonObject = new JSONObject(str);
            String s = jsonObject.toString();
            Log.e("shandahua", "onCreate: "+s );
            JSONObject object = new JSONObject(s);
            String data = object.optString("data");
            JSONObject dataObject = new JSONObject(data);
            String department = dataObject.optString("department");
            Log.e("shandahua", "onCreate: "+department );
        } catch (JSONException e) {
            e.printStackTrace();
        }
//          String str = "tab=1&subtab=2&subidname=iname";
//        String str = "http://121.196.223.175:8083/stapi2/2.0/wemedia/shareMedia?visibleType=1&content=%E5%A4%9A%E5%A4%9A%E5%A4%9A&userId=1000000453&weMediaId=203";
//        String tab = null;
//        String subtab = null;
//        String subidname = null;
//        try {
////            Uri uri = Uri.parse(str);
////            String json = "tab=1&subtab=2&subidname=iname";
//            if (str!=null) { //先默认
//                String[] keyValues = str.split("&");
//                for (int i = 0; i < keyValues.length; i++) {
//                    String tmpText = keyValues[i];
//                    int index = tmpText.indexOf("=");
//                    String key = tmpText.substring(0, index);
//                    String value = tmpText.substring(index + 1);
//                    if ("tab".equalsIgnoreCase(key)) {
//                        tab = value;
//                    } else if ("subtab".equalsIgnoreCase(key)) {
//                        subtab = value;
//                    } else if ("subidname".equalsIgnoreCase(key)) {
//                        subidname = value;
//                    }
//                }
//            }
//            JSONObject jsonObject = new JSONObject("tab=1");
//            if(jsonObject!=null) {
//                tab = jsonObject.optString("tab");
//                subtab = jsonObject.optString("subtab");
//                subidname = jsonObject.optString("subidname");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Uri uri = Uri.parse(str);
//        String path = uri.getPath();
//        if ("/3rd".equals(path)) {
//            String url = uri.getQueryParameter("url");
//            String extra = uri.getQueryParameter("extra");
//            String source = uri.getQueryParameter("source");
//            String fail = null;
//            String success = null;
//            String plugin = null;
//            String params = null;
//            HashMap map = new HashMap();
//            if (extra != null) {
//                try {
//                    JSONObject jsonObject = new JSONObject(extra);
//                    success = jsonObject.optString("success");
//                    fail = jsonObject.optString("fail");
//                    JSONObject obj = new JSONObject(fail);
//                    plugin = obj.optString("pluginID");
//                    params = obj.optString("params");
//                    map.put("success", success);
//                    map.put("pluginId", plugin);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//            Uri uri1 = Uri.parse(url);
//            String p = uri1.getPath();
//            String q = uri.getQuery();

        /* try {
            str = URLEncoder.encode(str,"UTF-8");
            Log.e("testtest", "11onCreate: "+str );
            str = URLEncoder.encode(str,"UTF-8");
            Log.e("testtest", "22onCreate: "+str );
            str = URLDecoder.decode(str,"UTF-8");
            Log.e("testtest", "33onCreate: "+str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        /*JSONObject jsonObject = null;
        String source = null;
        String url = null;
        String extra = null;
        try {
            str = URLDecoder.decode(str,"UTF-8");
            jsonObject = new JSONObject(str);
            source = jsonObject.optString("source");
            url = jsonObject.optString("url");
            extra = jsonObject.optString("extra");
            JSONObject obj = new JSONObject(extra);
            String fail = obj.optString("fail");
            String success = obj.optString("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(jsonObject!=null) {
            jsonObject.optString("source");
        }*/
        /*int quoteFirstIndex = str.indexOf("&");
        String temp = null;
        String url = null;
        String extra = null;
        if (quoteFirstIndex != -1) {
            try {
                str = URLDecoder.decode(str,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            temp = str.substring(quoteFirstIndex + 1);
            if (!temp.trim().isEmpty()) { //先默认
                String[] keyValues = temp.split("&");
                for (int i = 0; i < keyValues.length; i++) {
                    String tmpText = keyValues[i];
                    int index = tmpText.indexOf("=");
                    String key = tmpText.substring(0, index);
                    String value = tmpText.substring(index + 1);
                    if ("url".equalsIgnoreCase(key)) {
                        url = value;
                    } else if ("extra".equalsIgnoreCase(key)) {
                        extra = value;
                    }
                }
            }
        }*/
        /*try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {

        }

            /*int quoteFirstIndex = str.indexOf("?");
            String url = null;
            String extra = null;
            String params = null;
            String source = null;
            HashMap map = new HashMap();
            if (quoteFirstIndex != -1) {
                try {
                    str = URLDecoder.decode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                str = str.substring(quoteFirstIndex + 1);
                if (!str.trim().isEmpty()) { //先默认
                    String[] keyValues = str.split("&");
                    for (int i = 0; i < keyValues.length; i++) {
                        String tmpText = keyValues[i];
                        int index = tmpText.indexOf("=");
                        String key = tmpText.substring(0, index);
                        String value = tmpText.substring(index + 1);
                        if ("url".equalsIgnoreCase(key)) {
                            url = value;
                        } else if ("extra".equalsIgnoreCase(key)) {
                            extra = value;
                        } else if ("params".equalsIgnoreCase(key)) {
                            params = value;
                        }else if ("source".equalsIgnoreCase(key)) {
                            source = value;
                        }
                    }
                    String fail = null;
                    String success = null;
                    try {
                        JSONObject jsonObject = new JSONObject(extra);
                        success = jsonObject.optString("success");
                        fail = jsonObject.optString("fail");
                        map.put("success", success);
                        map.put("Pluginid", fail);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }*/

//            mTv.setText(uri1 + "/n" + p + "______" + q);
            initListener();
//        }

//            rxTest();
//        final float scale = getResources().getDisplayMetrics().density;
        //TODO ：immerse status bar
//        initWindows();

    }

    private void rxTest() {

    }

    private void initWindows() {
        Window window = getWindow();
        int color = getResources().getColor(android.R.color.holo_blue_light);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(color);
            //设置导航栏颜色
            window.setNavigationBarColor(color);
            ViewGroup contentView = ((ViewGroup) findViewById(android.R.id.content));
            View childAt = contentView.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            //设置contentview为fitsSystemWindows
            ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
            View childAt = contentView.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
            //给statusbar着色
            View view = new View(this);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(this)));
            view.setBackgroundColor(color);
            contentView.addView(view);  //是addView 而不是 addView(,0)  因为 contentView 是FrameLayout
        }
    }

    private void initListener() {
        mBtn = (Button) findViewById(R.id.btn_is_open_repayment_remind);
        mBtn_toggle = (CompoundButton) findViewById(R.id.btn_toggle);
        mBtn_toggle_second = (CompoundButton) findViewById(R.id.btn_toggle_second);
        mBtn_toggle.setOnClickListener(this);
//        mBtn_toggle_second.setOnClickListener(this);
        mBtn_toggle_second.setOnCheckedChangeListener(this);
        mBtn.setOnClickListener(this);
        mTvLocation = (TextView) findViewById(R.id.geo_location);

        //gridview  模拟click 实现
        initGridData();
        mGridView = (GridView) findViewById(R.id.gridview);
        mAdapter = new MyAdapter();
        mGridView.setNumColumns(4);
        mGridView.setAdapter(new MyAdapter());


        // 自定义view 入口
        mBtnSimpleView = (Button) findViewById(R.id.btn_simple_self_define);
        mBtnSimpleView.setOnClickListener(this);
    }

    private void initGridData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Button textView = new Button(this);
            textView.setText("text:"+i);
            Drawable drawable = getResources().getDrawable(R.drawable.tv_perform_click_test);
            textView.setBackground(drawable);
            mList.add(textView);
        }
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return null != mList?mList.size():0;
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
//            mList.get(position).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.e(TAG, "onClick: position "+position );
//                    Toast.makeText(MainActivity.this, "bei click le   sssss", Toast.LENGTH_LONG);
//                }
//            });
            Log.e(TAG, "getView: "+System.currentTimeMillis()+"-----"+position );
            return mList.get(position);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e(TAG, "onItemClick: itemclick -----"+position+"==time=="+ System.currentTimeMillis());
            }
        });

//        mGridView.performItemClick(mGridView.getChildAt(0),0,mGridView.getItemIdAtPosition(0));
        mGridView.performItemClick(mGridView.getAdapter().getView(0,null, null), 0, mGridView.getItemIdAtPosition(0));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_is_open_repayment_remind :



                toggleIsOpenRepaymentRemind();

                //location
//                setLocation();

                break;
            case R.id.btn_toggle :

                boolean isCheck = mBtn_toggle.isChecked();

                if(isCheck) {
                    mBtn_toggle.setText("kai");
                }else{
                    mBtn_toggle.setText("guan");
                }
                break;
            case R.id.btn_toggle_second :
                boolean isCheck1 = mBtn_toggle_second.isChecked();
                if(isCheck1) {
                    mBtn_toggle_second.setText("guan");
                }else{
                    mBtn_toggle_second.setText("kai");
                }
                break;
            case R.id.btn_simple_self_define :

                Intent intent = new Intent(MainActivity.this, SelfDefineEntranceActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void setLocation() {
        try {
            Address address = getLocation();
            String countryName = address.getCountryName();//得到国家名称，比如：中国
            Log.e(TAG, "countryName = " + countryName);
            String locality = address.getLocality();//得到城市名称，比如：北京市
            Log.e(TAG, "locality = " + locality);
            for (int i = 0; address.getAddressLine(i) != null; i++) {
                String addressLine = address.getAddressLine(i);//得到周边信息，包括街道等，i=0，得到街道名称
                Log.e(TAG, "addressLine = " + addressLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
//        mGridView.performItemClick(mGridView.getAdapter().getView(0,null,null),0,mGridView.getItemIdAtPosition(0));
    }

    private void toggleIsOpenRepaymentRemind() {
        if (mIsOpenRepaymentRemind) { //原来是开启状态，点击后切换为关闭状态

            mIsOpenRepaymentRemind = false;
            mBtn.setBackgroundResource(R.drawable.toggle_button_on);
        } else { // 从关闭状态切换为开启状态
            mIsOpenRepaymentRemind = true;
            mBtn.setBackgroundResource(R.drawable.toggle_button_off);

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.btn_toggle_second :
//                buttonView.setText(isChecked?"kai":"guan");
//                buttonView.setChecked(isChecked);

        }
    }

    private static final String TAG = "GEO_LOCATION";
   // 龙华中路:31.18478179512045,121.4574426404483:station
    public Address getLocation() {
        double x = 31.18478179512045;  //纬度
        double y = 121.4574426404483;  //经度
        Geocoder gc = new Geocoder(this, Locale.getDefault());
        List<Address> locationList = null;
        try {
            locationList = gc.getFromLocation(x, y, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Address address = locationList.get(0);//得到Address实例
//Log.i(TAG, "address =" + address);


        return address;
    }
}

       /* int quoteFirstIndex = str.indexOf("&");
        int qutoLastIndex = str.lastIndexOf("&");
        String url = null;
        String extra = null;
        if(quoteFirstIndex != -1 && qutoLastIndex != -1) {
            url = str.substring(quoteFirstIndex+5,qutoLastIndex);
            extra = str.substring(qutoLastIndex+7);
            try {
                url = URLDecoder.decode(url,"UTF-8");
                extra = URLDecoder.decode(extra,"UTF-8");
                String xx = URLDecoder.decode("%22%7D","UTF-8");
                Log.e("xxxx", "onCreate: "+xx );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        HashMap map = new HashMap();
        String fail = null;
        String success = null;
        try {
            JSONObject jsonObject = new JSONObject(extra);
            success = jsonObject.optString("success");
            fail = jsonObject.optString("fail");
            map.put("success",success);
            map.put("Pluginid",fail);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


