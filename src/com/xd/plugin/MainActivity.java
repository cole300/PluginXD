package com.xd.plugin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.sdk.BS;
import com.sdk.BSListener;
import com.sdk.BSUser;
import com.sdk.UserWrapper;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        						  WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        
        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		BSUser.getInstance().login();
        	}
        });
        
        BS.getInstance().init(this);
        BSUser.getInstance().setListener(new BSListener()
        {
        	@Override
        	public void onCallBack(int code, String msg)
        	{
        		switch(code)
        		{
        		case UserWrapper.DEFAULT:
	       			 System.out.println("USER回调--"+msg);
	       			 break;
	       		case UserWrapper.INIT_FAIL:
	       			 System.out.println("USER回调--INIT_FAIL");
	       			 break;
	       		case UserWrapper.INIT_SUCCESS:
	       			 System.out.println("USER回调--INIT_SUCCESS");
	       			 break;
	       		case UserWrapper.LOGIN_CANCEL:
	       			 System.out.println("USER回调--LOGIN_CANCEL");
	       			 break;
	       		case UserWrapper.LOGIN_FAIL:
	       			 System.out.println("USER回调--LOGIN_FAIL");
	       			 break;
	       		case UserWrapper.LOGIN_NO_NEED:
	       			 System.out.println("USER回调--LOGIN_NO_NEED");
	       			 break;
	       		case UserWrapper.LOGIN_SUCCESS:
	       			 System.out.println("USER回调--LOGIN_SUCCESS");
	       			 break;
	       		case UserWrapper.LOGIN_TIMEOUT:
	       			 System.out.println("USER回调--LOGIN_TIMEOUT");
	       			 break;
        		}
        	}
        });
    }
}
