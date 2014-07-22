package com.comicon.pamphlet.data.cotroller;

import java.util.List;

import org.json.JSONException;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.comicon.pamphlet.data.dataBase.DataBase;
import com.comicon.pamphlet.data.model.CircleModel;
import com.comicon.pamphlet.data.model.WorkModel;
import com.common.httplinker.*;

public class Controller implements Resourcer {
	private String testUrl = "http://whitecomet.net/5066771dc042a8e4730680c5b91c7537.html";
	private String dataUrl = "http://twzc.comicon1111.org/?c=api&a=getcdb&key=2ECBBB73";
	public static Resourcer instance(Context context){
		return new Controller(context);
	}
	
	private Context context;
	
	private Controller(Context context){
		this.context = context;
	}
	@Override
	public List<CircleModel> getAllList() {
		return DataBase.instance(context).getAllCircles();
	}
	@Override
	public List<CircleModel> getFavouriteList() {
		return DataBase.instance(context).getFavourCircles();
	}
	@Override
	public List<WorkModel> getSearchResult(String search) {
		return DataBase.instance(context).search(search);
	}

	@Override
	public void update(final Handler handler) {
		new Thread(){
			@Override
			public void run() {
				handler.sendEmptyMessage(1);
				HttpLinkClient client = new HttpLinkClient();
				String result = client.synGet(testUrl, null);
				handler.sendEmptyMessage(2);
				try {
					DataBase.instance(context.getApplicationContext()).updateData(result);
					handler.sendEmptyMessage(3);
				} catch (Exception e) {
					handler.sendEmptyMessage(4);
				}

			}
		}.start();
	}

	@Override
	public void sendResponse(String s) {
		// TODO Auto-generated method stub
		Toast.makeText(context, "发送成功"+s, Toast.LENGTH_LONG).show();
	}

	@Override
	public void initial() {
		DataBase.instance(context).initialData();
	}
}
