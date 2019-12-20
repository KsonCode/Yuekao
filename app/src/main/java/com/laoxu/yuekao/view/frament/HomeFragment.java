package com.laoxu.yuekao.view.frament;

import android.content.Intent;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.laoxu.yuekao.MainActivity;
import com.laoxu.yuekao.R;
import com.laoxu.yuekao.base.BaseFragment;
import com.laoxu.yuekao.base.BasePresenter;
import com.laoxu.yuekao.contract.IHomeContract;
import com.laoxu.yuekao.model.adapteer.ProductAdapter;
import com.laoxu.yuekao.model.entity.FlowEntity;
import com.laoxu.yuekao.model.entity.ProductEntity;
import com.laoxu.yuekao.presenter.HomePresenter;
import com.laoxu.yuekao.view.activity.SecondActivity;
import com.laoxu.yuekao.view.widgets.FlowLayout;

import org.w3c.dom.Text;

import java.net.URLEncoder;


public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.IView {
    private FlowLayout flowLayout;
    private EditText editText;
    private Button btn;
    private RecyclerView rv;


    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView(View view) {



       flowLayout =view.findViewById(R.id.flowlayout);
       rv =view.findViewById(R.id.rv);
       rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
       editText =view.findViewById(R.id.et_keyword);
       btn =view.findViewById(R.id.btn_search);

       //点击流式布局的tag，请求搜索接口
       flowLayout.setFlowCallback(new FlowLayout.FlowCallback() {
           @Override
           public void flowClick(String name) {
               String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode(name)+"&count=10&page=1";


               presenter.getProductdata(url);
           }
       });

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               if (TextUtils.isEmpty(editText.getText().toString())){
                   Toast.makeText(getActivity(), "不能唯恐", Toast.LENGTH_SHORT).show();
                   return;
               }

               flowLayout.addTextView(editText.getText().toString());

               String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword="+URLEncoder.encode(editText.getText().toString())+"&count=10&page=1";


               presenter.getProductdata(url);

           }
       });

    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    protected void initData() {


        String url = "http://blog.zhaoliang5156.cn/baweiapi/"+ URLEncoder.encode("手机");
        presenter.getFlowdata(url);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    /**
     * 成功
     * @param data
     */
    @Override
    public void success(Object data) {
        if (data instanceof FlowEntity){//instance

            //
            FlowEntity flowEntity = (FlowEntity) data;
            flowLayout.add(flowEntity.tags);

        }else if (data instanceof ProductEntity){
            ProductEntity productEntity = (ProductEntity) data;
            //适配器，recyclerview

            ProductAdapter productAdapter = new ProductAdapter(getActivity(),productEntity.result);
            rv.setAdapter(productAdapter);
            //接收接口传过来的数据
            productAdapter.setRvItemClick(new ProductAdapter.RvItemClick() {
                @Override
                public void onClick(String name) {
                    Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getActivity(), SecondActivity.class));
                }
            });

        }

    }

    /**
     * 失败
     * @param throwable
     */
    @Override
    public void error(Throwable throwable) {

    }
}
