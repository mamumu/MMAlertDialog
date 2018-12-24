package com.mumu.mmalertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mumu.alertdialog.MMAlertDialogUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private String webUrl = "https://www.jianshu.com/u/281e9668a5a6";
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    private void showDialog1() {
        MMAlertDialogUtils.showDialog(MainActivity.this,
                "标题",
                "我是中国人，我爱我的祖国",
                null,
                "确定",
                false,
                null,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    private void showDialog2() {
        MMAlertDialogUtils.showDialog(this,
                "标题",
                "我是中国人，我爱我的祖国",
                "取消",
                "确定",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    private void showDialogXieYi() {
        final boolean[] misChecked = {false};
        MMAlertDialogUtils.showDialogXieYi(this,
                "个人协议",
                webUrl,
                "我知道了",
                "我已阅读并同意以上条款，下次不再提示",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (misChecked[0]) {
                            Toast.makeText(MainActivity.this, "checkbox选中了--我知道了", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            misChecked[0] = true;
                        } else {
                            misChecked[0] = false;
                        }
                    }
                });
    }

    private void showImageDialog() {
        MMAlertDialogUtils.showDialogImage(this,
                "http://img0.imgtn.bdimg.com/it/u=3295048120,2386838883&fm=214&gp=0.jpg",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                showDialog1();
                break;
            case R.id.btn_2:
                showDialog2();
                break;
            case R.id.btn_3:
                showDialogXieYi();
                break;
            case R.id.btn_4:
                showImageDialog();
                break;
        }
    }
}
