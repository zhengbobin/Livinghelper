package com.boby.livinghelper.app.example;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Toast;
import com.boby.livinghelper.R;
import com.boby.livinghelper.app.example.entity.ExampleEntity;
import com.boby.livinghelper.app.example.mvp.contract.ExampleContact;
import com.boby.livinghelper.app.example.mvp.presenter.ExamplePresenter;
import com.boby.livinghelper.base.BaseActivity;
import com.boby.livinghelper.util.LogUtil;
import java.util.List;
import java.util.Random;

/**
 * MVP 示例代码
 *
 * @author zbobin.com
 */
public class ExampleActivity extends BaseActivity<ExamplePresenter>
        implements ExampleContact.View {

    private static final String TAG = ExampleActivity.class.getSimpleName();

    private AppCompatTextView tvShow;
    private AppCompatButton btnRequestApi;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        tvShow = (AppCompatTextView) findViewById(R.id.tv_show);
        btnRequestApi = (AppCompatButton) findViewById(R.id.btn_request_api);

        mDialog = new ProgressDialog(this);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setCancelable(false);
        mDialog.setMessage("正在加载...");

        btnRequestApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getExampleEntity();
            }
        });
    }

    @Override
    protected ExamplePresenter onCreatePresenter() {
        return new ExamplePresenter(this);
    }

    @Override
    public void showDialog() {
        mDialog.show();
    }

    @Override
    public void onSuccess(ExampleEntity entity) {
        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
        try {
            List<ExampleEntity.KindEntity> results = entity.getKind();
            tvShow.setText(results.get(new Random().nextInt(7)).toString());

            for (ExampleEntity.KindEntity result : results) {
                LogUtil.e(TAG, result.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFail(String s) {
        LogUtil.e(TAG, s);
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideDialog() {
        mDialog.dismiss();
    }
}
