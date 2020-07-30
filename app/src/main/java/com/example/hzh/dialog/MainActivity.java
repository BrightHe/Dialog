package com.example.hzh.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        findViewById( R.id.hello ).setOnClickListener( this );
    }

    //点击按钮，弹出圆角对话框
    public void showDialog() {
        mDialog = new Dialog(this,R.style.mydialog);
        Window window = mDialog.getWindow();
        View contentView = this.getLayoutInflater().inflate(R.layout.note_dailog, null);
        TextView tv_title = (TextView) contentView.findViewById(R.id.tv_title);
        TextView tv_cancel = (TextView) contentView.findViewById(R.id.tv_cancel);
        TextView tv_postive = (TextView) contentView.findViewById(R.id.tv_positive);
        mDialog.setContentView(contentView);
        tv_title.setText("标注备忘录");
        tv_cancel.setOnClickListener(this);
        tv_postive.setOnClickListener(this);
        mDialog.show();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hello:
                showDialog();
                break;
            case R.id.tv_cancel:
                mDialog.dismiss();
                break;
            case R.id.tv_positive:
                //TO Do Something
                Toast.makeText(this,"确定",Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
                break;
        }
    }
}
